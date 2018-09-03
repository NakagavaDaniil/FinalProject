import model.entity.User;
import model.service.PlayerService;
import model.service.TeamService;
import model.service.UserService;
import org.junit.Test;


import java.sql.Date;
import java.util.Optional;

public class TestAll {
    @Test
    public void testLoginService(){
        UserService userService = new UserService();
        Optional<User> user =userService.login("admin","1");

    }
    @Test
    public void testPlayer(){
        PlayerService playerService = new PlayerService();

    }
    @Test
    public void testTeams(){
        TeamService playerService = new TeamService();
    }
    @Test
    public void testMyTeams(){
        TeamService playerService = new TeamService();
    }

    @Test
    public void testCreatUkrUser(){
        User user = new User();
        user.setEMAIL("Хлопак");
        user.setUSER_PASSWORD("212");
        user.setUSER_LOGIN("Логін");
        user.setUSER_LAST_NAME("Піська");
        user.setUSER_FIRST_NAME("ЇхалоЄ");
        user.setBIRTH_DATE(new Date(12,12,12));
        UserService userService = new UserService();
        userService.register(user);

    }
}
