package me.jollyfly.blog.model.exception;

/**
 * 业务异常
 */
public class BusinessException extends RuntimeException{
    private static final long serialVersionUID = 251113349280995637L;

    /**
     * @param message 异常信息
     * @param cause 异常原因
     */
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
