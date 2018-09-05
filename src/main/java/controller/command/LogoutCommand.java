package controller.command;



import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        request.getSession().removeAttribute("userLogin");
        request.getSession().removeAttribute("userId");

        return "/view/jsp/main.jsp";
    }
}
