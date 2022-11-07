package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.*;
import java.util.ArrayList;

    public class LaptopDaoSerializableFile implements LaptopDao{
        private final File file;
        private ArrayList<Laptop> laptopi;

        private void save() throws Exception {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(this.file));
            os.writeObject(laptopi);
        }

        public LaptopDaoSerializableFile(){
            this.file = new File("laptops.txt");
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file));
                this.laptopi = (ArrayList<Laptop>) in.readObject();
            } catch (Exception e) {
                this.laptopi = new ArrayList<>();
            }
        }

        @Override
        public void dodajLaptopUListu(Laptop laptop) {
            this.laptopi.add(laptop);
        }

        @Override
        public void dodajLaptopUFile(Laptop laptop){
            dodajLaptopUListu(laptop);
            try {
                this.save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         *
         * @param procesor name of the processor
         * @return laptop with the given processor, or null if it doesn't exist
         */
        @Override
        public Laptop getLaptop(String procesor) throws NeodgovarajuciProcesorException {
            for (Laptop l : laptopi)
                if (l.getProcesor().equals(procesor))
                    return l;
            throw new NeodgovarajuciProcesorException("Nema trazenog procesora");
        }

        @Override
        public void napuniListu(ArrayList<Laptop> laptopi) {
            this.laptopi.addAll(laptopi);
        }

        @Override
        public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException {
            ArrayList<Laptop> result = new ArrayList<>();
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file));
            result = (ArrayList<Laptop>) in.readObject();
            return result;
        }
    }


