package controller.command;


import model.dao.DAOFactory;
import model.dao.UserDAO;
import model.entity.User;
import model.service.DAOService;

import javax.servlet.http.HttpServletRequest;



public class LoginCommand implements Command {
    public String execute (HttpServletRequest request)  {
        String LOGIN = request.getParameter("login");
        String PASSWORD = request.getParameter("psw");

        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();

        User user = userDAO.getUser(LOGIN, PASSWORD);

        if( LOGIN == null || LOGIN.equals("") || PASSWORD == null || PASSWORD.equals("")  ){

            return "view/main.jsp";
        }

        DAOService daoService = new DAOService();

        if (!daoService.checkWithDB(LOGIN,"login")){

            return "view/main.jsp"; }

//        if(CommandUtility.checkUserIsLogged(request, LOGIN)){
//            return "/error.jsp";
//        TODO }

        request.setAttribute("userLogin",user.getUSER_LOGIN());
        request.setAttribute("userID",user.getID());

        //TODO change direct
        return "view/main.jsp";


    }



}
