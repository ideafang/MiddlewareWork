package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class WebClient extends JFrame {

	private JPanel WORK;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("WebClient");
					frame.setContentPane(new WebClient().WORK);
					frame.setSize(530, 300);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		WORK = new JPanel();
		WORK.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(WORK);
		WORK.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		textArea.setBounds(10, 10, 285, 241);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		WORK.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u624B\u673A\u53F7\u7801\u67E5\u8BE2", "\u5929\u6C14\u67E5\u8BE2", "IP\u5730\u5740\u67E5\u8BE2"}));
		comboBox.setBounds(305, 102, 199, 21);
		WORK.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		textField.setBounds(305, 147, 199, 53);
		WORK.add(textField);
		textField.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setBounds(419, 228, 85, 23);
		WORK.add(search);
		
		JLabel lblNewLabel = new JLabel("MiddleWare Work4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(305, 14, 199, 21);
		WORK.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edit by : 2016012915");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(315, 34, 189, 21);
		WORK.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Using webxml.com.cn Service");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(305, 57, 199, 23);
		WORK.add(lblNewLabel_2);
		
		JButton clean = new JButton("Clean");
		clean.setBounds(305, 228, 93, 23);
		WORK.add(clean);
		
		search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.append("\n");
				int select = comboBox.getSelectedIndex();
				String str = textField.getText();
				switch (select) {
				case 0:
					String result = SwingAction.GetPhoneInfo(str);
					textArea.append(result);
					break;
				case 1:
					String[] results1 = SwingAction.GetWeather(str);
					for (String st : results1) {
						textArea.append(st);
					}
					break;
				case 2:
					String[] results2 = SwingAction.GetIpInfo(str);
					for (String st : results2) {
						textArea.append(st);
					}
					break;
				default:		
				}
			}
			
		});
		
		clean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.setText("");
			}
			
		});
	}
}
