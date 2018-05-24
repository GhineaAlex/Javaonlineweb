package servlets;

import implementari.HDD;
import implementari.IOUtils;
import implementari.Memorie;
import implementari.Placadebaza;
import implementari.Procesor;
import implementari.Sursa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "ScadereStoc", urlPatterns = {"/ScadereStoc"})
public class ScadereStoc extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String codAsString = request.getParameter("cod");
        int id = 0;
        if (codAsString != null && !"".equals(codAsString)) {
            id = Integer.parseInt(codAsString);
        }
        switch (ComponentaServlet.getSelectOption().toLowerCase()) {
            case ("hdd"): {
                ArrayList<HDD> hdd = IOUtils.readHDD();
                HDD deModificat = getHDDbyID(id, hdd);
                IOUtils.updateScadStocHDD(deModificat);
                break;
            }
            case ("memorie"): {
                ArrayList<Memorie> mem = IOUtils.readMemorie();
                Memorie deModificat = getMemoriebyID(id, mem);
                IOUtils.updateScadStocMemorie(deModificat);
                break;
            }
            case ("placadebaza"): {
                ArrayList<Placadebaza> pb = IOUtils.readPlacadebaza();
                Placadebaza deModificat = getPlacadebazabyID(id, pb);
                IOUtils.updateScadStocPlacadebaza(deModificat);
                break;
            }
            case ("procesor"): {
                ArrayList<Procesor> proc = IOUtils.readProcesor();
                Procesor deModificat = getProcesorbyID(id, proc);
                IOUtils.updateScadStocProcesor(deModificat);
                break;
            }
            case ("sursa"): {
                ArrayList<Sursa> s = IOUtils.readSursa();
                Sursa deModificat = getSursabyID(id, s);
                IOUtils.updateScadStocSursa(deModificat);
                break;
            }

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Componenta.jsp");
        requestDispatcher.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdaugareStoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdaugareStoc.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdaugareStoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdaugareStoc.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private HDD getHDDbyID(int id, ArrayList<HDD> hdd) {
        for (HDD h : hdd) {
            if (id == h.getCodProdus()) {
                return h;
            }
        }
        return null;
    }

    private Memorie getMemoriebyID(int id, ArrayList<Memorie> hdd) {
        for (Memorie h : hdd) {
            if (id == h.getCodProdus()) {
                return h;
            }
        }
        return null;
    }

    private Placadebaza getPlacadebazabyID(int id, ArrayList<Placadebaza> hdd) {
        for (Placadebaza h : hdd) {
            if (id == h.getCodProdus()) {
                return h;
            }
        }
        return null;
    }

    private Procesor getProcesorbyID(int id, ArrayList<Procesor> hdd) {
        for (Procesor h : hdd) {
            if (id == h.getCodProdus()) {
                return h;
            }
        }
        return null;
    }

    private Sursa getSursabyID(int id, ArrayList<Sursa> hdd) {
        for (Sursa h : hdd) {
            if (id == h.getCodProdus()) {
                return h;
            }
        }
        return null;
    }

}