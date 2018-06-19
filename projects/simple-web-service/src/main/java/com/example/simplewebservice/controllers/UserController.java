package com.example.simplewebservice.controllers;

import com.example.simplewebservice.models.User;
import com.example.simplewebservice.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Controller
public class UserController {

    private final UserDao userDao;

    // 这个玩意是自动注入的呦
    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    /*
     * 1. 声明了一个路由 Post /create
     * 2. 返回一个response
     * 3. 需要验证, Email是一个正规表达式
     * FIXME Validation好像运行不了
     */
    @PostMapping("/create")
    @ResponseBody
    @Validated
    public String create(@Pattern (regexp = "/^[0-9a-zA-Z_]+@[0-9a-zA-Z_\\.]$/") @NotBlank @RequestParam("email") String email, @NotBlank @RequestParam("name") String name) {
        User u;
        try {
            u = new User(email, name);
            userDao.save(u);
        } catch (Exception e) {
            return "error creating the user, ex: " + e.toString();
        }
        return "user successfully created!";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User u = new User(id);
            userDao.delete(u);
        } catch (Exception e) {
            return "error delete the user, ex: " + e.toString();
        }
        return "user successfully deleted!";
    }

    /// 另一种实现路由的方法
    @RequestMapping(value = "/getByEmail", method = RequestMethod.GET)
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User u = userDao.findByEmail(email);
            userId = String.valueOf(u.getId());
        } catch (Exception e) {
            return "User not found.";
        }
        return "User Found, Id :" + userId;
    }

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        List<User> users = new ArrayList<>();
        try {

            userDao.findAll().forEach(users::add);

        } catch (Exception e) {
            return "can not list users, ex = " + e.toString();
        }

        AtomicReference<String> res = new AtomicReference<>("");
        users.forEach(v -> res.updateAndGet(v1 -> v1 + String.format("id=%d, email=%s, name=%s<br>\n", v.getId(), v.getEmail(), v.getName())));
        return String.valueOf(res);
    }

    @PutMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            Optional<User> userOpt = userDao.findById(id);

            if (!userOpt.isPresent()) {
                throw new Exception("can not found user, id = " + id);
            }

            User u;
            u = userOpt.get();

            u.setEmail(email);
            u.setName(name);
            userDao.save(u);

        } catch (Exception e) {
            return "error updating the user: " + e.toString();
        }

        return "user successfully updated.";
    }
}
