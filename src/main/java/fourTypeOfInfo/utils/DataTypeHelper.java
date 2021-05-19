package fourTypeOfInfo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTypeHelper {
    public static Date parseToDate(String dateStr){
        Date date = new Date();
        try {
            date=new SimpleDateFormat("dd.MM.yyyy hh:mm:ss").parse(dateStr);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
