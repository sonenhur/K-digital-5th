package part1.chap06;

public class Member {
    private String name;
    private int age;

    public Member() {
        System.out.println("Member 기본 생성자가 호출되었습니다.");
    }

    public Member(String name) {
        System.out.println("Member 생성자1가 호출되었습니다.");
    }

    public Member(int age) {
        System.out.println("Member 생성자2가 호출되었습니다.");
    }

    public Member(String name, int age) {
        System.out.println("Member 생성자3가 호출되었습니다.");
    }

    public static void main(String[] args) {
        Member m1 = new Member();
        Member m2 = new Member("홍");
        Member m3 = new Member(20);
        Member m4 = new Member("Lee", 10);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
