import java.util.*;

public class PakuriProgram {
    public static void main(String[] args) {
        //Variable and Object declaration
        Scanner in = new Scanner(System.in);
        String max, ans;
        int cap = 0, op=-1;

        //Introduction
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        while(cap <= 0) {
            try {
                System.out.print("Enter max capacity of the Pakudex: ");
                max = in.next();
                cap = Integer.parseInt(max);
                if (cap < 0) {
                    throw new Exception();
                }
            } catch (Exception a) {
                System.out.print("Please enter a valid size.");
            }
        }

        Pakudex pakudex = new Pakudex(cap);
        System.out.println("The Pakudex can hold " + cap + " species of Pakuri.");
        boolean cont = true;
        while(cont) { //loop to navigate the pakudex
            System.out.print("Pakudex Main Menu\n" +
                    "-----------------\n" +
                    "1. List Pakuri\n" +
                    "2. Show Pakuri\n" +
                    "3. Add Pakuri\n" +
                    "4. Evolve Pakuri\n" +
                    "5. Sort Pakuri\n" +
                    "6. Exit\n");
                System.out.print("What would you like to do?");
                ans = in.next();

                try {
                    op = Integer.parseInt(ans);
                } catch (Exception a) {

                }

            //Complete task from menu selection
            if (op == 1) {
                if (pakudex.getSize() == 0) {
                    System.out.println("No Pakuri in Pakudex yet!");
                }
                else {
                    System.out.println("Pakuri In Pakudex:");
                    String[] speciesList = pakudex.getSpeciesArray();
                    for (int i = 0; i < pakudex.getSize(); i++) {
                        System.out.println((i+1) + ". " + speciesList[i]);
                    }
                }
            }
            else if (op == 2) {
                System.out.print("Enter the name of the species to display: ");
                String species = in.next();
                String[] speciesList = pakudex.getSpeciesArray();
                for (int i = 0; i < speciesList.length; i++) {
                    if (speciesList[i].equals(species)) {
                        int [] stats = pakudex.getStats(species);
                        System.out.print("Species: " + species + "\n" +
                                "Attack: " + stats[0] + "'\n" +
                                "Defense: " + stats[1] + "\n" +
                                "Speed: " + stats[2]);
                    }
                    else {
                        System.out.print("Error: No such Pakuri!");
                    }
                }
            }
            else if (op == 3) {
                System.out.print("Enter the name of the species to add: ");
                String species = in.next();
                String[] speciesList = pakudex.getSpeciesArray();
                boolean check = pakudex.addPakuri(species);
                if (!check) {
                    for (int i = 0; i < speciesList.length; i++) {
                        if (speciesList[i].equals(species)) {
                            System.out.print("Error: Pakudex already contains this species!");
                            break;
                        } else if (pakudex.getSize() == pakudex.getCapacity()) {
                            System.out.print("Error: Pakudex is full!");
                            break;
                        }
                    }
                }
                else if (check) {
                    System.out.print("Pakuri species " + species + " successfully added!");
                }
            }
            else if (op == 4) {
                System.out.print("Enter the name of the species to evolve: ");
                String species = in.next();
                boolean check = pakudex.evolveSpecies(species);
                if (!check) {
                    System.out.println("Error: No such Pakuri!");
                }
                else if (check) {
                    System.out.println(species + " has evolved!");
                }
            }
            else if (op == 5) {
                pakudex.sortPakuri();
                System.out.println("Pakuri have been sorted!");
            }
            else if (op == 6) {
                System.out.println("Thanks for using Pakudex! Bye!");
                cont = false;
            }
            else {
                System.out.print("Unrecognized menu selection!");
            }
        }

    }
}
