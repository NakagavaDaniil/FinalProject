package controller.command;


import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;


public class LoginCommand implements Command {
    private UserService userService;
    public LoginCommand(UserService userService) {
        this.userService=userService;
    }

    public String execute (HttpServletRequest request)  {

        String login = request.getParameter("login");
        String password = request.getParameter("psw");

        HttpSession session = request.getSession();

        if( login == null || login.equals("") || password == null || password.equals("")  ){

            return "view/jsp/main.jsp";
        }

       try {
          if (CommandUtility.checkUserIsLogged(login)) {
              request.setAttribute("logged",true);
              return "view/jsp/main.jsp";
          }
        }catch (Exception e){
           e.printStackTrace();
        }
        Optional<User> user = userService.login(login,password);

       session.setAttribute("userLogin",user.get().getUSER_LOGIN());
        session.setAttribute("userId",user.get().getID());


        return "/view/jsp/main.jsp";


    }



}
