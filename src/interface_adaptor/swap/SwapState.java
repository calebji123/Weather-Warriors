package interface_adaptor.swap;

public class SwapState {
    private String message = "";
    private String nextCardName = "";
    private Integer nextCardHealth = 0;
    private  String swapError = null;

    public SwapState(SwapState copy) {
        this.message = copy.message;
        this.nextCardName = copy.nextCardName;
        this.nextCardHealth = copy.nextCardHealth;
    }
    public SwapState(){}

    public String getMessage() {return this.message;}
    public void setMessage(String message) {this.message = message;}
    public String getNextCardName() {return this.nextCardName;}
    public void setNextCardName(String name) {this.nextCardName = name;}
    public Integer getNextCardHealth() {return this.nextCardHealth;}
    public void setNextCardHealth(Integer health) {this.nextCardHealth = health;}
    public void setSwapError(String error) {this.swapError = error;}
}
