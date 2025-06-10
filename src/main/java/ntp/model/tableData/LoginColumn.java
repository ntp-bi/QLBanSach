package ntp.model.tableData;

public enum LoginColumn {
	TENDANGNHAP("TenDangNhap"),
	MATKHAU("MatKhau"),
	QUYEN("Quyen");
	
	private String value;

	private LoginColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
		
}
