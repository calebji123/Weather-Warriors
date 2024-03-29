package interface_adaptor.end_turn;

import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import use_case.end_turn.EndTurnOutputBoundary;
import use_case.end_turn.EndTurnOutputData;

public class EndTurnPresenter implements EndTurnOutputBoundary {
    private final GameViewModel gameViewModel;

    public EndTurnPresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }

    public void prepareSuccessView(EndTurnOutputData outputData) {
        GameState gameState = gameViewModel.getState();
        gameState.setLog(gameState.getLog() + "\r\n" + outputData.getMessage());
        gameState.setActiveCardName(outputData.getActiveCardName());
        gameState.setActiveCardHealth(outputData.getActiveCardHealth());
        gameState.setNextCardName(outputData.getNextCardName());
        gameState.setOpponentCardHealth(outputData.getBossHealth());
        gameState.setGameOver(outputData.getGameEnded());
        gameState.setDeckSize(outputData.getDeckSize());
        gameViewModel.setState(gameState);
        gameViewModel.firePropertyChanged();
    }
}
