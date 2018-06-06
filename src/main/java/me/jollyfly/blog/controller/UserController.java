package me.jollyfly.blog.controller;

import lombok.extern.slf4j.Slf4j;
import me.jollyfly.blog.model.dto.LoginDTO;
import me.jollyfly.blog.model.exception.BusinessException;
import me.jollyfly.blog.model.result.Result;
import me.jollyfly.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static me.jollyfly.blog.model.result.Result.FAIL;
import static me.jollyfly.blog.model.result.Result.SUCCESS;


/**
 * @author zhichao.wan
 */
@RestController
@RequestMapping(value = "/api")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "user/login")
    public Result<Boolean> login(@Validated LoginDTO loginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder messageBuilder = new StringBuilder();
            bindingResult.getAllErrors().forEach(it -> messageBuilder.append(it.getDefaultMessage()).append("；"));
            log.info("参数校验不通过，msg={},参数：{}", messageBuilder.toString(), loginDTO);
            return new Result<>(false, messageBuilder.toString(), FAIL);
        }
        try {
            Boolean loginSuccess = userService.login(loginDTO.getNic(), loginDTO.getPassword());
            if (loginSuccess) {
                return new Result<>(true, "登陆成功", SUCCESS);
            } else {
                return new Result<>(false, "用户名或密码错误", FAIL);
            }
        } catch (Exception e) {
            if (e instanceof BusinessException) {
                log.info("登陆失败，参数loginDTO：{}, 异常信息{}", loginDTO, e.getMessage());
                return new Result<>(false, e.getMessage(), FAIL);
            } else {
                log.error("登陆接口调用异常，参数 {}", loginDTO);
                log.error("异常详情", e);
                return new Result<>(false, "网络异常，请稍后再试", FAIL);
            }
        }
    }

}
