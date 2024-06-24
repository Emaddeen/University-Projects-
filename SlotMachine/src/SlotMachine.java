import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class SlotMachine extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new SlotMachine();
    }
    private CountThread thread1;
    private CountThread thread2;
    private CountThread thread3;
    private JLabel spinner1; // Left digit display
    private JLabel spinner2; // Middle digit display
    private JLabel spinner3; // Right digit display
    private int[] values; // Digit values
    private JButton startStop; // Button to start or stop spinner(s)
    // Constructor
    public class CountThread extends Thread {
        int index;
        JLabel label;
        private Random random = new Random();

        public CountThread(int i, JLabel l) {
            label = l;
            index = i;
        }

        boolean go = true;

        @Override
        public void run() {
            while (go) {
                if (values[index] >= 9)
                    values[index] = 0;
                values[index]++;
                label.setText(values[index] + "");
                try {
                    Thread.sleep(50 + random.nextInt(100)); // Vary the speed of spinning
                } catch (InterruptedException e) {
                    return; // Exit the thread when interrupted
                }
            }
        }
    }

    public SlotMachine() {
        super("Slots!");
        values = new int[3];
        makeFrame();
    }

    // Makes all three digits start spinning.
    public void startSpinning() {
        thread1 = new CountThread(0, spinner1);
        thread2 = new CountThread(1, spinner2);
        thread3 = new CountThread(2, spinner3);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    // Makes one digit stop spinning.
// If all digits stop, displays a message if all three digits are the same.
    public void stopSpinning() {
        if (thread1 != null) {
            thread1.go = false;
            thread1 = null;
        } else if (thread2 != null) {
            thread2.go = false;
            thread2 = null;
        } else if (thread3 != null) {
            thread3.go = false;
            thread3 = null;
        } else {
            startStop.setText("START");
            if (values[0]==values[1] && values[1]==values[2]){
                System.out.println("You WON!!!");
            }else {
                System.out.println("Sorry No luck :'(");
            }
        }

    }


    // This method is called when Start/Stop button is clicked.
    public void actionPerformed(ActionEvent e) {
        if (startStop.getText().equals("START")) {
            startStop.setText("STOP");
            startSpinning();
        } else {
            stopSpinning();
        }
    }

    // Builds the window and makes it appear!
    private void makeFrame() {
        setLayout(new BorderLayout(5, 5));
        JPanel spinnerPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        spinner1 = new JLabel("0", JLabel.CENTER);
        spinner1.setFont(new Font(null, Font.BOLD, 40));
        spinnerPanel.add(spinner1);
        spinner2 = new JLabel("0", JLabel.CENTER);
        spinner2.setFont(new Font(null, Font.BOLD, 40));
        spinnerPanel.add(spinner2);
        spinner3 = new JLabel("0", JLabel.CENTER);
        spinner3.setFont(new Font(null, Font.BOLD, 40));
        spinnerPanel.add(spinner3);
        add(spinnerPanel, BorderLayout.CENTER);
        startStop = new JButton("START");
        startStop.setFont(new Font(null, Font.ITALIC, 20));
        startStop.addActionListener(this);
        add(startStop, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
