package 基础实例.泛型.多态的进阶;

public class School {
    public void showclass(Grade<?> grade){
        grade.Show();
    }
}
