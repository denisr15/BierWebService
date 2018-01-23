package ch.tbz;

public class Beer {
    private String id;
    private String name;
    private String description;
    private int idStyle;

    public String toString(){
        String output = this.id + ";" + this.name;
        return output;
    }
}
