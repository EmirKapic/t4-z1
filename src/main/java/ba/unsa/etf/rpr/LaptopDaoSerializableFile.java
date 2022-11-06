package ba.unsa.etf.rpr;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LaptopDaoSerializableFile implements LaptopDao{
    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoSerializableFile() throws IOException {
        file = new File("laptops.txt");
        laptopi = new ArrayList<>();
        file.createNewFile();
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        FileOutputStream fos = new FileOutputStream(file.getCanonicalPath(), true);
        if (file.length() == 0){
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(laptop);
            oos.reset();
            oos.close();
        }
        else{
            MyOutput oos = new MyOutput(fos);
            oos.writeObject(laptop);
            oos.close();
        }
    }

    /**
     *
     * @param procesor name of the processor
     * @return laptop with the given processor, or null if it doesn't exist
     */
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
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file.getCanonicalPath());
        ObjectInputStream f = new ObjectInputStream(fis);
        ArrayList<Laptop> l = new ArrayList<>();
        while (true) {
            Laptop lapt = new Laptop();
            try {
                lapt = (Laptop) f.readObject();
                l.add(lapt);
            } catch(Exception e){
                System.out.println(e);
                break;
            }
        }
        f.close();
        return l;
    }
}
