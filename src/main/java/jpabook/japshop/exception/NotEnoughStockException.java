package jpabook.japshop.exception;

public class NotEnoughStockException extends RuntimeException {

    //생성자로 RuntimeException을 오버라이드 해줌
    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
