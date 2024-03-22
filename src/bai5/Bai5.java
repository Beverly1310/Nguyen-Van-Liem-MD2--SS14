package bai5;

import java.util.Arrays;

public class Bai5 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        // lọc ra các số lớn hơn 5
        int[] arr2 = Arrays.stream(arr).filter((num)->num>5).toArray();
        //in ra bằng forEach
        Arrays.stream(arr2).forEach(System.out::println);
    }
}
