package lightClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.lightService.lightServiceGrpc;
import smartsec.lightService.LightService.lightRequest;
import smartsec.lightService.LightService.lightResponse;
import smartsec.lightService.lightServiceGrpc.lightServiceStub;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.jmdns.ServiceInfo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;

public class light_GUI_rpc extends JFrame {

	private JPanel contentPane;
	public static List<lightRequest> lightReqList = new ArrayList<lightRequest>();
	public static List<String> lightResList = new ArrayList<String>();
	public static String host = "localhost";
	public static int port;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {

				
				try {
					light_GUI_rpc frame = new light_GUI_rpc();
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
	public light_GUI_rpc() {
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		port = serviceInfo.getPort();
		host = "localhost";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("On/Off Light RPC");
		lblNewLabel.setFont(new Font("Quicksand", Font.BOLD, 21));
		lblNewLabel.setBounds(151, 21, 189, 53);
		contentPane.add(lblNewLabel);
		
		JComboBox idComboBox = new JComboBox();
		
		idComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		
		idComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		idComboBox.setBounds(109, 148, 71, 31);
		contentPane.add(idComboBox);
		
		JComboBox actionComboBox = new JComboBox();
		actionComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		actionComboBox.setModel(new DefaultComboBoxModel(new String[] {"on", "off"}));
		actionComboBox.setBounds(278, 148, 102, 31);
		contentPane.add(actionComboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Select Light Id");
		lblNewLabel_1.setFont(new Font("Quicksand", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(109, 123, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Action");
		lblNewLabel_2.setFont(new Font("Quicksand", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(278, 123, 125, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("UPDATE STATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get the Light Id
				int id = Integer.parseInt(idComboBox.getSelectedItem().toString());
				
				//Get the Action to Perform
				String action = actionComboBox.getSelectedItem().toString();
				
				System.out.println("id: "+id+", action: "+action);
				//Add the lightRquest to the ArrayList of Requests
				lightReqList.add(lightRequest.newBuilder().setId(id).setAction(action).build());
				
				int option = JOptionPane.showConfirmDialog(rootPane, "Do you want to update another light state?", "CONFIRM", JOptionPane.YES_NO_OPTION);
				
				if(option == 0) {
					System.out.println("Yes");
					idComboBox.setSelectedIndex(0);
					actionComboBox.setSelectedIndex(0);
				}else {
					System.out.println("No");
					System.out.println(lightReqList);
					//do the sending
					
					ManagedChannel channel = ManagedChannelBuilder.
							forAddress(host, port)
							.usePlaintext()
							.build();
					
					
					lightServiceStub  asyncStub = lightServiceGrpc.newStub(channel);
					
					final CountDownLatch finishLatch = new CountDownLatch(1);
					 
			        StreamObserver<lightRequest> requestObserver = asyncStub.onOffLight(new StreamObserver<lightResponse>() {
			            public void onNext(lightResponse lightStatus) {
			                System.out.println(lightStatus.getStatus());
			                lightResList.add(lightStatus.getStatus()); //Add response to list of responses
			                
			            }

			            public void onError(Throwable th) {
			                th.printStackTrace();
			                finishLatch.countDown();
			            }

			            public void onCompleted() {
			                System.out.println("Completed!");
			                String fullDetail = "";
			                for(String status: lightResList) {
			                	fullDetail += "\n\n"+status;
			                }
			                
			                fullDetail += "\n\n";
			                
			                finishLatch.countDown();
			                
			                JOptionPane.showMessageDialog(rootPane, fullDetail, "INFO", JOptionPane.INFORMATION_MESSAGE);
			                
			                dispose();
			                light_GUI_main instance = new light_GUI_main();
			                instance.setLocationRelativeTo(null);
			                instance.setVisible(true);
			            }
			        });
			        
			        try {
			            for (lightRequest lr : lightReqList) {
			                requestObserver.onNext(lr);
			            }
			            
			            requestObserver.onCompleted();
			            // Receiving happens asynchronously
			            finishLatch.await(1, TimeUnit.MINUTES);
			            
			        } catch (Exception ex) {
			            requestObserver.onError(ex);
			        }finally {
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
		btnNewButton.setFont(new Font("Quicksand", Font.BOLD, 14));
		btnNewButton.setBounds(177, 229, 140, 53);
		contentPane.add(btnNewButton);
	}
}
