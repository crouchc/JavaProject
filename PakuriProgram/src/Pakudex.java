public class Pakudex {

    private Pakuri[] pakudex;
    private int pakudexSize = 0;
    public Pakudex() {
        pakudex = new Pakuri[20];
    }
    public Pakudex(int capacity) {
        pakudex = new Pakuri[capacity];
    }
    public int getSize() {
        return this.pakudexSize;
    }
    public int getCapacity() {
        return pakudex.length;
    }
    public String[] getSpeciesArray() {
        String[] species = new String[pakudexSize];
        if (this.pakudexSize == 0) {
            return null;
        }
        for (int i = 0; i < this.pakudexSize; i++) {
            species[i] = pakudex[i].getSpecies();
        }
        return species;
    }
    public int[] getStats(String species) {
        int ind = -1;
        int[] stats = new int[3];
        for (int i = 0; i < pakudexSize; i++) {
            if (pakudex[i].getSpecies() == species) {
                ind = i;
            }
        }
        if (ind == -1) {
            return null;
        }
        stats[0] = pakudex[ind].getAttack();
        stats[1] = pakudex[ind].getDefense();
        stats[2] = pakudex[ind].getSpeed();
        return stats;
    }
    public void sortPakuri() {
        Pakuri temp;
        for (int i = 1; i < pakudexSize; i++) {
            if(pakudex[i] != null) {
                if (pakudex[i-1].getSpecies().compareTo(pakudex[i].getSpecies()) > 0) {
                    temp = pakudex[i-1];
                    pakudex[i-1] = pakudex[i];
                    pakudex[i] = temp;
                }
            }
        }
    }
    public boolean addPakuri(String species) {
        for (int i = 0; i < pakudexSize; i++) {
            if (pakudex[i] != null) {
                String spec = pakudex[i].getSpecies();
                if (spec.equals(species)) {
                    return false;
                }
            }
        }
        if (pakudexSize != getCapacity()) {
            pakudex[pakudexSize] = new Pakuri(species);
            pakudexSize++;
            return true;
        }
        else {
            return false;
        }


    }
    public boolean evolveSpecies(String species) {
        if (pakudexSize == 0) {
            return false;
        }
        for (int i = 0; i < pakudexSize; i++) {
            if (pakudex[i].getSpecies().equals(species)) {
                pakudex[i].evolve();
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
