package controller.command;


import model.entity.User;
import model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);

    private UserService userService;
    LoginCommand(UserService userService) {
        this.userService=userService;
    }

    /**
     * @param request
     * check login and password
     * add user id in session
     * @return page url
     */
    public String execute (HttpServletRequest request)  {

        String login = request.getParameter("login");
        String password = request.getParameter("psw");

        HttpSession session = request.getSession();

        if( login == null || login.equals("") || password == null || password.equals("")  ){

            return "view/jsp/main.jsp";
        }


        Optional<User> user = userService.login(login,password);
       if(user.isPresent()){
           session.setAttribute("userLogin",user.get().getUSER_LOGIN());
           session.setAttribute("userId",user.get().getID());
           logger.info("User "+ user.get().getID()+" "+user.get().getUSER_LOGIN()+" logged successfully.");

           return "view/jsp/main.jsp";
       }

        logger.info("Invalid attempt of login user:'"+ login+"'");


        return "/view/jsp/main.jsp";


    }



}
