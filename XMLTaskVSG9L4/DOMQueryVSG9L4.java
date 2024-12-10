package hu.domparse.vsg9l4;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMQueryVSG9L4 {
	 public static void main(String[] args) {
	        try {
	            // XML fájl betöltése
	            File xmlFile = new File("XMLVSG9L4.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(xmlFile);
	            
	            // Normalizálás
	            doc.getDocumentElement().normalize();

	            System.out.println("Rendelések, ahol a fizetendő összeg >= 100000:");

	            // Rendelések lekérdezése
	            NodeList rendelesek = doc.getElementsByTagName("rendeles");

	            for (int i = 0; i < rendelesek.getLength(); i++) {
	                Element rendeles = (Element) rendelesek.item(i);
	                int fizetendoOsszeg = Integer.parseInt(rendeles.getElementsByTagName("fizetendo_osszeg").item(0).getTextContent());

	                if (fizetendoOsszeg >= 100000) {
	                    String rendelesId = rendeles.getAttribute("rendelesid");
	                    String vevoId = rendeles.getAttribute("vevoid");
	                    String fizetesiMod = rendeles.getElementsByTagName("fizetesi_mod").item(0).getTextContent();
	                    String datum = rendeles.getElementsByTagName("datum").item(0).getTextContent();

	                    System.out.println("Rendelés ID: " + rendelesId);
	                    System.out.println("Vevő ID: " + vevoId);
	                    System.out.println("Fizetési mód: " + fizetesiMod);
	                    System.out.println("Dátum: " + datum);
	                    System.out.println("Fizetendő összeg: " + fizetendoOsszeg);
	                    System.out.println();
	                }
	            }

	            System.out.println("Termékek listája:");

	            // Termékek lekérdezése
	            NodeList termekek = doc.getElementsByTagName("termek");

	            for (int i = 0; i < termekek.getLength(); i++) {
	                Element termek = (Element) termekek.item(i);
	                String termekId = termek.getAttribute("termekid");
	                String nev = termek.getElementsByTagName("nev").item(0).getTextContent();
	                int ar = Integer.parseInt(termek.getElementsByTagName("ar").item(0).getTextContent());

	                System.out.println("Termék ID: " + termekId);
	                System.out.println("Név: " + nev);
	                System.out.println("Ár: " + ar);
	                System.out.println();
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
