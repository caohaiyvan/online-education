package com.chy.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chy.commonutils.Result;
import com.chy.serviceedu.entity.EduTeacher;
import com.chy.serviceedu.query.TeacherQuery;
import com.chy.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author chy
 * @since 2020-07-28
 */
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @GetMapping("findAll")
    public Result findAll() {
        return Result.ok().data("items", eduTeacherService.list(null));

    }

    @PostMapping("user/login")
    public Result login() {
        return Result.ok().data("token", "admin");

    }

    @GetMapping("user/info")
    public Result info() {
        return Result.ok().data("roles", "[admin]").data("name", "admin");

    }

    @DeleteMapping("remove/{id}")
    public Result removeTeacher(@PathVariable("id") String id) {
        if (eduTeacherService.removeById(id)) {
            return Result.ok();
        }
        return Result.error();
    }

    /**
     * 分页条件查询
     * @param pageNo
     * @param pageSize
     * @param teacherQuery
     * @return
     */
    @PostMapping("{pageNo}/{pageSize}")
    public Result pageList(@PathVariable("pageNo") Long pageNo, @PathVariable("pageSize") Long pageSize, @RequestBody( required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> page = new Page<>(pageNo, pageSize);
        eduTeacherService.pageQuery(page, teacherQuery);
        List<EduTeacher> records = page.getRecords();
        long total = page.getTotal();
        return Result.ok().data("total", total).data("records", records);


    }
}

