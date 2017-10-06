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

@WebServlet(name = "AddPeriodical", urlPatterns = {"/addperiodical.jsp"})
public class AddPeriodical extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoFactory daoFactory = (DaoFactory) req.getServletContext().getAttribute("periodicals.model");
        PeriodicalDao periodicalDao = daoFactory.getPeriodicalDao();
        Periodical periodical = new Periodical();
        periodical.setName(req.getParameter("name"));
        periodical.setDescription(req.getParameter("description"));
        periodical.setIssuesPerMonth(Integer.parseInt(req.getParameter("issuesPerMonth")));
        periodical.setCost(req.getParameter("cost"));
        try {
            periodicalDao.save(periodical);
        } catch (PersistException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
