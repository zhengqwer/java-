package cn.tedu.store.service.ex;
/**
 * 输入密码错误异常
 * @author soft01
 *
 */
public class PasswordNotmatchException extends ServiceException {

	private static final long serialVersionUID = -265105965703347257L;

	public PasswordNotmatchException() {
		super();
	}

	public PasswordNotmatchException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PasswordNotmatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotmatchException(String message) {
		super(message);
	}

	public PasswordNotmatchException(Throwable cause) {
		super(cause);
	}

	
}
