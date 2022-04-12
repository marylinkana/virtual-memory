package vm;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private int adress;
    private int allocationAdress;
    private String value;

    public Space(int _adress) {
        adress = _adress;
    }

    public int getAdress() {
        return adress;
    }

    public void setAdress(int adress) {
        this.adress = adress;
    }

    public String getValues() {
        return value;
    }

    public void setValue(String _value) {
        value = _value;
    }

    public int getAllocationAdress() {
        return allocationAdress;
    }

    public void setAllocationAdress(int allocationAdress) {
        this.allocationAdress = allocationAdress;
    }

    @Override
    public String toString() {
        return "\nSpace{" +
                "adress=" + adress +
                ", value=" + value +
                '}';
    }
}
