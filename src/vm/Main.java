package vm;

public class Main {
    public static void main(String args[]){
        Memory mem = new Memory(10);
        int adr1 = mem.allocate(2);
        int adr2 = mem.allocate(5);
        int adr3 = mem.allocate(3);

        mem.writeValue(adr1, "toto");
        mem.writeValue(adr2, "titi");
        mem.writeValue(adr3, "34");

        mem.release(adr1, 2);

        mem.readValue(adr1);

        System.out.println(mem.toString());

    }
}
