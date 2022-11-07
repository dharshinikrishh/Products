package com.mkj.gtset.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "productinfo")
public class ProductInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificateNumber;
	private String countryOfOrigin;
	private String manufacturingDate;
	private int weight;
	private String color;
	
	public ProductInfo(String countryOfOrigin, String manufacturingDate, int weight, String color) {
		super();
		this.countryOfOrigin = countryOfOrigin;
		this.manufacturingDate = manufacturingDate;
		this.weight = weight;
		this.color = color;
	}
	
	
	
}
