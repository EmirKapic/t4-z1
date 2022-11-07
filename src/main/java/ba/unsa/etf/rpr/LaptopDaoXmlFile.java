package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaptopDaoXmlFile implements LaptopDao{

    private File file;
    private XmlMapper mapper;
    private ArrayList<Laptop> laptopi;


    public LaptopDaoXmlFile(){
        file = new File("laptops.xml");
        try {
            file.createNewFile();
            this.mapper = new XmlMapper();
            this.laptopi = mapper.readValue(file, new TypeReference<>(){});
        } catch (IOException e) {
            this.laptopi = new ArrayList<>();
        }
    }
    private void save(){
        try {
            mapper.writeValue(this.file,this.laptopi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop){
        this.laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop){
        dodajLaptopUListu(laptop);
        save();
    }

    @Override
    public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
        for (Laptop l : this.laptopi)
            if (l.getProcesor().equals(procesor))
                return l;
        throw new NeodgovarajuciProcesorException("Nema trazenog procesora");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {
        this.laptopi.addAll(laptopi);
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> result;
        result = mapper.readValue(file, new TypeReference<>(){});
        return result;
    }
}
