package com.MachineTest.Nimap.Bean;

import com.MachineTest.Nimap.Entity.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class ProductBean {
	private int id;
	private String name;
	private String description;
	private Double price;
	private Category category;
	
	public ProductBean() {
		
	}
}
