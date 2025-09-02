package part1.chap13_nonGeneric;

class Bag {
    private Object thing;

    public Bag(Object thing) {
        this.thing = thing;
    }

    public Object getThing() {
        return thing;
    }

    public void setThing(Object thing) {
        this.thing = thing;
    }

    void showType() {
        System.out.println("T의 타입은 " + thing.getClass().getName());
    }
}

class Book {
}

class PencilCase {
}

class Notebook {
}

public class BagTest {
    public static void main(String[] args) {
        Bag bag = new Bag(new Book());
        Bag bag2 = new Bag(new PencilCase());
        Bag bag3 = new Bag(new Notebook());

        bag.showType();
        bag2.showType();
        bag3.showType();

        //타입캐스팅(형변환)
        Book b = (Book) bag.getThing();
        //Book b = bag.getThing(); //오류 발생
        //Object가 부모클래스인데 자식클래스에 집어넣을 수 없음
        PencilCase pc = (PencilCase) bag2.getThing();
        Notebook nb = (Notebook) bag3.getThing();

        bag.showType();
        bag2.showType();
        bag3.showType();

        bag = bag2;
        bag2 = bag3;
    }
}
