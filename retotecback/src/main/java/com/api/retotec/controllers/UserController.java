package com.api.retotec.controllers;

import com.api.retotec.models.UserModel;
import com.api.retotec.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://127.0.0.7:5500")
@RestController
@RequestMapping("/futbolista")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public Page<UserModel> getUsers(){
        final Pageable pageable = PageRequest.of(0, 10, Sort.by(
                Sort.Direction.ASC, "id"
        ));
        return this.userService.getUsers();
    }
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }


    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable long id){
        return this.userService.getById(id);
    }
    @PutMapping(path = "{id}")
    public UserModel updateUserById(@RequestBody UserModel request ,@PathVariable Long id){
        return this.userService.updateByID(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "User with id" + id + " deleted!";
        } else {
            return "User with id" + id + " could not be deleted!";
        }

    }

}
