/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArithmeticCalculatorServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Main
 */
public class ArithmeticCalculatorServlet extends HttpServlet {


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
        request.setAttribute("message", "---");
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
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
        boolean isNumber = true,
                notEmpty = true;
        
        int firstInt = 0,
            secondInt = 0,
            result = 0;
        
        String plus = request.getParameter("plus"),
               minus = request.getParameter("minus"),
               multiply = request.getParameter("multiply"),
               divide = request.getParameter("divide"),
               first = request.getParameter("first"),
               second = request.getParameter("second");
        
        if(first == "" || second == "")
        {
            notEmpty = false;
            request.setAttribute("message", "invalid");
        }
        
        
        if(notEmpty)
        {
            try
            {
                firstInt = Integer.parseInt(first);
                secondInt = Integer.parseInt(second);
            }
            catch(NumberFormatException exception)
            {
                isNumber = false;
                request.setAttribute("message", "invalid");
            }
        }
        
        if(notEmpty && isNumber)
        {
            if(plus != null)
            {
                result = firstInt + secondInt;
            }
            else if(minus != null)
            {
                result = firstInt - secondInt;
            }
            else if(multiply != null)
            {
                result = firstInt * secondInt;
            }
            else if(divide != null)
            {
                result = firstInt / secondInt;
            }
            
            request.setAttribute("message", result);
        }
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }
}
