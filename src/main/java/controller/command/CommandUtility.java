package controller.command;

import model.entity.User;


import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;


public class CommandUtility {
    private static HashMap<String,User> loggedUsers=null;

    {
        loggedUsers =new HashMap<>();
    }

    static boolean checkUserIsLogged( User user){
        if(loggedUsers.containsKey(user.getUSER_LOGIN())){
            return true;
        }else {
            loggedUsers.put(user.getUSER_LOGIN(),user);
            return false;
        }
    }
    public void removeUser(String login){
     loggedUsers.remove(login);
    }


    public  User getLoggedUser(String login){
        return loggedUsers.get(login);
    }
}
