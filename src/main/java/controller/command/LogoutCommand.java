package controller.command;



import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        CommandUtility commandUtility = new CommandUtility();
        commandUtility.removeUser((String) request.getSession().getAttribute("userLogin"));
        request.getSession().removeAttribute("userLogin");



        return "/view/jsp/main.jsp";
    }
}
