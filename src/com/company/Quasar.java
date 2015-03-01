package com.company;

import java.util.Random;

/**
 * Created by Admin on 2/27/2015.
 */
public class Quasar
{
    private int startingCredits;
    private int endingCredits;
    private int betAmount;
    private double credits;

    public Quasar(int startingCredits, int endingCredits, int betAmount)
    {
        this.startingCredits = startingCredits;
        this.endingCredits = endingCredits;
        this.betAmount = betAmount;
    }

    public void Play()
    {
        int seconds = 0;
        int secondsPerGame = 6;
        int gameNumber = 0;
        int wins = 0;
        int losses = 0;
        credits = startingCredits;
        Random random = new Random();
        int number;

        while (credits > 0 && credits >= betAmount && credits < endingCredits)
        {
            gameNumber++;
            seconds += secondsPerGame;
            credits -= betAmount;
            number = random.nextInt(8) + 1;
            while (number < 17)
            {
                switch (number)
                {
                    case 1:
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                    case 15:
                        number += random.nextInt(3) + 4;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 16:
                        number += random.nextInt(7) + 1;
                        break;
                }
            }
            if (number > 20)
            {
                losses++;
                System.out.format("GAME NUMBER %d", gameNumber);
                System.out.println();
                System.out.println("RESULT: LOSS");
                System.out.format("NUMBER: %d", number);
                System.out.println();
                System.out.format("CREDITS REMAINING: %f", credits);
                System.out.println();
                System.out.println();
            }
            else
            {
                wins++;
                System.out.format("GAME NUMBER %d", gameNumber);
                System.out.println();
                System.out.println("RESULT: WIN");
                switch (number)
                {
                    case 17:
                        credits += betAmount;
                        System.out.format("CREDITS WON: %d", betAmount);
                        System.out.println();
                        break;
                    case 18:
                        credits += betAmount * 1.25;
                        System.out.format("CREDITS WON: %f", betAmount * 1.25);
                        System.out.println();
                        break;
                    case 19:
                        credits += betAmount * 1.5;
                        System.out.format("CREDITS WON: %f", betAmount * 1.5);
                        System.out.println();
                        break;
                    case 20:
                        credits += betAmount * 2;
                        System.out.format("CREDITS WON: %d", betAmount * 2);
                        System.out.println();
                        break;
                }
                System.out.format("NUMBER: %d", number);
                System.out.println();
                System.out.format("CREDITS REMAINING: %f", credits);
                System.out.println();
                System.out.println();
            }
        }
        System.out.format("FINAL CREDITS: %f", credits);
        System.out.println();
        double percentage = ((double)wins / (double)gameNumber) * 100;
        System.out.format("WINS TO LOSSES: %d / %d (WON %f PERCENT)", wins, losses, percentage);
        System.out.println();
        int days = 0;
        int hours = 0;
        int minutes = 0;
        while (seconds >= 60)
        {
            if (seconds - 86400 >= 0)
            {
                days++;
                seconds -= 86400;
            }
            else if (seconds - 3600 >= 0)
            {
                hours++;
                seconds -= 3600;
            }
            else
            {
                minutes++;
                seconds -= 60;
            }
        }
        System.out.format("TIME TAKEN: %d DAYS, %d HOURS, %d MINUTES, %d SECONDS", days, hours, minutes, seconds);
    }
}
