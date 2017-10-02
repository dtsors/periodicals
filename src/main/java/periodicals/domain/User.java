package periodicals.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id = 1;
    private String login = "login";
    private String password = "password";
    private String email = "email";

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
