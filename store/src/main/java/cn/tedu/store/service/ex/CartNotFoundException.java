package cn.tedu.store.service.ex;
/**
 * 查不到购物车中数据异常
 * @author soft01
 *
 */
public class CartNotFoundException extends ServiceException {

	private static final long serialVersionUID = -2114685377846711349L;

	public CartNotFoundException() {
		super();
	}

	public CartNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CartNotFoundException(String message) {
		super(message);
	}

	public CartNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
