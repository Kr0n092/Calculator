import javax.swing.*;
import java.awt.*;
/**
 * Created by olivier on 10/16/15.
 */
public class Calculator{

    private CalculatorModel $model;

    private CalculatorView $view;

    public Calculator() {
        $model = new CalculatorModel();

        $view = new CalculatorView($model, null);

        $model.addObserver($view);
    }

    private void createGui() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add($view.getUI());

        frame.pack();
        frame.setVisible(true);
    }

    private static void createAndShowGUI() {
        Calculator calculator = new Calculator();
        calculator.createGui();

    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
