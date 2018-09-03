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
        empList.add(judgeService.getById((Integer) request.getSession().getAttribute("userId")));
        request.setAttribute("empList", empList);

        return "/view/jsp/judgePage.jsp";
    }
}
