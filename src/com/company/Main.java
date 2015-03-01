package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        int startingCredits = 0;
        int endingCredits = 0;
        int betAmount = 0;
        while (startingCredits == 0)
        {
            System.out.print("Enter how many credits you want to start with: ");
            startingCredits = startingCreditsValidation();
        }
        System.out.println();
        while (endingCredits == 0)
        {
            System.out.print("Enter how many credits you want to end with: ");
            endingCredits = endingCreditsValidation();
        }
        System.out.println();
        while (betAmount == 0)
        {
            System.out.print("Enter how many credits you want to bet per game: ");
            betAmount = betAmountValidation();
        }

        Quasar quasar = new Quasar(startingCredits, endingCredits, betAmount);
        quasar.Play();
    }

    private static int startingCreditsValidation()
    {
        try
        {
            int startingCredits = input.nextInt();
            return startingCredits;
        }
        catch (InputMismatchException e)
        {
            System.err.println("Your input is invalid!");
            input.next();
            System.out.println();
            return 0;
        }
    }

    private static int endingCreditsValidation()
    {
        try
        {
            int endingCredits = input.nextInt();
            return endingCredits;
        }
        catch (InputMismatchException e)
        {
            System.err.println("Your input is invalid!");
            input.next();
            System.out.println();
            return 0;
        }
    }

    private static int betAmountValidation()
    {
        try
        {
            int betAmount = input.nextInt();
            return betAmount;
        }
        catch (InputMismatchException e)
        {
            System.err.println("Your input is invalid!");
            input.next();
            System.out.println();
            return 0;
        }
    }
}
