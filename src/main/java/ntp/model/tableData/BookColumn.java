package ntp.model.tableData;

public enum BookColumn {
	MASACH("masach"),
	TENSACH("tensach"),
	SOLUONG("soluong"),
	GIA("gia"),
	MALOAI("maloai"),
	SOTAP("sotap"),
	ANH("anh"),
	NGAYNHAP("NgayNhap"),
	TACGIA("tacgia");

	private String value;

	private BookColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
