package com.github.conanchen.gedit.repository;

import com.github.conanchen.gedit.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface DistrictRepository<T,String extends Serializable> extends JpaRepository<District,String>,JpaSpecificationExecutor<District> {

    List<District> findByPid(Long pid);
}
