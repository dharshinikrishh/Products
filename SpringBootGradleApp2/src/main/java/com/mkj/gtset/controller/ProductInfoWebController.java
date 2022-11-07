package com.mkj.gtset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtset.entity.Product;
import com.mkj.gtset.entity.ProductInfo;
import com.mkj.gtset.service.ProductInfoService;
import com.mkj.gtset.service.ProductService;


@RestController
@RequestMapping("product/productInfo")
public class ProductInfoWebController {

	@Autowired
	ProductInfoService productInfoService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/add") 
	public Product doProductInfoThings(@RequestBody ProductInfo productInfo,@RequestParam String productName)
	{
		Product alreadySavedProduct =null;
		try
		{
			ProductInfo savedProductInfo=productInfoService.addProductInfo(productInfo);
			if(savedProductInfo.getCertificateNumber()!=0)
			{
				alreadySavedProduct=productService.getProductByProductName(productName);
				if(alreadySavedProduct!= null)
				{
					Product productInfoAddProduct=productService.linkProduct(savedProductInfo, alreadySavedProduct);
					return productInfoAddProduct;
				}
				else
				{
					throw new Exception("Product not found,"+alreadySavedProduct+"for"+productName);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return alreadySavedProduct;
		}
		return alreadySavedProduct;
		
	}

}
