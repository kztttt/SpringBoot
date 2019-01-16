package com.bap.Mapper;


import com.bap.entry.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<StudentInfo> findAll();
}