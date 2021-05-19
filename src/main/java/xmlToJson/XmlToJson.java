package xmlToJson;
import org.json.JSONObject;
import org.json.XML;
import java.io.*;
import java.util.Properties;

public class XmlToJson {
    public static void main(String[] args) throws IOException {

        // read xml file
        Properties properties = new Properties();
        properties.load(new FileReader("app.config"));
        FileReader in = new FileReader(properties.getProperty("app.xmlToJsonInput"));
        StringBuilder xmlString = new StringBuilder();
        int i;
        while((i=in.read())!=-1)
            xmlString.append((char)i);
        in.close();

        // converts xml to json
        JSONObject xmlJSONObj = XML.toJSONObject(xmlString.toString());
        String jsonPrettyPrintString = xmlJSONObj.toString(4);

        // creates json file and write above json String to it
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(properties.getProperty("app.xmlToJsonOutput")), "utf-8"))) {
            writer.write(jsonPrettyPrintString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
