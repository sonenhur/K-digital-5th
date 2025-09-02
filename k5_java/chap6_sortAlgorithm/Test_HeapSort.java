package chap6_sortAlgorithm;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
    public void Insert(int x);

    public int DeleteMax();
}

class Heap implements MaxHeap {
    final int heapSize = 100;
    private int[] heap;
    private int n; // current size of MaxHeap
    private int MaxSize; // Maximum allowable size of MaxHeap

    public Heap(int sz) {
        MaxSize = sz;
        n = 0;
        heap = new int[MaxSize + 1];
    }

    public void display() {
        System.out.print("MaxHeap:: (i, heap[i]): ");
        for (int i = 1; i <= n; i++) {
            System.out.print("(" + i + ", " + heap[i] + ") ");
        }
        System.out.println();
    }

    @Override
    public void Insert(int x) {
        if (n == MaxSize) {
            HeapFull();
            return;
        }
        int i = ++n;
        while ((i != 1) && (x > heap[i / 2])) {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        heap[i] = x;
    }

    @Override
    public int DeleteMax() {
        if (n == 0) {
            HeapEmpty();
            return -1; // or throw exception
        }
        int item = heap[1]; // get the root value
        int last = heap[n--]; // remove the last element and decrease the size
        int parent = 1;
        int child = 2;
        while (child <= n) {
            if (child < n && heap[child] < heap[child + 1])
                child++;
            if (last >= heap[child])
                break;
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = last;
        return item;
    }

    private void HeapEmpty() {
        System.out.println("Heap Empty");
    }

    private void HeapFull() {
        System.out.println("Heap Full");
    }
}

public class Test_HeapSort {
    static void showData(int[] d) {
        for (int i = 0; i < d.length; i++)
            System.out.print(d[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        int select = 0;
        Scanner stdIn = new Scanner(System.in);
        Heap heap = new Heap(20);
        final int count = 10;
        int[] x = new int[count + 1];
        int[] sorted = new int[count];

        do {
            System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
            select = stdIn.nextInt();
            switch (select) {
                case 1:
                    System.out.print("input value: ");
                    int data = stdIn.nextInt();
                    heap.Insert(data);
                    heap.display();
                    break;
                case 2:
                    heap.display();
                    break;
                case 3:
                    for (int i = count; i >= 1; i--) {
                        sorted[i - 1] = heap.DeleteMax();
                    }
                    System.out.println("Sorted Array:");
                    showData(sorted);
                    break;
                case 4:
                    return;
            }
        } while (select < 5);
    }
}
