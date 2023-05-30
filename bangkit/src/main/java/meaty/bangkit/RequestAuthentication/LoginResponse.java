package meaty.bangkit.RequestAuthentication;

import lombok.Data;


@Data
public class LoginResponse {
    String username;
    String token;
    String type;
    public LoginResponse(String tokenjwt, String username) {
        this.username = username;
        this.token = tokenjwt;
        this.type = "Bearer";
    }
}
