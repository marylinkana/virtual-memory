package vm;

import java.util.Arrays;


public class Memory {
    //Contien l'ensemble des espaces mémoire
    private Space[] spaces;
    private int startAvailableIndex;

    //initialise les espaces mémoire en fonction de la taille souhaitée
    public Memory(int _size) {
        spaces = new Space[_size];
        for (int i = 0; i < _size; i++){
            spaces[i] = new Space();
            //on initialise la valeur de allocAdr à -1 pour signifié qu'il n'est pas alloué
            spaces[i].setAllocAdr(-1);
        }
        startAvailableIndex = 0;
    }

    // alloue le nombre d'espace mémoire demandée
    public int allocate(int size) {
        // vérifie qu'il a assez d'espace mémoire avant d'effectuer l'allocation
        if (evalableSpace() >= size ){
            final int allocAdress = startAvailableIndex;
            spaces[allocAdress].setAllocAdr(allocAdress);
            startAvailableIndex += size;
            return allocAdress;
        }
        // s'il n'y a plus assez d'espaces mémoire on retourne -1
        else {
            System.out.println("!!!Espace insufisant!!!");
        }
        return -1;
    }

    private int evalableSpace(){
        return spaces.length - startAvailableIndex;
    }

    public Space[] getSpaces() {
        return spaces;
    }

    // Libère les espaces mémoire alloué à l'adresse défini
    public void release(int adress, int size) {
        try{
            for(int i = adress; i < adress + size; i++){
                spaces[i].setAllocAdr(-1);
                spaces[i].setValue(null);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // Renvoie la valeur présente dans l'espace alloué
    public void readValue(int adress) {
        try{
            if(spaces[adress].getAllocAdr() != -1){
                System.out.println(spaces[adress].getValues());
            }
            else System.out.println("Adresse non alloué");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Renvoie la valeur située à la position donnée dans l'espace alloué
    public void readValue(int adress, int position) {
        try {
            if(spaces[adress].getAllocAdr() != -1) {
                System.out.println(spaces[adress + position].getValues());
            }
            else System.out.println("Adresse non alloué");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Saisie une valeur à la première position dans l'espace alloué
    public void writeValue(int adress, String value){
        try {
            if(spaces[adress].getAllocAdr() != -1) {
                spaces[adress].setValue(value);
            }
            else System.out.println("Adresse non alloué");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Saisie une valeur à la position donnée dans l'espace alloué
    public void writeValue(int adress, String value,  int position){
        try {
            if(spaces[adress].getAllocAdr() != -1) {
                spaces[adress + position].setValue(value);
            }
            else System.out.println("Adresse non alloué");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Memory{" +
                "\nspaces=" + Arrays.toString(spaces) +
                '}';
    }
}
