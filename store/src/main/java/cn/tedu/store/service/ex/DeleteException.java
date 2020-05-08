package cn.tedu.store.service.ex;
/**
 * 删除失败时发生此异常
 * @author soft01
 *
 */
public class DeleteException extends ServiceException {

	private static final long serialVersionUID = -4890183478536596921L;

	public DeleteException() {
		super();
	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteException(String message) {
		super(message);
	}

	public DeleteException(Throwable cause) {
		super(cause);
	}

	
}
