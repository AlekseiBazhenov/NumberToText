package ui;

import interfaces.ObserverUpdateUI;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.FontUIResource;

import builder.ConvertWrapper;

import utils.NumberUtils;

import decorator.DecoratorNumber;
import digits.EnteredNumber;

public class Window implements ObserverUpdateUI {

	private JFrame frameWindow;
	private JPanel panel;
	private JLabel decimalLabel;
	private JLabel octalLabel;
	private JTextField textInputField;

	private EnteredNumber inputNumber;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frameWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		initWindow();
		setPanelToWindow();
		addViews();

		inputNumber = new EnteredNumber();
		inputNumber.registerObserverUpdateUI(this);
		new ConvertWrapper(inputNumber);
	}

	private void initWindow() {
		frameWindow = new JFrame();
		frameWindow.setTitle("Test");
		frameWindow.setBounds(100, 100, 500, 300);
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameWindow.getContentPane().setLayout(null);
	}

	private void setPanelToWindow() {
		panel = new JPanel();
		panel.setBounds(5, 5, 495, 295);
		panel.setLayout(null);
		frameWindow.getContentPane().add(panel);
	}

	private void addViews() {
		addTextField();
		addTenLabel();
		addEightLabel();
	}

	private void addTextField() {
		textInputField = new JTextField(10);
		textInputField.setBounds(0, 0, 475, 20);
		textInputField.setFont(new FontUIResource("Tahoma", Font.PLAIN, 14));
		panel.add(textInputField);
		setTextChangeListener();
	}

	private void setTextChangeListener() {
		textInputField.getDocument().addDocumentListener(
				new DocumentListener() {
					public void changedUpdate(DocumentEvent e) {
						textChanged();
					}

					public void removeUpdate(DocumentEvent e) {
						textChanged();
					}

					public void insertUpdate(DocumentEvent e) {
						textChanged();
					}

					private void textChanged() {
						String inputText = textInputField.getText();
						if (inputText.isEmpty()) {
							resetTextInLabeles("");
						} else if (inputText.length() > 12) {
							resetTextInLabeles("Числа больше миллиардов пока не конвертируются");
						} else {
							try {
								Long.parseLong(inputText);
								inputNumber.setValue(inputText);
							} catch (NumberFormatException e) {
								if (!inputText.isEmpty()) {
									showError();
								}
							}
						}
					}

					private void resetTextInLabeles(String text) {
						decimalLabel.setText(text);
						octalLabel.setText(text);
					}

					private void showError() {
						JOptionPane.showMessageDialog(null,
								"Необходимо ввести число", "Ошибка",
								JOptionPane.ERROR_MESSAGE);
					}
				});
	}

	private void addTenLabel() {
		decimalLabel = new JLabel();
		decimalLabel.setFont(new FontUIResource("Tahoma", Font.PLAIN, 12));
		decimalLabel.setBounds(0, 25, 490, 20);
		panel.add(decimalLabel);
	}

	private void addEightLabel() {
		octalLabel = new JLabel();
		octalLabel.setFont(new FontUIResource("Tahoma", Font.PLAIN, 12));
		octalLabel.setBounds(0, 50, 490, 20);
		panel.add(octalLabel);
	}

	@Override
	public void updateUI(String decimal, String octal) {
		decimalLabel.setText(decimal);
		octalLabel.setText(octal);
	}
}
