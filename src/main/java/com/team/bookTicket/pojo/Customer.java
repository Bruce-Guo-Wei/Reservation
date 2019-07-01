package com.team.bookTicket.pojo;

public class Customer {
	Integer id;
	String cardId;
	String name;
	String address;
	String phone;
	Integer isAdmin;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * 暂不考虑请求参数不存在的情况
	 * @return
	 */
	public boolean canUpdate() {
		if(id!=null && (!name.isEmpty() || !cardId.isEmpty() || !address.isEmpty() || !phone.isEmpty() || isAdmin !=null )) {
			return true;
		}else {
			return false;
		}
	}
	public boolean canAdd() {
		if(!name.isEmpty() && !cardId.isEmpty()){
			return true;
		}else {
			return false;
		}
	}
}
