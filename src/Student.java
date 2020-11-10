public class Student {

    // this is a student class/object
    // our student has a name and surname,
    // gpa and id

    private String nameAndSurname;
    private double gpa;
    private long id;

    // why do we use getters and setters https://www.freecodecamp.org/news/java-getters-and-setters/#:~:text=Getters%20and%20setters%20are%20used,sets%20or%20updates%20its%20value.&text=Getters%20and%20setters%20allow%20control%20over%20the%20values.
    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
