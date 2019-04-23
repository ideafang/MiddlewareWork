package LearnMessage;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.TextArea;

public class Chat extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField sendText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setTitle("LearnMessage");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextArea textArea;
	public StringBuffer text;
	public String user;
	public String targe;
	public String url = "tcp://localhost:61616";

	/**
	 * Create the frame.
	 */
	public Chat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton send = new JButton("SEND");
		send.setBounds(331, 229, 93, 23);
		contentPane.add(send);
		
		textField1 = new JTextField();
		textField1.setBounds(225, 35, 199, 21);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setForeground(Color.BLACK);
		textField2.setFont(new Font("SimSun-ExtB", Font.PLAIN, 12));
		textField2.setHorizontalAlignment(SwingConstants.LEADING);
		textField2.setEnabled(true);
		textField2.setEditable(true);
		textField2.setDropMode(DropMode.USE_SELECTION);
		textField2.setBackground(Color.WHITE);
		textField2.setText("");
		textField2.setBounds(225, 93, 199, 21);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		sendText = new JTextField();
		sendText.setBounds(225, 155, 199, 64);
		contentPane.add(sendText);
		sendText.setColumns(10);
		
		JButton startButton = new JButton("START");
		startButton.setBounds(225, 229, 93, 23);
		contentPane.add(startButton);
		
		JLabel lblNewLabel = new JLabel("USER");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel.setBounds(226, 10, 54, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Send ID");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(225, 66, 93, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Message");
		lblNewLabel_2.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(225, 124, 156, 23);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true); 
		textArea.setBounds(10, 10, 199, 242);
		contentPane.add(textArea);
		textArea.append("MiddleWareWork3: LearnMessage \nEdited by : 2016012915 \n");
		
		startButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = textField1.getText();
				targe = textField2.getText();
				new Thread(new Receiver(user, url, null, null, textArea)).start();
			}
			
		});
		
		send.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password = null;
				String text1 = sendText.getText();
				textArea.append("Send message : \r" + text1 + "\n");
				Sender sender = new Sender(targe, url, user, password, text1);
				new Thread(sender).start();
			}
		});
	}
}
