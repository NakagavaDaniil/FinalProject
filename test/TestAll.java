import model.entity.User;
import model.service.PlayerService;
import model.service.UserService;
import org.junit.Test;


import java.sql.Date;
import java.util.Optional;

public class TestAll {
    @Test
    public void testLoginService(){
        UserService userService = new UserService();
        Optional<User> user =userService.login("admin","1");

        System.out.println(user.get());
    }
    @Test
    public void testPlayer(){
        PlayerService playerService = new PlayerService();
        System.out.println(playerService.getById(2));

    }
    @Test
    public void testTeams(){
        PlayerService playerService = new PlayerService();
        System.out.println(playerService.getAllTeams());
    }
    @Test
    public void testMyTeams(){
        PlayerService playerService = new PlayerService();
        System.out.println(playerService.getAllMyTeams(2));
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
