package interface_adaptor.exit;

import use_case.exit.ExitInputBoundary;

public class ExitController {
    final ExitInputBoundary exitInteractor;

    public ExitController(ExitInputBoundary exitInteractor) {
        this.exitInteractor = exitInteractor;
    }

    public void execute() {
        exitInteractor.execute();
    }
}
