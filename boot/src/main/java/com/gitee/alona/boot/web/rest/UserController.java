package com.gitee.alona.boot.web.rest;

import com.baomidou.mybatisplus.core.toolkit.AES;
import com.gitee.alona.boot.entity.User;
import com.gitee.alona.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 孤胆枪手
 * @version 1.0
 * @date 2020-07-22 23:31
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list() {
        List<User> list = userService.list();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User byId = userService.getById(user.getId());
        byId.setId(null);
        byId.setAge(25);
        boolean save = userService.save(byId);
        return ResponseEntity.ok(byId);
    }
}
