package cn.tedu.store.util;

import java.io.Serializable;

/**
 * 控制器向客户端响应结果的数据类型
 * @author soft01
 * @param <T> 如果控制器会向客户端响应某些数据，则表示响应的数据类型
 */
public class ResponseResult<T> implements Serializable {

	/**
	 * 序列化接口号
	 */
	private static final long serialVersionUID = -5698238315766641054L;

	private Integer state;
	private String message;
	private T data;// please object is OK

	public ResponseResult() {
		super();
	}

	public ResponseResult(Integer state) {
		super();
		this.state = state;
	}

	public ResponseResult(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public ResponseResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}

}
