package controller.command;


import model.entity.User;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserInfoCommand implements Command{
    private UserService userService;

    UserInfoCommand(UserService userService) {
        this.userService = userService;
    }

    /**
     * @param request
     * adding data about user
     *
     * @return page url
     */
    @Override
    public String execute(HttpServletRequest request) {

        List<User> empList = new ArrayList<>();
        empList.add(userService.getById((Integer) request.getSession().getAttribute("userId")));
        request.setAttribute("empList", empList);


        return "/view/jsp/userPage.jsp";
    }
}
