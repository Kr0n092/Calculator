import java.util.Observable;

/**
 * Created by olivier on 10/23/15.
 */
public interface Controller {
    void setView(View view);
    View getView();
    void setModel(Observable model);
    Observable getModel();
}
