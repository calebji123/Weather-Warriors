package use_case.how_to_play;

import api.TranslateAPI;

public class HowToPlayInteractor implements HowToPlayInputBoundary {
    final HowToPlayDataAccessInterface dataAccessObject;

    final HowToPlayOutputBoundary presenter;

    public HowToPlayInteractor(HowToPlayDataAccessInterface dataAccessObject, HowToPlayOutputBoundary presenter) {
        this.dataAccessObject = dataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(String lang) {
        String message = dataAccessObject.getHowToPlay();
        if (!lang.equals("EN")) {
            message = TranslateAPI.translate(lang, message);
        }
        HowToPlayOutputData outputData = new HowToPlayOutputData(message);
        presenter.prepareHowToPlayView(outputData);
    }
}
