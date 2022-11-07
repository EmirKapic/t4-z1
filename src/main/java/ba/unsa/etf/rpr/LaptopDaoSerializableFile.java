package ba.unsa.etf.rpr;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

    public class LaptopDaoSerializableFile implements LaptopDao{
        private File file;
        private ArrayList<Laptop> laptopi;
        private ObjectOutputStream oos;

        private void save() throws Exception {
            ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(file));
            ois.writeObject(laptopi);
        }

        public LaptopDaoSerializableFile() throws IOException {
            this.file = new File("laptops.txt");
            this.laptopi = new ArrayList<Laptop>();
            this.oos = new ObjectOutputStream(new FileOutputStream(file));
        }

        @Override
        public void dodajLaptopUListu(Laptop laptop) {
            this.laptopi.add(laptop);
        }

        @Override
        public void dodajLaptopUFile(Laptop laptop) throws IOException {
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
            ArrayList<Laptop> rez = new ArrayList<Laptop>();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            rez = (ArrayList<Laptop>) ois.readObject();
            return rez;
        }
    }


