package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhao on 2016/10/23.
 */
public class TimeUtil {
    public static int[] parseTime(String time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        int[] res = new int[4];
        try {
            Date date = sdf.parse(time);
            calendar.setTime(date);
            res[0] = calendar.get(calendar.YEAR);
            res[1] = calendar.get(calendar.MONTH);
            res[2] = calendar.get(calendar.DATE);
            res[3] = calendar.get(calendar.HOUR);
        } catch (ParseException e) {
            System.out.println(time);
            e.printStackTrace();
        }
        return res;
    }
}
