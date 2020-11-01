package com.chy.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chy.serviceedu.entity.EduTeacher;
import com.chy.serviceedu.query.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author chy
 * @since 2020-07-28
 */

public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> page, TeacherQuery teacherQuery);
}
