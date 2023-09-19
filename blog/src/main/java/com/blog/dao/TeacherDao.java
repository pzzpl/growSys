package com.blog.dao;

import com.blog.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface TeacherDao {
    Teacher queryByTeachernameAndPassword(@Param("teachername") String teachername, @Param("password") String password);
}

