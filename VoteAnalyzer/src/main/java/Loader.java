import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {
    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1572M.xml";

        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        DBConnection.executeMultiInsert();

        System.out.println("Duration: " + (System.currentTimeMillis() - start) + " ms");
    }

//    private static Document parseFile(String fileName) throws Exception {
//        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        return db.parse(new File(fileName));
//    }

//    private static void findEqualVoters(Document doc) throws Exception {
//        NodeList voters = doc.getElementsByTagName("voter");
//        int votersCount = voters.getLength();
//        for (int i = 0; i < votersCount; i++) {
//            Node node = voters.item(i);
//            NamedNodeMap attributes = node.getAttributes();
//
//            String name = attributes.getNamedItem("name").getNodeValue();
//            String birthDay = attributes.getNamedItem("birthDay").getNodeValue();
//
//            DBConnection.builderCreator(name, birthDay);
//
//        }
//        DBConnection.executeMultiInsert();
//    }
}