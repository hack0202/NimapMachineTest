package com.MachineTest.Nimap.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MachineTest.Nimap.Entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
