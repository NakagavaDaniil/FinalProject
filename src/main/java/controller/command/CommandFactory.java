package controller.command;

import model.service.PlayerService;
import model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();

    private Map<String, Command> command = new HashMap<String, Command>();
    private CommandFactory() {

    }

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    {
//TODO add all commands
        command.put("/login", new LoginCommand(new UserService()));
        command.put("/main",new MainCommand());
        command.put("/reg",new RegistrationCommand(new UserService()));
        command.put("/registration",new RegisterFormCommand());
        command.put("/logOut",new LogoutCommand());
        command.put("/userInfo", new UserInfoCommand(new UserService()));
        command.put("/playerInfo",new PlayerInfoCommand(new PlayerService()));
        command.put("/teamInfo", new TeamInfoCommand(new PlayerService()));

    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getRequestURI();
        System.out.println(action);
        Command command = this.command.get(action);
        return command;
    }
}
