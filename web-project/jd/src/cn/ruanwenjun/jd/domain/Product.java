package cn.ruanwenjun.jd.domain;


/**
 * @author ruanwenjun 
 *		   E-mail:861923274@qq.com
 * @date 2018年4月15日 上午11:23:37
*/
public class Product {
	private String pid;
	private String name;
	private String catalog;
	private String catalog_name;
	private Float price;
	private String number;
	private String longtext;
	private String picture;
	private String relese_time;     //时间暂时用relese_time表示
	public Product() {
		
	}
	public Product(String id, Float price, String name, String picture) {
		this.pid = id;
		this.price = price;
		this.name = name;
		this.picture = picture;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatalog() {
		return catalog;
	}
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}
	public String getCatalog_name() {
		return catalog_name;
	}
	public void setCatalog_name(String catalog_name) {
		this.catalog_name = catalog_name;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getLongtext() {
		return longtext;
	}
	public void setLongtext(String longtext) {
		this.longtext = longtext;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getRelese_time() {
		return relese_time;
	}
	public void setRelese_time(String relese_time) {
		this.relese_time = relese_time;
	}

	
}
