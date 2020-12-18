package examen2_davidzavala;

import java.io.Serializable;

public class Orden implements Serializable {

    private int Numero;
    private String Cliente;
    private int Piezas;
    private int Fresco;
    private int Papas;
    private int Biscuit;
    private int Pure;
    private int Pie;
    private static final long SerialVersionUID = 666L;

    public Orden() {
    }

    public Orden(int Numero, String Cliente, int Piezas, int Fresco, int Papas, int Biscuit, int Pure, int Pie) {
        this.Numero = Numero;
        this.Cliente = Cliente;
        this.Piezas = Piezas;
        this.Fresco = Fresco;
        this.Papas = Papas;
        this.Biscuit = Biscuit;
        this.Pure = Pure;
        this.Pie = Pie;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public int getPiezas() {
        return Piezas;
    }

    public void setPiezas(int Piezas) {
        this.Piezas = Piezas;
    }

    public int getFresco() {
        return Fresco;
    }

    public void setFresco(int Fresco) {
        this.Fresco = Fresco;
    }

    public int getPapas() {
        return Papas;
    }

    public void setPapas(int Papas) {
        this.Papas = Papas;
    }

    public int getBiscuit() {
        return Biscuit;
    }

    public void setBiscuit(int Biscuit) {
        this.Biscuit = Biscuit;
    }

    public int getPure() {
        return Pure;
    }

    public void setPure(int Pure) {
        this.Pure = Pure;
    }

    public int getPie() {
        return Pie;
    }

    public void setPie(int Pie) {
        this.Pie = Pie;
    }

    @Override
    public String toString() {
        return "Orden=" + Numero + ", Cliente=" + Cliente + "\nPiezas=" + Piezas + "\nFresco=" + Fresco + "\nPapas=" + Papas + "\nBiscuit=" + Biscuit + "\nPure=" + Pure + "\nPie=" + Pie;
    }

}
