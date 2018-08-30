package controller.command;

import model.service.UserService;

import java.util.concurrent.CopyOnWriteArrayList;


public class CommandUtility {
    //all logged users
private static CopyOnWriteArrayList<String> loggedUsers;

    {
        loggedUsers =new CopyOnWriteArrayList<>();
    }

    static boolean checkUserIsLogged(String login){
        if(loggedUsers.contains(login)){
            return true;
        }else {
            loggedUsers.add(login);
            return false;
        }
    }
    public void removeUser(String login){
        loggedUsers.remove(login);
    }

}
