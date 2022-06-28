/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SAMSUNG-PC
 */
public class Resultado {
    private int Lineas = 0;
    private int Metodos = 0;
    private int Comentarios = 0;
    private int LineasVacias = 0;
    private int Clases = 0;

    public Resultado() {
    }
    
    public int getLineas() {
        return Lineas;
    }

    public void setLineas(int Lineas) {
        this.Lineas = Lineas;
    }

    public int getMetodos() {
        return Metodos;
    }

    public void setMetodos(int Metodos) {
        this.Metodos = Metodos;
    }

    public int getComentarios() {
        return Comentarios;
    }

    public void setComentarios(int Comentarios) {
        this.Comentarios = Comentarios;
    }

    public int getLineasVacias() {
        return LineasVacias;
    }

    public void setLineasVacias(int LineasVacias) {
        this.LineasVacias = LineasVacias;
    }

    public int getClases() {
        return Clases;
    }

    public void setClases(int Clases) {
        this.Clases = Clases;
    }
    
    
}
