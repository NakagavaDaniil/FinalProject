package controller.command;


import model.entity.Team;
import model.service.TeamService;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class TeamInfoCommand implements Command{
    
    private TeamService teamService;

    TeamInfoCommand(TeamService teamService) {
        this.teamService = teamService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        List<Team> teamList = new ArrayList<>();
        int userId = (int) request.getSession().getAttribute("userId");
        String action = request.getParameter("action");


            if (action.equals("myTeams")) {

                teamList = teamService.getAllMyTeams(userId);

            }
            if (action.equals("allTeams")) {
                teamList = teamService.getAllTeams();

            }
            if(action.equals("search")){
                System.out.println(teamService.getByNameTeam(request.getParameter("search_string")));
                teamList.add(teamService.getByNameTeam(request.getParameter("search_string")));

            }
            if(action.equals("select")){
                Team temp;
                temp = teamService.getByNameTeam(request.getParameter("teamName"));
                List<Team> list = new ArrayList<>();
                list.add(temp);
                request.setAttribute("teamList",list);
            }
            if(action.equals("create")){
                Team temp = new Team();
                temp.setName(request.getParameter("create_string"));
                teamService.createTeam(temp);
                teamList = teamService.getAllTeams();
            }


        request.setAttribute("empList",teamList);

        return "/view/jsp/teamPage.jsp";
    }



}
