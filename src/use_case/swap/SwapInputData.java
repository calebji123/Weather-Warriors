package use_case.swap;

public class SwapInputData {
    final private String activeCardName;

    public SwapInputData(String activeCardName) {
        this.activeCardName = activeCardName;
    }

    public String getActiveCardName() {return this.activeCardName;}
}
