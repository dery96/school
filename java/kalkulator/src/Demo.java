import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Demo implements ActionListener {
    JTextField t1;
    JButton b1, b2, b3, b4, b5;
    int tmp, m;
    char operation;

    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();

        if (target == b1 || target == t1) {
            int k = Integer.parseInt(t1.getText());
            t1.setText(Integer.toString(k * k));
            t1.requestFocus();
        } else if (target == b2) {
            t1.setText("");
            t1.requestFocus();
        } else if (target == b3) {
            try {
                tmp = Integer.parseInt(t1.getText());
                operation = '+';
            } catch (NumberFormatException f){
                System.out.println("you can't do it like that: " + f );
                operation = ' ';
                tmp = 0;
            }
            t1.setText("");
            t1.requestFocus();
        } else if (target == b4) {
            try {
                tmp = Integer.parseInt(t1.getText());
                operation = '-';
            } catch (NumberFormatException f){
                System.out.println("you can't do it like that: " + f );
                operation = ' ';
                tmp = 0;
            }
            t1.setText("");
            t1.requestFocus();
        } else if (target == b5) {
            try {
                m = Integer.parseInt(t1.getText());
            } catch (NumberFormatException f){
                System.out.println("you can't do it like that: " + f );
                operation = ' ';
                tmp = 0;
                m = 0;
            }
            t1.setText(Integer.toString(eval(tmp, m ,operation)));
            t1.requestFocus();
        }

    }

    public int eval(int buf, int memory, char operation) {
        switch (operation) {
            case '+': return memory + buf;
            case '-': return memory - buf;
        }
        return 0;
    }

    void init() {
        t1 = new JTextField(6);
        b1 = new JButton("^2");
        b2 = new JButton("clear");
        b3 = new JButton("+");
        b4 = new JButton("-");
        b5 = new JButton("=");

        JPanel p = new JPanel();
        p.add(t1);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);

        t1.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        JFrame f = new JFrame();
        Container c = f.getContentPane();
        c.add(p);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        //do wersji 1.4
        //new Demo().init();

        //od wersji 1.5
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Demo().init();
            }
        });
    }
}