package semIV;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(this.real + c.real, this.imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(this.real - c.real, this.imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        double r = this.real * c.real - this.imaginary * c.imaginary;
        double i = this.real * c.imaginary + this.imaginary * c.real;
        return new Complex(r, i);
    }

    public Complex divide(Complex c) {
        double denominator = c.real * c.real + c.imaginary * c.imaginary;
        double r = (this.real * c.real + this.imaginary * c.imaginary) / denominator;
        double i = (this.imaginary * c.real - this.real * c.imaginary) / denominator;
        return new Complex(r, i);
    }

    public String toString() {
        return String.format("%.2f + %.2fi", real, imaginary);
    }
}

public class Cal extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	private JTextField tf1, tf2, tf3;
    private JComboBox<String> opList;
    private JButton btn;

    public Cal() {
       
            setTitle("Calculator");
            setLayout(new FlowLayout());
            setSize(270, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel num1Label = new JLabel("Enter first number:");
            add(num1Label);

            tf1 = new JTextField(10);
            add(tf1);

            JLabel num2Label = new JLabel("Enter second number:");
            add(num2Label);

            tf2 = new JTextField(10);
            add(tf2);

            JLabel resultLabel = new JLabel("Result:");
            add(resultLabel);

            tf3 = new JTextField(10);
            tf3.setEditable(false);
            add(tf3);

            String[] ops = {"+", "-", "*", "/", "C"};
            opList = new JComboBox<>(ops);
            add(opList);

            btn = new JButton("Calculate");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String op = (String) opList.getSelectedItem();
                try {
                    if (op.equals("+")) {
                        if (isFloat(tf1.getText()) && isFloat(tf2.getText())) {
                            float f1 = Float.parseFloat(tf1.getText());
                            float f2 = Float.parseFloat(tf2.getText());
                            tf3.setText(Float.toString(f1 + f2));
                        } else if (isInt(tf1.getText()) && isInt(tf2.getText())) {
                            int i1 = Integer.parseInt(tf1.getText());
                            int i2 = Integer.parseInt(tf2.getText());
                            tf3.setText(Integer.toString(i1 + i2));
                        } else if (isComplex(tf1.getText()) && isComplex(tf2.getText())) {
                            Complex c1 = parseComplex(tf1.getText());
                            Complex c2 = parseComplex(tf2.getText());
                            tf3.setText(c1.add(c2).toString());
                        } else {
                            tf3.setText("Invalid input");
                        }
                    } else if (op.equals("-")) {
                        if (isFloat(tf1.getText()) && isFloat(tf2.getText())) {
                            float f1 = Float.parseFloat(tf1.getText());
                            float f2 = Float.parseFloat(tf2.getText());
                            tf3.setText(Float.toString(f1 - f2));
                        } else if (isInt(tf1.getText()) && isInt(tf2.getText())) {
                            int i1 = Integer.parseInt(tf1.getText());
                            int i2 = Integer.parseInt(tf2.getText());
                            tf3.setText(Integer.toString(i1 - i2));
                        } else if (isComplex(tf1.getText()) && isComplex(tf2.getText())) {
                            Complex c1 = parseComplex(tf1.getText());
                            Complex c2 = parseComplex(tf2.getText());
                            tf3.setText(c1.subtract(c2).toString());
                        } else {
                            tf3.setText("Invalid input");
                        }
                    } else if (op.equals("*")) {
                        if (isFloat(tf1.getText()) && isFloat(tf2.getText())) {
                            float f1 = Float.parseFloat(tf1.getText());
                            float f2 = Float.parseFloat(tf2.getText());
                            tf3.setText(Float.toString(f1 * f2));
                        } else if (isInt(tf1.getText()) && isInt(tf2.getText())) {
                            int i1 = Integer.parseInt(tf1.getText());
                            int i2 = Integer.parseInt(tf2.getText());
                            tf3.setText(Integer.toString(i1 * i2));
                        } else if (isComplex(tf1.getText()) && isComplex(tf2.getText())) {
                            Complex c1 = parseComplex(tf1.getText());
                            Complex c2 = parseComplex(tf2.getText());
                            tf3.setText(c1.multiply(c2).toString());
                        } else {
                            tf3.setText("Invalid input");
                        }
                    } else if (op.equals("/")) {
                        if (isFloat(tf1.getText()) && isFloat(tf2.getText())) {
                            float f1 = Float.parseFloat(tf1.getText());
                            float f2 = Float.parseFloat(tf2.getText());
                            tf3.setText(Float.toString(f1 / f2));
                        } else if (isInt(tf1.getText()) && isInt(tf2.getText())) {
                            int i1 = Integer.parseInt(tf1.getText());
                            int i2 = Integer.parseInt(tf2.getText());
                            if (i2 != 0) {
                                tf3.setText(Integer.toString(i1 / i2));
                            } else {
                                tf3.setText("Cannot divide by zero");
                            }
                        } else if (isComplex(tf1.getText()) && isComplex(tf2.getText())) {
                            Complex c1 = parseComplex(tf1.getText());
                            Complex c2 = parseComplex(tf2.getText());
                            tf3.setText(c1.divide(c2).toString());
                        } else {
                            tf3.setText("Invalid input");
                        }
                    } else if (op.equals("C")) {
                        tf1.setText("");
                        tf2.setText("");
                        tf3.setText("");
                    }
                } catch (NumberFormatException ex) {
                    tf3.setText("Invalid input");
                }
            }
        });
        add(btn);

        setVisible(true);
    }



    public Complex parseComplex(String s) {
        s = s.replaceAll("\\s+", "");
        if (s.equals("i")) {
            return new Complex(0, 1);
        } else if (s.equals("-i")) {
            return new Complex(0, -1);
        } else if (s.matches("^\\s*[-+]?\\s*\\d+\\.?\\d*i\\s*$")) {
            if (s.endsWith("i")) {
                double i = Double.parseDouble(s.substring(0, s.length() - 1));
                return new Complex(0, i);
            } else {
                return new Complex(Double.parseDouble(s.substring(0, s.length() - 1)), 0);
            }
        } else if (s.matches("^\\s*[-+]?\\s*\\d+\\.?\\d*[-+][^i]*i\\s*$")) {
            String[] parts = s.split("[-+]");
            double real = Double.parseDouble(parts[0]);
            double imaginary = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
            if (s.startsWith("-")) {
                imaginary *= -1;
            }
            return new Complex(real, imaginary);
        } else {
            return null;
        }
    }

    public boolean isFloat(String s) {
        return s.matches("^\\s*[-+]?\\s*\\d+\\.\\d+\\s*$");
    }

    public boolean isInt(String s) {
        return s.matches("^\\s*[-+]?\\s*\\d+\\s*$");
    }

    public boolean isComplex(String s) {
        s = s.replaceAll("\\s+", "");
        return s.matches("^\\s*[-+]?\\s*(\\d+\\.?\\d*i|i)\\s*$") || 
               s.matches("^\\s*[-+]?\\s*\\d+\\.?\\d*[-+][^i]*i\\s*$");
    }

    public static void main(String[] args) {
        Cal calculator = new Cal();
        calculator.setVisible(true);
    }
    }
