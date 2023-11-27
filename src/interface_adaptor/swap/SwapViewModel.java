package interface_adaptor.swap;

import interface_adaptor.ViewModel;
import interface_adaptor.attack.AttackState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SwapViewModel extends ViewModel {
    public final String TITLE_LABEL = "Swap View";
    public static final String BUTTON_LABEL = "Swap";
    private SwapState swapState = new SwapState();
    public SwapViewModel() {super("swap");}
    public void setState(SwapState state) {this.swapState = state;}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.swapState);
    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public SwapState getState() {return swapState;}
}
