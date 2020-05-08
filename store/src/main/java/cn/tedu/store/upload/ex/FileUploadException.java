package cn.tedu.store.upload.ex;
/**
 * 控制器类异常的集类
 * @author soft01
 *
 */
public class FileUploadException extends RuntimeException {

	private static final long serialVersionUID = -5546848685076649382L;

	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}
	
	

}
