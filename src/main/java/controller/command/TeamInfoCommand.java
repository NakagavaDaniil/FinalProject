package controller.command;


import model.entity.Game;
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

    /**
     * @param request
     * according to action return list of data to jsp
     * using if() not best decision
     *
     * class create , select , join and show teams
     * @return page url
     */
    @Override
    public String execute(HttpServletRequest request) {

        List<Team> teamList = new ArrayList<>();
        int userId = (int) request.getSession().getAttribute("userId");
        String action = request.getParameter("action");

        System.out.println(action);
            if (action.equals("myTeams")) {

                teamList = teamService.getAllMyTeams(userId);

            }
            if (action.equals("allTeams")) {
                teamList = teamService.getAllTeams();

            }
            if(action.equals("search")){

                teamList.add(teamService.getByNameTeam(request.getParameter("search_string")));
            }
            if(action.equals("select")){
                Team temp = teamService.getByNameTeam(request.getParameter("teamName"));
                selectTeam(request, temp);
                teamList = teamService.getAllTeams();
            }
            if(action.equals("create")){
                Team temp = new Team();
                temp.setName(request.getParameter("create_string"));
                teamService.createTeam(temp);

                teamList = teamService.getAllTeams();
            }
            if(action.equals("join")){
                teamService.joinTeam(userId, Integer.parseInt(request.getParameter("join_teamId")));
                Team temp = teamService.findById(Integer.parseInt(request.getParameter("join_teamId")));
                selectTeam(request, temp);
                teamList = teamService.getAllTeams();
            }


        request.setAttribute("empList",teamList);

        return "/view/jsp/teamPage.jsp";
    }

    private void selectTeam(HttpServletRequest request, Team temp) {
        List<Team> list = new ArrayList<>();
        list.add(temp);
        List<Game> gameHistory = teamService.getTeamHistory(temp.getName());
        List<String> teamPlayer = teamService.getTeamPLayer(temp.getId());
        request.setAttribute("teamPlayers", teamPlayer);
        request.setAttribute("history", gameHistory);
        request.setAttribute("teamList", list);
    }


}
