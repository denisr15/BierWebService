package ch.tbz;

public class Beer {
    private String id;
    private String name;
    private String description;
    private Long idStyle;

    public Beer(String id, String name, String description, Long idStyle) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.idStyle = idStyle;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdStyle() {
        return idStyle;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdStyle(Long idStyle) {
        this.idStyle = idStyle;
    }

}
