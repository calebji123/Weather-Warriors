package interface_adaptor.start;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class StartViewModel extends ViewModel {
    private StartState state;
    public StartViewModel(){
        super("start_turn");
    }

    public StartState getState(){
        return state;
    }

    public void setState(StartState state) {
        this.state = state;
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
