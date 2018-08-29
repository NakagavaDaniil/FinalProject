package controller.command;

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

        command.put("/login", new LoginCommand());
        command.put("/main",new MainCommand());
        command.put("/reg",new RegistrationCommand());
        command.put("/registration",new RegisterFormCommand());
        command.put("/logOut",new LogoutCommand());
        command.put("/userPage", new UserInfoCommand());
        command.put("/playerPage",new PlayerInfoCommand());

    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getRequestURI();
        System.out.println(action);
        Command command = this.command.get(action);
        return command;
    }
}
