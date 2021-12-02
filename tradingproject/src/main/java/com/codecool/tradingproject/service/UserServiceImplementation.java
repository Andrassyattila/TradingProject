package com.codecool.tradingproject.service;

import com.codecool.tradingproject.model.Users;
import com.codecool.tradingproject.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService, UserDetailsService {
    private UsersRepository usersRepository;

    @Autowired
    public UserServiceImplementation(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = findByUsername(username);
        if(users == null){
            throw new UsernameNotFoundException(username);
        }
        return new UserDetailImplementation(users);
    }

    public void updateUser(Long id,Users upUsers){
        Users u = usersRepository.getById(id);
        u.setFirstName(upUsers.getFirstName());
        usersRepository.save(u);

    }
}
