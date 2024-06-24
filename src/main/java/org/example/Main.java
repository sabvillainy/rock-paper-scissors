package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main{
static int userScore = 0;
static int computerScore = 0;
static int draw = 0;

public static void main(String[] args) {
    SaveSystem save = new SaveSystem("save-file.txt");

    String[] scores = save.readFile().split("\n");
    if (scores.length == 3) {
        userScore = Integer.parseInt(scores[0].split(":")[1].trim());
        computerScore = Integer.parseInt(scores[1].split(":")[1].trim());
        draw = Integer.parseInt(scores[2].split(":")[1].trim());
    }

    System.out.println("Welcome to Rock Paper Scissors!");
    showMenu(save);
}

private static void showMenu(SaveSystem save) {
    Scanner sc = new Scanner(System.in);
    while (true) {
        System.out.println("-------------------\nChoose one of them:\n1 - Play\n2 - Scoreboard\n3 - Quit");
        int userSelection = sc.nextInt();
        if (userSelection == 1) {
            play(save);
        } else if (userSelection == 2) {
            showScoreboard();
        } else if (userSelection == 3) {
            System.out.println("Quitting...");
            save.clearFile();
            save.writeFile("You:" + userScore + "\nComputer:" + computerScore + "\nDraw:" + draw);
            System.exit(0);
        } else {
            System.out.println("You've entered a wrong input. Please try again.");
        }
    }
}

private static void showScoreboard() {
    System.out.println("You: " + userScore);
    System.out.println("Computer: " + computerScore);
    System.out.println("Draw: " + draw);
}

private static void play(SaveSystem save) {
    Scanner sc = new Scanner(System.in);
    Random rnd = new Random();
    while (true) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        System.out.println("-------------------\nMake your move!\n1 - Rock\n2 - Paper\n3 - Scissors\n4 - Return to the Menu");
        int userMove = sc.nextInt();
        int computerMove = rnd.nextInt(3) + 1;
        if (userMove >= 1 && userMove <= 3) {
            System.out.println("You chose " + moves[userMove - 1] + "!");
            System.out.println("Computer chose " + moves[computerMove - 1] + "!");
            result(userMove, computerMove);
        } else if (userMove == 4) {
            break;
        } else {
            System.out.println("You've entered a wrong input. Please try again.");
        }
    }
}
    private static void result(int userMove, int computerMove) {
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