package vm;

public class UnknowedSpaceException extends Exception{
    public UnknowedSpaceException() {
        super("Cette espace n'existe pas");
    }
}
