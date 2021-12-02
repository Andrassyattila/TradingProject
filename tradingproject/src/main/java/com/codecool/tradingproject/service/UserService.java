package com.codecool.tradingproject.service;

import com.codecool.tradingproject.model.Users;

public interface UserService {

    public Users findByUsername(String username);

}
