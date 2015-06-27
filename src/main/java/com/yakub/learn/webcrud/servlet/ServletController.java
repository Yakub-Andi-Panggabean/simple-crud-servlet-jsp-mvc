package com.yakub.learn.webcrud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yakub.learn.webcrud.Dao.PegawaiDao;
import com.yakub.learn.webcrud.Dao.Impl.PegawaiDaoImpl;
import com.yakub.learn.webcrud.model.Pegawai;

/**
 * Servlet implementation class ServletController
 */
public class ServletController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  private PegawaiDao dao;

  public ServletController() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    try {
      System.out.println("Exec");
      dao = new PegawaiDaoImpl();
      List<Pegawai> list = dao.getAll();
      request.setAttribute("pegawais", list);
      String url = "form.jsp";
      request.getRequestDispatcher(url).forward(request, response);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    try {
      dao = new PegawaiDaoImpl();
      Pegawai p = new Pegawai(request.getParameter("nama"), request.getParameter("alamat"));
      String action = request.getParameter("act");
      if (action.equalsIgnoreCase("save")) {
        System.out.println("insert");
        System.out.println(p.getNama());
        System.out.println(p.getAlamat());
        dao.insert(p);
      } else if (action.equalsIgnoreCase("update")) {
        System.out.println("update");
        dao.update(p);
      } else if (action.equalsIgnoreCase("delete")) {
        System.out.println("delete");
        dao.delete(p.getNama());
      }
      List<Pegawai> list = dao.getAll();
      if (list.size() > 0) {
        request.setAttribute("pegawais", list);
        String url = "form.jsp";
        request.getRequestDispatcher(url).forward(request, response);
      }
      // response.sendRedirect("/JavaWebCrud/form.jsp");
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

}
