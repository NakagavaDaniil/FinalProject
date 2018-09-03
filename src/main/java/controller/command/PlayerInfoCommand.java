package controller.command;




import model.entity.Player;
import model.service.PlayerService;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


public class PlayerInfoCommand implements Command {
    private PlayerService playerService;

    PlayerInfoCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public String execute(HttpServletRequest request) {


        List<Player> empList = new ArrayList<>();
        ArrayList playerGameHistory = playerService.getById((Integer) request.getSession().getAttribute("userId")).getGameHistory();
         empList.add(playerService.getById((Integer) request.getSession().getAttribute("userId")));
        request.setAttribute("empList", empList);
        request.setAttribute("empHistory",playerGameHistory);
        return "/view/jsp/playerPage.jsp";
    }
}
