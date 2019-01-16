package com.bap.Mapper;


import com.bap.entry.StudentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Author lyd
 * @Date $ $
 * @Vesion 1.0
 * @Description 接口
 **/
@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    List<StudentInfo> findAll();
}