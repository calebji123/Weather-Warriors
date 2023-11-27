package interface_adaptor.swap;

import use_case.swap.SwapInputBoundary;
import use_case.swap.SwapInputData;

public class SwapController {
    final SwapInputBoundary swapUseCaseInteractor;

    public SwapController(SwapInputBoundary swapUseCaseInteractor) {
        this.swapUseCaseInteractor = swapUseCaseInteractor;
    }
    public void execute() {
        SwapInputData swapInputData = new SwapInputData();

        swapUseCaseInteractor.execute(swapInputData);
    }
}
