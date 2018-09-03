package controller.command;


import model.entity.User;
import model.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.GregorianCalendar;

public class RegistrationCommand implements Command {
    private UserService userService;

    RegistrationCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        String firstName;
        String lastName;
        String login;
        String   EMAIL = request.getParameter("email");
        firstName = new String( request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        lastName = new String(request.getParameter("surname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        login = new String(request.getParameter("login").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("psw").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        Date  BIRTH_DATE = dateConverter(request);




        User user = new User();
        user.setUSER_FIRST_NAME(firstName);
        user.setUSER_LAST_NAME(lastName);
        user.setEMAIL(EMAIL);
        user.setUSER_LOGIN(login);
        user.setUSER_PASSWORD(password);
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
