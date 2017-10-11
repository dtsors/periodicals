package periodicals;

public class Constants {
    public static final String CHARACTER_ENCODING = "UTF-8";
    public static final String CONTENT_TYPE = "text/html";
    public static final String ENGLISH = "en";
    public static final String RUSSIAN = "ru";

    public static final String PAGE_HOME = "/index.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PAGE_SUBSCRIBERS = "/viewusers.jsp";
    public static final String PAGE_RESTRICTION = "/restriction.jsp";

    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_ID = "id";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_DESCRIPTION = "description";
    public static final String PARAM_ISSUES_PER_MONTH = "issuesPerMonth";
    public static final String PARAM_COST = "cost";
    public static final String PARAM_LOGIN = "login";
    public static final String PARAM_LANG = "lang";
    public static final String PARAM_COUNT = "count";

    public static final String SESSION_LANGUAGE = "periodicals.language";
    public static final String SESSION_COMMAND_RESULT = "periodicals.command_result";
    public static final String SESSION_IS_AUTHORIZED = "periodicals.isAuthorized";
    public static final String SESSION_DAO = "periodicals.dao";
    public static final String SESSION_USER = "periodicals.user";
    public static final String SESSION_USER_LIST = "periodicals.userList";
    public static final String SESSION_PERIODICAL = "periodicals.periodical";
    public static final String SESSION_PERIODICAL_LIST = "periodicals.periodicalList";
    public static final String SESSION_ORDER = "periodicals.order";

    static final String MSG_DB_ERROR = "Error in data manipulating";
    static final String MSG_NO_SUCH_USER = "No such user";
    static final String MSG_WRONG_PASSWORD = "Wrong password";
    static final String MSG_LOGIN_SUCCESSFUL = "Login is successful";
    static final String MSG_REGISTRATION_SUCCESSFUL = "Registration is successful";
    static final String MSG_REGISTRATION_FAULT = "Registration is unsuccessful";
    static final String MSG_CHECK_MAIL = "Please check your email";
    static final String MSG_PASSWORD_CHANGED = "Password has been changed";
    static final String MSG_WRONG_TOKEN = "Wrong token";
    static final String MSG_LOGOUT = "Good bye";

    static final String STATUS_EMPTY = "";
    static final String STATUS_DANGER = "alert-danger";
    static final String STATUS_SUCCESS = "alert-success";
    public static final String STATUS_INFO = "alert-info";

    public static final String LOG_CAN_NOT_FIND_USER = ">>Can't find user";
    public static final String LOG_CAN_NOT_UPDATE_USER = ">>Can't update user";
    public static final String LOG_CAN_NOT_CREATE_USER = ">>Can't create user";
    public static final String LOG_CAN_NOT_CREATE_PERIODICAL = ">>Can't create periodical";
    public static final String LOG_CAN_NOT_DELETE_USER = ">>Can't delete user";
    public static final String LOG_CAN_NOT_DELETE_PERIODICAL = ">>Can't delete periodical";
}
