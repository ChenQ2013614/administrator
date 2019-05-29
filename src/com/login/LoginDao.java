package com.login;

import java.util.List;
import java.util.Map;
import java.lang.Override;

import com.jdbc.JdbcUtils;

public class LoginDao implements LoginService {
    private JdbcUtils jdbcUtils;
    public LoginDao() {
        // TODO Auto-generated constructor stub
        jdbcUtils = new JdbcUtils();
    }
    @Override
    public boolean Login(List<Object> params) {
        // TODO Auto-generated method stub
        boolean flag=false;
        try{
            jdbcUtils.getConnection();
            String sql="select * from userinfo where username = ? and pswd = ?";
            Map<String,Object> map = jdbcUtils.findSimpleResult(sql, params);
            flag= !map.isEmpty()?true:false;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jdbcUtils.releaseConn();
        }
        return flag;
    }

}
