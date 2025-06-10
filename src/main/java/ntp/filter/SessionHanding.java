package ntp.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionHanding {
    private static final String SESSION_EMAIL = "email";

    // Add email to session
    public void addSession(HttpServletRequest request, String email) {
        HttpSession session = request.getSession(true); // Lấy session hoặc tạo mới nếu chưa có
        session.setAttribute(SESSION_EMAIL, email);
        session.setMaxInactiveInterval(60 * 60 * 8); // 8 giờ
        System.out.println("[INFO] Session created and email added: " + email);
    }

    // Delete session
    public void deleteSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Không tạo mới session nếu chưa có
        if (session != null) {
            session.removeAttribute(SESSION_EMAIL);
            session.invalidate();
            System.out.println("[INFO] Session invalidated successfully.");
        } else {
            System.out.println("[WARNING] No session found to delete.");
        }
    }

    // Get email from session
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String email = (String) session.getAttribute(SESSION_EMAIL);
            if (email != null) {
                System.out.println("[INFO] Retrieved email from session: " + email);
            } else {
                System.out.println("[WARNING] Email not found in session.");
            }
            return email;
        } else {
            System.out.println("[WARNING] No active session found.");
            return null;
        }
    }
}
