package JDBCEntity;

public class jdbc {
	private Long user_id;
	private String name;
	private String hobby;
	private String address_name;
	private Long address_id;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getAddress_name() {
		return address_name;
	}
	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}
	public Long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}
	
	@Override
	public String toString() {
		return "jdbc [user_id=" + user_id + ", name=" + name + ", hobby=" + hobby + ", address_name=" + address_name
				+ ", address_id=" + address_id + "]";
	}
	
}
