package ntp.model;

public class LoginModel {
	private String TenDangNhap;
	private String MatKhau;
	private boolean Quyen;

	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginModel(String tenDangNhap, String matKhau, boolean quyen) {
		super();
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Quyen = quyen;
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public boolean isQuyen() {
		return Quyen;
	}

	public void setQuyen(boolean quyen) {
		Quyen = quyen;
	}

}
