package com.azarenka.repository;

import com.azarenka.domain.Manufacturer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ManufacturerRepository {
    List<Manufacturer> getManWichDoesntWorkWithVendor(@Param("title") String vendorTitle);
}
