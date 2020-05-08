package cn.tedu.store.upload.ex;
/**
 * 上传文件超出指定大小异常
 * @author soft01
 *
 */
public class FileSizeException extends FileUploadException{

	private static final long serialVersionUID = 5040781168923050319L;

	public FileSizeException() {
		super();
	}

	public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileSizeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileSizeException(String message) {
		super(message);
	}

	public FileSizeException(Throwable cause) {
		super(cause);
	}
	
	

}
