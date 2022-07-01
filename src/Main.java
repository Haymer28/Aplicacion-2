
/***********************************************************
************************************************************
************************************************************
*****                                                  *****
*****  Name: Programa2                                 *****
*****  Description: Conteo de LOC, clases, métodos y   *****
*****  comentarios                                     *****       
*****  Date: 18/06/2022                                *****
*****  @author Carlos Haymer Gonzalez Valencia         *****         
*****                                                  *****
************************************************************
************************************************************
***********************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        /*
        Se instancia la clase operaciones
        */
        Contador cn = new Contador();

        try {
            System.out.print("Digite la ruta: ");
            InputStreamReader sr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(sr);
            String archivo = br.readLine();
            /*
            Se crea una pequeña tabla y se llama al metodo leer archivo 
            ademas de eso también se valida la información diligenciada por
            el usuario ya que en caso de que la dirección sea incorrecta
            salta la exepcion del try/catch
            */
            System.out.println();
            System.out.printf("[--------Nombre--------][-LineasGlobales-][-Metodos-]"
                    + "[-Clases-][-Importaciones-][-Main-][-Comentarios-][-LineasVacias-]"
                    + "[-LineasReales-]%n");
            cn.leerArchivo(archivo);
        } catch (IOException e) {
            System.out.println("La dirección es incorrecta.");
        }
    }
}
//C:\\xampp\\htdocs\\Aplicacion-2\\src\\Resultado.java
//C:\\xampp\\htdocs\\Aplicacion-2\\src\\Contador.java
//C:\\xampp\\htdocs\\Aplicacion-2\\src\Main.java
//C:/xampp/htdocs/Aplicacion-2/src/
