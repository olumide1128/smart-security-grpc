package smartsec.cameraService;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import simpleJMDNS.SimpleServiceRegistration;

public class cameraServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 50051;
		String service_type = "_http._tcp.local.";
		String service_name = "cameraGrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(new cameraServiceImpl())
			    .build()
			    .start();
			System.out.println("\nCamera Server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("Camera Server started, listening on " + port);
	}

}
