/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.primerservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    //instancio una controladora logica
    Controladora control = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //creo la lista de usuarios que por ahora es mi BD lógica
        List<Usuario> listaUsuarios = new ArrayList<>();
        
        listaUsuarios = control.traerUsuarios();

        
        //me traigo la session de la request
        HttpSession miSesion= request.getSession();
        //seteo la lista de usuarios a la sesion
        miSesion.setAttribute("listaUsuarios", listaUsuarios);
        
        //ahora debo redireccionar la respuesta a otra pagina jsp
        response.sendRedirect("mostrarUsuarios.jsp");
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni"); 
        String nombre = request.getParameter("nombre"); 
        String apellido = request.getParameter("apellido"); 
        String telefono = request.getParameter("telefono"); 
        
        //creo un usuario para poder pasarle a la controladora y que esta use el metodo crearUsuario(usu)
        Usuario usu = new Usuario(dni, nombre, apellido, telefono); 
        
        //doy el ALTA
        control.crearUsuario(usu);
        //que redirecciones al index
        response.sendRedirect("index.jsp");
        
        
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
