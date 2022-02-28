package 基础实例.泛型.多态的进阶;

public class Grade <T>{
    private T t;

    public Grade() {

    }

    @Override
    public String toString() {
        return "Grade{" +
                "t=" + t +
                '}';
    }

    public void Show(){
        System.out.println(this);

    }

    public Grade(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
