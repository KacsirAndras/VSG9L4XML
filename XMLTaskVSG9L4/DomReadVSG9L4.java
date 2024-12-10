package hu.domparse.vsg9l4;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomReadVSG9L4 {
	
	public static void main(String[] args) {
        try {
            // XML fájl betöltése
            File xmlFile = new File("XMLVSG9L4.xml.");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalizálás
            doc.getDocumentElement().normalize();

            // Gyökérelem neve
            System.out.println("Gyökérelem: " + doc.getDocumentElement().getNodeName());

            // Vevők kiolvasása
            NodeList vevok = doc.getElementsByTagName("vevo");
            System.out.println("\nVevők:");
            for (int i = 0; i < vevok.getLength(); i++) {
                Element vevo = (Element) vevok.item(i);
                System.out.println("  Vevő ID: " + vevo.getAttribute("vevoid"));
                System.out.println("  Név: " + vevo.getElementsByTagName("nev").item(0).getTextContent());
                System.out.println("  Szállítási cím: " + vevo.getElementsByTagName("szallitasi_cim").item(0).getTextContent());
            }

            // Rendelések kiolvasása
            NodeList rendelesek = doc.getElementsByTagName("rendeles");
            System.out.println("\nRendelések:");
            for (int i = 0; i < rendelesek.getLength(); i++) {
                Element rendeles = (Element) rendelesek.item(i);
                System.out.println("  Rendelés ID: " + rendeles.getAttribute("rendelesid"));
                System.out.println("  Vevő ID: " + rendeles.getAttribute("vevoid"));
                System.out.println("  Szállítási költség: " + rendeles.getElementsByTagName("szallitasi_koltseg").item(0).getTextContent());
                System.out.println("  Fizetési mód: " + rendeles.getElementsByTagName("fizetesi_mod").item(0).getTextContent());
                System.out.println("  Dátum: " + rendeles.getElementsByTagName("datum").item(0).getTextContent());
                System.out.println("  Fizetendő összeg: " + rendeles.getElementsByTagName("fizetendo_osszeg").item(0).getTextContent());
            }

            // Termékek kiolvasása
            NodeList termekek = doc.getElementsByTagName("termek");
            System.out.println("\nTermékek:");
            for (int i = 0; i < termekek.getLength(); i++) {
                Element termek = (Element) termekek.item(i);
                System.out.println("  Termék ID: " + termek.getAttribute("termekid"));
                System.out.println("  Név: " + termek.getElementsByTagName("nev").item(0).getTextContent());
                System.out.println("  Ár: " + termek.getElementsByTagName("ar").item(0).getTextContent());
            }

            // Raktárak kiolvasása
            NodeList raktarak = doc.getElementsByTagName("raktar");
            System.out.println("\nRaktárak:");
            for (int i = 0; i < raktarak.getLength(); i++) {
                Element raktar = (Element) raktarak.item(i);
                System.out.println("  Raktár ID: " + raktar.getAttribute("raktarid"));
                Element elerhetoseg = (Element) raktar.getElementsByTagName("elerhetoseg").item(0);
                System.out.println("    Cím: " + elerhetoseg.getElementsByTagName("cim").item(0).getTextContent());
                System.out.println("    Telefonszám: " + elerhetoseg.getElementsByTagName("telefonszam").item(0).getTextContent());
            }

            // Tulajdonosok kiolvasása
            NodeList tulajdonosok = doc.getElementsByTagName("tulajdonos");
            System.out.println("\nTulajdonosok:");
            for (int i = 0; i < tulajdonosok.getLength(); i++) {
                Element tulajdonos = (Element) tulajdonosok.item(i);
                System.out.println("  Üzlet ID: " + tulajdonos.getAttribute("uzletid"));
                System.out.println("  Raktár ID: " + tulajdonos.getAttribute("raktarid"));
                System.out.println("  Név: " + tulajdonos.getElementsByTagName("nev").item(0).getTextContent());
            }

            // Üzletek kiolvasása
            NodeList uzletek = doc.getElementsByTagName("uzlet");
            System.out.println("\nÜzletek:");
            for (int i = 0; i < uzletek.getLength(); i++) {
                Element uzlet = (Element) uzletek.item(i);
                System.out.println("  Üzlet ID: " + uzlet.getAttribute("uzletid"));
                Element elerhetoseg = (Element) uzlet.getElementsByTagName("elerhetoseg").item(0);
                System.out.println("    Cím: " + elerhetoseg.getElementsByTagName("cim").item(0).getTextContent());
                System.out.println("    Telefonszám: " + elerhetoseg.getElementsByTagName("telefonszam").item(0).getTextContent());
                Node emailNode = elerhetoseg.getElementsByTagName("email").item(0);
                System.out.println("    Email: " + (emailNode != null ? emailNode.getTextContent() : "Nincs megadva"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
