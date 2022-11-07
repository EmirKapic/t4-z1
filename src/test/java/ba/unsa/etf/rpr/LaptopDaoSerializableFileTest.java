package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LaptopDaoSerializableFileTest {

    LaptopDaoSerializableFile ser = new LaptopDaoSerializableFile();
    Laptop l1, l2;

    @BeforeEach
    void Setup(){
        l1 = new Laptop();
        l1.setProcesor("Intel i5"); l1.setGrafickaKartica("Geforce");
        l2 = new Laptop();
        l2.setProcesor("Ryzen 5"); l2.setGrafickaKartica("Radeon");
    }


    @Test
    void dodajLaptopUFile() throws Exception {
        ser.dodajLaptopUFile(l1); ser.dodajLaptopUFile(l2);
        ArrayList<Laptop> testList = new ArrayList<>();
        testList.add(l1); testList.add(l2);
        assertEquals(testList, ser.vratiPodatkeIzDatoteke());
    }

    @Test
    void getLaptop() throws NeodgovarajuciProcesorException {
        assertEquals(l1, ser.getLaptop("Intel i5"));
    }

    @Test
    void getLaptopExceptionTest(){
        assertThrows(NeodgovarajuciProcesorException.class, () -> ser.getLaptop("Intel i6"));
    }

    @Test
    void vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        ArrayList<Laptop> testList = new ArrayList<>();
        testList.add(l1); testList.add(l2);
        assertEquals(testList, ser.vratiPodatkeIzDatoteke());
    }
}