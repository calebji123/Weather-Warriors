package app;

import interface_adaptor.ViewManagerModel;
import interface_adaptor.exit.ExitController;
import interface_adaptor.exit.ExitPresenter;
import interface_adaptor.exit.ExitViewModel;
import use_case.exit.ExitInputBoundary;
import use_case.exit.ExitInteractor;
import use_case.exit.ExitOutputBoundary;

public class ExitUseCaseFactory {

    public static ExitController createExitUseCase(ExitViewModel exitViewModel, ViewManagerModel viewManagerModel){
        ExitOutputBoundary exitOutputBoundary = new ExitPresenter(exitViewModel, viewManagerModel);
        ExitInputBoundary exitInteractor = new ExitInteractor( exitOutputBoundary);
        return new ExitController(exitInteractor);
    }
}
