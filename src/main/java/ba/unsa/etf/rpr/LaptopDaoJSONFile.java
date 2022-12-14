package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class LaptopDaoJSONFile implements LaptopDao {

    private final File file;
    private ArrayList<Laptop> laptopi;
    private ObjectMapper mapper;

    public LaptopDaoJSONFile() {

        this.file = new File("laptops.json");
        try {
            file.createNewFile();
            this.mapper = new ObjectMapper();
            this.laptopi = mapper.readValue(this.file, new TypeReference<>(){});
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
        ArrayList<Laptop> result = new ArrayList<>();
        result = mapper.readValue(file, new TypeReference<>(){});
        return result;
    }
}
