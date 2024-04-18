package chap9_tree;

import java.util.Random;
import java.util.Scanner;

//정수를 저장하는 이진트리 만들기 실습

class TreeNode {
    int data;
    TreeNode LeftChild;
    TreeNode RightChild;

    public TreeNode(int data) {
        this.data = data;
        this.LeftChild = null;
        this.RightChild = null;
    }
}

class Tree {
    TreeNode root;

    Tree() {
        root = null;
    }

    TreeNode inorderSucc(TreeNode current) {
        TreeNode temp = current.RightChild;
        if (current.RightChild != null)
            while (temp.LeftChild != null)
                temp = temp.LeftChild;
        return temp;
    }

    boolean isLeafNode(TreeNode current) {
        if (current.LeftChild == null && current.RightChild == null)
            return true;
        else
            return false;
    }

    void inorder() {
        inorder(root);
    }

    void preorder() {
        preorder(root);
    }

    void postorder() {
        postorder(root);
    }

    void inorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            inorder(CurrentNode.LeftChild);
            System.out.print(" " + CurrentNode.data);
            inorder(CurrentNode.RightChild);
        }
    }

    void preorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            System.out.print(CurrentNode.data + " ");
            preorder(CurrentNode.LeftChild);
            preorder(CurrentNode.RightChild);
        }
    }

    void postorder(TreeNode CurrentNode) {
        if (CurrentNode != null) {
            postorder(CurrentNode.LeftChild);
            postorder(CurrentNode.RightChild);
            System.out.print(CurrentNode.data + " ");
        }
    }

    boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
        // 설계하여 구현

        TreeNode p = root; // 현재 노드를 루트로 초기화
        TreeNode q = null; // 부모 노드를 초기화
        TreeNode temp = new TreeNode(x); // 삽입할 새로운 노드 생성

        if (p == null) { // 루트가 null이면 트리가 비어있으므로,
            root = temp; // 새로운 노드를 루트로 설정하고 종료.
            return true;
        }
        while (p != null) {
            if (x < p.data) { // x가 현재 노드의 값보다 작다면
                q = p; // 왼쪽 자식으로 이동하고 q에 현재 노드의 값을 대입
                p = p.LeftChild;
            } else if (p.data < x) {// x가 현재 노드의 값보다 크다면
                q = p; // 오른쪽 자식으로 이동하고 q에 현재 노드의 값을 대입
                p = p.RightChild;
            } else { // 현재 노드의 값이 이미 트리에 존재하는 값인 경우,
                return false; // 중복된 값이므로 삽입을 중단하고 false를 반환.
            }
        }
        // q는 새로운 노드를 연결할 부모 노드
        if (x < q.data) { // x가 부모 노드의 값보다 작다면
            q.LeftChild = temp;// 왼쪽 자식으로 연결.
        } else { // x가 부모 노드의 값보다 크다면
            q.RightChild = temp; // 오른쪽 자식으로 연결.
        }
        return true; // 삽입 성공 및 종료
    }

    boolean delete(int num) {
        TreeNode p = root, q = null;
        while (p != null) {
            if (num < p.data) {
                q = p;
                p = p.LeftChild;
            } else if (num > p.data) {
                q = p;
                p = p.RightChild;
            } else {// num과 같은 노드를 찾았다 - 삭제할 노드이다

                // Case 1: 삭제할 노드가 자식이 없는 경우
                if (p.LeftChild == null && p.RightChild == null) {
                    if (p == root) {
                        root = null;
                    } else if (num < q.data) {
                        q.LeftChild = null;
                    } else {
                        q.RightChild = null;
                    }
                }
                // Case 2: 삭제할 노드가 자식이 하나인 경우
                else if (p.RightChild == null) {
                    if (p == root) {
                        root = p.LeftChild; // 루트 노드를 삭제하고 왼쪽 자식으로 대체
                    } else if (num < q.data) {
                        q.LeftChild = p.LeftChild; // 부모의 왼쪽 자식을 삭제한 노드의 왼쪽 자식으로 대체
                    } else {
                        q.RightChild = p.LeftChild; // 부모의 오른쪽 자식을 삭제한 노드의 왼쪽 자식으로 대체
                    }
                } else if (p.LeftChild == null) {
                    if (p == root) {
                        root = p.RightChild; // 루트 노드를 삭제하고 오른쪽 자식으로 대체
                    } else if (num < q.data) {
                        q.LeftChild = p.RightChild; // 부모의 왼쪽 자식을 삭제한 노드의 오른쪽 자식으로 대체
                    } else {
                        q.RightChild = p.RightChild; // 부모의 오른쪽 자식을 삭제한 노드의 오른쪽 자식으로 대체
                    }
                }
                // Case 3: 삭제할 노드가 자식이 둘인 경우
                else {
                    TreeNode succeeding = succeeding(p); // 후계자 노드 찾기
                    if (p == root) {
                        root = succeeding; // 루트 노드를 삭제하고 후계자로 대체
                    } else if (num < q.data) {
                        q.LeftChild = succeeding;  // 부모의 왼쪽 자식을 삭제한 노드의 후계자로 대체
                    } else {
                        q.RightChild = succeeding; // 부모의 오른쪽 자식을 삭제한 노드의 후계자로 대체
                    }
                    succeeding.LeftChild = p.LeftChild; // 후계자의 왼쪽 자식 설정
                }
                return true; // 삭제 성공
            }
        }
        return false; // 삭제 실패
    }

    // 주어진 노드의 후계자 노드를 찾아 반환
    private TreeNode succeeding(TreeNode p) {
        TreeNode q = p;
        TreeNode temp = p.RightChild;
        while (temp.LeftChild != null) {
            q = temp;
            temp = temp.LeftChild;
        }
        if (q != p) {
            q.LeftChild = temp.RightChild;
            temp.RightChild = p.RightChild;
        }
        return temp;
    }

    boolean search(int num) {
        TreeNode p = root;
        while (p != null) {
            if (num == p.data) {
                return true; // 찾음
            } else if (num < p.data) {
                p = p.LeftChild; // 왼쪽 자식으로 이동
            } else { // (num > p.data)
                p = p.RightChild; // 오른쪽 자식으로 이동
            }
        }
        return false;
    }
}

