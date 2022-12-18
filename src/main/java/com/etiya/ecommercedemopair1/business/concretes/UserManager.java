package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.UserService;
import com.etiya.ecommercedemopair1.business.constants.Messages;
import com.etiya.ecommercedemopair1.core.util.messages.MessageService;
import com.etiya.ecommercedemopair1.core.util.results.DataResult;
import com.etiya.ecommercedemopair1.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import com.etiya.ecommercedemopair1.repository.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private MessageService messageService;


    @Override
    public DataResult<User> findById(int id) {
        User user = userRepository.findById(id);
        return new SuccessDataResult<User>(user, messageService.getMessage(Messages.User.usergetted));
    }

    @Override
    public boolean existsById(int id) {
        return userRepository.existsById(id);
    }
}
