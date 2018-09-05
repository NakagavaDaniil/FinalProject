package controller.command;

import model.entity.Question;
import model.service.JudgeService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;


public class QuestionsCommand implements Command {
    private JudgeService judgeService;
    QuestionsCommand(JudgeService judgeService) {
        this.judgeService=judgeService;
    }

    @Override
    public String execute(HttpServletRequest request) {

      String action =  request.getParameter("action");

        if(action.equals("add")){
            Question question = new Question();

            question.setQuestion(request.getParameter("quest_text"));
            question.setAnswear(request.getParameter("answer"));
            question.setVariantsOfAnswear(createVariants(request));
            question.setLanguage(request.getLocale().toLanguageTag());

            judgeService.createQuesion(question);
        }
        if(action.equals("myQuest")){
          request.setAttribute("empList", judgeService.getUserQuest((Integer) request.getSession().getAttribute("userId")));
        }
        if(action.equals("allQuest")){
            request.setAttribute("empList",judgeService.getAllQuest());

        }



        return "/view/jsp/questionPage.jsp";
    }
    private ArrayList<String> createVariants(HttpServletRequest request){

        String temp =  request.getParameter("variants");
        String[] split = temp.split(",");
        return new ArrayList<>(Arrays.asList(split));
    }


}
