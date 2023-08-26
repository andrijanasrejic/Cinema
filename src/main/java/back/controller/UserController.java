package back.controller;

import back.document.User;
import back.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping("/register/{name}/{password}/{email}")
    public ResponseEntity<String> register(@PathVariable(value = "name") String name, @PathVariable(value = "password") String password, @PathVariable(value = "email") String email) {

        if(userRepository.findByUserName(name) != null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Username already in use!");

        }

        User newUser = new User(name, password, email);

        try {
            userRepository.save(newUser);
            return ResponseEntity.ok("Registration successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
        }

    }

    @GetMapping("/login/{name}/{password}")
    public ResponseEntity<String> login(@PathVariable(value = "name") String name, @PathVariable(value = "password") String password){
        try {
            User user = userRepository.findByUserName(name);
            if(!Objects.equals(user.getPassword(), password)){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed!");
            }
            System.out.println(user);
            return ResponseEntity.ok().body("Login successful");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed!");
        }
    }

}