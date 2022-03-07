package br.com.letscode.bookstore.exception;

public class BusinessException extends RuntimeException {

    private final int type;

    public BusinessException(int type, String message) {
        super(message);
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
