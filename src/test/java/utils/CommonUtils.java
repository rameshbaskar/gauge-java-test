package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class CommonUtils {

    public static void sleepFor(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            // Do Nothing
        }
    }

    public static String getCustomTimeStampFor(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }
}
