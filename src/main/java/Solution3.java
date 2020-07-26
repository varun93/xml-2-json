import org.json.JSONObject;
import org.json.XML;

public class Solution3 {

    public String convertToJson(String xmlString, String origKey, String newKey) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        String jsonString = jsonObject.toString();
        return jsonString.replace(origKey, newKey);
    }

}
