package hu.domparse.vsg9l4;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class DOMModifyVSG9L4 {
	public static void main(String[] args) {
		try {
			// XML fájl betöltése
			File xmlFile = new File("XMLVSG9L4.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			// Új termék hozzáadása
			Element newTermek = doc.createElement("termek");
			newTermek.setAttribute("termekid", "7");

			Element nev = doc.createElement("nev");
			nev.appendChild(doc.createTextNode("Steak"));
			newTermek.appendChild(nev);

			Element ar = doc.createElement("ar");
			ar.appendChild(doc.createTextNode("20000"));
			newTermek.appendChild(ar);

			// Hozzáadás a gyökérelemhez
			doc.getDocumentElement().appendChild(newTermek);
			System.out.println("Új termék hozzáadva!");

			// Új vevő hozzáadása
			Element newVevo = doc.createElement("vevo");
			newVevo.setAttribute("vevoid", "7");

			Element vevoNev = doc.createElement("nev");
			vevoNev.appendChild(doc.createTextNode("Steve Brad"));
			newVevo.appendChild(vevoNev);

			Element szallitasiCim = doc.createElement("szallitasi_cim");
			szallitasiCim.appendChild(doc.createTextNode("123 Avenue"));
			newVevo.appendChild(szallitasiCim);

			// Hozzáadás a gyökérelemhez
			doc.getDocumentElement().appendChild(newVevo);
			System.out.println("Új vevő hozzáadva!");

			// Egy üzlet ID módosítása
			NodeList uzletek = doc.getElementsByTagName("uzlet");
			for (int i = 0; i < uzletek.getLength(); i++) {
				Element uzlet = (Element) uzletek.item(i);
				if (uzlet.getAttribute("uzletid").equals("1")) { // Eredeti ID
					uzlet.setAttribute("uzletid", "7"); // Új ID
					System.out.println("Az üzlet ID módosítva: 1 -> 10");
					break;
					}
				}
			// XML fájl mentése
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("XMLVSG9L4_modified.xml"));
			transformer.transform(source, result);

			System.out.println("Az XML fájl sikeresen módosítva!");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
