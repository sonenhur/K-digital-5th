package chap8_list;

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public int Delete(int element) { // delete the element
//		TODO: 현재 노드와 이전 노드 초기화하기
		Node1 current = first;
		Node1 previous = null;
//		TODO: while 써서 현재 노드를 찾고, 삭제하고 데이터를 반환
		while (current != null) {
			if (current.data == element) {
				if (previous == null) { // 얘가 헤드였으면
					first = current.link; // 다음 노드가 헤드가 됨
					return 1;
				}
				previous.link = current.link; // current 삭제하고 앞뒤를 이어줌
				return 1;
			}
			previous = current; // 다음 노드로 이동
			current = current.link; // 다음 노드로 이동
		}
		return 0;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
	    Node1 current = first; // 첫 번째 노드를 가리키는 포인터를 생성하고 초기화

	    System.out.println("연결 리스트: ");
	    while (current != null) {
	        System.out.print(current.data + " "); // 현재 노드의 데이터 값을 출력
	        current = current.link; // 다음 노드로 이동
	    }
	    System.out.println();
	}

	public void Add(int element) {
	    Node1 tmp = new Node1(element); 
	    Node1 cur = first, prev = null; // cur은 현재 노드, prev는 이전 노드

		if (first == null) { // 리스트가 비어 있는 경우
			first = tmp; 	// element 값을 첫 번째 노드로 설정
	    } else {
	        while (cur != null && element > cur.data) { // element 값이 현재 노드의 값보다 크면
	            prev = cur; // 다음 노드로 이동
	            cur = cur.link; // 다음 노드로 이동
	        }

	        if (prev == null) { // 리스트의 맨 앞에 노드를 삽입해야 하는 경우
	            tmp.link = first; // 새로운 노드를 첫 번째로 설정하고 기존 첫 번째 노드를 연결
	            first = tmp; // 리스트의 첫 번째를 새로운 노드로 업데이트
	        } else {
	            tmp.link = cur; // 새로운 노드를 현재 노드(p) 앞에 연결
	            prev.link = tmp; // 이전 노드(q)를 새로운 노드로 연결
	        }
	    }
	}

	public boolean Search(int data) {
		Node1 current = first;

		while (current != null) {
			if (current.data == data) {
				return true;
			}
			current = current.link;
		}
		return false;
	}
}
public class _1정수연결리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = rand.nextInt(20);
				// double d = Math.random();
				// data = (int) (d * 50);
				l.Add(data);
				break;
			case Delete: // 머리 노드 삭제
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 " + n + " 데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}