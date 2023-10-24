package gestorAplicacion.Aerolinea;

import java.io.Serializable;
import java.util.*;
import gestorAplicacion.Alimentos.*;

import static uiMain.Estetica.*;

import gestorAplicacion.Aerolinea.*;
import gestorAplicacion.Cuenta.*;
import gestorAplicacion.Descuentos.Descuento;

public class Boleto implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int cont = 0;
    private int id;
    
    // Atributos 
    private String tipo;
    private Usuario user;
    private String status = "Pendiente";
    private String origen;
    private String destino;
    private boolean checkInRealizado = false;
    private ArrayList<ServiciosEspeciales> serviciosContratados = new ArrayList<>();

    private float valor;

    private ArrayList<Maleta> equipaje = new ArrayList<>();
    private Asiento asiento;
    private Pasajero pasajero;

    // ...precios
    private float valorInicial;
    private float valorEquipaje;
    // precios...

    // Some atributos...
    private ArrayList<Descuento> descuentos = new ArrayList<>();
    private Vuelo vuelo;

    public Boleto(String origen, String destino, Usuario propietario, Vuelo vuelo) {
        cont++;
        this.origen = origen;
        this.destino = destino;
        this.user = propietario;
        this.vuelo = vuelo;
        this.pasajero = new Pasajero(propietario, this);
        this.id = cont;
    }

    public void updateValor() {
        int temp = 0;
        for (Maleta maleta : equipaje) {
            temp += maleta.calcularPrecio();
        }
        this.valorEquipaje = temp;
        this.valor = this.valorInicial + temp;
    }

    public void asignarAsiento(Asiento asiento) {
        asiento.asignarBoleto(this);
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
        this.valorInicial = asiento.getValor();
        this.valor = valorInicial;
        this.tipo = asiento.getTipo();
    }

    public void upgradeAsiento(Asiento prevAsiento, Asiento newAsiento) {
        this.asiento = newAsiento;
        this.valorInicial = newAsiento.getValor();
        this.valor = valorInicial;
        this.tipo = newAsiento.getTipo();

        int temp = 0;
        for (Maleta maleta : equipaje) {
            temp += maleta.calcularPrecio();
        }
        this.valorEquipaje = temp;
        this.valor = this.valorInicial + temp;

        prevAsiento.desasignarBoleto();
        newAsiento.asignarBoleto(this);
    }

    public void reasignarAsiento(Asiento asiento) {
        this.asiento = asiento;
        this.valorInicial = asiento.getValor() * (float) (asiento.getValor() * 0.1);
        this.valor = valorInicial;
        this.tipo = asiento.getTipo();
    }

    public void anadirServiciosEspeciales(ArrayList<ServiciosEspeciales> serviciosContratados) {
        this.serviciosContratados.addAll(serviciosContratados);
    }

    public void resetEquipaje() {
        this.equipaje = null;
    }

    public String getOrigenDestino() {
        return this.origen + " - " + this.destino;
    }

    public void addEquipaje(Maleta maleta) {
        this.equipaje.add(maleta);
        this.updateValor();
    }

    public String getInfo() {
        return negrita("Precio: ") + colorTexto("$" + this.valor, "verde") +
        negrita(", Tipo: ") + this.tipo + 
        negrita(", Numero de asiento: ") + this.asiento.getN_silla() +
        negrita(", Estado: ") + this.status;
    }

    // ...Metodos get y set...

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Usuario getUser() {
        return this.user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public ArrayList<Maleta> getEquipaje() {
        return this.equipaje;
    }

    public void setEquipaje(ArrayList<Maleta> equipaje) {
        this.equipaje = equipaje;
    }

    public Asiento getAsiento() {
        return this.asiento;
    }

    public Pasajero getPasajero() {
        return this.pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public float getValorInicial() {
        return this.valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public float getValorEquipaje() {
        return this.valorEquipaje;
    }

    public void setValorEquipaje(float valorEquipaje) {
        this.valorEquipaje = valorEquipaje;
    }

    public Vuelo getVuelo() {
        return this.vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public boolean getCheckInRealizado() {
        return this.checkInRealizado;
    }

    public void setCheckInRealizado(boolean checkInRealizado) {
        this.checkInRealizado = checkInRealizado;
    }

    public ArrayList<ServiciosEspeciales> getServiciosContratados() {
        return this.serviciosContratados;
    }

    public void setServiciosContratados(ArrayList<ServiciosEspeciales> serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
}
