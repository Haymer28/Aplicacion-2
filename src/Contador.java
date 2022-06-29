
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    To change this license header, choose License Headers in Project Properties.    
    To change this template file, choose Tools | Templates  
    and open the template in the editor.
 */

/*
 
  @author SAMSUNG-PC
 */
public class Contador {

    Resultado rs = new Resultado();
    private int linea = 0;
    private int metodo = 0;
    private int clase = 0;
    private int comentario = 0;
    private int lineasVacia = 0;
    private int libreria = 0;
    private int main = 0;
    String line = "";

    public void leerArchivo(String ruta) {

        try {
            //BufferedReader es una clase de Java para leer el texto de una secuencia de entrada (como un archivo)
            BufferedReader bf = new BufferedReader(new FileReader(ruta));
            //bread toma el valor de bf.readLine que es método que  lee todos los caracteres
            while ((line = bf.readLine()) != null) {
                String trim = line.trim();
                //llamamos los metodos y les pasamos el String por parametro
                lineasGlobales(trim);
                contadorMetodos(trim);
                contadorClases(trim);
                contadorLibrerias(trim);
                contadorMain(trim);
                contadorComentarios(trim);
                contadorLineasVacias(trim);
                lineasReales(trim);
            }

        } catch (Exception e) {
            System.err.println("no se encontro archivos");
        }
    }

    public void lineasGlobales(String archivo) {
        linea++;
        rs.setLineas(linea);
    }

    public void contadorMetodos(String archivo) {
//        if (archivo.contains("public static")||archivo.contains("public void")||archivo.contains("public int")
//                ||archivo.contains("public double")||archivo.contains("public boolean")||archivo.contains("public String")
//                ||archivo.contains("if")||archivo.contains("for")||archivo.contains("while")||archivo.contains("for")
//                ||archivo.contains("while")||archivo.contains("catch")||archivo.contains("else")
//                ||archivo.contains("set")) {
        Pattern p = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)*\\s+\\w+\\(");
        Matcher m = p.matcher(archivo);

        Pattern po = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)\\s*(get|set)\\w*\\(");
        Matcher mo = po.matcher(archivo);

        if (m.find()) {
            metodo++;
        }
        if (mo.find()) {
            metodo++;
        }

        rs.setMetodos(metodo);
    }

    public void contadorClases(String archivo) {
        if (archivo.contains("public class")) {
            clase++;
            rs.setClases(clase);
        }
    }
    
    public void contadorLibrerias(String archivo){
         if (archivo.contains("import")) {
            libreria++;
            rs.setLibreria(libreria);
        }
    }
    
    public void contadorMain(String archivo){
        if (archivo.contains("public static void")){
            main++;
            rs.setMain(main);
        }
    }
    
    public void contadorComentarios(String archivo){
        if (archivo.contains("/")|| archivo.contains("*")){
            comentario++;
            rs.setComentarios(comentario);
        }
    }
    
    public void contadorLineasVacias(String archivo){
        if (archivo.isEmpty()){
            lineasVacia++;
            rs.setLineasVacias(lineasVacia);
        }
    }
    
    public void lineasReales(String archivo){
        rs.setClases(clase);
        rs.setLineasVacias(lineasVacia);
        rs.setLibreria(libreria);
        rs.setMain(main);
        rs.setLineas(linea);
        
        int noReales = (clase + lineasVacia + libreria + main);
        rs.setDiferencia(noReales);
        
        int reales = (linea - noReales);
        rs.setTotal(reales);
    }

    public void mostrar() {
        System.out.println("Lineas globales " + rs.getLineas());
        System.out.println("Metodos: " + rs.getMetodos());
        System.out.println("Reales " + rs.getTotal());
    }
    

}
//if|for|while|(\}\s*catch)|else
