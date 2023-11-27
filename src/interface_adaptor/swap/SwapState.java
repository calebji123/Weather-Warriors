package interface_adaptor.swap;

public class SwapState {
    private String message;
    private String activeCardName;
    private Integer activeCardHealth;
    private String nextCardName;
    private Boolean hasError;
    private String swapError;

    public SwapState(SwapState copy) {
        this.message = copy.message;
        this.activeCardName = copy.activeCardName;
        this.activeCardHealth = copy.activeCardHealth;
        this.nextCardName = copy.nextCardName;
        this.swapError = copy.swapError;
        this.hasError = copy.hasError;
    }
    public SwapState(){}

    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
    public String getActiveCardName() {return this.activeCardName;}
    public void setActiveCardName(String name) {this.activeCardName = name;}
    public Integer getActiveCardHealth() {return this.activeCardHealth;}
    public void setActiveCardHealth(Integer health) {this.activeCardHealth = health;}
    public String getNextCardName() {return this.nextCardName;}
    public void setNextCardName(String name) {this.nextCardName = name;}
    public void setSwapError(String error) {this.swapError = error;}
    public String getSwapError() {return this.swapError;}
    public void setHasError(Boolean hasError) {this.hasError = hasError;}
}
