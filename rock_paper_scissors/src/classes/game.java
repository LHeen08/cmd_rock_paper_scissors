package classes;

import java.util.Random;
import java.util.Scanner;

public class game {

    //  Start game message
    public static void startGame() throws InterruptedException {
        //  Ask user for input
        System.out.println("Welcome to Rock, Paper, Scissors!\n" +
                "-----------------------------------\n\n\n" +
                "If you have never played before press 'h' for help \n" +
                "or press 's' to start\n" +
                "-----------------------------------"
        );


        // Get the input from the user
        Scanner input = new Scanner(System.in);

        char response = input.next().charAt(0);


        if (response == 'h') {

            //  Display the directions
            System.out.println(directions());

            //  Begin playing the game
            playGame();


        } else if (response == 's') {

            //  Begin playing the game
            playGame();

        }

    }


    //  Directions
    private static String directions() {

        return "-----------------------------------\n" +
                "The rules of rock, paper, scissors are simple:\n" +
                "rock BEATS scissors\n" +
                "scissors BEATS paper\n" +
                "paper BEATS rock\n" +
                "-----------------------------------";

    }


    //  Play the game
    private static void playGame() throws InterruptedException {

        //  Need to make it a game where the user selects what they want to play and then a countdown occurs for the
        //      computer to play

        //Set the bool to true to play the game
        boolean keepGoing = true;

        while (keepGoing == true) {

            //  Output
            System.out.println("-----------------------------------" +
                    "");

            System.out.println("Choose what you would like to play...\n" +
                    "Rock: press 'r'\n" +
                    "Paper: press 'p'\n" +
                    "Scissors: press 's'\n" +
                    "-----------------------------------");


            // Get the input from the user
            Scanner input = new Scanner(System.in);
            char response = input.next().charAt(0);

            if (response == 'r') {

                //  Countdown and play
                countdown();

                //  Get computer answer
                computerTurn(response);

            } else if (response == 'p') {

                //  Countdown and play
                countdown();

                //  Get computer answer
                computerTurn(response);


            } else if (response == 's') {

                //  Countdown and play
                countdown();

                //  Get computer answer
                computerTurn(response);

            } else {
                System.out.println("Incorrect item selected...");
            }


            System.out.println("Play again?(y/n)\n");

            char answer = input.next().charAt(0);

            if(!playAgain(answer)){
               keepGoing = false;
            }

        }

    }

    private static boolean playAgain(char answer) {

        //  Ask user if they want to play again and get the answer

        if (answer == 'y') {
            return true;

        } else {
            System.out.println("Thanks for playing!");
            return false;
        }


    }


    private static void countdown() throws InterruptedException {

        for (int i = 3; i > 0; i--) {
            System.out.println(i + "\n");
            Thread.sleep(750);

        }

    }

    private static void computerTurn(char userAnswer) {

        //  Array that holds the computers options
        String[] computerHand = {"rock", "paper", "scissors"};

        Random randItem = new Random();

        int randomIndex = randItem.nextInt(computerHand.length);

        String compChoice = computerHand[randomIndex];

        System.out.println("Your choice: " + findOutUserAnswer(userAnswer) +
                "\n" +
                "Opponent choice: " + compChoice +
                "\n\n");


        switch (userAnswer) {
            case 'r':
                if (compChoice == "rock") {
                    System.out.println("Draw!");

                } else if (compChoice == "paper") {
                    System.out.println("You lose!");
                } else if (compChoice == "scissors") {
                    System.out.println("You win!");
                }
                break;

            case 'p':
                if (compChoice == "rock") {
                    System.out.println("You win!");

                } else if (compChoice == "paper") {
                    System.out.println("Draw!");
                } else if (compChoice == "scissors") {
                    System.out.println("You lose!");
                }
                break;

            case 's':
                if (compChoice == "rock") {
                    System.out.println("You lose!");

                } else if (compChoice == "paper") {
                    System.out.println("You win!");
                } else if (compChoice == "scissors") {
                    System.out.println("You win!");
                }
                break;
        }


    }

    private static String findOutUserAnswer(char userAnswer) {

        String convString = null;

        if (userAnswer == 'r') {
            convString = "rock";
        } else if (userAnswer == 'p') {
            convString = "paper";
        } else if (userAnswer == 's') {
            convString = "scissors";
        }


        return convString;
    }


}
