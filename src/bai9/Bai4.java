package bai9;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bai4 {
    public static void main(String[] args) {
        LocalDate month = LocalDate.now();
        int lengthMonth = month.lengthOfMonth();
        System.out.println(lengthMonth);
    }
}
