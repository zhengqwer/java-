package cn.tedu.store.service.ex;
/**
 * 非法绑定异常
 * @author soft01
 *
 */
public class AccessDeniedException extends ServiceException {

	private static final long serialVersionUID = -2146831597708949351L;

	public AccessDeniedException() {
		super();
	}

	public AccessDeniedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccessDeniedException(String message) {
		super(message);
	}

	public AccessDeniedException(Throwable cause) {
		super(cause);
	}

	
}
