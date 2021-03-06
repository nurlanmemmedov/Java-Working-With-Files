package objectToXml;

public class Student {
    private long id;
    private String name;
    private String surName;

    public Student(long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
