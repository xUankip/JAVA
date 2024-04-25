package Calculator;

import java.util.Scanner;

public class Calculator {
    public static float tinhChuViTamGiac(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a ");
        float a = scanner.nextFloat();
        System.out.println("Input b");
        float b = scanner.nextFloat();
        System.out.println("Input c");
        float c = scanner.nextFloat();
        return a + b + c;
    }

    public static float sum(){
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Type a");
        float a = scanner1.nextFloat();
        System.out.println("Type b");
        float b = scanner1.nextFloat();
        return a+b;
    }

    public static float squareShape()  {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Type Square Edge");
        float a = scanner2.nextFloat();
        return a*a;
    }
}
