package ntp.service;

import ntp.model.LoginModel;
import ntp.model.UserModel;
import ntp.repository.AuthRepository;
import ntp.repository.UserRepository;

public class AuthService {
	UserRepository userRepository = new UserRepository();
	AuthRepository authRepository = new AuthRepository();

	public UserModel getKhachHangByEmail(String email) {
		return userRepository.getKhachHangByEmail(email);
	}

	public boolean checkLogin(String email, String password) {
		return authRepository.checkExistingOfKhachHangByEmailNPassword(email, password) > 0;
	}

	public boolean checkExistingOfKhachHangByEmail(String email) {
		return authRepository.checkExistingOfKhachHangByEmail(email) > 0;
	}

	public LoginModel getQuyen(boolean quyen) {
		return authRepository.getQuyen(quyen);
	}
}
