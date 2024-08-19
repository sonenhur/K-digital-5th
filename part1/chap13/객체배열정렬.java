package part1.chap13;

class Student implements Comparable<Student> {
    String sno;  // 학생 번호
    String sname;  // 학생 이름

    // Student 클래스의 생성자
    // 학생 번호와 이름을 매개변수로 받음
    public Student(String sno, String sname) {
        this.sno = sno;
        this.sname = sname;
    }

    @Override
    public String toString() {// Student 객체를 문자열로 변환하는 메소드
        return "(" + sno + "," + sname + ")";
    }

    @Override
    public int compareTo(Student s) {// 두 Student 객체를 비교하는 메소드
        return Integer.parseInt(this.sno) - Integer.parseInt(s.sno);
        // 문자열 숫자를 정수로 변환
    }
}

public class 객체배열정렬 {
    static void sortStudent(Student[] data) {
        Student temp; //임시변수(지역변수)
        for (int i = 0; i < data.length; i++)
            for (int j = i + 1; j < data.length; j++) {
                // 두 Student 객체를 비교해서 순서 변경
                if (data[i].compareTo(data[j]) > 0) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
    }

    public static void main(String[] args) {
        // Student 객체 배열 생성, 초기화
        Student[] data = {
                new Student("12", "홍길동"),
                new Student("121", "홍길순"),
                new Student("213", "홍길춘"),
                new Student("9", "홍길홍")
        };
        sortStudent(data);
//		Arrays.sort(data);// 이게 문제가 있어서 sortStudent()를 구현

        //출력
        for (Student st : data)
            // B에서 차례대로 객체를 꺼내서 A에 넣겠다는 뜻
            // B에 더이상 꺼낼 객체가 없을 때까지
            System.out.print(" " + st);
    }
}