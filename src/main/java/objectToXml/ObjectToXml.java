package objectToXml;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;
import java.util.*;

public class ObjectToXml {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileReader("app.config"));

        List<ClassRoom> classRoomList = new ArrayList<>();

        for(int i=0; i < 100; i++){
            List<Student> students = new ArrayList<>();
            students.add(new Student(1, "Nurlan", "Mammad"));
            students.add(new Student(2, "Nurlan", "Mammad"));
            students.add(new Student(3, "Nurlan", "Mammad"));
            students.add(new Student(4, "Nurlan", "Mammad"));
            students.add(new Student(5, "Nurlan", "Mammad"));
            classRoomList.add(new ClassRoom(i, students, "name"+i, 100+i));
        }

        // converts list of classroom objects to xml
        XStream xstream = new XStream(new DomDriver());
        String xml = xstream.toXML(classRoomList);

        // creates xml file and write above xml String to ir
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(properties.getProperty("app.objectToXmlOutput")), "utf-8"))) {
            writer.write(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
