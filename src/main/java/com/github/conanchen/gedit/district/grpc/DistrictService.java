package com.github.conanchen.gedit.district.grpc;

import com.github.conanchen.gedit.common.grpc.District;
import com.github.conanchen.gedit.common.grpc.Status;
import com.github.conanchen.gedit.repository.DistrictRepository;
import com.github.conanchen.gedit.repository.page.OffsetBasedPageRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

@GRpcService
@Slf4j
public class DistrictService extends DistrictApiGrpc.DistrictApiImplBase {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public void upsert(UpsertDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
        District district = request.getDistrict();
        com.github.conanchen.gedit.model.District districtModel = new com.github.conanchen.gedit.model.District();
        BeanUtils.copyProperties(district,districtModel);
        districtRepository.save(district);
        DistrictResponse.Builder responseBuilder = DistrictResponse.newBuilder();
        responseBuilder.setDistrict(district);
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void getTop(GetTopDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {


        responseObserver.onCompleted();
    }

    @Override
    public void listChild(ListChildDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
       Long parentId = request.getParentId();
       List<com.github.conanchen.gedit.model.District> districtList = districtRepository.findByPid(parentId);
       for (com.github.conanchen.gedit.model.District district : districtList){
           District.Builder responseDistrictBuild = District.newBuilder();
           responseDistrictBuild.setAdcode(district.getAdcode());
           responseDistrictBuild.setCenter(district.getCenter());
           responseDistrictBuild.setCitycode(district.getCitycode());
           responseDistrictBuild.setLevel(district.getLevel());
           responseDistrictBuild.setName(district.getName());
           responseDistrictBuild.setPid(district.getPid());
           responseDistrictBuild.setId(district.getId());
           DistrictResponse response = DistrictResponse.newBuilder()
                   .setDistrict(responseDistrictBuild.build())
                   .setStatus(Status.newBuilder()
                           .setCode(Status.Code.OK)
                           .setDetails("success").build())
                   .build();
           responseObserver.onNext(response);
       }
       responseObserver.onCompleted();

    }

    @Override
    public void list(ListDistrictRequest request, StreamObserver<DistrictResponse> responseObserver) {
        DistrictResponse.Builder responseBuild = DistrictResponse.newBuilder();
        OffsetBasedPageRequest pageable = new OffsetBasedPageRequest(
                (int)request.getPage(),request.getSize());
        Page<com.github.conanchen.gedit.model.District> districtPage = districtRepository.findAll(pageable);
        List<com.github.conanchen.gedit.model.District> districtList = districtPage.getContent();
        if(districtPage.hasContent()){
            for(com.github.conanchen.gedit.model.District district : districtList){
                District responseDistrict = District.newBuilder()
                        .setId(district.getId())
                        .setPid(district.getPid())
                        .setName(district.getName())
                        .setLevel(district.getLevel())
                        .setCitycode(district.getCitycode())
                        .setCenter(district.getCenter())
                        .setAdcode(district.getAdcode())
                        .build();
                responseBuild.setDistrict(responseDistrict).setStatus(Status.newBuilder().setCode(Status.Code.OK).setDetails("success").build());
                responseObserver.onNext(responseBuild.build());
            }
            responseObserver.onCompleted();
        }else{
            responseBuild.setStatus(Status.newBuilder()
                    .setCode(Status.Code.OUT_OF_RANGE)
                    .setDetails("暂无更多数据").build());
            responseObserver.onNext(responseBuild.build());
            responseObserver.onCompleted();
        }
    }
}