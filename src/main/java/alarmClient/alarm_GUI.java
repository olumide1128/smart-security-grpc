package alarmClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.alarmService.alarmServiceGrpc;
import smartsec.alarmService.AlaramService.alarmResponse;
import smartsec.alarmService.alarmServiceGrpc.alarmServiceBlockingStub;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.jmdns.ServiceInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class alarm_GUI extends JFrame {

	private JPanel contentPane;
	public static ManagedChannel channel;
	public static String host = "localhost";
	public static int port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
		
				try {
					alarm_GUI frame = new alarm_GUI();
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
	public alarm_GUI() {
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		port = serviceInfo.getPort();
		host = "localhost";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton activateBtn = new JButton("Activate Alarm");
		
		activateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				channel = ManagedChannelBuilder.
						forAddress(host, port)
						.usePlaintext()
						.build();
				
				alarmServiceBlockingStub  blockingStub = alarmServiceGrpc.newBlockingStub(channel);
			    
				
			    try {
			    	 alarmResponse response = blockingStub.activateAlarm(Empty.getDefaultInstance());
			    	 
			    	 System.out.println(response.getMsg());
			    	 JOptionPane.showMessageDialog(rootPane, response.getMsg(), "INFO", JOptionPane.INFORMATION_MESSAGE);
			    	 
			    } catch (StatusRuntimeException ex) {
				    System.out.println("RPC failed: "+ ex.getStatus().getDescription());
				    JOptionPane.showMessageDialog(rootPane, ex.getStatus().getDescription(), "ERROR", JOptionPane.ERROR_MESSAGE);
				    
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
		
		
		activateBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		activateBtn.setBounds(114, 150, 238, 65);
		contentPane.add(activateBtn);
		
		JLabel lblNewLabel = new JLabel("ALARM SERVICES");
		lblNewLabel.setBounds(139, 27, 185, 31);
		lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
	}

}
