package meaty.bangkit.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import meaty.bangkit.Model.UserModel;
import meaty.bangkit.Service.User.UserService;
import meaty.bangkit.RequestAuthentication.UserAllRequest;
import meaty.bangkit.RequestAuthentication.UserRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/{username}")
    private UserModel getuser(@PathVariable("username") String username, Principal principal) {
        try {
            UserModel user = userService.getUserByUsername(username);
            return user;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "username " + username + " not found. ");
        }
    }

    @GetMapping(value = "/")
    private List<UserAllRequest> getalluser() {
        try {
            List<UserAllRequest> userRequest = new ArrayList<UserAllRequest>();
            for (UserModel user : userService.getAllUser()) {
                UserAllRequest tempUser = new UserAllRequest();
                tempUser.setNama(user.getNama());
                tempUser.setUsername(user.getUsername());
                userRequest.add(tempUser);
            }
            return userRequest;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "not found.");
        }
    }
}
