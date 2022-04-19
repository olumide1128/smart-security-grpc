package cameraClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class camera_GUI_main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camera_GUI_main frame = new camera_GUI_main();
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
	public camera_GUI_main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SMART CAMERA SERVICES");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 21));
		lblNewLabel.setBounds(93, 11, 304, 38);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(76, 143, 1, 1);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("TAKE SNAPSHOTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//dispose();
				camera_GUI_rpc_takeSnapshots instance = new camera_GUI_rpc_takeSnapshots();
				instance.setLocationRelativeTo(null);
				instance.setVisible(true);
			}
			
		});
		btnNewButton.setFont(new Font("Quicksand", Font.PLAIN, 13));
		btnNewButton.setBounds(94, 95, 259, 49);
		contentPane.add(btnNewButton);
		
		JButton btnRepositionCameraBy = new JButton("REPOSITION CAMERA BY ID");
		btnRepositionCameraBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				camera_GUI_rpc_repositionCamera instance = new camera_GUI_rpc_repositionCamera();
				instance.setLocationRelativeTo(null);
				instance.setVisible(true);
			}
		});
		btnRepositionCameraBy.setFont(new Font("Quicksand", Font.PLAIN, 13));
		btnRepositionCameraBy.setBounds(93, 157, 259, 49);
		contentPane.add(btnRepositionCameraBy);
		
		JButton btnGetCameraStatus = new JButton("GET CAMERA STATUS");
		btnGetCameraStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				camera_GUI_rpc_getCameraStatus instance = new camera_GUI_rpc_getCameraStatus();
				instance.setLocationRelativeTo(null);
				instance.setVisible(true);
			}
		});
		btnGetCameraStatus.setFont(new Font("Quicksand", Font.PLAIN, 13));
		btnGetCameraStatus.setBounds(93, 222, 259, 49);
		contentPane.add(btnGetCameraStatus);
	}
}
