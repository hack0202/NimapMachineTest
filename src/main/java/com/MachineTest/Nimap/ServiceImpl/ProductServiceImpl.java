package com.MachineTest.Nimap.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.MachineTest.Nimap.Bean.ProductBean;
import com.MachineTest.Nimap.Entity.Category;
import com.MachineTest.Nimap.Entity.Product;
import com.MachineTest.Nimap.Exception.CategoryNotFoundException;
import com.MachineTest.Nimap.Repository.CategoryRepo;
import com.MachineTest.Nimap.Repository.ProductRepo;
import com.MachineTest.Nimap.Service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public String saveProduct(ProductBean request) {
	Category category = categoryRepo.findById(request.getCategory().getId()).orElseThrow(()-> new CategoryNotFoundException(request.getCategory().getId()));
	Product product = new Product()	;
	product.setName(request.getName());
	product.setDescription(request.getDescription());
	product.setPrice(request.getPrice());
	product.setCategory(category);
	productRepo.save(product);
	return "Product saved sucessfully";
	}

	@Override
	public Product getById(int id) {
	return productRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found with id :"+id));
		
	}

	@Override
	public String deleteProduct(int id) {
	productRepo.deleteById(id);
	return "Product deleted";
	}

	@Override
	public String updateProduct(ProductBean reqBean) {
	Optional<Product> product = productRepo.findById(reqBean.getId());
	if(product.isPresent()){
		Product existProduct = product.get();
		existProduct.setName(reqBean.getName());
		existProduct.setDescription(reqBean.getDescription());
		existProduct.setPrice(reqBean.getPrice());
		if(reqBean.getCategory()!=null) {
			existProduct.setCategory(reqBean.getCategory());
		}
		productRepo.save(existProduct);
		return "Product Updated ";
	}else {
		return "Product not found";
	}
		
	}

	@Override
	public Page<Product> getAll(Pageable pageable) {
		
		return productRepo.findAll(pageable);
	}

}
