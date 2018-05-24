/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "StergeComponenta", urlPatterns = {"/StergeComponenta"})
public class StergeComponenta extends HttpServlet {

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
                HDD deSters = getHDDbyID(id, hdd);
                IOUtils.deleteHDD(deSters);
                break;
            }
            case ("memorie"): {
                ArrayList<Memorie> hdd = IOUtils.readMemorie();
                Memorie deSters = getMemoriebyID(id, hdd);
                IOUtils.deleteMemorie(deSters);
                break;
            }
            case ("placadebaza"): {
                ArrayList<Placadebaza> hdd = IOUtils.readPlacadebaza();
                Placadebaza deSters = getPlacadebazabyID(id, hdd);
                IOUtils.deletePlacadebaza(deSters);

                break;
            }
            case ("procesor"): {
                ArrayList<Procesor> hdd = IOUtils.readProcesor();
                Procesor deSters = getProcesorbyID(id, hdd);
                IOUtils.deleteProcesor(deSters);
                break;
            }
            case ("sursa"): {
                ArrayList<Sursa> hdd = IOUtils.readSursa();
                Sursa deSters = getSursabyID(id, hdd);
                IOUtils.deleteSursa(deSters);
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
            Logger.getLogger(StergeComponenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StergeComponenta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StergeComponenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StergeComponenta.class.getName()).log(Level.SEVERE, null, ex);
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
