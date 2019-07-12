package com.azarenka.repository;

import com.azarenka.domain.Contact;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContactRepository {

    List<Contact> getContacts(@Param("manufacturer_name") String mName);
}
