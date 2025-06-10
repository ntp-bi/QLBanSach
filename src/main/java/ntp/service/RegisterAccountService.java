package ntp.service;

import ntp.repository.RegisterAccountRepository;

public class RegisterAccountService {
	RegisterAccountRepository registerAccountRepository = new RegisterAccountRepository();

	public boolean Dangky(String hoten, String diachi, String sodt, String email, String tendn, String pass)
			throws Exception {
		return registerAccountRepository.dangKyTaiKhoan(hoten, diachi, sodt, email, tendn, pass) > 0;
	}
}
