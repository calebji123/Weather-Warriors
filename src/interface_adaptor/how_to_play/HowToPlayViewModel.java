package interface_adaptor.how_to_play;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HowToPlayViewModel extends ViewModel {

    private HowToPlayState state = new HowToPlayState();

    public HowToPlayViewModel() {
        super("how_to_play");
    }

    public void setState(HowToPlayState state) {
        this.state = state;
    }

    public HowToPlayState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
