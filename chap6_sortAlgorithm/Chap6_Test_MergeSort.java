package chap6_sortAlgorithm;

// PhyscData 클래스를 Comparable로 수정해야 한다.
// stack을 이용한 객체들의 non-recursive MergeSort 구현

public class Chap6_Test_MergeSort {
    // 작업용 배열 buff 선언
    private static PhyscData[] buff;

    // --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void merge(PhyscData[] a, int lefta, int righta, int leftb, int rightb) {
        int i = lefta, j = leftb, k = 0;

        while (i <= righta && j <= rightb) {
            buff[k++] = (a[i].compareTo(a[j]) <= 0) ? a[i++] : a[j++];
        }
        while (i <= righta) {
            buff[k++] = a[i++];
        }

        while (j <= rightb) {
            buff[k++] = a[j++];
        }

        for (i = lefta, k = 0; i <= rightb; i++, k++) {
            a[i] = buff[k];
        }
    }

    // --- MergeSort(비재귀 버전)---//
    static void MergeSort(PhyscData[] a, int n) {
        int size;
        int lefta, righta, leftb, rightb;

        for (size = 1; size < n; size *= 2) {
            lefta = 0;
            while (lefta + size < n) {
                righta = lefta + size - 1;
                leftb = lefta + size;
                rightb = Math.min(leftb + size - 1, n - 1);
                merge(a, lefta, righta, leftb, rightb);
                lefta = rightb + 1;
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 171, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 171, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };
        int nx = x.length;
        buff = new PhyscData[nx]; // 작업용 배열 buff 크기 조정

        MergeSort(x, nx); // 배열 x를 MergeSort로 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println("■ 신체검사 리스트 ■");
        System.out.println(" 이름     키  시력");
        System.out.println("------------------");
        for (PhyscData physcData : x)
            System.out.printf("%-8s%3d%5.1f\n", physcData.name, physcData.height, physcData.vision);
    }

    static class PhyscData implements Comparable<PhyscData> {
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public int compareTo(PhyscData o) {
            return this.height - o.height;
        }
    }
}