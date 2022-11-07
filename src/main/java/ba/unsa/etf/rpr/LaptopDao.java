package ba.unsa.etf.rpr;

import java.io.IOException;
import java.util.ArrayList;

public interface LaptopDao {
    void dodajLaptopUListu(Laptop laptop) throws IOException;
    void dodajLaptopUFile(Laptop laptop) throws IOException;
    Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException;
    void napuniListu(ArrayList<Laptop> laptopi);
    ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException;
}
