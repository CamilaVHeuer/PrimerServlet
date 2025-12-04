
package com.mycompany.primerservlet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    //instancio a la controladora de la logica
    Controladora control = new Controladora();

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //me traigo el id del usuario y lo convierto a entero
        int id_editar= Integer.parseInt(request.getParameter("id_usuarioEditar"));
        
        //me traigo los datos del usuario correspondiente a ese id.
        Usuario usu = control.traerUsuario(id_editar);
        
        //me guardo el usuario como variable de sesion ya que sino no voy a poder acceder a él en el jsp al que redirecciono
        
        HttpSession miSesion= request.getSession();
        miSesion.setAttribute("usuEditar", usu);
        
        //redirecciono a un nuevo jsp para la edicion
        response.sendRedirect("editar.jsp");
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dni = request.getParameter("dni"); 
        String nombre = request.getParameter("nombre"); 
        String apellido = request.getParameter("apellido"); 
        String telefono = request.getParameter("telefono"); 
        
        //me traigo el usuario de la session y le modifico los valores
        Usuario usu = (Usuario) request.getSession().getAttribute("usuEditar");
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);
        
        //llamo a la logica con editarUsuario(usu);
        control.editarUsuario(usu);
        
        //redirecciono
        response.sendRedirect("index.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
