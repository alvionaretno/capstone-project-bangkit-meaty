package meaty.bangkit.RequestAuthentication;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    String nama;
}