public class Chap9_Test_BinaryTreeInt {
    enum Menu {
        Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

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
        Scanner stdIn = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values())
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdIn = new Scanner(System.in);
        Tree t = new Tree();
        Menu menu; // 메뉴
        int count = 0;
        int num;
        boolean result;
        do {
            switch (menu = SelectMenu()) {
                case Add: // 노드 삽입
                    System.out.println("The number of items = ");
                    count = stdIn.nextInt();
                    int[] input = new int[10];
                    for (int ix = 0; ix < count; ix++) {
                        input[ix] = rand.nextInt(20);
                    }
                    for (int i = 0; i < count; i++) {
                        if (!t.insert(input[i]))
                            System.out.println("Insert Duplicated data");
                    }
                    break;

                case Delete: // 노드 삭제
                    System.out.println("삭제할 데이터:: ");
                    num = stdIn.nextInt();
                    if (t.delete(num))
                        System.out.println("삭제 데이터 = " + num + " 성공");
                    else
                        System.out.println("삭제 실패");
                    ;
                    break;

                case Search: // 노드 검색
                    System.out.println("검색할 데이터:: ");

                    num = stdIn.nextInt();
                    result = t.search(num);
                    if (result)
                        System.out.println(" 데이터 = " + num + " 존재합니다.");
                    else
                        System.out.println("해당 데이터가 없습니다.");
                    break;

                case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
                    t.inorder();
                    System.out.println();
                    break;
            }
        } while (menu != Menu.Exit);
    }
}
