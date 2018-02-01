package matc.entjava;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.apache.log4j.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExerciseThree extends SimpleTagSupport {

    private final Logger logger = Logger.getLogger(this.getClass());

    //doTag method with if/else if/else to determine output
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        int currentTime;
        String currentDay = "";
        JspWriter out = getJspContext().getOut();

        currentTime = getTime();
        currentDay = getDateString();

        if (currentDay.equals("2/1")) {
            out.println("Its Groundhog Day!");
        } else {
            if (currentTime > 6 && currentTime < 12) {
                out.println("Hello It's Before 12PM! Good Morning");
            } else if (currentTime > 13 && currentTime < 17) {
                out.println("It's past 12! Good Afternoon!");
            } else if (currentTime > 17 && currentTime < 21) {
                out.println("its past 5PM! Good Evening!");
            } else if (currentTime > 21 && currentTime < 6) {
                if (currentTime > 24) {
                    out.println("hey something went wrong!");
                } else {
                    out.println("its past 5PM! Good Evening!");
                }
            } else {
                out.println("hey something went wrong!");
            }
        }
    }

    /**
     * https://stackoverflow.com/questions/907170/java-getminutes-and-gethours
     */
    public int getTime() {
        int currentHour;
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        currentHour = calendar.get(Calendar.HOUR_OF_DAY);

        logger.info(currentHour);
        return currentHour;
    }

    //returns date in a string of month and day int
    public String getDateString() {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;

        logger.info("Today is " + month + "/" + dayOfMonth);
        return month + "/" + dayOfMonth;

    }
}
