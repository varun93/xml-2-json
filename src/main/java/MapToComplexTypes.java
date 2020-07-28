import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

class Contact {
    int homeNumber;
    int mobileNumber;

    public  Contact(int homeNumber, int mobileNumber) {
        this.homeNumber = homeNumber;
        this.mobileNumber = mobileNumber;
    }

}

class PersonPojo {
    private String firstName;
    private String lastName;
    private List<Contact> contacts;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}

public class MapToComplexTypes {


    private static PersonPojo doMapping(JSONObject jsonObject) throws JSONException {
        PersonPojo person = new PersonPojo();
        String firstName = jsonObject.getString("firstName");
        String lastName = jsonObject.getString("lastName");
        person.setFirstName(firstName);
        person.setLastName(lastName);

        List<Contact> userContacts = new ArrayList<Contact>();
        JSONArray contacts = (JSONArray) jsonObject.get("contacts");
        int contactsLength = contacts.length();

        for(int i = 0; i < contactsLength; i++) {
            JSONObject contact = contacts.getJSONObject(i);
            int homeNumber = contact.getInt("homeNumber");
            int mobileNumber = contact.getInt("mobileNumber");
            userContacts.add(new Contact(homeNumber, mobileNumber));
        }
        person.setContacts(userContacts);
        return person;
    }

    public  static void main(String[] args) {

        String jsonString = "{\"firstName\":\"Varun\",\"lastName\":\"Hegde\",\"contacts\":[{\"homeNumber\":12345,\"mobileNumber\":134566},{\"homeNumber\":1233345,\"mobileNumber\":13334566},{\"homeNumber\":123420445,\"mobileNumber\":13454466}]}";
        JSONObject jsonObject = new JSONObject(jsonString);
        PersonPojo person = doMapping(jsonObject);
        System.out.println(person);
    }

}
