import org.json.JSONObject;
import org.json.XML;

public class Solution3 {

    private String xmlString;

    public  Solution3(String xmlString) {
        this.xmlString = xmlString;
    }

    public String convertToJson() {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        String jsonString = jsonObject.get("Person").toString();
        jsonString = jsonString.replace( "\"firstName\"", " \"modifiedFirstName\"");
        return jsonString;
    }
}
