package smartsec.lightService;

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
    comments = "Source: light_service.proto")
public final class lightServiceGrpc {

  private lightServiceGrpc() {}

  public static final String SERVICE_NAME = "lightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<smartsec.lightService.LightService.lightRequest,
      smartsec.lightService.LightService.lightResponse> getOnOffLightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "onOffLight",
      requestType = smartsec.lightService.LightService.lightRequest.class,
      responseType = smartsec.lightService.LightService.lightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<smartsec.lightService.LightService.lightRequest,
      smartsec.lightService.LightService.lightResponse> getOnOffLightMethod() {
    io.grpc.MethodDescriptor<smartsec.lightService.LightService.lightRequest, smartsec.lightService.LightService.lightResponse> getOnOffLightMethod;
    if ((getOnOffLightMethod = lightServiceGrpc.getOnOffLightMethod) == null) {
      synchronized (lightServiceGrpc.class) {
        if ((getOnOffLightMethod = lightServiceGrpc.getOnOffLightMethod) == null) {
          lightServiceGrpc.getOnOffLightMethod = getOnOffLightMethod = 
              io.grpc.MethodDescriptor.<smartsec.lightService.LightService.lightRequest, smartsec.lightService.LightService.lightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "lightService", "onOffLight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.lightService.LightService.lightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  smartsec.lightService.LightService.lightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new lightServiceMethodDescriptorSupplier("onOffLight"))
                  .build();
          }
        }
     }
     return getOnOffLightMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static lightServiceStub newStub(io.grpc.Channel channel) {
    return new lightServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static lightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new lightServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static lightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new lightServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class lightServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<smartsec.lightService.LightService.lightRequest> onOffLight(
        io.grpc.stub.StreamObserver<smartsec.lightService.LightService.lightResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getOnOffLightMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOnOffLightMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                smartsec.lightService.LightService.lightRequest,
                smartsec.lightService.LightService.lightResponse>(
                  this, METHODID_ON_OFF_LIGHT)))
          .build();
    }
  }

  /**
   */
  public static final class lightServiceStub extends io.grpc.stub.AbstractStub<lightServiceStub> {
    private lightServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<smartsec.lightService.LightService.lightRequest> onOffLight(
        io.grpc.stub.StreamObserver<smartsec.lightService.LightService.lightResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getOnOffLightMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class lightServiceBlockingStub extends io.grpc.stub.AbstractStub<lightServiceBlockingStub> {
    private lightServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class lightServiceFutureStub extends io.grpc.stub.AbstractStub<lightServiceFutureStub> {
    private lightServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private lightServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected lightServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new lightServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ON_OFF_LIGHT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final lightServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(lightServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ON_OFF_LIGHT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.onOffLight(
              (io.grpc.stub.StreamObserver<smartsec.lightService.LightService.lightResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class lightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    lightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return smartsec.lightService.LightService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("lightService");
    }
  }

  private static final class lightServiceFileDescriptorSupplier
      extends lightServiceBaseDescriptorSupplier {
    lightServiceFileDescriptorSupplier() {}
  }

  private static final class lightServiceMethodDescriptorSupplier
      extends lightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    lightServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (lightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new lightServiceFileDescriptorSupplier())
              .addMethod(getOnOffLightMethod())
              .build();
        }
      }
    }
    return result;
  }
}
