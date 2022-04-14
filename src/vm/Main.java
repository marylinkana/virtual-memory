package vm;

public class Main {
    public static void main(String args[]){
        // Build Memory of 10 spaces
        Memory mem = new Memory(10);

        int adr1 = mem.allocate(2); // allocate 2 spaces to adr1
        int adr2 = mem.allocate(5); // allocate 5 space to adr2
        int adr3 = mem.allocate(3); // allocate 3 space to adr3
        int adr4 = mem.allocate(1); // return error's message because memory full

        mem.writeValue(adr1, "toto"); // write toot at the 1st position of adr1
        mem.writeValue(adr2, "titi"); // write toot at the 1st position of adr2
        mem.writeValue(adr3, "34"); // write toot at the 1st position of adr3

        mem.readValue(adr1); // read value at fist position of adr1
        mem.readValue(adr1, 2); // read value at 2nd position of adr2 but the value is actualy null

        mem.writeValue(adr1, "bad", 3); // return error's message because adr1 don't have 3 spaces
        mem.writeValue(adr2, "good", 3); // write good at the 3th position of adr2

        mem.release(adr1, 2); // release the 2 spaces of adr1
        mem.readValue(adr1); // return error's message because adr1 is no longer allocate

        int adr5 = mem.allocate(2);
        // despite the fact that there are 2 empty spaces in the memory,
        // this allocation is impossible because our method is contiguous
        // start avalable index is at 10 and the last index of the mémory is 9

        System.out.println(mem.toString());

    }
}
