
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG-PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Contador cn = new Contador();
        
        cn.leerArchivo("C:\\xampp\\htdocs\\Aplicacion-1\\src\\aplicacion\\pkg1\\Nodo.java");
        cn.mostrar();
    }
}
