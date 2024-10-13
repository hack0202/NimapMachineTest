package com.MachineTest.Nimap.Service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.MachineTest.Nimap.Bean.ProductBean;
import com.MachineTest.Nimap.Entity.Product;

public interface ProductService {
public String saveProduct(ProductBean request);
public Product getById(int id);
public String deleteProduct(int id);
public String updateProduct(ProductBean reqBean);
public Page<Product> getAll(Pageable pageable);
}
