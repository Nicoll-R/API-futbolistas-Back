package com.api.retotec.services;

import com.api.retotec.models.UserModel;
import com.api.retotec.models.UserPosition;
import com.api.retotec.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;


    public Page<UserModel> getUsers(){
        final Pageable pageable = PageRequest.of(0, 10, Sort.by(
                Sort.Direction.ASC, "id"
        ));
        return userRepository.findAll(pageable);
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }



    public UserModel updateByID(UserModel request, Long id ){
        UserModel userModel = userRepository.findById(id).get();
        userModel.setFirstName(request.getFirstName());
        userModel.setLastName(request.getLastName());
        userModel.setDated (request.getDated());
        userModel.setCharact(request.getCharact());
        userModel.setPosition(request.getPosition());
        userRepository.save(userModel);
        return userModel;
    }

    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
