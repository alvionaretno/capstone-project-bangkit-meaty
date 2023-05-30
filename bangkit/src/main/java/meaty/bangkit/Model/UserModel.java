package meaty.bangkit.Model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)

public class UserModel implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 50)
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull
    @Lob
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(max = 50)
    @Column(name = "usia", nullable = false)
    private String usia;

    @NotNull
    @Size(max = 50)
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotNull
    @Size(max = 50)
    @Column(name = "domisili", nullable = false)
    private String domisili;

    @NotNull
    @Size(max = 50)
    @Column(name = "pekerjaan", nullable = false)
    private String pekerjaan;
}

