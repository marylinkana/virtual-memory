package vm;

public class NotFreeSpaceException extends Exception{
    public NotFreeSpaceException() {
        super("Cette espace n'est pas libre");
    }
}
