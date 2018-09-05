import model.entity.User;
import model.service.JudgeService;
import model.service.PlayerService;
import model.service.TeamService;
import model.service.UserService;
import org.junit.Assert;
import org.junit.Test;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestAll {
    @Test
    public void testLoginService(){
        UserService userService = new UserService();
        Optional<User> user =userService.login("admin","1");

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


    @Test
    public void testGetTeamPlayer(){
        TeamService playerService = new TeamService();
        List<String> sad;
        sad = playerService.getTeamPLayer(2);
        System.out.println(sad);
    }


    @Test
    public void testQuestion(){
        JudgeService judgeService = new JudgeService();
        judgeService.getAllQuest();
        Assert.assertNotNull(judgeService.getAllQuest());
    }
}
