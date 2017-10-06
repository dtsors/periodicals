package periodicals.controller;

import periodicals.domain.Periodical;
import periodicals.model.dao.DaoFactory;
import periodicals.model.dao.PeriodicalDao;
import periodicals.model.dao.exceptions.PersistException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DeletePeriodical", urlPatterns = {"/deleteperiodical.jsp"})
public class DeletePeriodical extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        try {
            Periodical periodical = new Periodical();
            periodical.setId(Integer.parseInt(req.getParameter("id")));
            periodicalDao.delete(periodical);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}