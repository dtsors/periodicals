package periodicals.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private String token;
    private String role;
}
