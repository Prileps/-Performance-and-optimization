import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    private Voter voter;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("voter")) {
            voter = new Voter(attributes.getValue("name"), attributes.getValue("birthDay"));
            try {
                DBConnection.builderCreator(voter.getName(), voter.getBirthDay());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    @Override
//    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equals("voter")) {
//            voter = null;
//        }
//    }
}