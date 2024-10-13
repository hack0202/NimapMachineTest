package com.MachineTest.Nimap.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.MachineTest.Nimap.Bean.CategoryBean;
import com.MachineTest.Nimap.Entity.Category;
import com.MachineTest.Nimap.Exception.CategoryNotFoundException;
import com.MachineTest.Nimap.Repository.CategoryRepo;
import com.MachineTest.Nimap.Service.CategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;

	@Override
	public String saveCategory(CategoryBean req) {
		Category category = new Category();
		category.setName(req.getName());
		repo.save(category);
		return "Category saved sucessfully";
	}

	@Override
	public Category getCategoryById(int id) {
	return repo.findById(id).orElseThrow(()-> new CategoryNotFoundException(id));
	}

	@Override
	public String updateCategory(CategoryBean req) {
	Optional<Category> cat = repo.findById(req.getId());
	if(cat.isPresent()) {
		Category existing = cat.get();
          existing.setName(req.getName());	
          repo.save(existing);
          return "Updated sucessfully";
	}
	else {
		return "cant find category with id :"+ req.getId();
	}
	}

	@Override
	public String deleteCategory(int id) {
		if(!repo.existsById(id)) {
			throw new CategoryNotFoundException(id);
		}
	repo.deleteById(id);
	return "Category with id :"+id+ " deleted";
	}

	@Override
	public List<Category> getall() {
		
		return repo.findAll();
	}

	@Override
	public Page<Category> getallCategories(Pageable pageable) {
	
		return repo.findAll(pageable);
	}

}
