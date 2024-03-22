package bai8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Bai8 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        boolean check=list.stream().anyMatch((num)->num%2==0);
        Optional<Integer> optional= list.stream().filter((num) -> num%2==0).findFirst();
        System.out.println("So chan dau tien la: "+ optional.orElseThrow(()->new RuntimeException("Khong co so chan nao")));
    }
}
