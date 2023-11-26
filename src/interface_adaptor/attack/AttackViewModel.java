package interface_adaptor.attack;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttackViewModel extends ViewModel {
    private AttackState state;
    public AttackViewModel(String viewName) {
        super(viewName);
    }

    public AttackState getState() {
        return state;
    }

    public void setState(AttackState state) {
        this.state = state;
    }

    PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
