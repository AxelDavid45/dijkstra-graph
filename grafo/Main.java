package grafo;

import java.util.Vector;


public class Main {
    public static void main(String[] args) {
        Vector vertices = new Vector();
        
        vertices.addElement("Alicanta");
        vertices.addElement("Barcelona");
        vertices.addElement("Cartagena");
        vertices.addElement("Murcia");
        vertices.addElement("Reus");
        
        Grafo distancias = new Grafo(vertices);
        
        distancias.insertarArista(0, 2, 5);
        distancias.insertarArista(2, 0, 3);
        distancias.insertarArista(0, 3, 5);
        distancias.insertarArista(1, 2, 3);
        distancias.insertarArista(1, 3, 6);
        distancias.insertarArista(3, 1, 2);
        distancias.insertarArista(1, 4, 3);
        distancias.insertarArista(4, 1, 1);
        
        distancias.imprimirGrafo();
        distancias.borrarVertice(4);        
        distancias.imprimirGrafo();
    }

}
