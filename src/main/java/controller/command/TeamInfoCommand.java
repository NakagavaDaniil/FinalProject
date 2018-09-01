package controller.command;


import model.service.PlayerService;


import javax.servlet.http.HttpServletRequest;


public class TeamInfoCommand implements Command{
    
    PlayerService playerService;

    public TeamInfoCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String command = request.getParameter("teamCommand");
        //TODO set int teamPage.jsp parameter!
   request.setAttribute("empList",playerService.getAllMyTeams((Integer) request.getSession().getAttribute("userId")));

        


        return "/view/jsp/teamPage.jsp";
    }
}
