package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        LaptopDaoJSONFile l = new LaptopDaoJSONFile();
        Laptop lap = new Laptop();
        lap.setBrend("Apple");
        lap.setCijena(5000); lap.setModel("Mac");lap.setGrafickaKartica("Nvidia");
        lap.setRam(16);lap.setSsd(256);lap.setVelicinaEkrana(20);lap.setProcesor("M1");
        l.dodajLaptopUListu(lap);
        l.dodajLaptopUFile(lap);
        l.dodajLaptopUFile(lap);
        ArrayList<Laptop> ls = new ArrayList<>();
        ls = l.vratiPodatkeIzDatoteke();
        System.out.println(ls.size());
        /*LaptopDaoJSONFile l = new LaptopDaoJSONFile();
        Laptop lap = new Laptop();
        lap.setBrend("Apple");
        lap.setCijena(5000); lap.setModel("Mac");lap.setGrafickaKartica("Nvidia");
        lap.setRam(16);lap.setSsd(256);lap.setVelicinaEkrana(20);lap.setProcesor("M1");
        l.dodajLaptopUListu(lap);
        l.dodajLaptopUFile(lap);
        Laptop lap2 = new Laptop();
        lap2.setBrend("HP");
        lap2.setCijena(500); lap2.setModel("113");lap2.setGrafickaKartica("AMD");
        lap2.setRam(16);lap2.setSsd(256);lap2.setVelicinaEkrana(20);lap2.setProcesor("Intel");
        l.dodajLaptopUListu(lap2);
        l.dodajLaptopUFile(lap2);
        lap.setProcesor("AMD");
        l.dodajLaptopUFile(lap);
        ArrayList<Laptop> lista = new ArrayList<>(l.vratiPodatkeIzDatoteke());
        System.out.println(lista.size());
        for (Laptop i : lista)
            System.out.println(i.getProcesor());*/
    }
}
