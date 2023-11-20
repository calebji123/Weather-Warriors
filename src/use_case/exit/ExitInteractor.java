package use_case.exit;

public class ExitInteractor implements ExitInputBoundary {
    final ExitOutputBoundary exitPresenter;

    public ExitInteractor(ExitOutputBoundary exitPresenter) {
        this.exitPresenter = exitPresenter;
    }

    @Override
    public void execute() {
        ExitOutputData exitOutputData = new ExitOutputData();
        exitPresenter.prepareSuccessView(exitOutputData);
    }
}
