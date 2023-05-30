package meaty.bangkit.Service.User;
import java.util.List;

import meaty.bangkit.Model.UserModel;
import meaty.bangkit.RequestAuthentication.UserRequest;

public interface UserService {
    UserModel getUserByUsername(String username);
    String encrypt(String password);
    UserModel addUser(UserModel user);
    public List<UserModel> getAllUser();
    UserModel getUserById(String id);
}