package interface_adaptor.exit;

import interface_adaptor.ViewManagerModel;
import use_case.exit.ExitOutputBoundary;
import use_case.exit.ExitOutputData;

public class ExitPresenter implements ExitOutputBoundary{
    private final ExitViewModel exitViewModel;
    private final ViewManagerModel viewManagerModel;

    public ExitPresenter(ExitViewModel exitViewModel, ViewManagerModel viewManagerModel) {
        this.exitViewModel = exitViewModel;
        this.viewManagerModel = viewManagerModel;
    }
    @Override
    public void prepareSuccessView(ExitOutputData exitOutputData) {
        ExitState exitState = exitViewModel.getState();

        viewManagerModel.setCurrentView(exitViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
