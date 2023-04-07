package com.example.gameComponent;

public class GameBoard {

    public BoardCell[][] cells;

    public GameBoard(int size){
        this.cells = new BoardCell[size][size];

        for(int i=0; i< cells.length; i++){
            for(int j=0; j< cells.length; j++){
                this.cells[i][j] = new BoardCell();
            }
        }
    }

}
