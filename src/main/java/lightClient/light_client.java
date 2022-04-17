package lightClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.jmdns.ServiceInfo;
import javax.swing.JOptionPane;

import com.google.protobuf.Empty;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import simpleJMDNS.SimpleServiceDiscovery;
import smartsec.cameraService.cameraServiceGrpc;
import smartsec.cameraService.CameraService.imgDetail;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceBlockingStub;
import smartsec.lightService.LightService.lightRequest;
import smartsec.lightService.LightService.lightResponse;
import smartsec.lightService.lightServiceGrpc;
import smartsec.lightService.lightServiceGrpc.lightServiceStub;

public class light_client {
	
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
		
		
		lightServiceStub  asyncStub = lightServiceGrpc.newStub(channel);
	    
		
		List<lightRequest> lightReqList = new ArrayList<lightRequest>();
		
		lightReqList.add(lightRequest.newBuilder().setId(1).setAction("on").build());
		lightReqList.add(lightRequest.newBuilder().setId(3).setAction("off").build());
		
		final CountDownLatch finishLatch = new CountDownLatch(1);
		 
        StreamObserver<lightRequest> requestObserver = asyncStub.onOffLight(new StreamObserver<lightResponse>() {
            public void onNext(lightResponse lightStatus) {
                System.out.println(lightStatus.getStatus());
                JOptionPane.showMessageDialog(null, lightStatus.getStatus());
            }

            public void onError(Throwable th) {
                th.printStackTrace();
                finishLatch.countDown();
            }

            public void onCompleted() {
                System.out.println("Completed!");
                finishLatch.countDown();
            }
        });
        
        
        //user entering data in stream fashion
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
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        
        
        
       
		

	  }
}
