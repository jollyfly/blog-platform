package me.jollyfly.blog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 */
@Data
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = -6521847685464952186L;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 4, max = 18, message = "用户名长度应该为4-18位")
    private String nic;

    @NotEmpty(message = "密码不能为空")
    @Size(min = 8, max = 18, message = "密码长度应该为8-18位")
    private String password;
}
