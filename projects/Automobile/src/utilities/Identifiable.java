package utilities;

public class Identifiable {
    private int id;
    private static int idGen = 1;

    public Identifiable( ) {
        this.id = idGen;
        idGen++;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return String.valueOf(id);
    }
}
