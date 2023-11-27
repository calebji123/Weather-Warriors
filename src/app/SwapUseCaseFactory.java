package app;

import interface_adaptor.game.GameViewModel;
import interface_adaptor.swap.SwapController;
import interface_adaptor.swap.SwapPresenter;
import interface_adaptor.swap.SwapViewModel;
import use_case.swap.SwapDataAccessInterface;
import use_case.swap.SwapInputBoundary;
import use_case.swap.SwapInteractor;
import use_case.swap.SwapOutputBoundary;

public class SwapUseCaseFactory {

    public static SwapController createSwapUseCase(SwapViewModel swapViewModel, SwapDataAccessInterface swapDataAccessObject, GameViewModel gameViewModel){
        SwapOutputBoundary swapOutputBoundary = new SwapPresenter(gameViewModel, swapViewModel);
        SwapInputBoundary swapInteractor = new SwapInteractor(swapDataAccessObject, swapOutputBoundary);
        return new SwapController(swapInteractor);
    }
}
