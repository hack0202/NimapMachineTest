package com.MachineTest.Nimap.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MachineTest.Nimap.Bean.ProductBean;
import com.MachineTest.Nimap.Entity.Product;
import com.MachineTest.Nimap.Service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody ProductBean request) {
		return productService.saveProduct(request);
	}
	@GetMapping("/products/{id}")
	public Product getById(@PathVariable int id) {
		return productService.getById(id);
	}
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody ProductBean reqBean) {
		reqBean.setId(id);
		return productService.updateProduct(reqBean);
	}
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getProducts(@RequestParam (defaultValue = "0") int page){
		PageRequest request= PageRequest.of(page, 10);
		return ResponseEntity.ok(productService.getAll(request));
	}
}
