
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG-PC
 */
public class Contador extends Resultado{
    
    public void LineasGlobales(String ruta, String Archivo) throws IOException{
        FileReader Fr = new FileReader(ruta + Archivo);
        BufferedReader Br = new BufferedReader(Fr);
        int cont = 0;
        String Linea = null;
        while ((Linea = Br.readLine()) != null){
            String LineaDos = Linea.trim();
            setLineas(cont++);
        }
        System.out.println(getLineas());
    }
}
