public class XmlToJson {

    public static void main(String[] args) {
        String xmlInputOne = "<Person><firstName>Varun</firstName><lastName>Hegde</lastName></Person>";
        String xmlInputTwo = "<firstName>Varun</firstName><lastName>Hegde</lastName>";
        String xmlInputThree = "<firstName>Varun</firstName><lastName>Hegde</lastName><contact><street>ABC</street><state>WA</state></contact>";

        String expectedJson = "{\"firstNameModified\": \"Varun\",\"lastName\": \"Hegde\" }";
        Solution1 solution1 = new Solution1(xmlInputOne);
        System.out.println("=========== Output from Solution 1 ============");
        System.out.println( solution1.covertToJson());
        System.out.println();

        Solution2 solution2 = new Solution2();
        System.out.println("=========== Output from Solution 2 Test Case One ============");
        System.out.println( solution2.convertToJson(xmlInputTwo));
        System.out.println();
        System.out.println("=========== Output from Solution 2:  Test Case Two ============");
        System.out.println( solution2.convertToJsonScenario2(xmlInputThree));
        System.out.println();
        System.out.println("=========== Output from Solution 2: Test Case Three ============");
        System.out.println( solution2.convertToJsonScenario3(xmlInputThree));
        System.out.println();

        Solution3 solution3 = new Solution3();
        System.out.println("=========== Output from Solution 3 ============");
        System.out.println( solution3.convertToJson(xmlInputOne, "firstName",  "first"));
        System.out.println();

        System.out.println("=========== Output from Solution 3: Test Case 2 ============");
        System.out.println( solution3.convertToJson(xmlInputThree, "street",  "apt"));
        System.out.println();

        System.out.println("=========== Output from Solution 3: Test Case 3 ============");
        System.out.println( solution3.convertToJson(xmlInputThree, "contact",  "address"));
        System.out.println();


    }

}
