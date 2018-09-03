package controller.command;

import model.service.JudgeService;

import javax.servlet.http.HttpServletRequest;

public class QuestionsCommand implements Command {
    private JudgeService judgeService;
    QuestionsCommand(JudgeService judgeService) {
        this.judgeService=judgeService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        return "/view/jsp/questionPage.jsp";
    }
    // TODO: 02.09.2018 ALL
}
