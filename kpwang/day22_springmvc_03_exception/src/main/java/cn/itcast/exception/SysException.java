package cn.itcast.exception;

/**
 * @author kpwang
 * @create 2020-07-10 20:15
 */
public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
