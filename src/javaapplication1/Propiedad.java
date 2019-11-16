package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author santiago.scantamburlo
 */
public class Propiedad {

    //Atributos
    private int codigo, cantAmbientes, superficie, precio;
    private char tipo, operacion;
    private String direccion;
    private boolean disponibilidad;

    //Constructores
    public Propiedad(int cod) {
        codigo = cod;
    }

    public Propiedad(int cod, char tipo, String direccion, int cAmb, char op, int sup, boolean disp, int pr) {
        this.codigo = cod;
        this.tipo = tipo;
        this.direccion = direccion;
        this.cantAmbientes = cAmb;
        this.operacion = op;
        this.superficie = sup;
        this.disponibilidad = disp;
        this.precio = pr;
    }

    //Modificadores
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setDireccion(String dir) {
        this.direccion = dir;
    }

    public void setCantAmbientes(int cAmb) {
        this.cantAmbientes = cAmb;
    }

    public void setOperacion(char op) {
        this.operacion = op;
    }

    public void setSuperficie(int sup) {
        this.superficie = sup;
    }

    public void setDisponibilidad(boolean disp) {
        this.disponibilidad = disp;
    }

    public void setPrecio(int pr) {
        this.precio = pr;
    }

    //Observadores
    public int getCodigo() {
        return this.codigo;
    }

    public char getTipo() {
        return this.tipo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public int getCantAmbientes() {
        return this.cantAmbientes;
    }

    public char getOperacion() {
        return this.operacion;
    }

    public int getSuperficie() {
        return this.superficie;
    }

    public boolean getDisponibilidad() {
        return this.disponibilidad;
    }

    public int getPrecio() {
        return this.precio;
    }

    //Concatena todos los atributos en un solo String
    public String toString() {
        return "Codigo: " + getCodigo() + " Tipo: " + getTipo() + " Direccion: " + getDireccion() + " Cant. Ambientes: " + getCantAmbientes() + " Operacion: " + getOperacion() + " Superficie: " + getSuperficie() + " Disponibilidad: " + getDisponibilidad() + " Precio: " + getPrecio();
    }

    //Compara los codigos de dos Propiedades y retorna "true" si son iguales, o "false" si no lo son
    public boolean equals(Propiedad p) {
        return this.codigo == p.codigo;
    }
}
