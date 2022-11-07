package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop();
        Laptop l3 = new Laptop();
        l1.setProcesor("Intel");
        l2.setProcesor("AMD");
        l3.setProcesor("ARM");
        LaptopDaoXmlFile f = new LaptopDaoXmlFile();
        f.dodajLaptopUFile(l1);
        f.dodajLaptopUFile(l2);
        f.dodajLaptopUFile(l3);
        ArrayList<Laptop> lista = f.vratiPodatkeIzDatoteke();
        for (Laptop x : lista) System.out.println(x);
    }
}
