/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PedidosXML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author node
 */
public class Principal {

    public static void main(String[] args) throws ParserConfigurationException {

        Producto p1 = new Producto("100", "Monitor", 100.00);
        Producto p2 = new Producto("101", "Rato", 10.00);
        Producto p3 = new Producto("102", "Portatil", 600.00);
        Producto p4 = new Producto("103", "Tablet", 400.00);
        Producto p5 = new Producto("104", "Teclado", 200.00);

        ArrayList<Producto> COMPRA1 = new ArrayList();
        COMPRA1.add(p1);
        COMPRA1.add(p2);

        ArrayList<Producto> COMPRA2 = new ArrayList();
        COMPRA2.add(p3);
        COMPRA2.add(p4);

        ArrayList<Producto> COMPRA3 = new ArrayList();
        COMPRA3.add(p3);
        COMPRA3.add(p4);

        ArrayList<Producto> COMPRA4 = new ArrayList();
        COMPRA4.add(p1);
        COMPRA4.add(p2);

        ArrayList<Producto> COMPRA5 = new ArrayList();
        COMPRA5.add(p5);

        ArrayList<Producto> COMPRA6 = new ArrayList();
        COMPRA6.add(p1);
        COMPRA6.add(p2);

        Pedido pedido1 = new Pedido("1", "Cliente1", COMPRA1);
        Pedido pedido2 = new Pedido("2", "Cliente2", COMPRA2);
        Pedido pedido3 = new Pedido("3", "Cliente3", COMPRA3);
        Pedido pedido4 = new Pedido("4", "Cliente4", COMPRA4);
        Pedido pedido5 = new Pedido("5", "Cliente5", COMPRA5);
        Pedido pedido6 = new Pedido("6", "Cliente6", COMPRA6);

        ArrayList<Pedido> pedidosTotales = new ArrayList();

        pedidosTotales.add(pedido1);
        pedidosTotales.add(pedido2);
        pedidosTotales.add(pedido3);
        pedidosTotales.add(pedido4);
        pedidosTotales.add(pedido5);
        pedidosTotales.add(pedido6);

        guardarListaPedidos(pedidosTotales);
        File ficheroDAT = new File("Pedidos.dat");
        leerDAT(ficheroDAT);

        //DOM
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation implementation = db.getDOMImplementation();
        Document documento = implementation.createDocument(null, "pedidos", null);
        documento.setXmlVersion("1.0");

        for (Pedido pd : pedidosTotales) {
            Element pedidos = documento.getDocumentElement();
            Element pedido = documento.createElement("pedido");
            pedidos.appendChild(pedido);

            Element idP = documento.createElement("idPedido");
            idP.setTextContent(pd.getIdPedido());
            pedido.appendChild(idP);

            Element nombreCliente = documento.createElement("nombreCliente");
            nombreCliente.setTextContent(pd.getNombreCliente());
            pedido.appendChild(nombreCliente);

            ArrayList<Producto> productoFinal = pd.getProductos();

            Element productos = documento.createElement("productos");
            Element producto;
            for (Producto pr : productoFinal) {
                producto = documento.createElement("producto");
                pedido.appendChild(productos);
                productos.appendChild(producto);
                
                Element idProducto = documento.createElement("idProducto");
                idProducto.setTextContent(pr.getIdProducto());
                producto.appendChild(idProducto);

                Element descripcion = documento.createElement("descripcion");
                descripcion.setTextContent(pr.getDescripcion());
                producto.appendChild(descripcion);

                Element idPrecio = documento.createElement("idPrecio");
                idPrecio.setTextContent(String.valueOf(pr.getPrecio()));
                producto.appendChild(idPrecio);
            }

        }

        //XML
        try {
            File f = new File("Pedidos.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(documento);
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.err.println(ex.getMessage());
        }

    }

    public static void guardarListaPedidos(ArrayList<Pedido> pedidos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("Pedidos.dat"))) {
            for (Pedido p : pedidos) {
                escritor.write(p.toString());
                escritor.newLine();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static void leerDAT(File f) {
        try (BufferedReader lector = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
