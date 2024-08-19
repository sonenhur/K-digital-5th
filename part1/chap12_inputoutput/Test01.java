package part1.chap12_inputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01 {
    //main은 스태틱 메서드.
    //객체 없이 호출가능. JVM이 제일 먼저 실행함.
    public static void main(String[] args) {
        try (FileInputStream fi = new FileInputStream("a.txt");
             //클래스		  	//참조변수   //클래스		   //생성자
             FileOutputStream fo = new FileOutputStream("b.txt");)
        // 스트림 => sequence of bytes
        // (프로그램과 외부 데이터가 단방향으로 연결됨)
        {
            int c = 0;
            while ((c = fi.read()) != -1) {
                fo.write(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println();
            //클래스.필드.데이터타입:PrintStream
        }
    }
}
