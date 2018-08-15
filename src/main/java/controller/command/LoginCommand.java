package controller.command;

import model.connection.ConnectionPoolHolder;
import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entity.User;
import model.service.DAOService;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginCommand implements Command {
    public String execute (HttpServletRequest request)  {
        String LOGIN = request.getParameter("login");
        String PASSWORD = request.getParameter("pass");

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();

        User user = userDAO.getUser(LOGIN, PASSWORD);

        if( LOGIN == null || LOGIN.equals("") || PASSWORD == null || PASSWORD.equals("")  ){

            return "/login.jsp";
        }

        DAOService daoService = new DAOService();

        if (!daoService.checkWithDB(LOGIN,"login")){return "/login.jsp"; }

        if(CommandUtility.checkUserIsLogged(request, LOGIN)){
            return "/error.jsp";
        }
        return "/userPage.jsp";


    }



}
