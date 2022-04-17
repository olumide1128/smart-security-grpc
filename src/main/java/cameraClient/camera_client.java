package cameraClient;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.jmdns.ServiceInfo;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.cameraService.CameraService.*;
import smartsec.cameraService.cameraServiceGrpc;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceBlockingStub;

public class camera_client {
	
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
		
		
		cameraServiceBlockingStub  blockingStub = cameraServiceGrpc.newBlockingStub(channel);
	    
		/*
	    try {
	    	 positionRequest request = positionRequest.newBuilder().setCameraId(3).setPan("hda").setTilt("98").setRotation("200").build();
	    	 
	    	 positionResponse response = blockingStub.repositionCameraById(request);
	    	 
	    	 System.out.println(response);
	    	 
	    } catch (StatusRuntimeException e) {
		    System.out.println("RPC failed: "+ e.getStatus().getDescription());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	    */
		
		Iterator<imgDetail> b64_strings;
		
		try {
		  b64_strings = blockingStub.takeSnapshotOfAllCameras(Empty.getDefaultInstance());
		  
		  while(b64_strings.hasNext()) {
			  System.out.println(b64_strings.next().getImgBase64());
		  }
		  
		} catch (StatusRuntimeException e) {
		  System.out.println("RPC failed: "+ e.getMessage());
		  
		  return;
		} finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }
	  }
}
