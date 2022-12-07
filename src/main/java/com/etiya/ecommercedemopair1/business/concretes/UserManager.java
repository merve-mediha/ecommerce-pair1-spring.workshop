package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.UserService;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import com.etiya.ecommercedemopair1.repository.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;


    @Override
    public User findById(int id) {
        return this.userRepository.findById(id);
    }

    @Override
    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }
}
