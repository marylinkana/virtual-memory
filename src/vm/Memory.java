package vm;

import java.util.Arrays;

public class Memory {
    //Contient l'ensemble des espaces mémoire
    private Space[] spaces; // l'objet Space est constitué d'une valeur et d'une adresse d'allocation
    private int startAvailableIndex;

    //initialise les espaces mémoire en fonction de la taille souhaitée
    public Memory(int _size) {
        spaces = new Space[_size];
        for (int i = 0; i < _size; i++){
            spaces[i] = new Space();
            //on initialise la valeur de allocAdr à -1 pour signifier qu'il n'est pas alloué
            spaces[i].setAllocAdr(-1);
        }
        startAvailableIndex = 0;
    }

    // alloue le nombre d'espace mémoire demandé
    public int allocate(int size) {
        // vérifie qu'il y a assez d'espace mémoire avant d'effectuer l'allocation
        if (evalableSpace() >= size ){
            final int allocAdress = startAvailableIndex;
            for(int i = allocAdress; i < allocAdress + size; i++){
                spaces[i].setAllocAdr(allocAdress);
            }
            startAvailableIndex += size;
            return allocAdress;
        }
        // s'il n'y a plus assez d'espaces mémoire on retourne -1
        else {
            System.out.println("!!!Espace insufisant!!!");
        }
        return -1;
    }

    //renvoie l'index du premier espace disponible
    private int evalableSpace(){
        return spaces.length - startAvailableIndex;
    }

    // Libère les espaces mémoire alloué à l'adresse définie
    public void releaseSpace(int adress, int size) {
        try{
            for(int i = adress; i < adress + size; i++){
                if(spaces[i].getAllocAdr() == adress){
                    spaces[i].setAllocAdr(-1);
                    spaces[i].setValue(null);
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    // Renvoie la valeur présente dans l'espace alloué
    public void readValue(int adress) {
        try{
            // vérifie que l'espace est bien alloué à cette adresse
            if(spaces[adress].getAllocAdr() == adress){
                System.out.println(spaces[adress].getValues());
            }
            else System.out.println("Bad Adress");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Renvoie la valeur située à la position donnée dans l'espace alloué
    public void readValue(int adress, int position) {
        try {
            // vérifie que l'espace est bien alloué à cette adresse
            if(spaces[adress + position -1].getAllocAdr() == adress) {
                System.out.println(spaces[adress + position -1].getValues());
            }
            else System.out.println("Bad Adress");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Saisie une valeur à la première position dans l'espace alloué
    public void writeValue(int adress, String value){
        try {
            if(spaces[adress].getAllocAdr() == adress) {
                spaces[adress].setValue(value);
            }
            else System.out.println("Bad Adress");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Saisie une valeur à la position donnée dans l'espace alloué
    public void writeValue(int adress, String value,  int position){
        try {
            // vérifie que l'espace est bien alloué à cette adresse
            if(spaces[adress + position -1].getAllocAdr() == adress) {
                spaces[adress + position -1].setValue(value);
            }
            else System.out.println("Bad Adress");
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
