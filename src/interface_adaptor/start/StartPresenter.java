package interface_adaptor.start;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import use_case.start.StartOutputBoundary;
import use_case.start.StartOutputData;

public class StartPresenter implements StartOutputBoundary {
    private final GameViewModel gameViewModel;
    private final ViewManagerModel viewManagerModel;
    public StartPresenter(GameViewModel gameViewModel, ViewManagerModel viewManagerModel){
        this.gameViewModel = gameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(StartOutputData outputData){
        GameState gameState = gameViewModel.getState();
        gameState.setActiveCardName(outputData.getActiveCardName());
        gameState.setActiveCardHealth(outputData.getActiveCardHealth());
        gameState.setOpponentCardHealth(outputData.getOpponentCardHealth());
        gameState.setNextCardName(outputData.getNextCardName());
        gameState.setLocation(outputData.getLocation());
        gameState.setTemperature(outputData.getTemperature());
        gameState.setHumidity(outputData.getHumidity());
        gameState.setNextLocation(outputData.getNextLocation());
        gameState.setGameOver(false);
        gameState.setDeckSize(5);
        gameState.setLog("");
        gameViewModel.setState(gameState);
        gameViewModel.firePropertyChanged();
        viewManagerModel.setCurrentView(gameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
