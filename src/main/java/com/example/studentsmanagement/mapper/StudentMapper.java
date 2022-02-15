package com.example.studentsmanagement.mapper;


import com.example.studentsmanagement.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper {

    // SELECT * FROM student WHERE NAME LIKE %T%;
    @Select("SELECT * FROM student WHERE NAME LIKE #{name}")
    List<Student> getStudentsContainStrInName(@Param("name") String name);


    // SELECT * FROM student WHERE university_class_id IN
    // (SELECT id FROM university_class WHERE year = 2022 AND number=1)
    @Select("SELECT id,name,university_class_id FROM student WHERE university_class_id IN\n" +
            "(SELECT id FROM university_class WHERE year = #{year} AND number= #{number})")
    List<Student> getStudentsInClass(@Param("year") int year, @Param("number") int number);
}
