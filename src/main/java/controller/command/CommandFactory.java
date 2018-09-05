package controller.command;

import model.service.JudgeService;
import model.service.PlayerService;
import model.service.TeamService;
import model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();

    private Map<String, Command> command = new HashMap<>();
    private CommandFactory() {

    }


    /**
     * SingleTon pattern
     * @return CommandFactory
     */
    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }


    /**
     * init HashMap with commands
     */
    {

        command.put("/login", new LoginCommand(new UserService()));
        command.put("/main",new MainCommand());
        command.put("/reg",new RegistrationCommand(new UserService()));
        command.put("/registration",new RegisterFormCommand());
        command.put("/logOut",new LogoutCommand());
        command.put("/userInfo", new UserInfoCommand(new UserService()));
        command.put("/playerInfo",new PlayerInfoCommand(new PlayerService()));
        command.put("/teamInfo", new TeamInfoCommand(new TeamService()));
        command.put("/judgeInfo", new JudgeInfoCommand(new JudgeService()));
        command.put("/questionInfo", new QuestionsCommand(new JudgeService()));


    }

    /**
     * @param request
     * return page url with new data
     * @return Command
     *
     */
    public Command getCommand(HttpServletRequest request) {

            String action = request.getRequestURI();
        return this.command.get(action);

    }
}
