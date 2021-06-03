/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AgeCalculatorServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Main
 */
public class AgeCalculatorServlet extends HttpServlet
{
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
            throws ServletException, IOException 
    {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        boolean isValid = true,
                isEmpty = false;
        
        int tempAge = 0;
        
        String age = request.getParameter("ageinput"),
               message = "<br>";
        
        if(age == "")
        {
            isEmpty = true;
        }
        request.setAttribute("age", age);
        
        
        try
        {
            tempAge = Integer.parseInt(age);
            tempAge++;
        }
        catch(NumberFormatException exception)
        {
            isValid = false;
        }
        
        if(isEmpty)
        {
            message += "You must give your current age";
        }
        else if(isValid)
        {
            message += "Your age next birthday will be " + tempAge;
        }
        else
        {
            message += "You must enter a number";
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }
}
