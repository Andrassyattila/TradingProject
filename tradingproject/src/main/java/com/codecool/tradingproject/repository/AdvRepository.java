package com.codecool.tradingproject.repository;

import com.codecool.tradingproject.model.Advertise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdvRepository extends CrudRepository<Advertise, Long> {
    List<Advertise> findById(long id);


}
