/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjemploXML;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author node
 */
public class Principal {

    public static void main(String[] args) throws SAXException, IOException, TransformerConfigurationException, TransformerException {
//        try{
//            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//            DocumentBuilder db = dbf.newDocumentBuilder();
//            Document doc = db.parse("books.xml");
//        }catch(Exception ex){
//            System.err.println(ex.getMessage());
//        }







        //De XML a DOM
        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder creador = fabrica.newDocumentBuilder();
            Document doc = creador.parse("books.xml");
            
            Element libreria = doc.getDocumentElement();
            Element e = doc.createElement("libro");
            Element l = doc.createElement("SiNo");
           
            libreria.appendChild(e);
             e.appendChild(l);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            DOMSource recurso = new DOMSource(doc);
            File salida = new File("ejemploXMLaDOM.xml");
            StreamResult resultado = new StreamResult(salida);
            trans.transform(recurso, resultado);
            
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
