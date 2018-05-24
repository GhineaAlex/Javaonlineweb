/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "AdaugareComponenta", urlPatterns = {"/AdaugareComponenta"})
public class AdaugareComponenta extends HttpServlet {

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
            out.println("<link rel='stylesheet' type='text/css' href='"
                    + request.getContextPath() + "/style/style.css' />");
            out.println("<!DOCTYPE html>");
          out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
         
            out.println("<head>");
            out.println("<title>Universal</title>");
            out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />");
            
            out.println("</head>");
            
            out.println("<body>");
              out.println("<div id=\"wrapper\">");
               out.println("<div class=\"menuzone\">");
                out.println("<div class=\"topMenu\">");
                out.println("<ul>");
                    out.println("<li class=\"first\">");
                        out.println("<a class=\"current\" href=\"#\">Home");
                        out.println("</a>");
                    out.println("</li>");
                out.println("</ul>");
            
                out.println("</div>");
                out.println("<div class=\"clear\">");
               out.println("</div");
              out.println("</div>");
                out.println("<div class=\"clear\">");
             out.println("</div>");
             out.println("<div id=\"header\">");
            out.println("<div id=\"logo\">");
            out.println("</div>");
            out.println("<div id=\"menu2\">");

            
            out.println("</div>");
            out.println(" <div class=\"compatibility\">");
            out.println(" <div class=\"compatibilitybox\">");
            //out.println("<h1>Adauga Componenta: </h1>");
           out.println("<div class=\"features\">");
            out.println("</div>");
            
              //out.println("<div id='container'>");
            out.println("<div id='mainpic'>");
            out.println("<h1>Magazin<span class='off'>Online</span></h1>");
            out.println("<br>");

            out.println("</div>");
           
            out.println("</div>");

           
            out.println("<ul>");
            out.println("<font size =\"5\">");
            out.println("<li>");
            out.println("<div id = 'margine'>");
            out.println("<h1>Adauga Componenta: </h1>");
            out.println("<form action = 'AddComponenta' method = 'post' >"); //trimite toate inf de mai jos in AddAngajat printr un request
            out.println("</li>");
             
            out.println("<li>");
            out.println("Pret: ");
            out.println("<input name = 'pret' />");
            out.println("</li>");
            
            out.println("<li>");
            out.println("Marca: ");
            out.println("<input name = 'marca' />");
            out.println("</li>");
            
            out.println("<li>");
            out.println("AnFabricatie: ");
            out.println("<input name = 'anFabricatie' />");
            out.println("</li>");
            
            out.println("<li>");
            out.println("Garantie: ");
            out.println("<input name = 'garantie' />");
            out.println("</li>");
            
            out.println("<li>");
            out.println("Producator: ");
            out.println("<input name = 'producator' />");
            out.println("</li>");
            
            out.println("<li>");
            out.println("TaraProvenienta: ");
            out.println("<input name = 'taraProvenienta' />");
            out.println("</li>");
            
            out.println("<br>");

            out.println("Tip Componenta: ");
            out.println("<input name = 'selectOption' />");

            out.println("<br>");

            out.println("<button type = 'submit'> Adauga </button>");

            out.println("</form>");
            out.println("</font>");
           out.println("</ul");
            //out.println("</div>");
            
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("<div class=\"welCome\">");
            out.println("<div id=\"columZone\">");
             out.println("<div class=\"clear\">");
             out.println("</div>");
            out.println("</div>");
            
            out.println("</div>");
            
            out.println("<div class=\"clear\">");
            //out.println("</div>");
            out.println("</div>");
            //out.println("div class=\"clear\">");
            out.println("</div>");
           
            
            
            out.println("</div>");
            //out.println("<LINK REL=\"StyleSheet\" HREF=\"<%=request.getContextPath()%>/util/CSS/style.css\" TYPE=\"text/css\"> ");
            // out.println("</head>"); 
            out.println("<div class=\"bottom_container\">");
            out.println(" <div id=\"container1\">");
            out.println("<div class=\"welCome\">");
           
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"welCometextBox2\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("<div id=\"footer\">");
          
            out.println("<ul>");
         
            out.println(" </ul>");
            
            out.println("</div>");
            out.println("</div>");
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
