//package com.github.conanchen.gedit.district.grpc;
//
//import com.github.conanchen.gedit.common.grpc.LogInterceptor;
//import com.google.gson.Gson;
//import org.lognet.springboot.grpc.GRpcService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.text.SimpleDateFormat;
//
//@GRpcService(interceptors = {LogInterceptor.class})
//public class DistrictService extends DistrictApiGrpc.DistrictApiImplBase {
//    private static final Logger log = LoggerFactory.getLogger(DistrictService.class);
//    private static final Gson gson = new Gson();
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    @Override
//    public void upsert(UpsertDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
//        super.upsert(request, responseObserver);
//    }
//
//    @Override
//    public void getTop(GetTopDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
//        super.getTop(request, responseObserver);
//    }
//
//    @Override
//    public void listChild(ListChildDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
//        super.listChild(request, responseObserver);
//    }
//
//    @Override
//    public void list(ListDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
//        super.list(request, responseObserver);
//    }
//}