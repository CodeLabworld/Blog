package com.cong.Utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {

    //设置token过期时间
    public static final int EXPIRE = 7;
    //设置密钥
    public static final String APP_SECRET = "fsdfaediviasefnlafsadc";

    /**
     * 生成token
     *
     * @param map //传入payload
     * @return 返回token
     */
    public static String creatToken(Map<String, Object> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, (String) v);
        });
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, EXPIRE);
        builder.withExpiresAt(instance.getTime());
        return builder.sign(Algorithm.HMAC256(APP_SECRET));
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(APP_SECRET)).build().verify(token);  // 如果验证通过，则不会把报错，否则会报错

    }

    /**
     * 获取token中payload
     *
     * @param token
     * @return
     */
    public static DecodedJWT getToken(String token) {
        return JWT.require(Algorithm.HMAC256(APP_SECRET)).build().verify(token);
    }


}
