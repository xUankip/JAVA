package com.test.aptech.shape;
import java.util.Scanner;
public class Retangle {
    private long length;
    private long width;
    Scanner scanner = new Scanner(System.in);
    public void perimeter() {
        System.out.println("Type the length: ");
        length = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Type the width");
        width = scanner.nextLong();
        scanner.nextLine();
        System.out.println("The Perimeter of the Shape : " + 2*(length+width));
    }
    public void acreage() {
        System.out.println("Type the length: ");
        length = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Type the width");
        width = scanner.nextLong();
        scanner.nextLine();
        System.out.println("The acreage of the shape: " + length*width);
    }

}
