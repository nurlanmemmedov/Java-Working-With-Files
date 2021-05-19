package fourTypeOfInfo;
import fourTypeOfInfo.utils.DataTypeHelper;
import fourTypeOfInfo.utils.Sorter;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class FourTypeOfInfo {
    public static void main(String[] args) throws IOException, ParseException {

        Properties properties = new Properties();
        properties.load(new FileReader("app.config"));

        List<String> lines = new ArrayList<>();
        List<Date> dates = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        List<String> carNumbers = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(properties.getProperty("app.fourTypeOfInfoData")))) {
            stream.forEach(line -> {
                if(line.matches("-?\\d+") && DataTypeHelper.isInteger(line)){
                    integers.add(Integer.parseInt(line));
                }else if(line.matches("\\d{2}+[a-zA-Z]{2}+\\d{3}")){
                    carNumbers.add(line);
                }else if(line.matches("\\d{2}.\\d{2}.\\d{4}\\s\\d{2}:\\d{2}:\\d{2}")){
                    dates.add(DataTypeHelper.parseToDate(line));
                }
                else {
                    lines.add(line);
                }
            });
        }

        writeToFile(properties.getProperty("app.fourTypeOfInfoStrings"), Sorter.sortString(lines));
        writeToFile(properties.getProperty("app.fourTypeOfInfoIntegers"), Sorter.sortInteger(integers));
        writeToFile(properties.getProperty("app.fourTypeOfInfoCars"), Sorter.sortCarNumber(carNumbers));
        writeToFile(properties.getProperty("app.fourTypeOfInfoDates"), Sorter.sorDate(dates));
    }

    // write to file line by line
    public static <T> void writeToFile(String fileName, List<T> list) throws IOException {
        BufferedWriter writer = new BufferedWriter( new FileWriter( fileName));
        for (T data : list){
            if (data instanceof Date){
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                writer.write(dateFormat.format(data)+"\n");
            }
            else {
                writer.write(data + "\n");
            }
        }
        writer.close();
    }
}
