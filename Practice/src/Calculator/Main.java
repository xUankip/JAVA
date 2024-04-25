package Calculator;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            System.out.println("Menu");
            System.out.println("1. Calculate Triangle perimeter");
            System.out.println("2. Calculate Sum of 2 number");
            System.out.println("3. Calculate square shape");
            System.out.println("Type the number you choose");
            int choice;
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Chu Vi Tam Giac");
                    System.out.println(Calculator.tinhChuViTamGiac());
                    break;
                case 2:
                    System.out.println("Tong 2 so la" + Calculator.sum());
                    break;
                case 3:
                    System.out.println("Square Shape is :" + Calculator.squareShape());
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
}
