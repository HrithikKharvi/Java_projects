package com.example;

import com.example.gameComponent.*;

import java.util.*;

public class SnakeLadderGame {

    public Player winner;
    public Deque<Player> players = new LinkedList<>();
    public GameBoard board;
    int boardSize;
    public Die die;
    public Scanner scanner;
    private int snakeCount = 4;
    private int ladderCount = 4;
    private boolean isGameLoaded = false;

    private final Map<Integer, Boolean> snakeLadPos = new HashMap<>();

    public SnakeLadderGame(){
        try{

            this.scanner = new Scanner(System.in);
            initializeGame();
            System.out.println("Loading game....");
            Thread.sleep(1000);
            System.out.println("Game is setup! start playing");
            isGameLoaded = true;
        }catch(Exception e){
            System.out.println("Game over because you entered invalid digit");
        }

    }

    private void initializeGame() throws Exception{
        this.board = new GameBoard(10);
        this.boardSize = board.cells.length * board.cells.length;
        initializeSnakeLadder();
        System.out.println("Enter number of die ");
        int dieCount = scanner.nextInt();
        this.die = new Die(dieCount);
        addPlayers();
    }

    private void initializeSnakeLadder(){
        int bound = this.board.cells.length;
        while(this.snakeCount > 0){
            int start = getRandomNumber(bound);
            int end = getRandomNumber(bound);
            if(start < end || snakeLadPos.containsKey(start))continue;

            Mover mover = new Mover(start, end);
            snakeLadPos.put(start, true);
            int cellCol = (start % bound);
            int cellRow = (start / bound);
            BoardCell cell = this.board.cells[cellRow][cellCol];
            cell.mover = mover;
            this.snakeCount--;
        }

        while(this.ladderCount > 0){
            int start = getRandomNumber(bound);
            int end = getRandomNumber(bound);
            if(start > end || snakeLadPos.containsKey(start))continue;

            Mover mover = new Mover(start, end);
            snakeLadPos.put(start, true);
            int cellCol = (start % bound);
            int cellRow = (start / bound);
            BoardCell cell = this.board.cells[cellRow][cellCol];
            cell.mover = mover;
            this.ladderCount--;
        }
    }

    private int getRandomNumber(int bound){
        return (int) Math.floor(Math.random() * ((bound*bound) - 1)) + 1;
    }

    private void addPlayers(){
        System.out.println("Enter the number of players");
        int playerCount = scanner.nextInt();

        while(playerCount > 0){
            this.players.addFirst(new Player("Player"+playerCount, String.valueOf(playerCount)));
            playerCount--;
        }
    }

    public void start(){
        if(!isGameLoaded) {
            System.out.println("Failed to load the Game");
            return;
        }
        Player currentPlayer;
        int option = 1;
        while(winner == null){
            currentPlayer = getCurrentPlayer();
            System.out.println("It's " + currentPlayer.name + "'s turn");
            System.out.println("Now you are at " + currentPlayer.position);
            System.out.println("To roll press 1 \t To quit the game press 2");
            try{
                option = this.scanner.nextInt();

            }catch(Exception e){
                winner = getCurrentPlayer();
                continue;
            }
            if (option == 1) {
                makeMove(currentPlayer);
            }else{
                winner = getCurrentPlayer();
                break;
            }
        }

        System.out.println("The winner is " + winner.name);
    }

    private void makeMove(Player currentPlayer){
        int moveCount = die.rollDie();
        currentPlayer.position += moveCount;
        if(currentPlayer.position >= this.boardSize){
            winner = currentPlayer;
            return;
        }
        int bound = this.board.cells.length;
        int cellRow = (currentPlayer.position / bound);
        int cellCol = (currentPlayer.position % bound);

        Mover jump = this.board.cells[cellRow][cellCol].mover;
        if(jump != null && jump.start == currentPlayer.position){
               currentPlayer.position = jump.end;
               if(jump.start > jump.end){
                   System.out.println("Snake bite :(");
               }else{
                   System.out.println("Found ladder :)");
               }
        }
    }

    private Player getCurrentPlayer(){
        Player currentPlayer = this.players.removeFirst();
        this.players.addLast(currentPlayer);
        return currentPlayer;
    }

}
