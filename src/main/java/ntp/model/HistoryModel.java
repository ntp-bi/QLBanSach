package ntp.model;

public class HistoryModel {
	private String masach;
	private String tensach;
	private long gia;
	private long soluongmua;
	private long thanhtien;
	private long makh;
	private Boolean damua;
	private String anh;
	private String ngaymua;
	private long mahoadon;

	public HistoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoryModel(String masach, String tensach, long gia, long soluongmua, long thanhtien, long makh,
			Boolean damua, String anh, String ngaymua, long mahoadon) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		this.soluongmua = soluongmua;
		this.thanhtien = thanhtien;
		this.makh = makh;
		this.damua = damua;
		this.anh = anh;
		this.ngaymua = ngaymua;
		this.mahoadon = mahoadon;
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

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public long getSoluongmua() {
		return soluongmua;
	}

	public void setSoluongmua(long soluongmua) {
		this.soluongmua = soluongmua;
	}

	public long getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}

	public long getMakh() {
		return makh;
	}

	public void setMakh(long makh) {
		this.makh = makh;
	}

	public Boolean getDamua() {
		return damua;
	}

	public void setDamua(Boolean damua) {
		this.damua = damua;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public String getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}

	public long getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}

}
