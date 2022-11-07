package com.mkj.gtset.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.ProductInfo;
import com.mkj.gtset.repository.ProductInfoRepository;
@Service
public class ProductInfoServiceImpl implements ProductInfoService{

	@Autowired
	ProductInfoRepository productInfoRepository;
	
	@Override
	@Transactional
	public ProductInfo addProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		ProductInfo savedProductInfo =productInfoRepository.save(productInfo);
		return savedProductInfo;
	}

}
