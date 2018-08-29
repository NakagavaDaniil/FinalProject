package controller.command;

import model.dao.DAOFactory;
import model.dao.PlayerDAO;
import model.dao.UserDAO;
import model.entity.Player;
import model.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PlayerInfoCommand implements Command {
    private static Player user =null ;

    @Override
    public String execute(HttpServletRequest request) {

try {


    CommandUtility commandUtility = new CommandUtility();
    user = (Player) commandUtility.getLoggedUser((String) request.getSession().getAttribute("userLogin"));

    DAOFactory daoFactory = DAOFactory.getInstance();
    PlayerDAO playerDAO = daoFactory.getPlayerDAO();
    playerDAO.getPlayer(user.getUSER_LOGIN());



    List<Player> empList = new ArrayList<>();

    empList.add(playerDAO.getPlayer(user.getUSER_LOGIN()));
    request.setAttribute("empList", empList);
}catch (Exception e){
    e.printStackTrace();
}


        return "/view/jsp/playerPage.jsp";
    }
}
