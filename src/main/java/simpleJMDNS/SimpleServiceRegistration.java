package simpleJMDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class SimpleServiceRegistration {

	public void run(int port, String service_type, String service_name) {

		//get a jMDNS instance
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			/*
			 * service information
			 */
			
			//the assumption is that we are registering a grpc server
			//service_type = "_grpc._tcp.local.";				//service-type.domain
			// service_name + service_type => simple_http._tcp.local
			//String service_name = "GrpcServer";							
			int service_port = port;
			String service_desc = "test integration of jmDNS with gRPC";
				
			
			//Create ServiceInfo - 
			//use the factory method to create the object			
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
			
			/*
			 * register the service
			 */
			
			jmdns.registerService(serviceInfo);
			
			System.out.printf("registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
			
			//sleep for 10 seconds
			Thread.sleep(10000);
			System.out.println("\nService Registered");
			//unregister the services
			//jmdns.unregisterAllServices();   //you could also unregister a single service
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
