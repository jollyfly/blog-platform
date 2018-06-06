package me.jollyfly.blog.model.exception;


/**
 * 服务器异常
 */
public class ServerException extends RuntimeException{

    private static final long serialVersionUID = 8176492981435745312L;

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
