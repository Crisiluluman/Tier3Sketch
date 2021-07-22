public class DummyObject {

    private String name;
    private int age;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{"
                + "\"name\": " + "\""+ getName() +"\","
                + "\"age\": " + getAge() + ","
                + "\"salary\":" + getSalary()
                + "}";
    }
}
