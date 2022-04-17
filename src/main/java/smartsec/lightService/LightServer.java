package smartsec.lightService;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import simpleJMDNS.SimpleServiceRegistration;

public class LightServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 50052;
		String service_type = "_http._tcp.local.";
		String service_name = "lightGrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(new lightServiceImpl())
			    .build()
			    .start();
			System.out.println("\nLight Server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("Light Server started, listening on " + port);
	}

}
