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
            out.println("<!DOCTYPE html>");
            out.println("<html>");

            //out.println("<LINK REL=\"StyleSheet\" HREF=\"<%=request.getContextPath()%>/util/CSS/style.css\" TYPE=\"text/css\"> ");
            // out.println("</head>"); 
            out.println("<head>");
            out.println("<title>Magazin Online</title>");
            out.println("<style>");
            out.println("body {\n"
                    + "	margin: 0;\n"
                    + "	padding: 0;\n"
                    + "	text-align: left;\n"
                    + "	font: 12px Arial, Helvetica, sans-serif;\n"
                    + "	font-size: 13px;\n"
                    + "	color: #061C37;\n"
                    + "	background: #EEEFE4;\n"
                    + "	background-image:url(images/background.png);\n"
                    + "	background-repeat:repeat-x;\n"
                    + "}\n"
                    + "*\n"
                    + "{\n"
                    + "  margin: 0 auto 0 auto;\n"
                    + " text-align:left;}\n"
                    + "\n"
                    + "#container\n"
                    + "{\n"
                    + "  display: block; \n"
                    + "  height:auto;\n"
                    + "  position: relative; \n"
                    + "  width: 940px;\n"
                    + "}\n"
                    + "\n"
                    + "#mainpic h1\n"
                    + "{\n"
                    + "	position:absolute;\n"
                    + "text-align:right;\n"
                    + "color:#F8FDEE;\n"
                    + "font-size:30px;\n"
                    + "color:#FFF;	\n"
                    + "left:60px;\n"
                    + "top:20px;\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "#mainpic\n"
                    + "{\n"
                    + "background-image:url(images/main.jpg);\n"
                    + "background-repeat:no-repeat;\n"
                    + "width:900px;\n"
                    + "height:450px;	\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + ".off\n"
                    + "{\n"
                    + "color:#3A6028;\n"
                    + "	\n"
                    + "}\n"
                    + "\n"
                    + "html, body {\n"
                    + "text-align: center;\n"
                    + "}\n"
                    + "p {text-align: left;}");
            out.println("#margine\n"
                    + "{\n"
                    + "	text-align:left;\n"
                    + "	margin-left: 100px;\n"
                    + "}");
            out.println("</style>");
            out.println("</head>");

            out.println("<body>");
            out.println("<div id='container'>");
            out.println("<div id='mainpic'>");
            out.println("<h1>Magazin<span class='off'>Online</span></h1>");
            out.println("<br>");

            out.println("</div>");
            //out.println("<h2>Bine ai venit, " + request.getSession().getAttribute("user") + "!</h2>");
            out.println("</div>");

            out.println("<br><br>");

            out.println("<div id = 'margine'>");
            out.println("<h1>Adauga Componenta: </h1>");
            out.println("<form action = 'AddComponenta' method = 'post' >"); //trimite toate inf de mai jos in AddAngajat printr un request

            out.println("Pret: ");
            out.println("<input name = 'pret' />");

            out.println("Marca: ");
            out.println("<input name = 'marca' />");

            out.println("AnFabricatie: ");
            out.println("<input name = 'anFabricatie' />");

            out.println("Garantie: ");
            out.println("<input name = 'garantie' />");

            out.println("Producator: ");
            out.println("<input name = 'producator' />");

            out.println("TaraProvenienta: ");
            out.println("<input name = 'taraProvenienta' />");

            out.println("<br>");

            out.println("Tip Componenta: ");
            out.println("<input name = 'selectOption' />");

            out.println("<br>");

            out.println("<button type = 'submit'> Adauga </button>");

            out.println("</form>");
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
