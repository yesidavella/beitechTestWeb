/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitech.controller;

import com.beitech.model.CatalogForm;
import com.beitech.model.dao.CatalogDao;
import com.beitech.model.dao.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yesid
 */
public class ModifyCatalogSrv extends HttpServlet {
    
    private final String insert ="INSERT";
    private final String delete ="DELETE";

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
        
        boolean success = false;
        response.setContentType("text/html;charset=UTF-8");
        
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        int idProduct = Integer.parseInt(request.getParameter("idProduct"));
        String operation = request.getParameter("operation");
        
        DAOFactory daoFactory = DAOFactory.getInstance();
        CatalogDao catalogDao = daoFactory.getCatalogDAO();
        
        CatalogForm catalogForm = new CatalogForm();
        catalogForm.setIdProduct(idProduct);
        catalogForm.setIdCustomer(idCustomer);
        
        if(operation.equalsIgnoreCase(insert)){
            success = catalogDao.insertProductInCatalog(catalogForm);
        }else if(operation.equalsIgnoreCase(delete)){
            success = catalogDao.deleteProductInCatalog(catalogForm);
        }
        
        if(!success){
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
