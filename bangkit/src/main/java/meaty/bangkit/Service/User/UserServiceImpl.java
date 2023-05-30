package meaty.bangkit.Service.User;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import meaty.bangkit.Model.UserModel;
import meaty.bangkit.Repository.UserDB;
import meaty.bangkit.RequestAuthentication.UserRequest;


@Service
@Transactional

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel getUserByUsername(String username) {
        return userDB.findByUsername(username);
    }
    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
    @Override
    public UserModel addUser(UserModel user){
        return userDB.save(user);
    }
    @Override
    public List<UserModel> getAllUser() {
        return userDB.findAll();
    }

    @Override
    public UserModel getUserById(String id) {
        return userDB.findById(id);
    }
    
}