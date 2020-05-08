package cn.tedu.store.upload.ex;
/**
 * 文件上传读写失败异常
 * @author soft01
 *
 */
public class FileIoException extends FileUploadException {

	private static final long serialVersionUID = -6506115506243776165L;

	public FileIoException() {
		super();
	}

	public FileIoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileIoException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileIoException(String message) {
		super(message);
	}

	public FileIoException(Throwable cause) {
		super(cause);
	}
	
	

}
