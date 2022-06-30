
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        //instancio la clase Operaciones
        Contador cn = new Contador();

//         cn.leerArchivo("C:\\xampp\\htdocs\\Aplicacion-2\\src\\Main.java");
//         cn.mostrar();
        try {
            //instancio la clase Operaciones
            //imprimo un mensaje predefinido
            System.out.println("Adjute todos los archivos del programa en una misma carpeta.");
            System.out.println("Digite la dirección de los archivos:");
            System.out.println("Ej: C:/programa/C:/xampp/htdocs/Aplicacion-2/src//");
            System.out.println("------------------------------");
            System.out.print("Digite la ruta: ");

            //creo una sentencia para leer archivos que el usuario escriba
            InputStreamReader sr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(sr);
            String archivo = br.readLine();

            //si la ruta termina con el "/" leerá los archivos que encuentre dentro
            //mostrará de una forma ordenada en una lista los datos que recolecte
            //de la clase Operaciones
            System.out.println();
            System.out.printf("[--------Nombre--------][-LineasGlobales-][-Metodos-]"
                    + "[-Clases-][-Importaciones-][-Main-][-Comentarios-][-LineasVacias-]"
                    + "[-LineasReales-]%n");
            cn.leerArchivo(archivo);
            //en caso de que la ruta sea incorrecta mandará este mensaje
            //en caso de que algo falle mandará este mensaje
        } catch (IOException e) {
            System.out.println("La dirección es incorrecta.");
        }
    }
}
//C:\\xampp\\htdocs\\Aplicacion-2\\src\\Resultado.java
//C:\\xampp\\htdocs\\Aplicacion-2\\src\\Contador.java
//C:\\xampp\\htdocs\\Aplicacion-2\\src\Main.java
//C:/xampp/htdocs/Aplicacion-2/src/
