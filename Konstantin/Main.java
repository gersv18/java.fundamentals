package com.company;

import java.util.Scanner;

import static java.lang.Double.NaN;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String flag = "u";

        double result = NaN;
        double num2;

        for(;flag.equals("u");)
        {

            System.out.print("Enter number 1 = ");
            double num1 = in.nextDouble();

            if (result != result )
            {
                System.out.print("Enter number 2 = ");
                num2 = in.nextDouble();
            }
            else num2 = result ;

            System.out.print("Сhoose action ( + - * / %) = ");
            String action = in.next();

            switch (action) {
                case "+":
                    result = num1 + num2;
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case "-":
                    result = num1 - num2;
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = num1 * num2;
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case "/":
                    result = num1 / num2;
                    System.out.println(num1 + " / " + num2 + " = " + result);
                    break;
                case "%":
                    result = num1 % num2;
                    System.out.println(num1 + " % " + num2 + " = " + result);
                    break;
                default:
                    System.out.print("Invalid Action");
            }

            System.out.print(" continue enter u, exit enter x = ");
            flag = in.next();


        }

    }
}
