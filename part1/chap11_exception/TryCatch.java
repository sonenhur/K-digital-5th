package part1.chap11_exception;

public class TryCatch {
    public static void main(String[] args) {
        try {
            int arr[] = new int[3];
            arr[3] = 30;
            System.out.println("OK");
        } catch (Exception e) {
//			에러 메세지 보고싶을때 사용
//			e.printStackTrace(); 
            System.out.println("오류 발생 : " + e.getMessage());
        }
        System.out.println("GOOD");
    }
}