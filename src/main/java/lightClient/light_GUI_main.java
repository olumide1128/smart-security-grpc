package lightClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import simpleJMDNS.SimpleServiceDiscovery;

import javax.swing.JLabel;
import java.awt.Font;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class light_GUI_main extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					light_GUI_main frame = new light_GUI_main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public light_GUI_main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SMART LIGHT SERVICE");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 23));
		lblNewLabel.setBounds(110, 24, 263, 56);
		contentPane.add(lblNewLabel);
		
		JButton openRPCBtn = new JButton("On/Off Light");
		
		openRPCBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				light_GUI_rpc instance = new light_GUI_rpc();
				instance.setLocationRelativeTo(null);
				instance.setVisible(true);
			}
		});
		openRPCBtn.setFont(new Font("Quicksand", Font.PLAIN, 15));
		openRPCBtn.setBounds(118, 144, 231, 70);
		contentPane.add(openRPCBtn);
	}
}
