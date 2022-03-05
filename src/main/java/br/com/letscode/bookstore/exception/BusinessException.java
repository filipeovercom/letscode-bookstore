package br.com.letscode.bookstore.exception;

public class BusinessException extends RuntimeException {

    private int type;

    public BusinessException(int type, String message) {
        super(message);
        this.type = type;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public int getType() {
        return type;
    }
}
