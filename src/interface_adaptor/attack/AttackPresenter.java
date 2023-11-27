package interface_adaptor.attack;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import use_case.attack.AttackOutputBoundary;
import use_case.attack.AttackOutputData;

public class AttackPresenter implements AttackOutputBoundary {
    private final GameViewModel gameViewModel;
    public AttackPresenter(GameViewModel gameViewModel){
        this.gameViewModel = gameViewModel;
    }
    @Override
    public void prepareSuccessView(AttackOutputData attackOutputData) {
        GameState gameState = gameViewModel.getState();
        gameState.setLog(gameState.getLog() +"\r\n"+ attackOutputData.getMessage());
        gameState.setOpponentCardHealth(attackOutputData.getBossHealth());
        gameState.setGameOver(attackOutputData.gameOver());
        gameViewModel.setState(gameState);
        gameViewModel.firePropertyChanged();
    }
}
