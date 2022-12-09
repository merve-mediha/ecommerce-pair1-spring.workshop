package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.UserService;
import com.etiya.ecommercedemopair1.business.constants.Paths;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Paths.apiPrefix + "users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getById")
    public DataResult<User> getById(int id){
        return userService.findById(id);
    }
}
