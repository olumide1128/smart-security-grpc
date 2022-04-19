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
import smartsec.cameraService.CameraService.camera;
import smartsec.cameraService.CameraService.cameraRequest;
import smartsec.cameraService.cameraServiceGrpc;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceBlockingStub;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.jmdns.ServiceInfo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class camera_GUI_rpc_getCameraStatus extends JFrame {

	private JPanel contentPane;
	public static String host = "localhost";
	public static int port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camera_GUI_rpc_getCameraStatus frame = new camera_GUI_rpc_getCameraStatus();
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
	public camera_GUI_rpc_getCameraStatus() {
		
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GET CAMERA STATUS");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 19));
		lblNewLabel.setBounds(117, 11, 208, 41);
		contentPane.add(lblNewLabel);
		
		JComboBox idComboBox = new JComboBox();
		idComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		idComboBox.setBounds(169, 126, 95, 41);
		contentPane.add(idComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Quicksand", Font.BOLD, 15));
		lblNewLabel_1.setBounds(209, 101, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton getBtn = new JButton("GET STATUS");
		getBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
				
				ManagedChannel channel = ManagedChannelBuilder.
						forAddress(host, port)
						.usePlaintext()
						.build();
				
				
				cameraServiceBlockingStub  blockingStub = cameraServiceGrpc.newBlockingStub(channel);
				
			    try {
			    	 cameraRequest request = cameraRequest.newBuilder().setCameraId(id).build();
			    	 
			    	 camera response = blockingStub.getCameraStatusById(request);
			    	 
			    	 JOptionPane.showMessageDialog(rootPane, response, "RESPONSE", JOptionPane.INFORMATION_MESSAGE);
			    	 
			    } catch (StatusRuntimeException ex) {
				    String errmsg = "RPC failed: "+ ex.getStatus().getDescription();
				    JOptionPane.showMessageDialog(rootPane, errmsg, "Error", JOptionPane.ERROR_MESSAGE);
				    
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
		});
		getBtn.setFont(new Font("Quicksand", Font.BOLD, 17));
		getBtn.setBounds(50, 211, 178, 55);
		contentPane.add(getBtn);
		
		JButton btnGoHome = new JButton("GO HOME");
		btnGoHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				camera_GUI_main instance = new camera_GUI_main();
                instance.setLocationRelativeTo(null);
                instance.setVisible(true);
			}
			
		});
		btnGoHome.setFont(new Font("Quicksand", Font.BOLD, 17));
		btnGoHome.setBounds(238, 211, 156, 55);
		contentPane.add(btnGoHome);
	}

}
