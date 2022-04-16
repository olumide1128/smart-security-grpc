package smartsec.lightService;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import smartsec.lightService.LightService.lightRequest;
import smartsec.lightService.LightService.lightResponse;
import smartsec.lightService.lightServiceGrpc.lightServiceImplBase;

public class lightServiceImpl extends lightServiceImplBase{

	@Override
	public StreamObserver<lightRequest> onOffLight(StreamObserver<lightResponse> responseObserver) {
		// TODO Auto-generated method stub
        return new StreamObserver<lightRequest>() {
            @Override
            public void onNext(lightRequest request) {
            	LightDataService lds = new LightDataService(); //Load the light json
                String lightState = lds.changeLightState(request.getId(), request.getAction());
                
        		if(lightState == "Id not found!") {
     	           Metadata metadata = new Metadata();
     	            responseObserver.onError(
     	                    Status.UNAVAILABLE.withDescription("Light with id "+request.getId()+" does not exist!")
     	                            .asRuntimeException(metadata));
        		}else if(lightState == "Error updating Light State!") {
     	           Metadata metadata = new Metadata();
     	            responseObserver.onError(
     	                    Status.UNAVAILABLE.withDescription("Error updating State for Light with Id "+request.getId())
     	                            .asRuntimeException(metadata));
        		}else {
                    lightResponse res = lightResponse.newBuilder().setStatus(lightState).build();
                    responseObserver.onNext(res);
        		}

            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
		
	}
	
	
}
