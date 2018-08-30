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
        if(command=="myTeam"){request.setAttribute("empList",playerService.getAllMyTeams((Integer) request.getSession().getAttribute("userId")));}
        else if(command==null||command.equals("")){request.setAttribute("empList", playerService.getAllTeams());}
        else {request.setAttribute("empList", playerService.getByNameTeam(request.getParameter(command)));}
        


        return "/view/jsp/teamPage.jsp";
    }
}
