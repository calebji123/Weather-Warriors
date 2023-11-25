package interface_adaptor.how_to_play;

import use_case.how_to_play.HowToPlayInputBoundary;

public class HowToPlayController {
    final HowToPlayInputBoundary howToPlayInputBoundary;

    public HowToPlayController(HowToPlayInputBoundary howToPlayInputBoundary) {
        this.howToPlayInputBoundary = howToPlayInputBoundary;
    }

    public void execute(String lang) {
        howToPlayInputBoundary.execute(lang);
    }
}
