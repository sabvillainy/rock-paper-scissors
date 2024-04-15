package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int userScore = 0;
    static int computerScore = 0;
    static int draw = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to Rock Paper Scissors!");
        showMenu();
    }

    private static void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------\nChoose one of them:\n1 - Play\n2 - Scoreboard\n3 - Quit");
        int userSelection = sc.nextInt();
        while(true){
            if(userSelection==1){
                play();
            }
            else if(userSelection==2){
                showScoreboard();
                showMenu();
            }
            else if(userSelection==3){
                System.out.println("Quitting...");
                System.exit(0);
            }
            else{
                System.out.println("You've entered a wrong input. Please try again.");
                showMenu();
            }
        }
    }

    private static void showScoreboard() {
        System.out.println("You:"+userScore);
        System.out.println("Computer:"+computerScore);
        System.out.println("Draw:"+draw);
    }

    private static void play() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int userMove;
        while (true) {
            String[] moves = {"Rock", "Paper", "Scissors"};
            System.out.println("-------------------\nMake your move!\n1 - Rock\n2 - Paper\n3 - Scissors\n4 - Return to the Menu");
            userMove = sc.nextInt();
            int computerMove = rnd.nextInt(1, 4);
            if(userMove == 1 || userMove == 2 || userMove == 3) {
                System.out.println("You chose " + moves[userMove - 1] +"!");
                System.out.println("Computer chose " + moves[computerMove - 1] + "!");
                result(userMove,computerMove);
            }
            else if(userMove==4){
                showMenu();
            }
            else{
                System.out.println("You've entered a wrong input. Please try again.");
                play();
            }
        }
    }

    private static void result(int userMove, int computerMove) {
        //1 taş 2 kağıt 3 makas
        if(userMove==computerMove){
            System.out.println("Draw! Play again!");
            draw++;
        }
        else if(userMove==1&&computerMove==2){
            System.out.println("You lost! Paper beats rock. Play again!");
            computerScore++;
        }
        else if(userMove==1&&computerMove==3){
            System.out.println("You won! Rock beats scissors. Play again!");
            userScore++;
        }
        else if(userMove==2&&computerMove==1){
            System.out.println("You won! Paper beats rock. Play again!");
            userScore++;
        }
        else if(userMove==2&&computerMove==3){
            System.out.println("You lost! Scissors beats paper. Play again!");
            computerScore++;
        }
        else if(userMove==3&&computerMove==1){
            System.out.println("You lost! Rock beats scissors. Play again!");
            computerScore++;
        }
        else if(computerMove==2&&userMove==3) {
            System.out.println("You lost! Scissors beats paper. Play again!");
            computerScore++;
        }
    }
}