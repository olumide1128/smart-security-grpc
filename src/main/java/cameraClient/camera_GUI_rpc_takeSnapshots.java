package cameraClient;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.jmdns.ServiceInfo;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.cameraService.cameraServiceGrpc;
import smartsec.cameraService.CameraService.imgDetail;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceBlockingStub;

public class camera_GUI_rpc_takeSnapshots extends JFrame {

	private static JPanel contentPane;
	public static String host = "localhost";
	public static int port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					camera_GUI_rpc_takeSnapshots frame = new camera_GUI_rpc_takeSnapshots();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public camera_GUI_rpc_takeSnapshots(){
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		port = serviceInfo.getPort();
		host = "localhost";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(new GridLayout(2,3,10,20));
		
		try {
			loadAllImagesInPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //This called a method to convert to img and load them in the JPanel
		    
		setContentPane(contentPane);	
		pack();
      
	}
	
	//Method to load Images
	public static void loadAllImagesInPanel() throws IOException {
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		
		cameraServiceBlockingStub  blockingStub = cameraServiceGrpc.newBlockingStub(channel);
		
		Iterator<imgDetail> b64_strings;
		
		try {
		  b64_strings = blockingStub.takeSnapshotOfAllCameras(Empty.getDefaultInstance());
		  
		  int count = 0;
		  
		  while(b64_strings.hasNext()) {
			  	count ++; //increment count
			  	
			  	String baseString = b64_strings.next().getImgBase64();
				BufferedImage img = Base64ToImg(baseString); //Convert string to BufferedImage
				
				//ImageIcon icon = new ImageIcon("images/shirt.jpg");
				ImageIcon icon = new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_DEFAULT));
				
				JLabel label = new JLabel(icon);
				label.setText("Cam "+count);
				label.setHorizontalTextPosition(JLabel.CENTER);
				label.setVerticalTextPosition(JLabel.BOTTOM);
				  
				//add labels to panel
				contentPane.add(label);
		  }
		  
		} catch (StatusRuntimeException ex) {
		    String errmsg = "RPC failed: "+ ex.getStatus().getDescription();
		    JOptionPane.showMessageDialog(null, errmsg, "Error", JOptionPane.ERROR_MESSAGE);
		  
		  return;
		} finally {
	    	//shutdown channel
	    	try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
	}
	
	
    public static BufferedImage Base64ToImg(String img_string) throws IOException{
        
        BufferedImage image = null;
        byte[] imageByte;
        
        //Decode string
        imageByte = Base64.getDecoder().decode(img_string);
        
        // create a buffered image
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
        
        return image;
          
    
    }

}
