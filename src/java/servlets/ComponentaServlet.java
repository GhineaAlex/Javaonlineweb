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
import static jdk.nashorn.internal.objects.NativeJava.type;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "ComponentaServlet", urlPatterns = {"/ComponentaServlet"})
public class ComponentaServlet extends HttpServlet {

    public static String selectOption;

    public static String getSelectOption() {
        return selectOption;
    }

    public static void setSelectOption(String selectOption) {
        ComponentaServlet.selectOption = selectOption;
    }

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
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
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
            
            out.println("<div class=\"clear\">");
            //out.println("</div>");
            out.println("</div>");
            //out.println("div class=\"clear\">");
            out.println("</div>");
            out.println("<div id=\"banner\">");
            out.println(" <h1>PG Shop</h1>");
            out.println("<div class=\"features\">");
            out.println(" <ul>");
            out.println("<li>Easy to use <br />");
            out.println("<span class=\"bannertxt\"> Databases</span>");
            out.println(" </li>");
            out.println("<li>Great security<br />");
            out.println(" <span class=\"bannertxt\">For our users</span>");
            out.println("</li>");
            out.println("<li>The best prices<br />");
            out.println("<span class=\"bannertxt\">For the buyers</span></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println(" <div class=\"compatibility\">");
            out.println(" <div class=\"compatibilitybox\">");
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("<div class=\"welCome\">");
            out.println("<div id=\"columZone\">");
            out.println("<div class=\"column1\">");
            out.println("<h3>AMD CPUs</h3>");
            out.println("<img src=\"images/product1.png\" alt=\"\" />");
            out.println("<div class=\"columnText\">The best CPU on the market<br /></div>");
            out.println("<div class=\"columnLink\">USD 249.99 <span class=\"order\">| <a href='AfisareProcesoare'>Order Now</a></span>"+" </div>");
            out.println("</div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>Intel CPUs</h3>");
            out.println("<img src=\"images/product6.png\" alt=\"\" />");
            out.println("<div class=\"columnText\">The most powerful CPUs<br /></div>");
            out.println("<div class=\"columnLink\">USD 349.99 <span class=\"order\">| <a href='AfisareProcesoare'>Order Now</a></span>"+" </div>");
            out.println("</div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>Power Supplies</h3>");
            out.println("<img src=\"images/product3.png\" alt=\"\" />");
            out.println("<div class=\"columnText1\">Powerful power supply for your PC<br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 49.99 <span class=\"order\">| <a href='AfisareSurse'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"column2\">");
            out.println("<h3>Motherboards</h3>");
            out.println(" <img src=\"images/product4.png\" alt=\"4\" />");
            out.println("<div class=\"columnText1\">The motherboard for your gaming system <br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 149.99 <span class=\"order\">| <a href='AfisarePlacidebaza'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>HDDs</h3>");
            out.println(" <img src=\"images/product7.png\" alt=\"4\" />");
            out.println("<div class=\"columnText1\">High capacity HDDs for your PC<br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 39.99 <span class=\"order\">| <a href='AfisareHDD'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>DDR4 Memories</h3>");
            out.println(" <img src=\"images/product5.png\" alt=\"4\" />");
            out.println("<div class=\"columnText1\">DDR4 memories for your PC<br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 59.99 <span class=\"order\">| <a href='AfisareMemorii'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>DDR3 Memories</h3>");
            out.println(" <img src=\"images/product5.png\" alt=\"4\" />");
            out.println("<div class=\"columnText1\">DDR3 memories for your PC<br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 49.99 <span class=\"order\">| <a href='AfisareMemorii'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"column1\">");
            out.println("<h3>SSHDs </h3>");
            out.println(" <img src=\"images/product8.png\" alt=\"4\" />");
            out.println("<div class=\"columnText1\">Fast storage unity<br />"+"</div>");
            out.println("<div class=\"columnLink\">USD 49.99 <span class=\"order\">| <a href='AfisareMemorii'>Order Now</a></span>"+" </div>");
            out.println(" </div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"bottom_container\">");
            out.println(" <div id=\"container1\">");
            out.println("<div class=\"welCome\">");
            out.println("<div class=\"welComeleft\"></div>");
            out.println(" <div class=\"welComeright\"></div>");
            out.println("<h2>WELCOME TO OUR SHOP </h2>");
            out.println("</div>");
            out.println("<div class=\"welCometextBox1\">");
            out.println("<div class=\"welCometext\"> <span class=\"welCometextBold\">Because we like potatos.</span> <br />");
            out.println(" <br />");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"welCometextBox2\">");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"clear\">");
            out.println("</div>");
            out.println("<div id=\"footer\">");
          
            out.println("<ul>");
            out.println("Copyright PG 2018");
            out.println(" </ul>");
            
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
           

            
            
            
            //out.println("</html>");
    }}
    

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

