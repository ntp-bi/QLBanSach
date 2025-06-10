package ntp.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "uploadImage", urlPatterns = { "/upload" })
public class UploadImage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Đặt encoding và character set
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		String dirUrl1 = req.getServletContext().getRealPath("") + File.separator + "image_sach";
		resp.getWriter().println(dirUrl1);

		try {
			String anh = null;
			if (req.getContentLength() <= 0) {// Chay lan dau
				RequestDispatcher rd = req.getRequestDispatcher("./book");
				rd.forward(req, resp);
				return;
			}

			List<FileItem> fileItems = upload.parseRequest((RequestContext) req); // Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = req.getServletContext().getRealPath("") + File.separator + "image_sach";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);// lưu file
							anh = "image_sach/" + nameimg;
							System.out.println("UPLOAD THÀNH CÔNG...!");
							System.out.println("Đường dẫn lưu file là: " + dirUrl);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("txtms"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txtts"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txttg"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txtsl"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txtg"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txta"))
						resp.getWriter().println(fileItem.getString());
					if (tentk.equals("txtml"))
						resp.getWriter().println(fileItem.getString());
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}
}
