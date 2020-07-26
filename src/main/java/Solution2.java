import org.json.JSONObject;
import org.json.XML;

public class Solution2 {

    private void rename(JSONObject jsonObject, String origKey, String renamedKey) {
        jsonObject.put(renamedKey, jsonObject.get(origKey));
        jsonObject.remove(origKey);
    }

    public String convertToJson(String xmlString) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        rename(jsonObject,  "firstName", "modifiedFirstName");
        return jsonObject.toString();
    }

    public String convertToJsonScenario2(String xmlString) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        JSONObject contact = jsonObject.getJSONObject("contact");
        rename(contact, "street", "apt");
        return jsonObject.toString();
    }

    public String convertToJsonScenario3(String xmlString) {
        JSONObject jsonObject = XML.toJSONObject(xmlString);
        rename(jsonObject, "contact", "address");
        return jsonObject.toString();
    }

}
