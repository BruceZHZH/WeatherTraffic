package Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhao on 2016/10/23.
 */
public class TestTime {
    public static void main(String[] args){
        System.out.println();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse("2015-11-28 16:53:00");
            calendar.setTime(date);
            System.out.println(calendar.get(calendar.YEAR));
            System.out.println(calendar.get(calendar.MONTH));
            System.out.println(calendar.get(calendar.DATE));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
