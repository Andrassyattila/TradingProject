package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {


    Boolean existsByUsername(String username);

    Users findByUsername(String string);

    @Override
    Optional<Users> findById(Long aLong);

}
