import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JPanel base;
    private JTextArea text;
    private JPanel button_wrapper;
    private JButton [] button;


    private String current;
    private String adder;

    private Calculator cal;

    public CalculatorGUI() {
        super("계산기");
        cal = new Calculator();
        this.setSize(500,500);
        current = "0";
        adder = "0";
        this.init();
        setVisible(true);
    }
    public void init() {

        base = new JPanel();
        text = new JTextArea();
        button_wrapper = new JPanel();
        button = new JButton[19];
        button[0] = new JButton("AC");
        button[1] = new JButton("+/-");
        button[2] = new JButton("%");
        button[3] = new JButton("/");
        button[4] = new JButton("7");
        button[5] = new JButton("8");
        button[6] = new JButton("9");
        button[7] = new JButton("x");
        button[8] = new JButton("4");
        button[9] = new JButton("5");
        button[10] = new JButton("6");
        button[11] = new JButton("-");
        button[12] = new JButton("1");
        button[13] = new JButton("2");
        button[14] = new JButton("3");
        button[15] = new JButton("+");
        button[16] = new JButton("0");
        button[17] = new JButton(".");
        button[18] = new JButton("=");
        for(int i = 0; i< 19; i++) {
            button[i].addActionListener(this);
        }

        base.setLayout(null);
        text.setBounds(10, 10, 480, 80);
        text.setBackground(Color.white);
        text.setText("0\n\n0");
        text.setEditable(false);
        text.setMargin(new Insets(10,10,10,10));
        button_wrapper.setBounds(10, 100, 480, 370);
        button_wrapper.setBackground(Color.gray);
        button_wrapper.setLayout(new GridLayout(5, 4));

        for(int i = 0 ; i < 19; i++) {
            button_wrapper.add(button[i]);
        }

        base.add(text);
        base.add(button_wrapper);
        this.add(base);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();
//        button[0] = new JButton("AC");
//        button[1] = new JButton("+/-");
//        button[2] = new JButton("%");
//        button[17] = new JButton(".");

        if(target == button[16]) {
            current = cal.setTarget(0);
        }
        else if(target == button[12]) {
            current = cal.setTarget(1);
        }
        else if(target == button[13]) {
            current = cal.setTarget(2);
        }
        else if(target == button[14]) {
            current = cal.setTarget(3);
        }
        else if(target == button[8]) {
            current = cal.setTarget(4);
        }
        else if(target == button[9]) {
            current =  cal.setTarget(5);
        }
        else if(target == button[10]) {
            current = cal.setTarget(6);
        }
        else if(target == button[4]) {
            current = cal.setTarget(7);
        }
        else if(target == button[5]) {
            current = cal.setTarget(8);
        }
        else if(target == button[6]) {
            current = cal.setTarget(9);
        }
        else if(target == button[3]) {
            // 나누기
            adder = cal.calLogic(3);
            current = "0";
        }
        else if(target == button[7]) {
            // 곱하기
            adder = cal.calLogic(2);
            current = "0";
        }
        else if(target == button[11]) {
            // 빼기
            adder = cal.calLogic(1);
            current = "0";
        }
        else if(target == button[15]) {
            // 더하기
            adder = cal.calLogic(0);
            current = "0";
        }
        else if(target == button[18]) {
            adder = cal.result();
            current = "0";
        }
        else if(target == button[0]) {
            cal.ac();
            current = "0";
            adder = "0";
        }
        else if(target == button[17]) {
            current = cal.point();
        }
        setText();
    }

    public void setText() {
        text.setText(adder + "\n\n" + current);
    }
}
