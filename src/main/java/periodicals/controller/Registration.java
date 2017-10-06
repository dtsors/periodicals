package periodicals.controller;

import periodicals.domain.User;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.UserDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration", urlPatterns = {"/registration.jsp"})
public class Registration extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        UserDao userDao = daoFactory.getUserDao();
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        try {
            userDao.save(user);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
