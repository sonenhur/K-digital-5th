package chap2_dataStructure;

class PhyscData2 implements Comparable<PhyscData2> {
	String name;
	int height;
	double vision;

	PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public int compareTo(PhyscData2 o) {
		//키 순으로 정렬
		return this.height - o.height;
	}
}

public class 객체배열정렬 {
	
	// 버블 정렬을 이용하여 데이터를 정렬하는 메소드
	static void sortData(PhyscData2[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			for (int j = i + 1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
		}
	}
	
	// 두 요소의 위치를 바꾸는 메소드
	static void swap(PhyscData2[] data, int ind1, int ind2) {
		PhyscData2 temp = data[ind1];
		data[ind1] = data[ind2];
		data[ind2] = temp;
	}
	
	// 배열의 데이터를 출력하는 메소드
	private static void showData(PhyscData2[] data) {
		for (PhyscData2 d : data) {
			System.out.print(d.name + ":" + d.height + "," + d.vision + " / ");
		}System.out.println();
	}
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("홍동", 164, 1.3),
				new PhyscData2("홍길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("이길동", 182, 0.6),
				new PhyscData2("박길동", 167, 0.2),
				new PhyscData2("최길동", 169, 0.5),};
		
		showData(data); // 데이터 출력
		sortData(data); // 데이터 정렬
		showData(data); // 정렬된 데이터 출력
	}

}
