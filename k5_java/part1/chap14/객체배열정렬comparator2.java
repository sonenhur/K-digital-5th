//package part1.chap14;
//
////public interface Comparator<T> {
////	int compare(T 01, T 02);
////}
////
////public interface Comparable<T> {
////	public int compareTo(T o);
////}
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//class Student2 {
//	String sno; //학생 번호
//	String sname; //학생 이름
//
//	public Student2(String sno, String sname) {
//		this.sno = sno;
//		this.sname = sname;
//	} //생성자를 통해 두 값을 초기화
//	public String toString() {
//		return "[" + sno + ", " + sname + "]";
//	} //toString() 메소드를 통해 문자열로 반환
//}
//
//public class 객체배열정렬comparator2 {
//				//sortStudent 메소드		인자						인자
//	static void sortStudent2(Student2[] data, Comparator<Student2> comp) {
//		Arrays.sort(data, comp);
//	}
//	public static void main(String[] args) {
//
//		Comparator<Student2> compNo = (s1, s2) -> Integer.parseInt(s1.sno) - Integer.parseInt(s2.sno);
//
//		Comparator<Student2> compName = (s1, s2) -> s1.sname.compareTo(s2.sname);
//
//		Student2[] data = {
//				new Student2("9", "홍라동"),
//				new Student2("12", "홍다동"),
//				new Student2("121", "홍가동"),
//				new Student2("213", "홍나동")
//				};
//
//		sortStudent2(data, compNo);
//		for (Student2 stno : data)
//			System.out.print(" " + stno);
//
//		System.out.println();
//
//		sortStudent2(data, compName);
//		for (Student2 stname : data)
//			System.out.print(" " + stname);
//	}
//}
