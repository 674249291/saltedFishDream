package com.saltedfish.web.filter;


import com.alibaba.fastjson.JSONObject;
import com.saltedfish.constant.Constant;
import com.saltedfish.entity.User;
import com.saltedfish.service.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/refreshToken" )
public class RefreshToken extends HttpServlet {

	private Logger logger = LogManager.getLogger(RefreshToken.class);
	
	private static final long serialVersionUID = 2573245614706073195L;
	
	@Autowired
	private JwtUtil jwt;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	response.setContentType( "text/event-stream;charset=UTF-8" );
            response.setHeader( "Cache-Control", "no-cache" );
            response.setHeader( "Connection", "keep-alive" );
            PrintWriter out = response.getWriter();
        	String token = request.getParameter("token");
        	//解密jwt
        	Claims claims = jwt.parseJWT(token);
     		String json = claims.getSubject();
     		User user = JSONObject.parseObject(json, User.class);
     		String subject = JwtUtil.generalSubject(user);
     		String refreshToken = jwt.createJWT(Constant.JWT_ID, subject, Constant.JWT_TTL);
            out.print("retry: "+Constant.JWT_REFRESH_INTERVAL+ "\n" );
     		out.print("data: "+refreshToken+"\n\n" );
            out.flush();
          } catch (Exception e) {
        	  logger.error(e);
          }
     }

}
