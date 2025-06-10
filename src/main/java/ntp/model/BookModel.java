package ntp.model;

public class BookModel {
	private String masach;
	private String tensach;
	private Long soluong;
	private Long gia;
	private String maloai;
	private String tacgia;
	private String anh;
	private String sotap;
	private String ngaynhap;

	public BookModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookModel(String masach, String tensach, Long soluong, Long gia, String maloai, String tacgia, String anh,
			String sotap, String ngaynhap) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.soluong = soluong;
		this.gia = gia;
		this.maloai = maloai;
		this.tacgia = tacgia;
		this.anh = anh;
		this.sotap = sotap;
		this.ngaynhap = ngaynhap;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public Long getSoluong() {
		return soluong;
	}

	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}

	public Long getGia() {
		return gia;
	}

	public void setGia(Long gia) {
		this.gia = gia;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getTacgia() {
		return tacgia;
	}

	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getSotap() {
		return sotap;
	}

	public void setSotap(String sotap) {
		this.sotap = sotap;
	}

	public String getNgaynhap() {
		return ngaynhap;
	}

	public void setNgaynhap(String ngaynhap) {
		this.ngaynhap = ngaynhap;
	}

}
