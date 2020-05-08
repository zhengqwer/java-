package cn.tedu.store.entity;

import java.util.Date;

/**
 * 生成订单数据的实体类
 * 
 * @author soft01
 *
 */
public class Order extends BaseEntity {

	private static final long serialVersionUID = -8983278690979763024L;

	private Integer oid;
	private Integer uid;
	private String recv_name;
	private String recv_phone;
	private String recv_address;
	private Long total_price;
	private Integer status;
	private Date order_time;
	private Date pay_titme;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getRecv_name() {
		return recv_name;
	}

	public void setRecv_name(String recv_name) {
		this.recv_name = recv_name;
	}

	public String getRecv_phone() {
		return recv_phone;
	}

	public void setRecv_phone(String recv_phone) {
		this.recv_phone = recv_phone;
	}

	public String getRecv_address() {
		return recv_address;
	}

	public void setRecv_address(String recv_address) {
		this.recv_address = recv_address;
	}

	public Long getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Long total_price) {
		this.total_price = total_price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Date getPay_titme() {
		return pay_titme;
	}

	public void setPay_titme(Date pay_titme) {
		this.pay_titme = pay_titme;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", recv_name=" + recv_name + ", recv_phone=" + recv_phone
				+ ", recv_address=" + recv_address + ", total_price=" + total_price + ", status=" + status
				+ ", order_time=" + order_time + ", pay_titme=" + pay_titme + "]";
	}

}
