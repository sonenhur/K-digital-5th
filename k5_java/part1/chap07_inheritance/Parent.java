package part1.chap07_inheritance;

public class Parent {
    private String name;

    public Parent() {
        this.name = "홍길동"; // this 안달아도 되지만 명확하게
        System.out.println("Parent()");
    }

    public Parent(String name) {
        this.name = name;
        System.out.println("Parent(String name)");
    }

    public String getName() {
        return name;
    }
}
