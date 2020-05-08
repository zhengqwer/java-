package cn.tedu.store.upload.ex;
/**
 * 上传文件无效异常,可能时选择了0字节的文件
 * @author soft01
 *
 */
public class FileEmptyException extends FileUploadException {

	private static final long serialVersionUID = -4204500722792616208L;

	public FileEmptyException() {
		super();
	}

	public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileEmptyException(String message) {
		super(message);
	}

	public FileEmptyException(Throwable cause) {
		super(cause);
	}
	
	

}
