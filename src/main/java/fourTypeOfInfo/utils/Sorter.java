package fourTypeOfInfo.utils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {
    public static List<Date> sorDate(List<Date> list){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> sortString(List<String> list){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<Integer> sortInteger(List<Integer> list){
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static List<String> sortCarNumber(List<String> list){
        return list.stream().sorted((n1, n2) ->
                formatCarNumber(n2).compareTo(formatCarNumber(n1)))
                .collect(Collectors.toList());
    }

    public static String formatCarNumber(String carNumber){
        String letters = carNumber.substring(2,4);
        carNumber.replaceAll(letters,"");
        return letters+carNumber;
    }
}
