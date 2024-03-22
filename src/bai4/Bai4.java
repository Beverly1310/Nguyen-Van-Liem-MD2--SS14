package bai4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Bai4 {
    public static void main(String[] args) {
        String[] arr = new String[100];
        // thêm str vào mảng
        for (int i = 0; i < 100; i++) {
            String str = "SV"+i;
            arr[i]=str;
        }
        // sx theo thứ tự tự nhiên
        Arrays.stream(arr).sorted(Comparator.naturalOrder());
        Arrays.stream(arr).forEach(System.out::println);
    }
}
