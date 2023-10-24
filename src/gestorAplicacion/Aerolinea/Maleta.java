package gestorAplicacion.Aerolinea;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Cuenta.*;

import static uiMain.Estetica.*;

public class Maleta implements Serializable {

    private final static long serialVersionUID = 1L;

    private int id;

    private int peso;
    private int largo;
    private int ancho;
    private int alto; // Al fin y al cabo es un volumen

    private Pasajero pasajero; //
    private Boleto boleto;
    private String destino_origen;
    private String estado;

    public Maleta(int id, int peso, int largo, int ancho, int alto) {
        this.id = id;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int calcularPrecio() {
        return ((this.peso + ((this.alto * this.ancho * this.largo) / 5)) / 2) + 5; // Crear formula para calcular el
                                                                                    // valor total con respecto al peso,
                                                                                    // largo y alto
    }

    public void asignarBoleto(Boleto boleto) {
        this.boleto = boleto;
        this.pasajero = boleto.getPasajero();
        this.destino_origen = boleto.getOrigenDestino();
    }

    // ...Metodos get y set...

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return this.peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getLargo() {
        return this.largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Boleto getBoleto() {
        return this.boleto;
    }

    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }

    public String getDestino_origen() {
        return this.destino_origen;
    }

    public void setDestino_origen(String destino_origen) {
        this.destino_origen = destino_origen;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}