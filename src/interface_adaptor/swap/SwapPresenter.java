package interface_adaptor.swap;

import interface_adaptor.ViewManagerModel;
import use_case.swap.SwapOutputBoundary;
import use_case.swap.SwapOutputData;

public class SwapPresenter implements SwapOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final SwapViewModel swapViewModel;

    public SwapPresenter(ViewManagerModel viewManagerModel, SwapViewModel swapViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.swapViewModel = swapViewModel;
    }

    @Override
    public void prepareSuccessView(SwapOutputData data) {
        SwapState swapState = swapViewModel.getState();
        swapState.setMessage(data.getMessage());
        swapState.setNextCardName(data.getNextCardName());
        swapState.setNextCardHealth(data.getNextCardHealth());

        swapViewModel.setState(swapState);
        swapViewModel.firePropertyChanged();

        viewManagerModel.setCurrentView(swapViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        SwapState swapState = swapViewModel.getState();
        swapState.setSwapError(error);
        swapViewModel.firePropertyChanged();
    }
}
