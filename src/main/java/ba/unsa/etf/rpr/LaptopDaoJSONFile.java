package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jdk.internal.util.xml.XMLStreamException;
import jdk.internal.util.xml.impl.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {
    private ObjectMapper o;
    private File file;
    private ArrayList<Laptop> laptopi;
    private FileOutputStream fos;
    private JsonGenerator g;
    public LaptopDaoJSONFile() throws IOException {
        file = new File("laptops.json");
        fos = new FileOutputStream(file.getCanonicalPath());
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        o = new ObjectMapper(jsonFactory);
        laptopi = new ArrayList<>();
        /*file = new File("laptops.json");
        o = new ObjectMapper();
        fos = new FileOutputStream(file.getCanonicalPath(),true);
        g = o.getFactory().createGenerator(fos);
        laptopi = new ArrayList<>();*/
    }
    @Override
    public void dodajLaptopUListu(Laptop laptop) throws IOException {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        try{
            o.writeValue(fos, laptop);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public Laptop getLaptop(String procesor) {
        for (Laptop l : laptopi)
            if (l.getProcesor().equals(procesor))
                return l;
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    /**
     * NE RADI !!!
     */
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file.getCanonicalPath());
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        ArrayList<Laptop> l = new ArrayList<>();

        while(true){
            Laptop lapt = new Laptop();
            try {
                lapt = mapper.readValue(file, Laptop.class);
                l.add(lapt);
            } catch(Exception e){
                System.out.println(e);
                break;
            }
        }
        return l;
    }
}
