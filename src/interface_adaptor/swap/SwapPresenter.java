package interface_adaptor.swap;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.game.GameState;
import interface_adaptor.game.GameViewModel;
import use_case.swap.SwapOutputBoundary;
import use_case.swap.SwapOutputData;

public class SwapPresenter implements SwapOutputBoundary {
    private final SwapViewModel swapViewModel;
    private final GameViewModel gameViewModel;

    public SwapPresenter(GameViewModel gameViewModel, SwapViewModel swapViewModel) {
        this.gameViewModel = gameViewModel;
        this.swapViewModel = swapViewModel;
    }

    @Override
    public void prepareSuccessView(SwapOutputData data) {
        SwapState swapState = swapViewModel.getState();
        GameState gameState = gameViewModel.getState();
        gameState.setActiveCardName(data.getActiveCardName());
        gameState.setActiveCardHealth(data.getActiveCardHealth());
        gameState.setNextCardName(data.getNextCardName());
        gameState.setLog(gameState.getLog() + data.getMessage());

        gameViewModel.setState(gameState);
        gameViewModel.firePropertyChanged();

        swapState.setHasError(false);
        swapViewModel.setState(swapState);
        swapViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SwapState swapState = swapViewModel.getState();
        swapState.setSwapError(error);
        swapState.setHasError(true);
        swapViewModel.firePropertyChanged();
    }
}
