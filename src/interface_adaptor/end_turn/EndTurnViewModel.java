package interface_adaptor.end_turn;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EndTurnViewModel extends ViewModel {
    private EndTurnState state;

    public EndTurnViewModel() {
        super("end_turn");
    }

    public EndTurnState getState() {
        return state;
    }

    public void setState(EndTurnState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
