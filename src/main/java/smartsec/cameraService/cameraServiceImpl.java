package smartsec.cameraService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Empty;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import smartsec.cameraService.CameraService.camera;
import smartsec.cameraService.CameraService.cameraRequest;
import smartsec.cameraService.CameraService.imgDetail;
import smartsec.cameraService.CameraService.positionRequest;
import smartsec.cameraService.CameraService.positionResponse;
import smartsec.cameraService.cameraServiceGrpc.cameraServiceImplBase;

public class cameraServiceImpl extends cameraServiceImplBase{

	@Override
	public void takeSnapshotOfAllCameras(Empty request, StreamObserver<imgDetail> responseObserver) {
		// TODO Auto-generated method stub
        ArrayList<String> imgStrings = CameraDataService.takeSnapshots();
        
        if(imgStrings == null) {
	           Metadata metadata = new Metadata();
	            responseObserver.onError(
	                    Status.UNAVAILABLE.withDescription("Error Occured when trying to take snapshot!")
	                            .asRuntimeException(metadata));
        }else {
            for (String imgString : imgStrings) {
            	imgDetail bstr = imgDetail.newBuilder().setImgBase64(imgString).build();
                responseObserver.onNext(bstr);
            }
            responseObserver.onCompleted();
        }
        

	}

	@Override
	public void repositionCameraById(positionRequest request, StreamObserver<positionResponse> responseObserver) {
		// TODO Auto-generated method stub
		
		CameraDataService cds = new CameraDataService(); //This would load the cameraJSON to the JSONArray
		String result = cds.updateCameraPosition(request.getCameraId(), request.getPan(), request.getTilt(), request.getRotation());
		
		if(result == "Id not found!") {
	           Metadata metadata = new Metadata();
	            responseObserver.onError(
	                    Status.UNAVAILABLE.withDescription("Camera with id "+request.getCameraId()+" does not exist!")
	                            .asRuntimeException(metadata));
		}else if(result == "Error updating position!") {
	           Metadata metadata = new Metadata();
	            responseObserver.onError(
	                    Status.UNAVAILABLE.withDescription("Error updating position for Camera with Id "+request.getCameraId())
	                            .asRuntimeException(metadata));
		}else if(result == "Position Properties must be Number!") {
	           Metadata metadata = new Metadata();
	            responseObserver.onError(
	                    Status.UNAVAILABLE.withDescription("Position Properties must be Number!")
	                            .asRuntimeException(metadata));
		}else {
			positionResponse res = positionResponse.newBuilder().setResponseMsg(result).build();
			
	        responseObserver.onNext(res);
	        responseObserver.onCompleted();
		}

		
	}

	
	@Override
	public void getCameraStatusById(cameraRequest request, StreamObserver<camera> responseObserver) {
		// TODO Auto-generated method stub
		CameraDataService cds = new CameraDataService(); //This would load the cameraJSON to the JSONArray
		camera camStatus = cds.getCameraStatus(request.getCameraId());
		
		if(camStatus == null){
	           Metadata metadata = new Metadata();
	            responseObserver.onError(
	                    Status.UNAVAILABLE.withDescription("Camera with id "+request.getCameraId()+" does not exist!")
	                            .asRuntimeException(metadata));
		}else {
	        responseObserver.onNext(camStatus);
	        responseObserver.onCompleted();
		}

		
	}
	
	
}
