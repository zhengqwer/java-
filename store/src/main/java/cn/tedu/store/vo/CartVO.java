package cn.tedu.store.vo;

import java.io.Serializable;
/**
 * 处理购物车数据的VO类 value-object
 * @author soft01
 *
 */
public class CartVO implements Serializable{
	
	private static final long serialVersionUID = -2149265607062947685L;
	
	private Integer cid;
	private Long gid;
	private String title;
	private String image;
	private Long price;
	private Integer num;
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "CartVO [cid=" + cid + ", gid=" + gid + ", title=" + title + ", image=" + image + ", price=" + price
				+ ", num=" + num + "]";
	}
	
	
}
