
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Kalk implements ActionListener, KeyListener{
    JTextField t1;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton bplus, brow, bmultiply, bminus, bdivide, bcomma, breset, bpower, bsqrt, bmemory, baddMemory, bminusMemory;
    double memory, buf, storage;
    char operation = ' ';

    public void keyPressed(KeyEvent evt) {
        char c = evt.getKeyChar();
        System.out.println(c);
    }

    public void keyReleased(KeyEvent evt) {
        char c = evt.getKeyChar();
        System.out.println(c);
    }

    public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        System.out.println(c);
    }

    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();

        if (target == b1) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();
        } else if (target == b2) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();
        } else if (target == b3) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();
        } else if (target == b4) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b5) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b6) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b7) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b8) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b9) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == b0) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();

        } else if (target == bplus) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            System.out.println(buf);
            operation = '+';
            t1.setText("");
            t1.requestFocus();
        } else if (target == bminus) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            operation = '-';
            t1.setText("");
            t1.requestFocus();
        } else if (target == bmultiply) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            operation = '*';
            t1.setText("");
            t1.requestFocus();
        } else if (target == bsqrt) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            if (buf >= 0) {
                t1.setText(Double.toString(Math.sqrt(buf)));
            } else {
                t1.setText("Nieprawidlowy ulamek");
            }
            t1.requestFocus();
        } else if (target == bpower) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            operation = '^';
            t1.setText("");
            t1.requestFocus();
        } else if (target == breset) {
            if (buf == 0 && operation == ' ' && memory == 0) {
                storage = 0;
            }
            buf = 0;
            operation = ' ';
            memory = 0;

            t1.setText("");
            t1.requestFocus();
        } else if (target == baddMemory) {
            storage += Double.parseDouble(t1.getText().replaceAll(",", "."));
            t1.setText("");
            t1.requestFocus();
        } else if (target == bminusMemory) {
            storage -= Double.parseDouble(t1.getText().replaceAll(",", "."));
            t1.setText("");
            t1.requestFocus();
        } else if (target == bmemory) {
            if (storage == 0) {
                t1.setText("");
            } else {
                t1.setText(Double.toString(storage));
            }
            t1.requestFocus();
        }  else if (target == bdivide) {
            buf = Double.parseDouble(t1.getText().replaceAll(",", "."));
            operation = '/';
            t1.setText("");
            t1.requestFocus();
        } else if (target == bcomma) {
            t1.setText(t1.getText() + ((JButton) target).getText());
            t1.requestFocus();
        } else if (target == brow || target == t1) {
            if (operation != ' ') {
                memory = Double.parseDouble(t1.getText().replaceAll(",", "."));
                t1.setText(Double.toString(evalOperation(buf, memory, operation)));
            } else {
                t1.setText("");
            }
            t1.requestFocus();
        }
    }

    public double evalOperation(double memory, double buf, char operation) {
        switch (operation) {
            case '+': return memory + buf;
            case '-': return memory - buf;
            case '*': return memory * buf;
            case '/': if (buf == 0) {
                return 0.0;
            } return memory / buf;
            case '^': return Math.pow(memory, buf);
        }
        return 0.0;
    };

    void init() {
        JFrame f = new JFrame();
        Container c = f.getContentPane();

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        c.setLayout(gbl);


        t1 = new JTextField(15);
        t1.addActionListener(this);
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t1.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.ipadx = 0;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(t1, gbc);
        c.add(t1);


        b1 = new JButton("1");
        b1.addActionListener(this);
        b1.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b1, gbc);
        c.add(b1);

        b2 = new JButton("2");
        b2.addActionListener(this);
        b2.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b2, gbc);
        c.add(b2);

        b3 = new JButton("3");
        b3.addActionListener(this);
        b3.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b3, gbc);
        c.add(b3);

        bmultiply = new JButton("*");
        bmultiply.addActionListener(this);
        bmultiply.setFocusable(false);
        bmultiply.setToolTipText("mnozenie");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(bmultiply, gbc);
        c.add(bmultiply);


        b4 = new JButton("4");
        b4.addActionListener(this);
        b4.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b4, gbc);
        c.add(b4);

        b5 = new JButton("5");
        b5.addActionListener(this);
        b5.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b5, gbc);
        c.add(b5);

        b6 = new JButton("6");
        b6.addActionListener(this);
        b6.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b6, gbc);
        c.add(b6);

        bminus = new JButton("-");
        bminus.addActionListener(this);
        bminus.setFocusable(false);
        bminus.setToolTipText("odejomwanie");
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(bminus, gbc);
        c.add(bminus);

        b7 = new JButton("7");
        b7.addActionListener(this);
        b7.setFocusable(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b7, gbc);
        c.add(b7);

        b8 = new JButton("8");
        b8.addActionListener(this);
        b8.setFocusable(false);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b8, gbc);
        c.add(b8);

        b9 = new JButton("9");
        b9.addActionListener(this);
        b9.setFocusable(false);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbl.setConstraints(b9, gbc);
        c.add(b9);


        bplus = new JButton("+");
        bplus.addActionListener(this);
        bplus.setFocusable(false);
        bplus.setToolTipText("dodawanie");
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 0, 5);
        gbl.setConstraints(bplus, gbc);
        c.add(bplus);


        brow = new JButton("=");
        brow.addActionListener(this);
        brow.setFocusable(false);
        brow.setToolTipText("wykonaj działanie");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(brow, gbc);
        c.add(brow);

        bdivide = new JButton("/");
        bdivide.addActionListener(this);
        bdivide.setFocusable(false);
        bdivide.setToolTipText("dzielenie");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(bdivide, gbc);
        c.add(bdivide);

        b0 = new JButton("0");
        b0.addActionListener(this);
        b0.setFocusable(false);
        b0.setToolTipText("0");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(b0, gbc);
        c.add(b0);

        bcomma = new JButton(".");
        bcomma.addActionListener(this);
        bcomma.setFocusable(false);
        bcomma.setToolTipText("przecinek");
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 0);
        gbl.setConstraints(bcomma, gbc);
        c.add(bcomma);

        breset = new JButton("c");
        breset.addActionListener(this);
        breset.setFocusable(false);
        breset.setToolTipText("resetuj");
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(breset, gbc);
        c.add(breset);

        bpower = new JButton("^x");
        bpower.addActionListener(this);
        bpower.setFocusable(false);
        bpower.setToolTipText("potegowanie");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(bpower, gbc);
        c.add(bpower);

        bsqrt = new JButton("sqrt");
        bsqrt.addActionListener(this);
        bsqrt.setFocusable(false);
        bsqrt.setToolTipText("pierwiastek");
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(bsqrt, gbc);
        c.add(bsqrt);

        bmemory = new JButton("M");
        bmemory.addActionListener(this);
        bmemory.setFocusable(false);
        bmemory.setToolTipText("pobierz zachowana wartosc pamieci");
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(bmemory, gbc);
        c.add(bmemory);

        baddMemory = new JButton("M+");
        baddMemory.addActionListener(this);
        baddMemory.setFocusable(false);
        baddMemory.setToolTipText("dodaj do pamieci");
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(baddMemory, gbc);
        c.add(baddMemory);

        bminusMemory = new JButton("M-");
        bminusMemory.addActionListener(this);
        bminusMemory.setFocusable(false);
        bminusMemory.setToolTipText("odejmij od pamieci");
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbl.setConstraints(bminusMemory, gbc);
        c.add(bminusMemory);


        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Kalk");
        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Kalk().init();
            }
        });
    }
}