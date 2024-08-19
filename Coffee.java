import java.util.Arrays;

public class Coffee implements Comparable<Coffee> {
    private final String name;
    private final int price;

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Coffee[] coffees = new Coffee[]{new Coffee("Americano", 3500), new Coffee("Green tea Latte", 5500),
                new Coffee("Vanilla Latte", 4500), new Coffee("Espresso", 3000)};

        Arrays.sort(coffees); // Now it should work
        for (Coffee coffee : coffees) {
            System.out.println(coffee.toString());
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Coffee otherCoffee) {
        // Compare coffees based on their prices
        return Integer.compare(this.price, otherCoffee.getPrice());
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
