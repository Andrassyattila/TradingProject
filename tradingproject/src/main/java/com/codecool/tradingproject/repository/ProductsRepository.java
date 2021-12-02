package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long aLong);

    @Query(value= "Select * from product where authorized = false", nativeQuery = true)
    Collection<Product> findAllByAuthorized();

    @Query(value= "Select * from product where authorized = true ", nativeQuery = true)
    Collection<Product> findAllByAuthorizedTrue();

    @Query(value= "Select * from product where authorized = true order by publication_date desc limit 5 ", nativeQuery = true)
    List<Product> findFirst5ByOrderByPublicationDateDesc();


}
