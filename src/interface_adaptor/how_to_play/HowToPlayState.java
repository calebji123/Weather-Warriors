package interface_adaptor.how_to_play;

public class HowToPlayState {
    private String message;

    public HowToPlayState(HowToPlayState copy) {
        message = copy.message;
    }

    public HowToPlayState() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
