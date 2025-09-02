package part1.chap11_exception;

public class ExceptTest {

    public static void main(String[] args) {
        ExceptTest babo = new ExceptTest();
        babo.a();

//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("Fine!");
    }

    public void c() throws Exception {
        System.out.println("C1");
        int v = 10 / 0;
        System.out.println("C2");
    }

    public void b() throws Exception {
        System.out.println("B1");
        c();
        System.out.println("B2");
    }

    public void a() {
        System.out.println("A1");
        try {
            b();
        } catch (Exception e) {
            System.out.println("오류 발생 : " + e.getMessage());
        }
        System.out.println("A2");
    }
}
