package interface_adaptor.how_to_play;

import use_case.how_to_play.HowToPlayOutputBoundary;
import use_case.how_to_play.HowToPlayOutputData;

public class HowToPlayPresenter implements HowToPlayOutputBoundary {

    private final HowToPlayViewModel howToPlayViewModel;

    public HowToPlayPresenter(HowToPlayViewModel howToPlayViewModel) {
        this.howToPlayViewModel = howToPlayViewModel;
    }

    @Override
    public void prepareHowToPlayView(HowToPlayOutputData outputData) {
        HowToPlayState howToPlayState = howToPlayViewModel.getState();
        howToPlayState.setMessage(outputData.getMessage());
        howToPlayViewModel.firePropertyChanged();
    }
}
