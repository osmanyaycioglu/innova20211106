package com.training.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test/*")
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(final HttpServletRequest reqParam,
                      final HttpServletResponse respParam) throws ServletException, IOException {
        String parameterLoc = reqParam.getParameter("isim");
        //        ServletInputStream inputStreamLoc = reqParam.getInputStream();
        System.out.println("Servlet çalıştı " + parameterLoc);
        PrintWriter writerLoc = respParam.getWriter();
        writerLoc.println("Hello test");
        respParam.addHeader("Content-Type",
                            "text/plain");
    }

}
