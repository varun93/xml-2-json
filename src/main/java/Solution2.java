import org.json.JSONObject;
import org.json.XML;

public class Solution2 {

    private String xmlString;

    public Solution2(String xmlString) {
        this.xmlString = xmlString;
    }

    private void rename(JSONObject jsonObject, String origKey, String renamedKey) {
        jsonObject.put(renamedKey, jsonObject.get(origKey));
        jsonObject.remove(origKey);
    }

    public String convertToJson() {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        rename(jsonObject, "firstName", "modifiedFirstName");
        return jsonObject.toString();
    }

}
