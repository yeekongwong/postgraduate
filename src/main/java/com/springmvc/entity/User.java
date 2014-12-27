package com.springmvc.entity;

public class User implements java.io.Serializable {
	/**
	 * 需要对应着User.hbm.xml,才能算是PO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String pwd;
	public User() {
	}
	public User(String name,String pwd){
		this.name=name;
		this.pwd=pwd;
	}
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pwd) {
		this.pwd = pwd;
	}
}
