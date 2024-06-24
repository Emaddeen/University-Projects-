import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlotMachine extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new SlotMachine();
	}

	private JLabel spinner1; // Left digit display
	private JLabel spinner2; // Middle digit display
	private JLabel spinner3; // Right digit display
	private int[] values; // Digit values
	private JButton startStop; // Button to start or stop spinner(s)

	private Thread thread1;
	private Thread thread2;
	private Thread thread3;

	// Constructor
	public SlotMachine() {
		super("Slots!");
		values = new int[3];
		makeFrame();
	}

	// Makes all three digits start spinning.
	public void startSpinning() {
		// Disable the button during spinning
		startStop.setEnabled(false);

		// Create and start spinner threads with varying speeds
		thread1 = new SpinnerThread(spinner1);
		thread2 = new SpinnerThread(spinner2);
		thread3 = new SpinnerThread(spinner3);
		thread1.start();
		thread2.start();
		thread3.start();
	}

	// Makes one digit stop spinning.
	// If all digits stop, displays a message if all three digits are the same.
	public void stopSpinning() {
		// Interrupt the threads to stop spinning
		thread1.interrupt();
		thread2.interrupt();
		thread3.interrupt();

		// Check if all three digits are the same
		if (values[0] == values[1] && values[1] == values[2]) {
			JOptionPane.showMessageDialog(this, "Congratulations! You win!");
		} else {
			JOptionPane.showMessageDialog(this, "Sorry, you didn't win.");
		}

		// Re-enable the button
		startStop.setEnabled(true);
	}

	// This method is called when the Start/Stop button is clicked.
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
		JPanel spinnerPanel = new JPanel(new GridLayout(1, 3, 5, 5);

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

	// Thread class to simulate spinning of a spinner
	class SpinnerThread extends Thread {
		private JLabel spinner;

		public SpinnerThread(JLabel spinner) {
			this.spinner = spinner;
		}

		@Override
		public void run() {
			try {
				while (!isInterrupted()) {
					// Simulate spinning by incrementing the value
					int currentValue = Integer.parseInt(spinner.getText());
					values[spinner == spinner1 ? 0 : spinner == spinner2 ? 1 : 2] = currentValue;
					currentValue = (currentValue + 1) % 10;
					spinner.setText(Integer.toString(currentValue);

					// Vary the speed of spinning using Thread.sleep()
					Thread.sleep(100 + (int) (Math.random() * 300));
				}
			} catch (InterruptedException e) {
				// Thread was interrupted, stop spinning
			}
		}
	}
}
