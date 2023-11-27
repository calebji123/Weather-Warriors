package interface_adaptor.attack;

import interface_adaptor.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AttackViewModel extends ViewModel {
    public final String TITLE_LABEL = "Attack View";
    public static final String REGULAR_BUTTON_LABEL = "Attack";
    public static final String SPECIAL_BUTTON_LABEL = "Special Attack";
    private AttackState attackState = new AttackState();

    public AttackViewModel() {super("attack");}
    public void setState(AttackState state) {this.attackState = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.attackState);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public AttackState getState() {return attackState;}
}
