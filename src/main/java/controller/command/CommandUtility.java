package controller.command;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;

public class CommandUtility {
    static boolean checkUserIsLogged(HttpServletRequest request, String userName){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if (!loggedUsers.stream().allMatch(loggedUsers::equals)) {
            loggedUsers.add(userName);
            request.getSession().getServletContext()
                    .setAttribute("loggedUsers", loggedUsers);
            return false;
        } else {
            return true;
        }
    }
}
