package controller.command;


import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entity.User;
import model.service.DAOService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginCommand implements Command {
    public String execute (HttpServletRequest request)  {
        String LOGIN = request.getParameter("login");
        String PASSWORD = request.getParameter("psw");

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUser(LOGIN, PASSWORD);

        HttpSession session = request.getSession();

        if( LOGIN == null || LOGIN.equals("") || PASSWORD == null || PASSWORD.equals("")  ){

            return "view/jsp/main.jsp";
        }

        DAOService daoService = new DAOService();

        if (!daoService.checkWithDB(LOGIN,"login")){

            return "view/jsp/main.jsp"; }
try {


    if (CommandUtility.checkUserIsLogged(user)) {
        return "view/jsp/main.jsp";
    }
}catch (Exception e){
    e.printStackTrace();
}

      session.setAttribute("userLogin",user.getUSER_LOGIN());
        session.setAttribute("userId",user.getID());


        return "/view/jsp/main.jsp";


    }



}
