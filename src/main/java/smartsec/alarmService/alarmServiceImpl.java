package smartsec.alarmService;

import com.google.protobuf.Empty;

import io.grpc.stub.StreamObserver;
import smartsec.alarmService.AlaramService.alarmResponse;
import smartsec.alarmService.alarmServiceGrpc.alarmServiceImplBase;

public class alarmServiceImpl extends alarmServiceImplBase{

	@Override
	public void activateAlarm(Empty request, StreamObserver<alarmResponse> responseObserver) {
		// TODO Auto-generated method stub
		String msg = alarmDataService.activateAlarmSound();
		alarmResponse res = alarmResponse.newBuilder().setMsg(msg).build();
		
		responseObserver.onNext(res);
		responseObserver.onCompleted();
	}
	
	
}	
