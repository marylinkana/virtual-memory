package vm;

public class Main {
    public static void main(String args[]){
        Memory mem = new Memory(1000);
        int adr1 = mem.allocate(5);
        int adr2 = mem.allocate(10);
        int adr3 = mem.allocate(100);

        mem.release(adr1);
        mem.release(adr2);

        mem.writeValue(adr3, "543");
        mem.writeValue(adr3, 9, "34");

        mem.readValue(adr3);
        mem.readValue(adr3, 9);
    }
}
