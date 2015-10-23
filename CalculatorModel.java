import java.util.Observable;

/**
 * Created by olivier on 10/23/15.
 */
public class CalculatorModel extends Observable{
    private boolean $isOperationSet;
    private char $operation;
    private double $number1;
    private double $number2;

    CalculatorModel() {
        setIsOperationSet(false);
        setNumber1(0.0);
        setNumber2(0.0);

    }

    public void clear() {
        setIsOperationSet(false);
        setNumber1(0.0);
        setNumber2(0.0);

        CalculatorUpdate info = new CalculatorUpdate($number1, false);
        setChanged();
        notifyObservers(info);
    }

    public boolean isOperationSet() {
        return $isOperationSet;
    }

    public void setIsOperationSet(boolean $isOperationSet) {
        this.$isOperationSet = $isOperationSet;
    }

    public char getOperation() {
        return $operation;
    }

    public void setOperation(char $operation) {
        this.$operation = $operation;
        setIsOperationSet(true);

        CalculatorUpdate info = new CalculatorUpdate($number1, true);
        setChanged();
        notifyObservers(info);
    }

    public double getNumber1() {
        return $number1;
    }

    public void setNumber1(double number1) {
        this.$number1 = number1;

        CalculatorUpdate info = new CalculatorUpdate($number1, false);
        setChanged();
        notifyObservers(info);
    }


    public double getNumber2() {
        return $number2;
    }

    public void setNumber2(double number2) {
        this.$number2 = number2;

        CalculatorUpdate info = new CalculatorUpdate($number2, false);
        setChanged();
        notifyObservers(info);
    }

    public void processOperation() {
        switch (getOperation()) {
            case 'a':
                add();
                break;
            case 's':
                substract();
                break;
            case 'm':
                multiply();
                break;
            case 'd':
                divide();
                break;
            default:
                break;
        }
        setIsOperationSet(false);
        CalculatorUpdate info = new CalculatorUpdate($number1, false);
        setChanged();
        notifyObservers(info);

    }

    private void add() {
        $number1 += $number2;
    }

    private void substract() {
        $number1 -= $number2;
    }

    private void multiply() {
        $number1 *= $number2;
    }

    private void divide() {
        if ($number2 != 0.0) {
            $number1 /= $number2;
        }
    }

}
