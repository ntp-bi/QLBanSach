package ntp.model.tableData;

public enum BookCategoryColumn {
	MALOAI("maloai"),
	TENLOAI("tenloai");
	
	private String value;

	private BookCategoryColumn(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
		
}
