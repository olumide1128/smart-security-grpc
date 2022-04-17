package alarmClient;

import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.alarmService.AlaramService.alarmResponse;
import smartsec.alarmService.alarmServiceGrpc;
import smartsec.alarmService.alarmServiceGrpc.alarmServiceBlockingStub;


public class alarm_client {
	
	public static void main(String[] args) throws Exception {
		
		ServiceInfo serviceInfo;
		String service_type = "_http._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		ManagedChannel channel = ManagedChannelBuilder.
				forAddress(host, port)
				.usePlaintext()
				.build();
		
		
		alarmServiceBlockingStub  blockingStub = alarmServiceGrpc.newBlockingStub(channel);
	    
		
	    try {
	
	    	 alarmResponse response = blockingStub.activateAlarm(Empty.getDefaultInstance());
	    	 
	    	 System.out.println(response.getMsg());
	    	 
	    } catch (StatusRuntimeException e) {
		    System.out.println("RPC failed: "+ e.getStatus().getDescription());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	    
	}
}
