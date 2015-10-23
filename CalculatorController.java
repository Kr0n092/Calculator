import java.util.Observable;

/**
 * Created by olivier on 10/23/15.
 */
public class CalculatorController extends AbstractController {
    public CalculatorController(Observable model) {super(model);}

    public void setNumber1(double number) {((CalculatorModel)getModel()).setNumber1(number);}

    public void setNumber2(double number) {((CalculatorModel)getModel()).setNumber2(number);}

    public void setOperation(char operation) {((CalculatorModel)getModel()).setOperation(operation);}

    public void processOperation() {((CalculatorModel)getModel()).processOperation();}

    public boolean isOperationSet() {return ((CalculatorModel)getModel()).isOperationSet();}

    public void clear() { ((CalculatorModel)getModel()).clear();}
}
