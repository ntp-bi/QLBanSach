package ntp.model.tableData;

public enum UserColumn {
	MAKH("makh"),
	HOTEN("hoten"),
	DIACHI("diachi"),
	SODIENTHOAI("sodt"),
	EMAIL("email"),
	TENDANGNHAP("tendn"),
	PASS("pass");
	
	private String value;

	private UserColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
