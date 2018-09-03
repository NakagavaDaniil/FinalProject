package controller.command;



import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {


        request.getSession().removeAttribute("userLogin");

        return "/view/jsp/main.jsp";
    }
}
