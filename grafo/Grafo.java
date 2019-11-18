package grafo;

import java.util.Vector;

public class Grafo {

    int[][] matrizAdyacencia;
    Vector vertices;
    
    public Grafo(Vector v) {
        this.vertices = v;
        this.matrizAdyacencia = new int[v.size()][v.size()];
    }
    
    public void insertarArista(int v1, int v2, int peso) {
        this.matrizAdyacencia[v1][v2] = peso;
    }
    
    public void insertarArista(int v1, int v2) {
        this.matrizAdyacencia[v1][v2] = 1;
    }
    
    public int obtenerPeso(int v1, int v2) {
        return this.matrizAdyacencia[v1][v2];
    }
    
    public void imprimirGrafo() {
        for (int i = 0; i < this.matrizAdyacencia[0].length; i++) {
            for (int j = 0; j < this.matrizAdyacencia.length;j++)
                System.out.print(this.matrizAdyacencia[i][j] + " ");
            System.out.println("");
        }
        for (int i = 0; i < vertices.size(); i++)
            System.out.println("V"+i + ": "+ this.vertices.elementAt(i));
    }
    
    public void borrarArista(int v1, int v2) {
        this.matrizAdyacencia[v1][v2] = 0;
    }
    
    public void borrarVertice(int verticeBorrar) {
        if(verticeBorrar >= 0 && verticeBorrar < vertices.size()) {
            int matrizAyacenciaTmp[][] = new int[vertices.size() - 1][vertices.size() - 1];
            
            if (verticeBorrar == vertices.size() - 1)
                for(int i = 0; i < vertices.size() - 1; i++)
                    for(int j = 0; j < vertices.size() - 1; j++)
                        matrizAyacenciaTmp[i][j] = this.matrizAdyacencia[i][j];
           else {
                for(int i = 0; i < vertices.size(); i++)
                        for(int j = verticeBorrar; j < vertices.size() - 1; j++)
                            this.matrizAdyacencia[i][j] = this.matrizAdyacencia[i][j+1];
            
                for(int i = 0; i < vertices.size(); i++)
                        for(int j = verticeBorrar; j < vertices.size() - 1; j++)
                            this.matrizAdyacencia[i][j] = this.matrizAdyacencia[j+1][i];
            
                for(int i = 0; i < vertices.size() - 1; i++)
                        for(int j = 0; j < vertices.size() - 1; j++)
                            matrizAyacenciaTmp[i][j] = this.matrizAdyacencia[i][j];
            }
            this.matrizAdyacencia = matrizAyacenciaTmp;
            this.vertices.removeElementAt(verticeBorrar);
       }  
        
    }
    
    public void insertarVertice(String nuevoVertice) {
        this.vertices.addElement(nuevoVertice);
        int matrizAdyacenciaTmp[][] = new int[this.vertices.size()][this.vertices.size()];
        
        for(int i = 0; i < this.matrizAdyacencia[0].length; i++)
            for(int j = 0; j < this.matrizAdyacencia.length; j++)
                matrizAdyacenciaTmp[i][j] = matrizAdyacencia[i][j];
    }
}
