package cn.tedu.store.entity;

/**
 * 商品数据的实体类
 * 
 * @author soft01
 *
 */
public class Cart extends BaseEntity {

	private static final long serialVersionUID = -986484262416734272L;
	
	private Integer cid;//购物车数据的id
	private Integer uid;//用户的id
	private Long gid;//商品id
	private Integer num;//商品数量

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", uid=" + uid + ", gid=" + gid + ", num=" + num + "]";
	}


}
