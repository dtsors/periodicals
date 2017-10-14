package periodicals;

public class Constants {
    public static final int PAGINATION_COUNT = 3;
    public static final String CHARACTER_ENCODING = "UTF-8";
    public static final String CONTENT_TYPE = "text/html";
    public static final String ENGLISH = "en";
    public static final String RUSSIAN = "ru";

    public static final String PAGE_HOME = "/index.jsp";
    public static final String PAGE_ERROR = "/error.jsp";
    public static final String PAGE_SUBSCRIBERS = "/viewusers.jsp";
    public static final String PAGE_RESTRICTION = "/restriction.jsp";
    public static final String PAGE_LOGIN = "/login.jsp";

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
    public static final String PARAM_ADDRESS = "address";
    public static final String PARAM_PAGE = "page";

    public static final String SESSION_LANGUAGE = "periodicals.language";
    public static final String SESSION_COMMAND_RESULT = "periodicals.command_result";
    public static final String SESSION_IS_AUTHORIZED = "periodicals.isAuthorized";
    public static final String SESSION_DAO = "periodicals.dao";
    public static final String SESSION_USER = "periodicals.user";
    public static final String SESSION_USER_LIST = "periodicals.userList";
    public static final String SESSION_PERIODICAL = "periodicals.periodical";
    public static final String SESSION_PERIODICAL_LIST = "periodicals.periodicalList";
    public static final String SESSION_ORDER = "periodicals.order";

    public static final String MSG_DB_ERROR = "Error in data manipulating";
    public static final String MSG_NO_SUCH_USER = "No such user";
    public static final String MSG_WRONG_PASSWORD = "Wrong password";
    public static final String MSG_LOGIN_SUCCESSFUL = "Login is successful";
    public static final String MSG_REGISTRATION_SUCCESSFUL = "Registration is successful";
    public static final String MSG_REGISTRATION_FAULT = "Registration is unsuccessful";
    public static final String MSG_CHECK_MAIL = "Please check your email";
    public static final String MSG_PASSWORD_CHANGED = "Password has been changed";
    public static final String MSG_WRONG_TOKEN = "Wrong token";
    public static final String MSG_LOGOUT = "Good bye";
    public static final String MSG_BUSKET_IS_EMPTY = "Your busket is empty";

    public static final String STATUS_EMPTY = "";
    public static final String STATUS_DANGER = "alert-danger";
    public static final String STATUS_SUCCESS = "alert-success";
    public static final String STATUS_WARNING = "alert-warning";
    public static final String STATUS_INFO = "alert-info";

    public static final String LOG_CAN_NOT_FIND_USER = ">>Can't find user";
    public static final String LOG_CAN_NOT_UPDATE_USER = ">>Can't update user";
    public static final String LOG_CAN_NOT_CREATE_USER = ">>Can't create user";
    public static final String LOG_CAN_NOT_CREATE_PERIODICAL = ">>Can't create periodical";
    public static final String LOG_CAN_NOT_DELETE_USER = ">>Can't delete user";
    public static final String LOG_CAN_NOT_DELETE_PERIODICAL = ">>Can't delete periodical";
}
