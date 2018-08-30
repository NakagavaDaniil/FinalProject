package controller.command;



import model.entity.Player;
import model.entity.User;
import model.service.PlayerService;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class PlayerInfoCommand implements Command {
    PlayerService playerService;

    public PlayerInfoCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        List<Player> empList = new ArrayList<Player>();
        empList.add(playerService.getById((Integer) request.getSession().getAttribute("userId")));
        request.setAttribute("empList", empList);

        return "/view/jsp/playerPage.jsp";
    }
}
