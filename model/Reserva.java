/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fujim
 */
public class Reserva {
    private String numreserva;
    private String ID;
    private String numpessoas;
    private String datain;
    private String dataout;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getNumreserva() {
        return numreserva;
    }

    public void setNumreserva(String numreserva) {
        this.numreserva = numreserva;
    }

    public String getNumpessoas() {
        return numpessoas;
    }

    public void setNumpessoas(String numpessoas) {
        this.numpessoas = numpessoas;
    }

    public String getDatain() {
        return datain;
    }

    public void setDatain(String datain) {
        this.datain = datain;
    }

    public String getDataout() {
        return dataout;
    }

    public void setDataout(String dataout) {
        this.dataout = dataout;
    }
    
}
