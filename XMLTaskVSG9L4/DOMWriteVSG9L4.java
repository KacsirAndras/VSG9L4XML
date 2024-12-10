package hu.domparse.vsg9l4;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMWriteVSG9L4 {
    public static void main(String[] args) {
        try {
            // Az eredeti XML fájl betöltése
            File inputFile = new File("XMLVSG9L4.xml");

            // DOM parser inicializálása
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // XML fájl betöltése Document objektumba
            Document doc = dBuilder.parse(inputFile);

            // Gyökérelem kiírása
            doc.getDocumentElement().normalize();
            System.out.println("Gyökérelem: " + doc.getDocumentElement().getNodeName());

            // Fa struktúra kiíratása a konzolra
            printNode(doc.getDocumentElement(), 0);

            // Új fájlba írás (XMLNeptunkod1.xml)
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // Indítási paraméterek beállítása (pl. behúzás)
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            // Dokumentum mentése
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("XMLNeptunkod1.xml"));
            transformer.transform(source, result);

            System.out.println("Az XML fájlt sikeresen mentettük: XMLNeptunkod1.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Rekurzív metódus a fa struktúra kiírására a konzolra.
     * 
     * @param node   Az aktuális elem vagy attribútum.
     * @param indent Behúzások száma (vizuális megjelenítés).
     */
    private static void printNode(Node node, int indent) {
        // Behúzás készítése
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        // Aktuális csomópont neve és értéke
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print("<" + node.getNodeName());

            // Attribútumok kiírása
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attribute = attributes.item(i);
                System.out.print(" " + attribute.getNodeName() + "=\"" + attribute.getNodeValue() + "\"");
            }
            System.out.println(">");

            // Gyermek csomópontok rekurzív feldolgozása
            NodeList children = node.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                printNode(children.item(i), indent + 1);
            }

            // Záróelem kiírása
            for (int i = 0; i < indent; i++) {
                System.out.print("  ");
            }
            System.out.println("</" + node.getNodeName() + ">");

        } else if (node.getNodeType() == Node.TEXT_NODE) {
            // Szöveges csomópontok kezelése
            String textContent = node.getTextContent().trim();
            if (!textContent.isEmpty()) {
                System.out.println(textContent);
            }
        }
    }
}
