
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
    

    public void leerArchivo(String ruta) throws FileNotFoundException, IOException {
        File directorio = new File(ruta);
        String[] archivos = directorio.list();
        //
        int cantArchivos = archivos.length;
        //
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

    public void contadorMetodos(BufferedReader ruta) throws IOException {
        String fila = null;
        int cont = 0;
        while ((fila = ruta.readLine()) != null) {
            Pattern p = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)*\\s+\\w+\\(");
            Matcher m = p.matcher(fila);
            //Pattern po = Pattern.compile("(public)\\s*(static|void|int|double|boolean|String)\\s*(get|set)\\w*\\(");
            //Matcher mo = po.matcher(fila);
            if (m.find()) {
                cont++;
            }
//        if (mo.find()) {
//            cont++;
//        }
        }
        rs.setMetodos(cont);
        System.out.printf("[%s]", rs.getMetodos());
    }

    public void lineasGlobales(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            cont++;
        }
        rs.setLineas(cont);
        System.out.printf("[%16s ]", rs.getLineas());
    }

    public void contadorClases(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("public class")) {
                cont++;
            }
        }
        rs.setClases(cont);
            //System.out.println("aaaaaaaaaaaaaaaaaaaaaaa b " + rs.getClases());
        System.out.printf("[%5s ]", rs.getClases());

    }

    public void contadorLibrerias(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("import")) {
                cont++;
            }
        }
        rs.setLibreria(cont);
        System.out.printf("[%16s]", rs.getLibreria());
    }

    public void contadorMain(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("public static void")) {
                cont++;
            }
        }
        rs.setMain(cont);
        System.out.printf("[%16s]", rs.getMain());
    }

    public void contadorComentarios(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont = 0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.contains("/") || linea.contains("*")) {
                cont++;
            }
        }
        rs.setComentarios(cont);
        System.out.printf("[%16s]", rs.getComentarios());
    }

    public void contadorLineasVacias(BufferedReader ruta) throws IOException {
        String linea = null;
        int cont=0;
        while ((linea = ruta.readLine()) != null) {
            if (linea.isEmpty()) {
                cont++;
            }
        }
        rs.setLineasVacias(cont);
        System.out.printf("[%16s]", rs.getLineasVacias());
    }

    public void lineasReales() throws IOException {


        int hola = rs.getLineas()-(rs.getClases()+rs.getComentarios()+rs.getLibreria()+rs.getLineasVacias()+rs.getMain()+rs.getMetodos());
        rs.setTotal(hola);
        System.out.printf("[%16s ]%n", rs.getTotal());
    }
    }

//if|for|while|(\}\s*catch)|else
//C:/xampp/htdocs/Aplicacion-2/src/
