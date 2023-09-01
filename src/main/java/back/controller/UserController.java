package back.controller;

import back.document.Film;
import back.document.Projection;
import back.document.User;
import back.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public ResponseEntity<User> login(@PathVariable(value = "name") String name, @PathVariable(value = "password") String password){
        try {
            User user = userRepository.findByUserName(name);
            if(!Objects.equals(user.getPassword(), password)){
                return (ResponseEntity<User>) ResponseEntity.notFound().header("Authentification failed");
            }
            return ResponseEntity.ok(user);
        } catch (Exception e){
            return (ResponseEntity<User>) ResponseEntity.notFound().header("Authentification failed");
        }
    }


    @PutMapping("/user/projection/{name}/{time}/{size}/{price}")
    public ResponseEntity<String> addProjectionTime(@PathVariable(value = "name") String name,
                                                    @PathVariable(value = "time") String time,
                                                    @PathVariable(value = "size") Integer size,
                                                    @PathVariable(value = "price") Float price){
        User user;

        try {
            user = userRepository.findByUserName(name);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Film not found!");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(time, formatter);

        Projection projection = new Projection(dateTime, name, price, size);
        System.out.println(projection.getTime());

        user.addProjection(projection);
        userRepository.save(user);

        return ResponseEntity.ok("Added new projection");
    }

}