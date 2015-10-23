import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

/**
 * Created by olivier on 10/23/15.
 */
public class CalculatorView extends AbstractView implements ActionListener {
    private JButton[] $numbers, $operations;
    private JButton $clear;
    private JTextArea $display;

    private JPanel $panel;


    CalculatorView(Observable model, Controller controller) {
        super(model, controller);
        init();
    }

    private void init() {
        $panel = new JPanel();

        initNumberButtons();
        initOperationButtons();
        initClrButton();

        $display = new JTextArea("Enter calculations please...", 2, 10); //create text area for input
        $display.setEditable(false);
        $panel.add($display, BorderLayout.SOUTH);
    }

    private void initClrButton() {
        $clear = new JButton("CLR");
        $clear.setActionCommand("c");
        $clear.setEnabled(false);
        $clear.addActionListener(this);
        $clear.setToolTipText("Click to clear screen");
        $panel.add($clear);
    }

    private void initNumberButtons() {
        $numbers = new JButton[10]; //$numbers 0 up to 9
        for (int i = 0; i < 10; ++i) {
            $numbers[i] = new JButton("" + i);
            $numbers[i].setVerticalTextPosition(AbstractButton.CENTER);
            $numbers[i].setHorizontalTextPosition(AbstractButton.LEADING);
            $numbers[i].setActionCommand("" + i);
            $numbers[i].setEnabled(true);
            $numbers[i].addActionListener(this);
            $numbers[i].setToolTipText("Click this button to enter " + i);
            $panel.add($numbers[i], BorderLayout.CENTER);
        }
    }

    private void initOperationButtons() {
        $operations = new JButton[5]; //$operations on $numbers
        $operations[0] = new JButton("+");
        $operations[0].setActionCommand("a");
        $operations[1] = new JButton("-");
        $operations[1].setActionCommand("s");
        $operations[2] = new JButton("*");
        $operations[2].setActionCommand("m");
        $operations[3] = new JButton("/");
        $operations[3].setActionCommand("d");
        $operations[4] = new JButton("OK");
        $operations[4].setActionCommand("o");

        for (int i = 0; i < 5; ++i) {
            $operations[i].setVerticalTextPosition(AbstractButton.CENTER);
            $operations[i].setHorizontalTextPosition(AbstractButton.LEADING);
            $operations[i].setEnabled(true);
            $operations[i].addActionListener(this);
            $panel.add($operations[i], BorderLayout.PAGE_END);
        }
    }

    public void actionPerformed(ActionEvent e) {
        char command = e.getActionCommand().charAt(0);
        switch (command) {
            case 'o':
                ((CalculatorController)getController()).
                        processOperation();
                $clear.setEnabled(true);
                break;
            case 'c':
                ((CalculatorController)getController()).
                        clear();
                break;
            case 'a':
            case 's':
            case 'm':
            case 'd':
                if (command == 'd') {
                    $numbers[0].setEnabled(false);
                }
                ((CalculatorController)getController()).
                        setOperation(command);
                $clear.setEnabled(true);
                break;
            default:
                if(((CalculatorController)getController()).isOperationSet()) {
                    ((CalculatorController) getController()).
                            setNumber2(Double.parseDouble(e.getActionCommand()));
                } else {
                    ((CalculatorController) getController()).
                            setNumber1(Double.parseDouble(e.getActionCommand()));
                }
                $clear.setEnabled(true);
                break;

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        CalculatorUpdate info = (CalculatorUpdate) arg;
        if (info.isOperationSet()) {
            $display.setText("" + info.getOperation());
        } else {
            $display.setText("" + info.getNumber());
            if (info.getOperation() != 'd') {
                $numbers[0].setEnabled(true);
            }
        }
    }

    public JPanel getUI() {
        return $panel;
    }

    @Override
    public Controller defaultController(Observable model) {
        return new CalculatorController(model);
    }
}
