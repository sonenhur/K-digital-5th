package part1.chap08_polymorphism;

public class MyLinkedList2 {
    private Node head = null;

    public static void main(String[] args) {
        MyLinkedList2 myList = new MyLinkedList2();

        myList.print();
        myList.add("JAVA");
        myList.add("JSP");
        myList.add("Servlet");
        myList.add("Python");
        myList.add("Spring");
        myList.add("JAVA", "C++");
        myList.add("Servlet", "C#");
        myList.delete("Python");
        myList.print();
    }

    private Node find(String data) {
        Node next = head;
        do {
            if (next.data.equals(data))
                return next;
            next = next.next;
        } while (next.next != null);
        return null;
    }

    public void delete(String data) {
        Node node = find(data);
        Node p = node.prev;
        Node n = node.next;
        if (p != null && n != null) {
            p.next = n;
            n.prev = p;
        } else {
            if (p == null) {
                n.prev = null;
            }
            if (n == null) {
                p.next = null;
            }
        }
    }

    public void add(String prev, String data) {
        Node node = find(prev);
        if (node == null)
            add(data);
        else {
            Node newNode = new Node(data);
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
            newNode.prev = node;
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("등록된 데이터가 없습니다");
        }
        System.out.println("등록된 데이터는 다음과 같습니다");
        Node next = head;
        while (true) {
            System.out.println(next.data);

            if (next.next == null)
                break;

            next = next.next;
        }
        System.out.println("-".repeat(20));

        while (next != null) {
            System.out.println(next.data);
            next = next.prev;
        }
    }

    private class Node {
        private String data;
        private Node prev;
        private Node next;

        public Node(String data) {
            this.data = data;
        }
    }
}