package vm;

public class Space {
    private int allocAdr;
    private String value;

    public Space() {
    }

    public String getValues() {
        return value;
    }

    public void setValue(String _value) {
        value = _value;
    }

    public int getAllocAdr() {
        return allocAdr;
    }

    public void setAllocAdr(int allocAdr) {
        this.allocAdr = allocAdr;
    }

    @Override
    public String toString() {
        return "\nSpace{" +
                ", allocAdr=" + allocAdr +
                ", value='" + value + '\'' +
                '}';
    }
}
