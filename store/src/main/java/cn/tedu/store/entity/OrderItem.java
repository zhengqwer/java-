package cn.tedu.store.entity;

/**
 * 订单商品的实体类
 * @author soft01
 *
 */
public class OrderItem extends BaseEntity {

	private static final long serialVersionUID = -5095404612483377852L;

	private Integer id;
	private Integer oid;
	private Long gid;
	private String goods_title;
	private String goods_image;
	private Long goods_price;
	private Integer goods_num;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getGoods_title() {
		return goods_title;
	}

	public void setGoods_title(String goods_title) {
		this.goods_title = goods_title;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public Long getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(Long goods_price) {
		this.goods_price = goods_price;
	}

	public Integer getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}

	@Override
	public String toString() {
		return "Order_item [id=" + id + ", oid=" + oid + ", gid=" + gid + ", goods_title=" + goods_title
				+ ", goods_image=" + goods_image + ", goods_price=" + goods_price + ", goods_num=" + goods_num + "]";
	}

}
