package controller.command;

import javax.servlet.http.HttpServletRequest;

public class RegisterFormCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "view/jsp/registration.jsp";
    }
}
