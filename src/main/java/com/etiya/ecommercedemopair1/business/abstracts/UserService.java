package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.User;


public interface UserService {
    User findById(int id);
    boolean existsById(int id);
}
