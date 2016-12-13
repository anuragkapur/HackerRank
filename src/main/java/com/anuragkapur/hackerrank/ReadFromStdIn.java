package com.anuragkapur.hackerrank;

import java.util.Scanner;

/**
 * @author anuragkapur
 */
public class ReadFromStdIn {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Echo :: " + line);
        }
    }
}
