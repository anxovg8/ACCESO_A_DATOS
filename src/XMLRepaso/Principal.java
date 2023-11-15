/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XMLRepaso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        Clientes c1 = new Clientes("1", "Anxo");
        Clientes c2 = new Clientes("2", "Juan");
        Clientes c3 = new Clientes("3", "Pepe");
        Clientes c4 = new Clientes("4", "Tomas");
        Clientes c5 = new Clientes("5", "Enrique");
        Clientes c6 = new Clientes("6", "Mario");

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
        

        Pedido pedido1 = new Pedido(c1, COMPRA1);
        Pedido pedido2 = new Pedido(c2, COMPRA2);
        Pedido pedido3 = new Pedido(c3, COMPRA3);
        Pedido pedido4 = new Pedido(c4, COMPRA4);
        Pedido pedido5 = new Pedido(c5, COMPRA5);
        Pedido pedido6 = new Pedido(c6, COMPRA6);
        
        ArrayList<Pedido> pedidosTotales = new ArrayList();
        
        pedidosTotales.add(pedido1);
        pedidosTotales.add(pedido2);
        pedidosTotales.add(pedido3);
        pedidosTotales.add(pedido4);
        pedidosTotales.add(pedido5);
        pedidosTotales.add(pedido6);
        ArrayList<Producto> listaCompra = new ArrayList();
        listaCompra.add(p1);
        listaCompra.add(p2);
        listaCompra.add(p3);
        listaCompra.add(p4);
        listaCompra.add(p5);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Pedidos.dat"))){
            for(Pedido p:pedidosTotales){
                bw.write(p.toString());
                bw.newLine();
            }
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        
        
        try(BufferedReader lector = new BufferedReader(new FileReader("Pedidos.dat"))){
            String linea;
            while((linea=lector.readLine())!=null){
                System.out.println(linea);
            }
        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        
        
        
        //DOM
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        DOMImplementation implementation = db.getDOMImplementation();
        Document documento = implementation.createDocument(null, "pedidos", null);
        documento.setXmlVersion("1.0");
        
        
        for(Pedido p:pedidosTotales){
            Element pedidos = documento.getDocumentElement();
            Element pedido = documento.createElement("pedido");
            pedidos.appendChild(pedido);
            
            Element idP = documento.createElement("idPedido");
            idP.setTextContent(p.getCliente().getId());
            pedido.appendChild(idP);
            
            Element nombreCliente = documento.createElement("nombreCliente");
            nombreCliente.setTextContent(p.getCliente().getNombre());
            pedido.appendChild(nombreCliente);
            
            for(Producto pr:listaCompra){
                Element productos = documento.createElement("productos");
                Element producto = documento.createElement("producto");
                productos.appendChild(producto);
                pedido.appendChild(productos);
                
                Element idProducto = documento.createElement("idProducto");
                idProducto.setTextContent(pr.getId());
                producto.appendChild(idProducto);
                
                Element descricion = documento.createElement("descricion");
                descricion.setTextContent(pr.getNombre());
                producto.appendChild(descricion);
                
                Element idPrecio = documento.createElement("idPrecio");
                idPrecio.setTextContent(String.valueOf(pr.getPrecio()));
                producto.appendChild(idPrecio);
            }
            
        }
        
        try{
            File f = new File("Pedidos.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(documento);
            transformer.transform(source, result);
        }catch(TransformerException ex){
            System.err.println(ex.getMessage());
        }
        
        
        
        
    }

}
