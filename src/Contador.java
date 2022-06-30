
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
    private int cantArchivos;

    public void leerArchivo(String ruta) throws FileNotFoundException {
        File directorio = new File(ruta);
        String[] archivos = directorio.list();
        //
        cantArchivos = archivos.length;
        //
        for (int i = 0; i < cantArchivos; i++) {
            try {
                System.out.printf("[%21s ]", archivos[i]);
                BufferedReader c = new BufferedReader(new FileReader(ruta + archivos[i]));
                contadorMetodos(c);
//                BufferedReader lb = new BufferedReader(new FileReader(ruta + archivos[i]));
//                lineasGlobales(lb);
//                BufferedReader cc = new BufferedReader(new FileReader(ruta + archivos[i]));
//                contadorClases(cc);
//                BufferedReader cl = new BufferedReader(new FileReader(ruta + archivos[i]));
//                contadorLibrerias(cl);
//                BufferedReader cm = new BufferedReader(new FileReader(ruta + archivos[i]));
//                contadorMain(cm);
//                BufferedReader ct = new BufferedReader(new FileReader(ruta + archivos[i]));
//                contadorComentarios(ct);
//                BufferedReader cv = new BufferedReader(new FileReader(ruta + archivos[i]));
//                contadorLineasVacias(cv);
//                BufferedReader lr = new BufferedReader(new FileReader(ruta + archivos[i]));
//                lineasReales(lr);
            } catch (Exception e) {
                System.out.println("no se encontro archivo");
            }
        }
    }
    
     public void contadorMetodos(BufferedReader ruta) throws IOException {
        String fila = null;
        int cont = 0;
        while ((fila = ruta.readLine()) != null) {
            
        Pattern p = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)*\\s+\\w+\\(");
        Matcher m = p.matcher(fila);

        Pattern po = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)\\s*(get|set)\\w*\\(");
        Matcher mo = po.matcher(fila);

        if (m.find()) {
            cont++;
        }
        if (mo.find()) {
            cont++;
        }
        rs.setMetodos(cont);
        }
        System.out.printf("[%16]%n"+ rs.getMetodos());
    }
    
    public void lineasGlobales(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            cont++;
            rs.setLineas(cont);
        }
        System.out.printf("[%16s ]%n", rs.getLineas());
    }

   

    public void contadorClases(BufferedReader ruta) throws IOException {
        String linea = null;
        while ((linea = ruta.readLine()) != null) {
        if (linea.contains("public class")) {
            clase++;
            rs.setClases(clase);
        }
        }
        System.out.printf("[%16s ]%n", rs.getClases());
    }

    public void contadorLibrerias(BufferedReader ruta) throws IOException {
        String linea = null;
        while ((linea = ruta.readLine()) != null) {
        if (linea.contains("import")) {
            libreria++;
            rs.setLibreria(libreria);
        }
        }
        System.out.printf("[%16]%n", rs.getLibreria());
    }

    public void contadorMain(BufferedReader ruta) throws IOException {
        String linea = null;
        while ((linea = ruta.readLine()) != null) {
        if (linea.contains("public static void")) {
            main++;
            rs.setMain(main);
        }
        }
        System.out.printf("[%16]%n", rs.getMain());
        
    }

    public void contadorComentarios(BufferedReader ruta) throws IOException {
        String linea = null;
        while ((linea = ruta.readLine()) != null) {
        if (linea.contains("/") || linea.contains("*")) {
            comentario++;
            rs.setComentarios(comentario);
        }
        }
        System.out.printf("[%16]%n", rs.getComentarios());
        
    }

    public void contadorLineasVacias(BufferedReader ruta) throws IOException {
        String linea = null;
        while ((linea = ruta.readLine()) != null) {
        if (linea.isEmpty()) {
            lineasVacia++;
            rs.setLineasVacias(lineasVacia);
        }
        }
        System.out.printf("[%16]%n", rs.getLineasVacias());
        
    }

    public void lineasReales(BufferedReader ruta) {
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
