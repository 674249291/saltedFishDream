package com.saltedfish.web.filter;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saltedfish.entity.User;

@WebFilter(filterName="FileCaptureFilter",urlPatterns={"/test/index","/test/home"})
public class FileCaptureFilter implements Filter{

    private String protDirPath;

    private FilterConfig filterConfig;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws IOException, ServletException {

        User loginUser = (User) ((HttpServletRequest)request).getSession().getAttribute("user");

        if (loginUser == null){
            loginUser = new User();
            loginUser.setId(1);
        }

        String fileName = "F:/tmp/userId_"+loginUser.getId()+".html";

        File file = new File(filterConfig.getServletContext().getRealPath(fileName));

        // 判断缓存文件是否存在或者是否重新设置了缓存内容
        if (!file.exists()) {// 如果缓存文件不存在
            fileName=protDirPath+fileName;
            FileCaptureResponseWrapper responseWrapper = new
                    FileCaptureResponseWrapper((HttpServletResponse)response);
            chain.doFilter(request, responseWrapper);
            //得到的html 页面结果字符串
            //String html = responseWrapper.toString();
            // 写成html 文件
            responseWrapper.writeFile(fileName);
            // back to browser
            responseWrapper.writeResponse();

        }else{
            // 转发至缓存文件
            request.getRequestDispatcher(fileName).forward(request, response);

        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        this.filterConfig=arg0;
        protDirPath = arg0.getServletContext().getRealPath("/");
    }
}
