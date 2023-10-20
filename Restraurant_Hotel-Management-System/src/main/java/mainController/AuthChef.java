package mainController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Admin;
import service.AdminService;
@SuppressWarnings("serial")
@WebServlet("/auth")
public class AuthChef extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AdminService adminService = new AdminService();
		String id = req.getParameter("id");
		int ch_id = Integer.parseInt(id);
		Admin a = adminService.getAdminById(1);
		PrintWriter printWriter = resp.getWriter();
		if (adminService.authChef(ch_id, a)) {

			printWriter.write("<html><body><h1>" + "chef " +a.getName()+ " authorized successfully" + "</h1></body></html>");

		}else {

			printWriter.write("<html><body><h1>" +" Couldnt authorized the chef "+"</h1></body></html>");

		}

	}
}
