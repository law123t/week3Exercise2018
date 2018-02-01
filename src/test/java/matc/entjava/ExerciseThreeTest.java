package matc.entjava;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;

public class ExerciseThreeTest{
        private final Logger logger = Logger.getLogger(this.getClass());
        ExerciseThree tester = new ExerciseThree();

        @Test
        public void testGetTime(){
                Calendar rightNow = Calendar.getInstance();
                int hour = rightNow.get(Calendar.HOUR_OF_DAY);
                tester.getTime();

                assertEquals(hour, tester.getTime(), "This method doesn't retrieve the current hour");
        }

        //test with output of string, only other way to test is to write the same code and that seems counter productive
        //to say the least
        @Test
        public void testGetDateString() {
                tester.getDateString();
        }
}