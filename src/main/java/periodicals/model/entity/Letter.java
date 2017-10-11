package periodicals.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter @EqualsAndHashCode
public class Letter {
    private String subject;
    private String message;
    private String recipient;

    public Letter(String recipient) {
        this.recipient = recipient;
    }

    public Letter getRegistrationSuccessful(String login) {
        subject = "Thank you for registering";
        message = "Your login is: " + login;
        return this;
    }

    public Letter getPasswordRecovery(String token) {
        subject = "Changing password";
        message = "http://localhost:8080/updatepassword.jsp?token=" + token;
        return this;
    }

    public Letter getPasswordChanged() {
        subject = "Password has been changed";
        message = "Some message";
        return this;
    }

    public Letter getOrder(String order) {
        subject = "Your order";
        message = order;
        return this;
    }
}
