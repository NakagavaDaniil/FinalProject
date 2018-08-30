package controller.command;


import model.entity.User;
import model.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.GregorianCalendar;

public class RegistrationCommand implements Command {
    private UserService userService;

    public RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String FIRST_NAME = request.getParameter("name");
        String LAST_NAME = request.getParameter("surname");
        String EMAIL = request.getParameter("email");
        String LOGIN = request.getParameter("login");
        String PASSWORD=request.getParameter("psw");
        Date  BIRTH_DATE = dateConverter(request);


        User user = new User();
        user.setUSER_FIRST_NAME(FIRST_NAME);
        user.setUSER_LAST_NAME(LAST_NAME);
        user.setEMAIL(EMAIL);
        user.setUSER_LOGIN(LOGIN);
        user.setUSER_PASSWORD(PASSWORD);
        user.setBIRTH_DATE(BIRTH_DATE);

        HttpSession session = request.getSession();



        if (userService.register(user)) {
            session.setAttribute("userLogin",user.getUSER_LOGIN());
            session.setAttribute("userId",user.getID());
            return "/view/jsp/main.jsp";

        } else {
          request.setAttribute("exist",true);
          return "/view/jsp/registration.jsp";
        }



    }

    private Date dateConverter(HttpServletRequest request){

        int year = Integer.parseInt(request.getParameter("year"));
        int month = RegistrationCommand.month.valueOf(request.getParameter("month")).ordinal();
        int day = Integer.parseInt(request.getParameter("day"));
       GregorianCalendar date = new GregorianCalendar(year,month,day);

        return new Date(date.getTimeInMillis());
    }


    private enum month{
        January,February,March,April,May,June,July,August,September,October,November,December
    }

}
