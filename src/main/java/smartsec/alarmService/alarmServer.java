package smartsec.alarmService;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import simpleJMDNS.SimpleServiceRegistration;
import smartsec.lightService.lightServiceImpl;

public class alarmServer {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 50053;
		String service_type = "_http._tcp.local.";
		String service_name = "alarmGrpcServer";
		SimpleServiceRegistration ssr = new SimpleServiceRegistration();
		ssr.run(port, service_type, service_name);
		
	    
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(new alarmServiceImpl())
			    .build()
			    .start();
			System.out.println("\nAlarm Server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    System.out.println("Alarm Server started, listening on " + port);
	}
}
