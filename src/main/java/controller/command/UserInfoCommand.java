package controller.command;

import model.dao.UserDAO;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class UserInfoCommand implements Command{
    @Override
    public String execute(HttpServletRequest request) {


        UserDAO userDAO = UserDAO.getInstance();
        List<User> empList = new ArrayList<User>();

            empList.add(userDAO.getUserById((Integer) request.getSession().getAttribute("userId")));
            request.setAttribute("empList", empList);


        return "/view/jsp/userPage.jsp";
    }
}
