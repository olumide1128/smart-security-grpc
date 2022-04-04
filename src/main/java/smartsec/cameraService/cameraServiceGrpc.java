package smartsec.cameraService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: camera_service.proto")
public final class cameraServiceGrpc {

  private cameraServiceGrpc() {}

  public static final String SERVICE_NAME = "cameraService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      smartsec.cameraService.CameraService.imgDetail> getTakeSnapshotOfAllCamerasMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "takeSnapshotOfAllCameras",
      requestType = com.google.protobuf.Empty.class,
      responseType = smartsec.cameraService.CameraService.imgDetail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      smartsec.cameraService.CameraService.imgDetail> getTakeSnapshotOfAllCamerasMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, smartsec.cameraService.CameraService.imgDetail> getTakeSnapshotOfAllCamerasMethod;
    if ((getTakeSnapshotOfAllCamerasMethod = cameraServiceGrpc.getTakeSnapshotOfAllCamerasMethod) == null) {
      synchronized (cameraServiceGrpc.class) {
        if ((getTakeSnapshotOfAllCamerasMethod = cameraServiceGrpc.getTakeSnapshotOfAllCamerasMethod) == null) {
          cameraServiceGrpc.getTakeSnapshotOfAllCamerasMethod = getTakeSnapshotOfAllCamerasMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, smartsec.cameraService.CameraService.imgDetail>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "cameraService", "takeSnapshotOfAllCameras"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.cameraService.CameraService.imgDetail.getDefaultInstance()))
                  .setSchemaDescriptor(new cameraServiceMethodDescriptorSupplier("takeSnapshotOfAllCameras"))
                  .build();
          }
        }
     }
     return getTakeSnapshotOfAllCamerasMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.positionRequest,
      smartsec.cameraService.CameraService.positionResponse> getRepositionCameraByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "repositionCameraById",
      requestType = smartsec.cameraService.CameraService.positionRequest.class,
      responseType = smartsec.cameraService.CameraService.positionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.positionRequest,
      smartsec.cameraService.CameraService.positionResponse> getRepositionCameraByIdMethod() {
    io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.positionRequest, smartsec.cameraService.CameraService.positionResponse> getRepositionCameraByIdMethod;
    if ((getRepositionCameraByIdMethod = cameraServiceGrpc.getRepositionCameraByIdMethod) == null) {
      synchronized (cameraServiceGrpc.class) {
        if ((getRepositionCameraByIdMethod = cameraServiceGrpc.getRepositionCameraByIdMethod) == null) {
          cameraServiceGrpc.getRepositionCameraByIdMethod = getRepositionCameraByIdMethod = 
              io.grpc.MethodDescriptor.<smartsec.cameraService.CameraService.positionRequest, smartsec.cameraService.CameraService.positionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cameraService", "repositionCameraById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.cameraService.CameraService.positionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.cameraService.CameraService.positionResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new cameraServiceMethodDescriptorSupplier("repositionCameraById"))
                  .build();
          }
        }
     }
     return getRepositionCameraByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.cameraRequest,
      smartsec.cameraService.CameraService.camera> getGetCameraStatusByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCameraStatusById",
      requestType = smartsec.cameraService.CameraService.cameraRequest.class,
      responseType = smartsec.cameraService.CameraService.camera.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.cameraRequest,
      smartsec.cameraService.CameraService.camera> getGetCameraStatusByIdMethod() {
    io.grpc.MethodDescriptor<smartsec.cameraService.CameraService.cameraRequest, smartsec.cameraService.CameraService.camera> getGetCameraStatusByIdMethod;
    if ((getGetCameraStatusByIdMethod = cameraServiceGrpc.getGetCameraStatusByIdMethod) == null) {
      synchronized (cameraServiceGrpc.class) {
        if ((getGetCameraStatusByIdMethod = cameraServiceGrpc.getGetCameraStatusByIdMethod) == null) {
          cameraServiceGrpc.getGetCameraStatusByIdMethod = getGetCameraStatusByIdMethod = 
              io.grpc.MethodDescriptor.<smartsec.cameraService.CameraService.cameraRequest, smartsec.cameraService.CameraService.camera>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "cameraService", "getCameraStatusById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.cameraService.CameraService.cameraRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.cameraService.CameraService.camera.getDefaultInstance()))
                  .setSchemaDescriptor(new cameraServiceMethodDescriptorSupplier("getCameraStatusById"))
                  .build();
          }
        }
     }
     return getGetCameraStatusByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static cameraServiceStub newStub(io.grpc.Channel channel) {
    return new cameraServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static cameraServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new cameraServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static cameraServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new cameraServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class cameraServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void takeSnapshotOfAllCameras(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.imgDetail> responseObserver) {
      asyncUnimplementedUnaryCall(getTakeSnapshotOfAllCamerasMethod(), responseObserver);
    }

    /**
     */
    public void repositionCameraById(smartsec.cameraService.CameraService.positionRequest request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.positionResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRepositionCameraByIdMethod(), responseObserver);
    }

    /**
     */
    public void getCameraStatusById(smartsec.cameraService.CameraService.cameraRequest request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.camera> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCameraStatusByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTakeSnapshotOfAllCamerasMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                smartsec.cameraService.CameraService.imgDetail>(
                  this, METHODID_TAKE_SNAPSHOT_OF_ALL_CAMERAS)))
          .addMethod(
            getRepositionCameraByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smartsec.cameraService.CameraService.positionRequest,
                smartsec.cameraService.CameraService.positionResponse>(
                  this, METHODID_REPOSITION_CAMERA_BY_ID)))
          .addMethod(
            getGetCameraStatusByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                smartsec.cameraService.CameraService.cameraRequest,
                smartsec.cameraService.CameraService.camera>(
                  this, METHODID_GET_CAMERA_STATUS_BY_ID)))
          .build();
    }
  }

  /**
   */
  public static final class cameraServiceStub extends io.grpc.stub.AbstractStub<cameraServiceStub> {
    private cameraServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cameraServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cameraServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cameraServiceStub(channel, callOptions);
    }

    /**
     */
    public void takeSnapshotOfAllCameras(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.imgDetail> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTakeSnapshotOfAllCamerasMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void repositionCameraById(smartsec.cameraService.CameraService.positionRequest request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.positionResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRepositionCameraByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCameraStatusById(smartsec.cameraService.CameraService.cameraRequest request,
        io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.camera> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCameraStatusByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class cameraServiceBlockingStub extends io.grpc.stub.AbstractStub<cameraServiceBlockingStub> {
    private cameraServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cameraServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cameraServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cameraServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<smartsec.cameraService.CameraService.imgDetail> takeSnapshotOfAllCameras(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getTakeSnapshotOfAllCamerasMethod(), getCallOptions(), request);
    }

    /**
     */
    public smartsec.cameraService.CameraService.positionResponse repositionCameraById(smartsec.cameraService.CameraService.positionRequest request) {
      return blockingUnaryCall(
          getChannel(), getRepositionCameraByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public smartsec.cameraService.CameraService.camera getCameraStatusById(smartsec.cameraService.CameraService.cameraRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCameraStatusByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class cameraServiceFutureStub extends io.grpc.stub.AbstractStub<cameraServiceFutureStub> {
    private cameraServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private cameraServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected cameraServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new cameraServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartsec.cameraService.CameraService.positionResponse> repositionCameraById(
        smartsec.cameraService.CameraService.positionRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRepositionCameraByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartsec.cameraService.CameraService.camera> getCameraStatusById(
        smartsec.cameraService.CameraService.cameraRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCameraStatusByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TAKE_SNAPSHOT_OF_ALL_CAMERAS = 0;
  private static final int METHODID_REPOSITION_CAMERA_BY_ID = 1;
  private static final int METHODID_GET_CAMERA_STATUS_BY_ID = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final cameraServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(cameraServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TAKE_SNAPSHOT_OF_ALL_CAMERAS:
          serviceImpl.takeSnapshotOfAllCameras((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.imgDetail>) responseObserver);
          break;
        case METHODID_REPOSITION_CAMERA_BY_ID:
          serviceImpl.repositionCameraById((smartsec.cameraService.CameraService.positionRequest) request,
              (io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.positionResponse>) responseObserver);
          break;
        case METHODID_GET_CAMERA_STATUS_BY_ID:
          serviceImpl.getCameraStatusById((smartsec.cameraService.CameraService.cameraRequest) request,
              (io.grpc.stub.StreamObserver<smartsec.cameraService.CameraService.camera>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class cameraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    cameraServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smartsec.cameraService.CameraService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("cameraService");
    }
  }

  private static final class cameraServiceFileDescriptorSupplier
      extends cameraServiceBaseDescriptorSupplier {
    cameraServiceFileDescriptorSupplier() {}
  }

  private static final class cameraServiceMethodDescriptorSupplier
      extends cameraServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    cameraServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (cameraServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new cameraServiceFileDescriptorSupplier())
              .addMethod(getTakeSnapshotOfAllCamerasMethod())
              .addMethod(getRepositionCameraByIdMethod())
              .addMethod(getGetCameraStatusByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
