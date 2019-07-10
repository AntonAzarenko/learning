package com.azarenka.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface VendorRepository {

    int getCountVendorsByTitleManufacturer(@Param("title")String title);
}
