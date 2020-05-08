package cn.tedu.store.service.ex;
/**
 * 查找不到地址数据异常
 * @author soft01
 *
 */
public class AddressNotFoundException extends ServiceException {

	private static final long serialVersionUID = 5028136186556743637L;

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}
	
	

}
