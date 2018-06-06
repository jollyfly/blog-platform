package me.jollyfly.blog.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -8447546282609825338L;

    public static final int SUCCESS = 1;

    public static final int FAIL = 0;

    private T data;

    private String message;

    private Integer code;
}
