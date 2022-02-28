public class Student {

    private String Ssex,Sname,Class1;


    public Student() {
    }

    public Student(String ssex, String sname, String class1) {
        Ssex = ssex;
        Sname = sname;
        Class1 = class1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Ssex='" + Ssex + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Class='" + Class1 + '\'' +
                '}';
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        Class1 = class1;
    }
}
