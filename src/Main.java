
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
        
        System.out.println("Contador.java");
        cn.leerArchivo("C:\\xampp\\htdocs\\Aplicacion-2\\src\\Contador.java");
        cn.mostrar();
        
        
        System.out.println("Main.java");
        cn.leerArchivo("C:\\xampp\\htdocs\\Aplicacion-2\\src\\Main.java");
        cn.mostrar();
        
        
        System.out.println("Resultado.java");
        cn.leerArchivo("C:\\xampp\\htdocs\\Aplicacion-2\\src\\Resultado.java");
        cn.mostrar();
        
    }
}
