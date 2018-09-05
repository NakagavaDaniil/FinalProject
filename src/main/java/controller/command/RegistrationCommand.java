package controller.command;


import model.entity.User;
import model.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);

    /**
     * @param request
     * use getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8
     * to get cyrillic chars from jsp page
     * @return page url
     */
    @Override
    public String execute(HttpServletRequest request) {

        String firstName = new String( request.getParameter("name").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String lastName = new String(request.getParameter("surname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String login = new String(request.getParameter("login").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String   EMAIL = request.getParameter("email");
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
            logger.info("User "+ user.getID()+" "+user.getUSER_LOGIN()+" logged successfully.");
            return "/view/jsp/main.jsp";

        } else {
          request.setAttribute("exist",true);

            logger.info("User "+ user.getID()+" "+user.getUSER_LOGIN()+" logged unsuccessfully.");

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
