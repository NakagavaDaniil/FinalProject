package controller.command;

import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class RegisterFormCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "view/jsp/registration.jsp";
    }
}
