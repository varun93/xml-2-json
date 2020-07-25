public class XmlToJson {

    public static void main(String[] args) {
        String xmlInputOne = "<Person><firstName>Varun</firstName><lastName>Hegde</lastName></Person>";
        String xmlInputTwo = "<firstName>Varun</firstName><lastName>Hegde</lastName>";
        String expectedJson = "{\"firstNameModified\": \"Varun\",\"lastName\": \"Hegde\" }";
        Solution1 solution1 = new Solution1(xmlInputOne);
        System.out.println("=========== Output from Solution 1 ============");
        System.out.println( solution1.covertToJson());
        System.out.println();

        Solution2 solution2 = new Solution2(xmlInputTwo);
        System.out.println("=========== Output from Solution 2 ============");
        System.out.println( solution2.convertToJson());
        System.out.println();

        Solution3 solution3 = new Solution3(xmlInputOne);
        System.out.println("=========== Output from Solution 3 ============");
        System.out.println( solution3.convertToJson());
        System.out.println();

    }

}
