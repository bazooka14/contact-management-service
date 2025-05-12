package infrastructure;

public class idGenerator {
    static int id = 1;

    public static int getNextId() {
        return id++;
    }
}
