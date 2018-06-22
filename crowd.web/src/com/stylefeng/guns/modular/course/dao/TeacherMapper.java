package com.stylefeng.guns.modular.course.dao;

import com.stylefeng.guns.modular.course.model.Teacher;

public interface TeacherMapper {
    /**
     *
     * @mbggenerated 2018-06-15
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-06-15
     */
    int insert(Teacher record);

    /**
     *
     * @mbggenerated 2018-06-15
     */
    int insertSelective(Teacher record);

    /**
     *
     * @mbggenerated 2018-06-15
     */
    Teacher selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2018-06-15
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     *
     * @mbggenerated 2018-06-15
     */
    int updateByPrimaryKey(Teacher record);
}