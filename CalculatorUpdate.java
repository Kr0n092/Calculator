/**
 * Created by Olivier on 10/23/2015.
 */
public class CalculatorUpdate {
    private double $number;
    private char $operation;
    private boolean $isOperationSet;

    CalculatorUpdate() {
        $number = 0.0;
        $isOperationSet = false;
    }

    CalculatorUpdate(double number, boolean operationSet) {
        this.$number = number;
        this.$isOperationSet = operationSet;

    }

    public double getNumber() {
        return $number;
    }

    public void setNumber(double $number) {
        this.$number = $number;
    }

    public char getOperation() {
        return $operation;
    }

    public void setOperation(char $operation) {
        this.$operation = $operation;
    }

    public boolean isOperationSet() {
        return $isOperationSet;
    }

    public void setIsOperationSet(boolean $isOperationSet) {
        this.$isOperationSet = $isOperationSet;
    }
}
