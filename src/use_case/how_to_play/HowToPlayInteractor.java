package use_case.how_to_play;

public class HowToPlayInteractor implements HowToPlayInputBoundary {
    final HowToPlayDataAccessInterface dataAccessObject;

    final HowToPlayOutputBoundary presenter;

    public HowToPlayInteractor(HowToPlayDataAccessInterface dataAccessObject, HowToPlayOutputBoundary presenter) {
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        String message = dataAccessObject.getHowToPlay();
        HowToPlayOutputData outputData = new HowToPlayOutputData(message);
        presenter.prepareHowToPlayView(outputData);
    }
}
