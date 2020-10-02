package io.github.ruoxijun.mapper;

import io.github.ruoxijun.pojo.Student;
import io.github.ruoxijun.pojo.Teacher;
import io.github.ruoxijun.utils.GetSqlSession;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    @Test
    public void getAllList(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();

        // 学生
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentsList = studentMapper.getStudentsList();
        for (Student student : studentsList){
            System.out.println(student);
        }
        System.out.println("--------------------------分割线----------------------------");
        // 老师
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachersList = teacherMapper.getTeachersList();
        for (Teacher teacher : teachersList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getAllTeacher(){
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachersList = mapper.findTeacher(1);
        for (Teacher teacher: teachersList) {
            System.out.println(teacher);
            for (Student student : teacher.getStudents()) {
                System.out.println(student);
            }
        }
        sqlSession.close();
    }

    @Test
    public void findStudent(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",3);
        map.put("name","小张");
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.findStudents(map);
        for (Student student : students){
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void updateStudent(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
        map.put("name","张哥");
        map.put("tid",2);
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.updateStudent(map);
        if(i==1){
            sqlSession.commit();
            System.out.println("-----------更新成功-----------");
        }
        sqlSession.close();
    }

    @Test
    public void findStuForeach(){
        List<Object> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        SqlSession sqlSession = GetSqlSession.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuForeach = mapper.findStuForeach(ids);
        for (Student student : stuForeach) {
            System.out.println(student);
        }
        sqlSession.clearCache();
        sqlSession.close();
    }

    @Test
    public void cache(){
        SqlSession sqlSession1 = GetSqlSession.getSqlSession();
        SqlSession sqlSession2 = GetSqlSession.getSqlSession();
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        mapper1.getAll();
        mapper2.getAll();
        sqlSession1.close();
        sqlSession2.close();
    }

}
