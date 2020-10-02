package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

interface StudentMapper {
    @Select("select * from student")
    List<Student> getAll();
    List<Student> getStudentsList();
    List<Student> findStudents(Map<String,Object> map);
    int updateStudent(Map<String,Object> map);
    List<Student> findStuForeach(@Param("ids") List<Object> ids);
}
