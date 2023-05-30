package meaty.bangkit.RestController;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;

import meaty.bangkit.Model.UserModel;
import meaty.bangkit.RequestAuthentication.LoginRequest;
import meaty.bangkit.RequestAuthentication.LoginResponse;
import meaty.bangkit.RequestAuthentication.RegisterRequest;
import meaty.bangkit.Security.jwt.jwtutils;
import meaty.bangkit.Service.User.UserService;

import org.springframework.security.core.Authentication;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class jwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtutils jwtTokenUtil;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        final String jwt = jwtTokenUtil.generateToken((UserDetails) authenticate.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(jwt, authenticate.getName()));
    }

    @PostMapping(value = "/register")
    private UserModel register(@RequestBody RegisterRequest request, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field.");
        }

        else {
            UserModel user = new UserModel();
            user.setNama(request.getNama());
            user.setUsername(request.getUsername());
            user.setPassword(userService.encrypt(request.getPassword()));
            user.setDomisili(request.getDomisili());
            user.setEmail(request.getEmail());
            user.setGender(request.getGender());
            user.setPekerjaan(request.getPekerjaan());
            user.setUsia(request.getUsia());
            return userService.addUser(user);

        }
    }
}
