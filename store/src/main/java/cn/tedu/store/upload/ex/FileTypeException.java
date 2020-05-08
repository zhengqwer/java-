package cn.tedu.store.upload.ex;
/**
 * 上传文件类型不匹配异常
 * @author soft01
 *
 */
public class FileTypeException extends FileUploadException {

	private static final long serialVersionUID = 4570004014093456505L;

	public FileTypeException() {
		super();
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTypeException(String message) {
		super(message);
	}

	public FileTypeException(Throwable cause) {
		super(cause);
	}
	
	

}
