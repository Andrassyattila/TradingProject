package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories,Long> {

}
