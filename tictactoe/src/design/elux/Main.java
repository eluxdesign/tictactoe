package design.elux;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        String player = "X";

        System.out.println("TicTacToe game. Type in the coordinates for your row and column to make a move. You can exit the game if you enter -1. Have fun!");
        do {
            int row;
            int col;
            while(true) {
                System.out.println(game.printBoard());

                if (player.equals("X")) {
                    row = ScannerValidation.getNumber("It's Player X turn. Enter the coordinate for Row.");
                } else {
                    row = ScannerValidation.getNumber("It's Player 0 turn. Enter the coordinate for Row.");
                }

                col = ScannerValidation.getNumber("Enter the coordinate for Column");

                if(game.setPlay(row-1, col-1, player)) {
                    break;
                } else {
                    System.out.println("Field is already taken. Try again.");
                }
            }

            if (game.isGameOver()) {
                System.out.println(game.printBoard() + "\n" + player + " wins!");
                break;
            } else if (game.isGameOverWithoutWinner()) {
                System.out.println("It's a tie!");
                break;
            }

            if (player.equals("X")) {
                player = "O";
            } else {
                player = "X";
            }
        }
        while (true);
    }
}