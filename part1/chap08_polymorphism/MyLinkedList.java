package part1.chap08_polymorphism;

public class MyLinkedList {

    // 링크드 리스트의 시작노드의 참조값. (그래서 참조변수)
    private Node head = null;

    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.print();

        myList.add("JAVA");
        myList.add("JSP");
        myList.add("Servlet");
        myList.print();
    }

    // 노드를 추가하는 메서드
    public void add(String data) {
        // 새로운 노드를 생성
        Node newNode = new Node(data);
        if (head == null) { // 리스트의 시작점인 head가 아무것도 없으면, 즉 null이면,
            head = newNode; // 새로 만든 노드를 시작점으로 설정한다.
        } else {
            // 이쪽으로 들어온다는 것은 head에 이미 노드가 설정되어 있다는 의미.
            // 즉, 최소 1개 이상의 노드가 리스트에 존재한다는 의미가 된다.

            // 시작 노드값을 임시 변수 next에 설정
            //
            Node next = head;

            while (next.link != null) { // 현재 노드 next에 연결된 노드가 있는 동안 루프
                next = next.link; // 다음 노드를 현재 노드로 설정
            }
            // 여기까지 오면 리스트의 끝 노드에 도착했다는 의미 (연결된 노드가 없음)
            // 마지막 노드인 next의 다음 연결 노드로 newNode를 설정
            next.link = newNode;
        }
    }

    // 현재까지 입력된 리스트를 출력한다.
    public void print() {
        // head가 null이라는 의미는 데이터가 add 된 적이 없다는 의미
        if (head == null) {
            System.out.println("등록된 데이터가 없습니다");
            // 출력할 데이터가 없으므로 리턴
            return;
        }

        System.out.println("등록된 데이터는 다음과 같습니다");
        // 시작 노드값을 임시 변수 next에 설정
        Node next = head;

        // 현재 노드 next가 null이 아닌 동안 루프
        while (next != null) {
            System.out.println(next.data);

            // 현재 노드를 연결된 다음 노드로 설정한다
            next = next.link;
        }
    }

    // 내부 클래스
    private class Node {
        private String data; // 데이터를 저장하는 필드변수. (저장 데이터가 String Type)
        private Node link; // 현재노드에 연결된 다음노드 참조값을 저장하는 참조변수.

        // 노드 생성자(파라미터로 데이터(String)을 입력해야 한다.)
        public Node(String data) {
            this.data = data;
        }
    }
}