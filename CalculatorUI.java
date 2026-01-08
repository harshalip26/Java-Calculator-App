import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorUI extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton add, sub, mul, div;

    CalculatorUI() {
        setTitle("Calculator Application");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        add = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        add(new JLabel("First Number:"));
        add(t1);
        add(new JLabel("Second Number:"));
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(new JLabel("Result:"));
        add(result);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(t1.getText());
            double n2 = Double.parseDouble(t2.getText());
            double res = 0;

            if (e.getSource() == add) {
                res = n1 + n2;
            } else if (e.getSource() == sub) {
                res = n1 - n2;
            } else if (e.getSource() == mul) {
                res = n1 * n2;
            } else if (e.getSource() == div) {
                if (n2 == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                res = n1 / n2;
            }

            result.setText(String.valueOf(res));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new CalculatorUI();
    }
}
