package smartsec.alarmService;

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
    comments = "Source: alaram_service.proto")
public final class alarmServiceGrpc {

  private alarmServiceGrpc() {}

  public static final String SERVICE_NAME = "alarmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      smartsec.alarmService.AlaramService.alarmResponse> getActivateAlarmMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "activateAlarm",
      requestType = com.google.protobuf.Empty.class,
      responseType = smartsec.alarmService.AlaramService.alarmResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      smartsec.alarmService.AlaramService.alarmResponse> getActivateAlarmMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, smartsec.alarmService.AlaramService.alarmResponse> getActivateAlarmMethod;
    if ((getActivateAlarmMethod = alarmServiceGrpc.getActivateAlarmMethod) == null) {
      synchronized (alarmServiceGrpc.class) {
        if ((getActivateAlarmMethod = alarmServiceGrpc.getActivateAlarmMethod) == null) {
          alarmServiceGrpc.getActivateAlarmMethod = getActivateAlarmMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, smartsec.alarmService.AlaramService.alarmResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "alarmService", "activateAlarm"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.alarmService.AlaramService.alarmResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new alarmServiceMethodDescriptorSupplier("activateAlarm"))
                  .build();
          }
        }
     }
     return getActivateAlarmMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static alarmServiceStub newStub(io.grpc.Channel channel) {
    return new alarmServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static alarmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new alarmServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static alarmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new alarmServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class alarmServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void activateAlarm(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<smartsec.alarmService.AlaramService.alarmResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getActivateAlarmMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getActivateAlarmMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                smartsec.alarmService.AlaramService.alarmResponse>(
                  this, METHODID_ACTIVATE_ALARM)))
          .build();
    }
  }

  /**
   */
  public static final class alarmServiceStub extends io.grpc.stub.AbstractStub<alarmServiceStub> {
    private alarmServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alarmServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alarmServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alarmServiceStub(channel, callOptions);
    }

    /**
     */
    public void activateAlarm(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<smartsec.alarmService.AlaramService.alarmResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getActivateAlarmMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class alarmServiceBlockingStub extends io.grpc.stub.AbstractStub<alarmServiceBlockingStub> {
    private alarmServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alarmServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alarmServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alarmServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public smartsec.alarmService.AlaramService.alarmResponse activateAlarm(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getActivateAlarmMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class alarmServiceFutureStub extends io.grpc.stub.AbstractStub<alarmServiceFutureStub> {
    private alarmServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private alarmServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected alarmServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new alarmServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<smartsec.alarmService.AlaramService.alarmResponse> activateAlarm(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getActivateAlarmMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ACTIVATE_ALARM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final alarmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(alarmServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACTIVATE_ALARM:
          serviceImpl.activateAlarm((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<smartsec.alarmService.AlaramService.alarmResponse>) responseObserver);
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

  private static abstract class alarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    alarmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smartsec.alarmService.AlaramService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("alarmService");
    }
  }

  private static final class alarmServiceFileDescriptorSupplier
      extends alarmServiceBaseDescriptorSupplier {
    alarmServiceFileDescriptorSupplier() {}
  }

  private static final class alarmServiceMethodDescriptorSupplier
      extends alarmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    alarmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (alarmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new alarmServiceFileDescriptorSupplier())
              .addMethod(getActivateAlarmMethod())
              .build();
        }
      }
    }
    return result;
  }
}
