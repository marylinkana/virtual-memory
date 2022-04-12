package vm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Memory {
    private Space spaces[];
    private Random r_adress = new Random();

    public Memory(int _size) {
        spaces = new Space[_size];
        for (int i = 0; i < _size; i++){
            spaces[i] = new Space(r_adress.nextInt());
        }
    }

    public int allocate(int size) {
        int uaa = r_adress.nextInt();
        if (size < freeSpaces().count()){
            for (int i = 0; i < size; i++){
                freeSpaces().forEach(space -> {space.setAdress(uaa);});
            }
        }
        return uaa;
    }

    private Stream<Space> freeSpaces(){
        return Arrays.stream(spaces).filter(space -> space.getAllocationAdress() != 0);
    }

    private Stream<Space> getSpace(int adress){
        return Arrays.stream(spaces).filter(space -> space.getAllocationAdress() == adress);
    }

    public void release(int adress) {
        Arrays.stream(spaces).forEach(space -> {
            if (space.getAllocationAdress() == adress){
                space.setAllocationAdress(0);
            }
        });
    }

    public int getsize() {
        return spaces.length;
    }

    public void readValue(int adress){
        getSpace(adress).forEach(space -> {
            System.out.println(space.getValues());
        });
    }

    public void readValue(int adress, int position) {
        System.out.println(getSpace(adress).collect(Collectors.toList()).get(position - 1).getValues());
    }

    public void writeValue(int adress, String value){
        getSpace(adress).collect(Collectors.toList()).get(0).setValue(value);
    }

    public void writeValue(int adress, int position, String value){
        getSpace(adress).collect(Collectors.toList()).get(position-1).setValue(value);

    }
}
