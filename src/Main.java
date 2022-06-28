
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
    public static void main(String[] args) {
        
        Contador cn = new Contador();
        
        System.out.println("Ingrese la ruta");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        if(!ruta.isEmpty()){
        }else{
            System.out.println("erro");
        }
    }
    
}
