package javaswing;

import java.util.Scanner;
import java.util.Random;
import java.util.Vector;
public class Binary_Search1 {
    int Binary_Search(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return Binary_Search(arr, l, mid - 1, x);
            return Binary_Search(arr, mid + 1, r, x);
        }
        return -1;
    }
    public static void quickSort(int[] arr, int left, int right) {
    if (arr == null || arr.length == 0)
      return;

    if (left >= right)
      return;

    int middle = left + (right - left) / 2;
    int chot = arr[middle];
    int i = left, j = right;

    while (i <= j) {
      while (arr[i] < chot) {
        i++;
      }

      while (arr[j] > chot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    if (left < j)
      quickSort(arr, left, j);

    if (right > i)
      quickSort(arr, i, right);
}
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);   
        System.out.print("Nhập số phần tử random trong mảng : " );
        int n = sc.nextInt();
	System.out.print("Mảng : ");
	int arr[] = new int[n];
        Binary_Search1 ob = new Binary_Search1();
	ob.randomkhonglap(arr,n);      
        quickSort(arr , 0  , n-1);
        System.out.println("Mảng sau khi được sắp xếp");
        printArray(arr);
        System.out.println("\nNhập phần tử cần tìm : ");
        int x = sc.nextInt();
        
        int result = ob.Binary_Search(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Phần tử không tồn tại.");
        else
            System.out.println("Phần tử được tìm thấy tại vị trí: " + result);
        int min = arr[0];
        int max = arr[0];
            for(int i = 0; i< arr.length ; i++){
                if(arr[i]<min){
                    min = arr[i];
                }
                if(arr[i]>max){
                    max = arr[i];
                }
            }
        System.out.println("Giá trị nhỏ nhất là : " + min);//arr[0]);
        System.out.println("Giá trị lớn nhất là : " + max);//arr[arr.length-1]);
    }	
	void randomkhonglap(int arr[],int n) {
		Vector v = new Vector();
		Random rd = new Random();

        int iNew = 0;
        for (int i = 0; i < n; i++ ) {
            iNew = rd.nextInt(100);
            if (!v.contains(iNew)){
                v.add(iNew);
               arr[i] = iNew;
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
	}
    public static void printArray(int[] arr) {
    for(int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }
}
