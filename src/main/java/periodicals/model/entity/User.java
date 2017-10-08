package periodicals.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class User {
    private int id = 1;
    private String login = "login";
    private String password = "password";
    private String email = "email";
}
