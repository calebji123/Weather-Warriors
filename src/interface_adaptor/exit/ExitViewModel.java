package interface_adaptor.exit;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ExitViewModel extends ViewModel {
    private ExitState state = new ExitState();
    public ExitViewModel() {super("exit");}
    public void setState(ExitState state) {this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public ExitState getState() {return state;}
}
