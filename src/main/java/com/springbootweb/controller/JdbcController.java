package com.springbootweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql= "select * from blog";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    @GetMapping("/userAdd")
    public String add(){
        String sql = "insert into blog ( title) values ('33333')";
        jdbcTemplate.update(sql);
        return  "add ok";
    }
    @GetMapping("updateUser/{id}")
    public String updateUser(@PathParam("id") Integer id){
        String sql = "update blog set title = ? where id = " + id;
        // 对象
        Object[] objects = new Object[1];
        objects[0] = "哈哈哈";
        jdbcTemplate.update(sql, objects);
        return "update ok";
    }

    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathParam("id") Integer id){
        String sql = "delete from blog where id = " + id;

        jdbcTemplate.update(sql);
        return  "delete is oK";
    }

}
