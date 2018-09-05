package controller.command;

import model.entity.User;
import model.service.JudgeService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class JudgeInfoCommand implements Command{
    private JudgeService judgeService;
    JudgeInfoCommand(JudgeService judgeService) {
        this.judgeService = judgeService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        List<User> empList = new ArrayList<>();
        String userLogin = (String) request.getSession().getAttribute("userLogin");
        int userId = (int) request.getSession().getAttribute("userId");
        empList.add(judgeService.findById(userId));
        request.setAttribute("empList", empList);
        request.setAttribute("history",judgeService.getHistory(userLogin));

        return "/view/jsp/judgePage.jsp";
    }
}
