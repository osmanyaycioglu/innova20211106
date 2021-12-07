package com.training.spring.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        String parameterLoc = requestParam.getParameter("isim");
        if ("ali".equalsIgnoreCase(parameterLoc)) {
            responseParam.getWriter()
                         .println("geçemezsin");
        } else {
            System.out.println("Filter Çalıştı");
            chainParam.doFilter(requestParam,
                                responseParam);
        }
    }

}
