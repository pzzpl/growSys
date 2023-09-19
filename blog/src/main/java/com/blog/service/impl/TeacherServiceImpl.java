package com.blog.service.impl;

import com.blog.dao.TeacherDao;

import com.blog.pojo.Teacher;
import com.blog.service.TeacherService;
import com.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService  {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher checkTeacher(String teachername, String password) {
        Teacher teacher = teacherDao.queryByTeachernameAndPassword(teachername, password);
        return teacher;
    }
}
