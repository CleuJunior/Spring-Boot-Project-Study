package br.com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.User;
import br.com.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id)
    {

       return this.userRepository.findById(id).orElse(null);

    }

    @GetMapping("/list")
    public List<User> allUser()
    {
        
        return this.userRepository.findAll();
    }

    @PostMapping("/")
    public User user(@RequestBody User user)
    {
        return this.userRepository.save(user);
        
    }
    
    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id)
    {
        return this.userRepository.findByIdGreaterThan(id);
        
    }
    
    @GetMapping("/findbyname/{name}")
    public List<User> findByName(@PathVariable("name") String name)
    {
        return this.userRepository.findByNameIgnoreCase(name);
        
    }
    
}
