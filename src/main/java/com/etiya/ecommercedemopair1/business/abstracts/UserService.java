package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.User;


public interface UserService {
    DataResult<User> findById(int id);
    boolean existsById(int id);
}
