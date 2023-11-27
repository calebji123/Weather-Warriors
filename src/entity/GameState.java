package entity;

public class GameState {
    private Board game;

    public GameState(){

    }

    public Board getBoard(){
        return this.game;
    }
    public void setGame(Board board){
        this.game = board;
    }
}
