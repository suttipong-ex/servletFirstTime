/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.student.testwebservlet.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import th.co.geniustree.student.testwebservlet.controller.InsertData;
import th.co.geniustree.student.testwebservlet.controller.ShowData;
import th.co.geniustree.student.testwebservlet.model.stdBook;

/**
 *
 * @author suttipong
 */
@WebServlet(name = "StuentRec", urlPatterns = {"/StuentRec"})
public class StuentRec extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StuentRec</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StuentRec at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<stdBook> getShot = ShowData.show();
        request.setAttribute("list", getShot);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("show.html");
//            request.setAttribute("list", getShot);
        request.getRequestDispatcher("welcome.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("E-mail");
//            out.println(name);
//            out.println(phone);
//            out.println(email);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("th.co.geniustree.student_TestWebServlet_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        InsertData.Insert(name, phone, email, em);
        List<stdBook> getShot = ShowData.show();
        out.print("<table><tr><td>ID</td><td>Name</td><td>Phone</td><td>Email</td></tr>");
        for (int i = 0; i < getShot.size(); i++) {
            out.print("<tr>");
            out.print("<td>" + getShot.get(i).getId() + "</td>");
            out.print("<td>" + getShot.get(i).getName() + "</td>");
            out.print("<td>" + getShot.get(i).getPhone() + "</td>");
            out.print("<td>" + getShot.get(i).getEmail() + "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
        out.print("<style>td{border:2px solid black}tr{border:2px solid black}</style>");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
