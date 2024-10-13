package com.MachineTest.Nimap.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.MachineTest.Nimap.Bean.CategoryBean;
import com.MachineTest.Nimap.Entity.Category;

public interface CategoryService 
{
	
 public String saveCategory(CategoryBean req);
 public Category getCategoryById(int id);
 public String updateCategory(CategoryBean req);
 public String deleteCategory(int id);
 public List<Category> getall();
 public Page<Category> getallCategories(Pageable pageable);
}
