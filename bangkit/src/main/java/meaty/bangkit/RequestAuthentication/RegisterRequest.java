package meaty.bangkit.RequestAuthentication;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterRequest implements Serializable {
    String email;
    String password;
    String username;
    String nama;
    String usia;
    String gender;
    String pekerjaan;
    String domisili;
}