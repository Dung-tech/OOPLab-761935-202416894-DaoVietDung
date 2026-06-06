package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe";

        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
            System.out.println("Đã đọc file: " + inputBytes.length + " bytes");

            long startTime = System.currentTimeMillis();

            String outputString = "";
            for (int i = 0; i < inputBytes.length; i++) {
                outputString += (char) inputBytes[i];


                if (i % 500000 == 0) {
                    System.out.println("Đã xử lý: " + i + " / " + inputBytes.length + " bytes");
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Thời gian dùng String += : " + (endTime - startTime) + " ms");

        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + filename);
            e.printStackTrace();
        }
    }
}