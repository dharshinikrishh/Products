package com.mkj.gtset.service;

import org.springframework.stereotype.Service;

import com.mkj.gtset.entity.ProductInfo;

@Service
public interface ProductInfoService {

	public ProductInfo addProductInfo(ProductInfo productInfo);
}
