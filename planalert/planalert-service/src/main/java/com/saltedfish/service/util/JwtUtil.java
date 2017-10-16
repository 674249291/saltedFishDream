package com.saltedfish.service.util;

import com.alibaba.druid.util.Base64;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.saltedfish.constant.Constant;
import com.saltedfish.dto.TokenUserDTO;
import com.saltedfish.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/16.
 * 使用jwt，传递token
 */
@Component
public class JwtUtil {


    /**
     * 由字符串生成加密key
     * @return
     */
    public SecretKey generalKey(){
        String stringKey =  Constant.JWT_SECRET;
        byte[] encodedKey = Base64.base64ToByteArray(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    /**
     * 创建 jwt
     * @param id
     * @param subject
     * @param ttlMillis 有效时间
     * @return
     * @throws Exception
     */
    public String createJWT(String id, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
        long nowMillis = System. currentTimeMillis();
        Date now = new Date( nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts. builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date( expMillis);
            builder.setExpiration( exp);
        }
        return builder.compact();
    }

    /**
     * 解密 jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts. parser()
                .setSigningKey( key)
                .parseClaimsJws( jwt).getBody();
        return claims;
    }
    /**
     * 生成subject信息
     * @param user
     * @return
     */
    public static String generalSubject(User user){
        JSONObject jo = new JSONObject();
        try {
            jo.put("userId", user.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //添加用户的权限
        // jo.put("roleId", user.getRoleId());
        return jo.toString();
    }

    /**
     * 第二种形式
     * 从用户中创建一个jwt Token
     * @param userDTO 用户
     * @return token
     */
    public String create(TokenUserDTO userDTO) {
        SecretKey key = generalKey();
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + Constant.JWT_TTL))
                .setSubject(userDTO.getUsername())
                .claim("id", userDTO.getId())
                .claim("avatar", userDTO.getAvatar())
                .claim("email", userDTO.getEmail())
                .claim("roles", userDTO.getRoles())
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
    /**
     * 从token中取出用户
     */
    public TokenUserDTO parse(String token) {
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        TokenUserDTO userDTO = new TokenUserDTO();
        userDTO.setId(NumberUtils.toLong(claims.getId()));
        userDTO.setAvatar(claims.get("avatar",String.class));
        userDTO.setUsername(claims.get("username",String.class));
        userDTO.setEmail(claims.get("email",String.class));
        userDTO.setRoles((List<String>) claims.get("roles"));
        return userDTO;
    }

}
