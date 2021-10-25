/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.me.controller;

import com.me.pojo.Movie;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Jaeline
 */
@WebServlet(name = "MovieController", urlPatterns = {"/movie.do"})
public class MovieController extends HttpServlet {

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

        String selection = request.getParameter("selection");

        if (selection!= null && selection.equals("browse")) {
            request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp").forward(request, response);
        } else if (selection!=null && selection.equals("add")) {
            request.getRequestDispatcher("/WEB-INF/jsp/entermovie.jsp").forward(request, response);
        }

        if (selection!= null && selection.equals("added")) {
            Movie m1 = new Movie();
            m1.setTitle(request.getParameter("title"));
            m1.setActor(request.getParameter("actor"));
            m1.setActress(request.getParameter("actress"));
            m1.setGenre(request.getParameter("genre"));
            m1.setYear(request.getParameter("year"));

            try {      
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mymovies?useSSL=false", "root", "jaeline");
                String sql = "insert into movies values (?, ?, ?, ?, ?)";
                PreparedStatement prep = conn.prepareStatement(sql);
                prep.setString(1, m1.getTitle());
                prep.setString(2, m1.getActor());
                prep.setString(3, m1.getActress());
                prep.setString(4, m1.getGenre());
                prep.setString(5, m1.getYear());
                prep.executeUpdate();
                prep.close();
                conn.close();

            } catch (ClassNotFoundException ex) {
                out.println("Error loading driver");
            } catch (SQLException e) {
                out.println("Error with connection");
            }
            request.getRequestDispatcher("/WEB-INF/jsp/added.jsp").forward(request, response);

        } else if (selection!=null && selection.equals("browsed")) {
            String keyword = request.getParameter("keyword");
            String search = request.getParameter("search");
            ArrayList<Movie> movieList = new ArrayList<Movie>();
            try {    
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mymovies?useSSL=false", "root", "jaeline");
                String query = "SELECT * FROM MOVIES WHERE " + search + " like ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, "%" + keyword + "%");
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Movie movie = new Movie();
                    movie.setTitle(rs.getString("title"));
                    movie.setActor(rs.getString("actor"));
                    movie.setActress(rs.getString("actress"));
                    movie.setGenre(rs.getString("genre"));
                    movie.setYear(rs.getString("year"));
                    movieList.add(movie);
                }
                conn.close();
            } catch (ClassNotFoundException ex) {
                out.println("Error loading driver");
            } catch (SQLException e) {
                out.println("Error with connection");
            }
            
            request.setAttribute("movies", movieList);//Put list collection data into request for sharing
            request.getRequestDispatcher("/WEB-INF/jsp/results.jsp").forward(request, response);

        }
        String homepage = request.getParameter("name");
        if (homepage!= null && homepage.equals("home")) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
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
