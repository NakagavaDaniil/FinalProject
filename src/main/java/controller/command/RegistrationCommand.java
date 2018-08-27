package controller.command;

import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entity.User;
import model.service.DAOService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.GregorianCalendar;

public class RegistrationCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        String FIRST_NAME = request.getParameter("name");
        String LAST_NAME = request.getParameter("surname");
        String EMAIL = request.getParameter("email");
        String LOGIN = request.getParameter("login");
        String PASSWORD=request.getParameter("psw");
        Date  BIRTH_DATE = dateConverter(request);

        DAOService daoService = new DAOService();

        if (daoService.checkWithDB(EMAIL,"email")){return "/login.jsp"; }

        User user = new User();
        user.setUSER_FIRST_NAME(FIRST_NAME);
        user.setUSER_LAST_NAME(LAST_NAME);
        user.setEMAIL(EMAIL);
        user.setUSER_LOGIN(LOGIN);
        user.setUSER_PASSWORD(PASSWORD);
        user.setBIRTH_DATE(BIRTH_DATE);

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();

        int add = userDAO.addUser(user);

        String result = (add == 0) ? "view/register.jsp" : "view/main.jsp";

        if (add == 0) {
            result="error.jsp";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }


        return result;
    }

    private Date dateConverter(HttpServletRequest request){

        int year = Integer.parseInt(request.getParameter("year"));
        int month = RegistrationCommand.month.valueOf(request.getParameter("month")).ordinal();
        int day = Integer.parseInt(request.getParameter("day"));
       GregorianCalendar date = new GregorianCalendar(year,month,day);

        return new Date(date.getTimeInMillis());
    }


    private enum month{
        January,February,March,April,May,June,July,August,September,October,November,December
    }

}
