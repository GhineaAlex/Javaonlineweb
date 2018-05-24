/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Crud.CrudHDD;
import Crud.CrudSursa;
import implementari.HDD;
import implementari.IOUtils;
import implementari.Memorie;
import implementari.Placadebaza;
import implementari.Procesor;
import implementari.Sursa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.ComponentaServlet;

/**
 *
 * @author Valentin
 */
@WebServlet(name = "AddComponenta", urlPatterns = {"/AddComponenta"})
public class AddComponenta extends HttpServlet {

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
        String pretAsString = request.getParameter("pret");
        double pret = 0;
        if (pretAsString != null && !"".equals(pretAsString)) {
            pret = Double.parseDouble(pretAsString);
        }

        String anAsString = request.getParameter("anFabricatie");
        int an = 0;
        if (anAsString != null && !"".equals(anAsString)) {
            an = Integer.parseInt(anAsString);
        }

        String garantieAsString = request.getParameter("garantie");
        int garantie = 0;
        if (garantieAsString != null && !"".equals(garantieAsString)) {
            garantie = Integer.parseInt(garantieAsString);
        }
        
        String option = request.getParameter("selectOption");
        ComponentaServlet.setSelectOption(option);

        switch (ComponentaServlet.getSelectOption().toLowerCase()) {
            case ("hdd"): {
                HDD hdd = new HDD(pret, request.getParameter("marca"), an, garantie, request.getParameter("producator"),
                        request.getParameter("taraProvenienta"), 1);
                System.out.println(hdd);
                IOUtils.addHDD(hdd);
                break;
            }
            case ("memorie"): {
                Memorie mem = new Memorie(pret, request.getParameter("marca"), an, garantie, request.getParameter("producator"),
                        request.getParameter("taraProvenienta"), 1);
                System.out.println(mem);
                IOUtils.addMemorie(mem);
                break;
            }
            case ("placadebaza"): {
                Placadebaza pb = new Placadebaza(pret, request.getParameter("marca"), an, garantie, request.getParameter("producator"),
                        request.getParameter("taraProvenienta"), 1);
                System.out.println(pb);
                IOUtils.addPlacadebaza(pb);

                break;
            }
            case ("procesor"): {
                Procesor procesor = new Procesor(pret, request.getParameter("marca"), an, garantie, request.getParameter("producator"),
                        request.getParameter("taraProvenienta"), 1);
                System.out.println(procesor);
                IOUtils.addProcesor(procesor);
                break;
            }
            case ("sursa"): {
                Sursa s = new Sursa(pret, request.getParameter("marca"), an, garantie, request.getParameter("producator"),
                        request.getParameter("taraProvenienta"), 1);
                System.out.println(s);
                IOUtils.addSursa(s);
                break;
            }
            default:
            {
                
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
            Logger.getLogger(AddComponenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddComponenta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddComponenta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddComponenta.class.getName()).log(Level.SEVERE, null, ex);
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

}