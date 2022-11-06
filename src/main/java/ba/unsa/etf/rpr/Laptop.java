package ba.unsa.etf.rpr;

import java.io.Serializable;

public class Laptop implements Serializable {

    private String model;
    private double cijena;
    private int ram;
    private int ssd;
    private String procesor;
    private String grafickaKartica;
    private double velicinaEkrana;
    private String brend;

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getGrafickaKartica() {
        return grafickaKartica;
    }

    public void setGrafickaKartica(String grafickaKartica) {
        this.grafickaKartica = grafickaKartica;
    }

    public double getVelicinaEkrana() {
        return velicinaEkrana;
    }

    public void setVelicinaEkrana(double velicinaEkrana) {
        this.velicinaEkrana = velicinaEkrana;
    }


}
