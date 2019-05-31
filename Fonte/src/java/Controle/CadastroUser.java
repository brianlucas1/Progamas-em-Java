/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bcamargo
 */
public class CadastroUser extends HttpServlet {

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
            
            // PEGA OS PARAMETROS DE ACORDO COM O CAMPO DE TEXTO CRIADO NA TELA CADASTRO.HTML
           
            String cad =request.getParameter("cad");
            if(cad.equals("TelaCadastro")){
            String Nome = (request.getParameter("Nome"));
            String Sobrenome = (request.getParameter("Sobrenome"));
            String CPF = (request.getParameter("CPF"));
            String Telefone = (request.getParameter("Telefone"));
            String Celular  = (request.getParameter("Celular"));
            String Endereco  = (request.getParameter("Endereco"));
            String Complemento  = (request.getParameter("Complemento"));
            String Cidade  = (request.getParameter("Cidade"));
            String Estado  = (request.getParameter("Estado"));
            String Cep = (request.getParameter("Cep"));
            String Email = (request.getParameter("Email"));
            String dataEmTexto = (request.getParameter("dataNascimento"));
            Calendar dataNascimento = null;
           
             // fazendo a conversão da data
                try {
                    Date date = new SimpleDateFormat("dd/MM/yyyy")
                            .parse(dataEmTexto);
                    dataNascimento = Calendar.getInstance();
                    dataNascimento.setTime(date);
                } catch (ParseException e) {
                    out.println("Erro de conversão da data");
                    return; //para a execução do método
                }
                
                
            }
            
            
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
