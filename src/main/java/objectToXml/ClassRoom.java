package objectToXml;

import java.util.List;

public class ClassRoom {
    private long id;
    private List<Student> students;
    private String name;
    private int capacity;

    public ClassRoom(long id, List<Student> students, String name, int capacity) {
        this.id = id;
        this.students = students;
        this.name = name;
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
