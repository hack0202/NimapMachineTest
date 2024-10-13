package com.MachineTest.Nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MachineTest.Nimap.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
