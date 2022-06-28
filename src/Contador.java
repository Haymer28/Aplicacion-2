
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SAMSUNG-PC
 */
public class Contador {

    Resultado rs = new Resultado();
    private int lineas = 0;
    private int metodos = 0;
    private int clases = 0;
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
            }

        } catch (Exception e) {
            System.err.println("no se encontro archivos");
        }
    }

    public void lineasGlobales(String archivo) {
        lineas++;
        rs.setLineas(lineas);
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
            metodos++;
        }
        if (mo.find()) {
            metodos++;
        }

        rs.setMetodos(metodos);
    }

    public void contadorClases(String archivo) {
        if (archivo.contains("public class")) {
            clases++;
            rs.setClases(clases);
        }
    }

    public void mostrar() {
        System.out.println("Lineas globales " + rs.getLineas());
        System.out.println("Metodos: " + rs.getMetodos());
        System.out.println("Clases: " + rs.getClases());
    }

}
//if|for|while|(\}\s*catch)|else
