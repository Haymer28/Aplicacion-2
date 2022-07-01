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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contador {

    Resultado rs = new Resultado();
    
    /*
    Método para leer los archivos
    @param ruta
    @IOException
    */
    public void leerArchivo(String ruta) throws FileNotFoundException, IOException {
        /*
        Usamos 3 variables una tipo File que nos almacena la ruta del archivo, un array de archivos
        que nos itera cada vez que encuentre algo en el codigo y por utlmo una variable que nos almacena
        la cantidad de archivos que hay en el array
        */
        File directorio = new File(ruta);
        String[] archivos = directorio.list();
        int cantArchivos = archivos.length;
        /*
        Creamos un bucle for para que me itere segun la cantidad de archivos encontrados
        cada buffered nos permite almacenar la ruta en su parametro y pasar el nombre de los archivos
        para cada linea de la clase
        */
        for (int i = 0; i < cantArchivos; i++) {
            System.out.printf("[%21s ]", archivos[i]);
            BufferedReader lb = new BufferedReader(new FileReader(ruta + archivos[i]));
            lineasGlobales(lb);
            BufferedReader c = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorMetodos(c);
            BufferedReader cc = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorClases(cc);
            BufferedReader cl = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorLibrerias(cl);
             BufferedReader cm = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorMain(cm);
            BufferedReader ct = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorComentarios(ct);
            BufferedReader cv = new BufferedReader(new FileReader(ruta + archivos[i]));
            contadorLineasVacias(cv);
            BufferedReader ln = new BufferedReader(new FileReader(ruta + archivos[i]));
            lineasReales();

        }
    }
    /*
    Este mètodo se crea con el fin de contar los metodos
    @param ruta
    @IOException
    */
    public void contadorMetodos(BufferedReader ruta) throws IOException {
        /*
        En este caso tenemos dos variables una que nos ayuda a evaluar la informacion de la ruta y 
        otra que nos va a incrementar en caso de que encuentre el patron solicitado
        */
        String fila = null;
        int cont = 0;
        /*
        Leemos la ruta, asignamos un patron que concuerde con las palabras que usualmente se usan en los 
        metodos, hacemos un matcher ... después en caso de que encuentre lo que esta en el matcher nos
        incremente el contador y por ultimo almacenamos el contador en un get y lo mostramos con un get. 
        */
        while ((fila = ruta.readLine()) != null) {
            Pattern p = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)*\\s+\\w+\\(");
            Matcher m = p.matcher(fila);
            if (m.find()) {
                cont++;
            }
        }
        rs.setMetodos(cont);
        System.out.printf("[%9s]", rs.getMetodos());
    }
    /*
    Este mètodo cuenta las lineas globales
    @param ruta
    @IOException
    */
    public void lineasGlobales(BufferedReader ruta) throws IOException {
         /*
        En este caso tenemos dos variables una que nos ayuda a evaluar la informacion de la ruta y 
        otra que nos va a incrementar en caso de que encuentre el patron solicitado
        */
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            cont++;
        }
        rs.setLineas(cont);
        System.out.printf("[%15s ]", rs.getLineas());
    }
    /*
    Este mètodo cuenta las clases
    @param ruta
    @IOException
    */
    public void contadorClases(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("public class")) {
                cont++;
            }
        }
        rs.setClases(cont);
        System.out.printf("[%7s ]", rs.getClases());

    }
    /*
    Este mètodo se crea para contar el numero de librerias importadas
    @param ruta
    @IOException
    */
    public void contadorLibrerias(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("import")) {
                cont++;
            }
        }
        rs.setLibreria(cont);
        System.out.printf("[%15s]", rs.getLibreria());
    }
    /*
    Este mètodo se crea con el fin de contar el metodo main de una clase
    @param ruta
    @IOException
    */
    public void contadorMain(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("public static void")) {
                cont++;
            }
        }
        rs.setMain(cont);
        System.out.printf("[%6s]", rs.getMain());
    }
    /*
    Metodo para contar los comentarios 
    @param ruta
    @IOException
    */
    public void contadorComentarios(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("/") || linea.contains("*")) {
                cont++;
            }
        }
        rs.setComentarios(cont);
        System.out.printf("[%13s]", rs.getComentarios());
    }
    /*
    Un contador para lineas vacias
    @param ruta
    @IOException
    */
    public void contadorLineasVacias(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont=0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.isEmpty()) {
                cont++;
            }
        }
        rs.setLineasVacias(cont);
        System.out.printf("[%14s]", rs.getLineasVacias());
    }
    /*
    Suma la cantidad de lineas que no son reales y el resultado
    lo resta a la cantidad de lineas globales
    @param ruta
    @IOException
    */
    public void lineasReales() throws IOException {
        int resultado = rs.getLineas()-(rs.getClases()+rs.getComentarios()+rs.getLibreria()+rs.getLineasVacias()+rs.getMain()+rs.getMetodos());
        rs.setTotal(resultado);
        System.out.printf("[%13s ]%n", rs.getTotal());
    }
    }
