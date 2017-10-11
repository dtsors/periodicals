package periodicals;

import lombok.Getter;

import static periodicals.Constants.*;

@Getter
public enum AlertMessage {
    DB_ERROR(STATUS_DANGER, MSG_DB_ERROR),
    NO_SUCH_USER(STATUS_DANGER, MSG_NO_SUCH_USER),
    WRONG_PASSWORD(STATUS_DANGER, MSG_WRONG_PASSWORD),
    REGISTRATION_FAULT(STATUS_DANGER, MSG_REGISTRATION_FAULT),
    WRONG_TOKEN(STATUS_DANGER, MSG_WRONG_TOKEN),
    EMPTY(STATUS_EMPTY, ""),
    REGISTRATION_SUCCESSFUL(STATUS_SUCCESS, MSG_REGISTRATION_SUCCESSFUL),
    LOGIN_SUCCESSFUL(STATUS_INFO, MSG_LOGIN_SUCCESSFUL),
    LOGOUT(STATUS_INFO, MSG_LOGOUT),
    CHECK_MAIL(STATUS_INFO, MSG_CHECK_MAIL),
    PASSWORD_CHANGED(STATUS_INFO, MSG_PASSWORD_CHANGED),
    SUCCESS(STATUS_INFO, "");

    private String type;
    private String message;

    AlertMessage(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
