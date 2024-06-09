package com.javaded.service;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import com.javaded.grpccommon.DataServerGrpc;
import com.javaded.grpccommon.GRPCData;
import com.javaded.grpccommon.MeasurementType;
import com.javaded.model.Data;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;

@Service
public class GRPCDataServiceImpl implements GRPCDataService {

    @GrpcClient(value = "data-generator-blocking")
    private DataServerGrpc.DataServerBlockingStub blockingStub;

    @GrpcClient(value = "data-generator-async")
    private DataServerGrpc.DataServerStub asyncStub;

    @Override
    public void send(Data data) {
//        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
//            @Override
//            public void onNext(Empty empty) {
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//            }
//
//            @Override
//            public void onCompleted() {
//            }
//        };
        GRPCData request = build(data);
        blockingStub.addData(request);
//        asyncStub.addData(request, responseObserver);
    }

    private GRPCData build(Data data) {
        return GRPCData.newBuilder()
                .setSensorId(data.getSensorId())
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setSeconds(
                                        data.getTimestamp()
                                                .toEpochSecond(ZoneOffset.UTC)
                                )
                                .build())
                .setMeasurementType(
                        MeasurementType.valueOf(data.getMeasurementType().name())
                )
                .setMeasurement(data.getMeasurement())
                .build();
    }

    @Override
    public void send(List<Data> data) {
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty empty) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };

        StreamObserver<GRPCData> requestObserver = asyncStub.addStreamOfData(responseObserver);
        data.forEach(elem -> requestObserver.onNext(build(elem)));
        requestObserver.onCompleted();
    }

}
