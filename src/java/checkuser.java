/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author titi_
 */
@WebServlet(urlPatterns = {"/checkuser"})
public class checkuser extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()){
            Persistencia base = new Persistencia();
            ResultSet result = base.consultaSQL("select * from usuarios where usuario = " + "'" + request.getParameter("email") + "'" + "and clave = " + "'" + request.getParameter("password") + "'");
            
            while(result.next()){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<style text-align: center;>");
                out.println("<title>Proyecto Java Montiel</title>");   
                out.println("</style>");
                out.println("</head>");
                out.println("<body style=\"background-color: rgb(253, 253, 181);\">");
                out.println("<script type=\"text/javascript\">alert('Usuario'+' '+'Coincide'+' '+'Correctamente');</script>");
                out.println("<style type=\"text/css\">h1 { text-align: center}</style>");
                out.println("<h1>Usuario</h1>"); 
                out.println("<h1>" + result.getString("usuario") + "</h1>");
                out.println("<h1>Clave</h1>"); 
                out.println("<h1>" + result.getString("clave") + "</h1>");
                out.println("<style type=\"text/css\">h2 { text-align: center}</style>");
                out.println("<h1>Nombre y Apellido</h1>"); 
                out.println("<h2>" + result.getString("nombreyapellido") + "<BR>" + "</h2>");
                out.println("</body>");
                out.println("</html>");
            }        
                               
            if(result.first() == false){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<style text-align: center;>");
                out.println("<title>Proyecto Java Montiel</title>");   
                out.println("</style>");
                out.println("</head>");
                out.println("<body style=\"background-color: rgb(253, 253, 181);\">");
                out.println("<script type=\"text/javascript\">alert('Usuario'+' '+'No'+' '+'Coincide');</script>");
                out.println("<style type=\"text/css\">h1 { text-align: center}</style>");
                out.println("<h1>No hay usuarios que coincidan</h1>");
                out.println("<h1>Proyecto</h1>");
                out.println("<style type=\"text/css\">h2 { text-align: center}</style>");
                out.println("<h2>" + request.getContextPath() + "</h2>");
                out.println("<h1>Usuario</h1>"); 
                out.println("<h2>" + request.getParameter("email") + "</h2>"); 
                out.println("</body>");
                out.println("</html>");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(checkuser.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
