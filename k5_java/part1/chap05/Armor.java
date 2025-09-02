package part1.chap05;

public class Armor {
    public String color;
    protected boolean isFly;
    int weight;
    // 필드
    private String name;
    private int height;

    // 생성자
    public Armor() {
        // 기본 생성자
    }

    public Armor(String name, int height, int weight, String color, boolean isFly) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.color = color;
        this.isFly = isFly;
    }

    // Getter와 Setter 메소드
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean isFly) {
        this.isFly = isFly;
    }

    // 메소드
    void takeOff() {
        System.out.println(name + " is taking off.");
    }

    void land() {
        System.out.println(name + " is landing.");
    }

    void shootLaser() {
        System.out.println(name + " is shooting lasers.");
    }

    void launchMissile() {
        System.out.println(name + " is launching missiles.");
    }
}
