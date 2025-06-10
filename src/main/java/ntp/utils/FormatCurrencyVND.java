package ntp.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatCurrencyVND {
	// Hàm để format tiền theo VND
    public static String formatCurrencyVND(double amount) {
        // Tạo Locale Việt Nam
        Locale localeVN = new Locale("vi", "VN");

        // Sử dụng NumberFormat để format tiền tệ Việt Nam
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);

        // Trả về chuỗi đã format
        return currencyVN.format(amount);
    }
}
