package bankingsystem.backend.controller;

import bankingsystem.backend.dao.UserRepository;
import bankingsystem.backend.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/list-user")
public class TstController {

    private final UserRepository userRepository;

    public TstController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getUsers(){
       return this.userRepository.findAll();
    }
}
