package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

interface TeacherMapper {
    List<Teacher> getTeachersList();
    List<Teacher> findTeacher(@Param("id") int id);
}
