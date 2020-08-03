//package com.util;
//
//import com.core.entity.RedefinitionUserDetail;
//import com.core.entity.User;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by lenovo
// * Date 2020/7/27 13:46
// */
//public class JwtUtils {
//    public static final String TOKEN_HEADER = "Authorization";
//    public static final String TOKEN_PREFIX = "Bearer ";
//
//    public static final String SUBJECT = "congge";
//
//    public static final long EXPIRITION = 1000 * 24 * 60 * 60 * 7;
//
//    public static final String APPSECRET_KEY = "congge_secret";
//
//    private static final String ROLE_CLAIMS = "rol";
//
//    public static String generateJsonWebToken(User user) {
//
//        Map<String,Object> map = new HashMap<>();
//        map.put(ROLE_CLAIMS, "rol");
//
//        String token = Jwts
//                .builder()
//                .setSubject(SUBJECT)
//                .setClaims(map)
//                .claim("id", user.getUserId())
//                .claim("name", user.getUserName())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
//                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
//        return token;
//    }
//
//    /**
//     * 生成token
//     * @param username
//     * @param role
//     * @return
//     */
//    public static String createToken(String username,String role) {
//
//        Map<String,Object> map = new HashMap<>();
//        map.put(ROLE_CLAIMS, role);
//
//        String token = Jwts
//                .builder()
//                .setSubject(username)
//                .setClaims(map)
//                .claim("username",username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRITION))
//                .signWith(SignatureAlgorithm.HS256, APPSECRET_KEY).compact();
//        return token;
//    }
//
//    public static Claims checkJWT(String token) {
//        try {
//            final Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//            return claims;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 验证令牌
//     *
//     * @param token       令牌
//     * @param userDetails 用户
//     * @return 是否有效
//     */
//    public static Boolean validateToken(String token, UserDetails userDetails) {
//        RedefinitionUserDetail user = (RedefinitionUserDetail) userDetails;
//        String username = getUsername(token);
//        return (username.equals(user.getUsername()) && !isExpiration(token));
//    }
//
//    /**
//     * 获取用户名
//     * @param token
//     * @return
//     */
//    public static String getUsername(String token){
//        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//        return claims.get("username").toString();
//    }
//
//    /**
//     * 获取用户角色
//     * @param token
//     * @return
//     */
//    public static String getUserRole(String token){
//        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//        return claims.get("rol").toString();
//    }
//
//    /**
//     * 是否过期
//     * @param token
//     * @return
//     */
//    public static boolean isExpiration(String token){
//        Claims claims = Jwts.parser().setSigningKey(APPSECRET_KEY).parseClaimsJws(token).getBody();
//        return claims.getExpiration().before(new Date());
//    }
//
//    public static void main(String[] args) {
//        String name = "111";
//        String role = "222";
//        String token = createToken(name,role);
//        System.out.println(token);
//
//        Claims claims = checkJWT(token);
//        System.out.println(claims.get("username"));
//
//        System.out.println(getUsername(token));
//        System.out.println(getUserRole(token));
//        System.out.println(isExpiration(token));
//
//    }
//
//}