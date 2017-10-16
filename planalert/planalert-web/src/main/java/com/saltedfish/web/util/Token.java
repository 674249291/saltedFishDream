package com.saltedfish.web.util;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 * 使用token,并存入session中进行身份验证
 * javaweb带身份认证的，防止表单重复提交
 * 前端页面
 * <form>
    <input type="hidden" name="<%=Token.TOKEN_STRING_NAME %>" value="<%=Token.getTokenString(session) %>">
   </form>
 * 后台逻辑页面
 * if(Token.isTokenStringValid(request.getParameter(Token.TOKEN_STRING_NAME), request.getSession())){
    //To Do 业务代码
    }
 * 改进：将token存在session中，是否要存入到redis中，在分布式的情况下？一般情况下，都是在同一台服务器上面操作的，这样的话就不需要考虑到分布式的问题了
 */
public class Token {
    private static final String TOKEN_LIST_NAME = "tokenList";
    public static final String TOKEN_STRING_NAME = "token";

    private static ArrayList getTokenList(HttpSession session) {
        Object obj = session.getAttribute(TOKEN_LIST_NAME);
        if (obj != null) {
            return (ArrayList) obj;
        } else {
            ArrayList tokenList = new ArrayList();
            session.setAttribute(TOKEN_LIST_NAME, tokenList);
            return tokenList;
        }
    }

    private static void saveTokenString(String tokenStr, HttpSession session) {
        ArrayList tokenList = getTokenList(session);
        tokenList.add(tokenStr);
        session.setAttribute(TOKEN_LIST_NAME, tokenList);
    }

    private static String generateTokenString(){
        return new Long(System.currentTimeMillis()).toString();
    }

/** *//**
     * Generate a token string, and save the string in session, then return the token string.
     * @return a token string used for enforcing a single request for a particular transaction.
     */

    public static String getTokenString(HttpSession session) {
        String tokenStr = generateTokenString();
        saveTokenString(tokenStr, session);
        return tokenStr;
    }

/** *//**

     * check whether token string is valid. if session contains the token string, return true.
     * otherwise, return false.
     * @return true: session contains tokenStr; false: session is null or tokenStr is id not in session
     */

    public static boolean isTokenStringValid(String tokenStr, HttpSession session) {
        boolean valid = false;
        if(session != null){
            ArrayList tokenList = getTokenList(session);
            if (tokenList.contains(tokenStr)) {
                valid = true;
                tokenList.remove(tokenStr);
            }
        }
        return valid;
    }
}