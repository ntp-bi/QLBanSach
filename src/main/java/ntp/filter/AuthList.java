package ntp.filter;

public enum AuthList {
	ADMIN(1), USER(2);

	private int value;

	private AuthList(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
