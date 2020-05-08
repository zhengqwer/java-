package cn.tedu.store.upload.ex;
/**
 * 文件上传状态异常
 * @author soft01
 *
 */
public class FileStateException extends FileUploadException {

	private static final long serialVersionUID = -5762418708237627411L;

	public FileStateException() {
		super();
	}

	public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileStateException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileStateException(String message) {
		super(message);
	}

	public FileStateException(Throwable cause) {
		super(cause);
	}
	
	

}
