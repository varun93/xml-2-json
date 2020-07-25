import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

class Person {
    protected String firstName;
    protected String lastName;

    Person() { }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

}
class PersonModified extends Person {

    public PersonModified(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public static PersonModified fromPerson(Person person) {
        return new PersonModified(person.getFirstName(), person.getLastName());
    }
    @JsonProperty("firstNameModified")
    public String getFirstName() {
        return firstName;
    }
}

public class Solution1 {
    private String xmlString;

    public  Solution1(String xmlString) {
        this.xmlString = xmlString;
    }

    private String serialize(PersonModified person) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(person);
            return jsonString;
        } catch (IOException e) {
            System.out.println("Cannot serialize to json");
            throw e;
        }
    }

    private Person unmarshal(String xmlString) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Person person = xmlMapper.readValue(xmlString, Person.class);
            return person;
        } catch (IOException e) {
            System.out.println("Failed to unmarshall xml");
            throw e;
        }
    }

    public String covertToJson() {
        try {
            Person person = unmarshal(xmlString);
            PersonModified personJsonDto = PersonModified.fromPerson(person);
            String convertedString = serialize(personJsonDto);
            return convertedString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
