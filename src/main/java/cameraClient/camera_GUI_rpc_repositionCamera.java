package cameraClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.cameraService.cameraServiceGrpc;
import smartsec.cameraService.CameraService.positionRequest;
import smartsec.cameraService.CameraService.positionResponse;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceBlockingStub;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.jmdns.ServiceInfo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class camera_GUI_rpc_repositionCamera extends JFrame {

	private JPanel contentPane;
	private JTextField panField;
	private JTextField tiltField;
	private JTextField rotationField;
	public static String host = "localhost";
	public static int port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camera_GUI_rpc_repositionCamera frame = new camera_GUI_rpc_repositionCamera();
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
	public camera_GUI_rpc_repositionCamera() {
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		port = serviceInfo.getPort();
		host = "localhost";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REPOSITION CAMERA");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 11, 210, 46);
		contentPane.add(lblNewLabel);
		
		panField = new JTextField();
		panField.setBounds(118, 145, 86, 31);
		contentPane.add(panField);
		panField.setColumns(10);
		
		tiltField = new JTextField();
		tiltField.setBounds(230, 145, 86, 31);
		contentPane.add(tiltField);
		tiltField.setColumns(10);
		
		rotationField = new JTextField();
		rotationField.setBounds(338, 145, 86, 31);
		contentPane.add(rotationField);
		rotationField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pan");
		lblNewLabel_1.setFont(new Font("Quicksand", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(118, 120, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tilt");
		lblNewLabel_2.setFont(new Font("Quicksand", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(230, 120, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rotation");
		lblNewLabel_3.setFont(new Font("Quicksand", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(338, 120, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox idComboBox = new JComboBox();
		idComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		idComboBox.setBounds(37, 145, 46, 31);
		contentPane.add(idComboBox);
		
		JLabel lblNewLabel_4 = new JLabel("id");
		lblNewLabel_4.setFont(new Font("Quicksand", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(37, 121, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton repoBtn = new JButton("REPOSITION");
		repoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
				String pan = panField.getText();
				String tilt = tiltField.getText();
				String rotation = rotationField.getText();
				
				if(pan.equals("") || tilt.equals("") || rotation.equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Must Fill all Fields!", "Warning", JOptionPane.WARNING_MESSAGE);
				}else {
					
					ManagedChannel channel = ManagedChannelBuilder.
							forAddress(host, port)
							.usePlaintext()
							.build();
					
					
					cameraServiceBlockingStub  blockingStub = cameraServiceGrpc.newBlockingStub(channel);
					
					try {
				    	 positionRequest request = positionRequest.newBuilder().setCameraId(id).setPan(pan).setTilt(tilt).setRotation(rotation).build();
				    	 
				    	 positionResponse response = blockingStub.repositionCameraById(request);
				    	 
				    	 JOptionPane.showMessageDialog(rootPane, response.getResponseMsg(), "Response", JOptionPane.INFORMATION_MESSAGE);
				    	 
				    	 //Reset Fields
				    	 panField.setText("");
				    	 tiltField.setText("");
				    	 rotationField.setText("");
				    	 idComboBox.setSelectedIndex(0);
				    	 
				    } catch (StatusRuntimeException ex) {
					    String errmsg = "RPC failed: "+ ex.getStatus().getDescription();
					    JOptionPane.showMessageDialog(rootPane, errmsg, "Error", JOptionPane.ERROR_MESSAGE);
					    
				    	 panField.setText("");
				    	 tiltField.setText("");
				    	 rotationField.setText("");
				    	 idComboBox.setSelectedIndex(0);
				    	 
					    return;		
					    
				    } finally {
				    	//shutdown channel
				    	try {
							channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    }
				}
				
			    
			}
		});
		repoBtn.setFont(new Font("Quicksand", Font.BOLD, 14));
		repoBtn.setBounds(103, 225, 130, 46);
		contentPane.add(repoBtn);
		
		JButton btnMain = new JButton("GO HOME");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				camera_GUI_main instance = new camera_GUI_main();
                instance.setLocationRelativeTo(null);
                instance.setVisible(true);
			}
		});
		btnMain.setFont(new Font("Quicksand", Font.BOLD, 14));
		btnMain.setBounds(243, 225, 122, 46);
		contentPane.add(btnMain);
	}
}
