package com.dbexercise;

import domain.User;

import java.sql.*;
import java.util.Map;

public class UserDao {
    public void add() throws SQLException,ClassNotFoundException {
        // 커넥션 생성
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD"); // db 보안

        Class.forName("com.mysql.cj.jdbc.Driver");
//
        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);  // DB 연결
        PreparedStatement ps = conn.prepareStatement(                               // 쿼리 직접 작성
                "INSERT INTO users(id, name, password) VALUES(?, ?, ?)"
        );
        ps.setString(1, "1");   // 쿼리에 값 바인딩
        ps.setString(2, "jiwon");
        ps.setString(3, "3307");

        ps.executeUpdate();     // Contol+enter -> 쿼리 실행
        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Map<String, String> env = System.getenv();
        String dbHost = env.get("DB_HOST");
        String dbUser = env.get("DB_USER");
        String dbPassword = env.get("DB_PASSWORD");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(dbHost, dbUser, dbPassword);  // DB 연결
        PreparedStatement ps = conn.prepareStatement(                               // 쿼리 직접 작성
                "SELECT id, name, password FROM users WHERE id=?");
        ps.setString(1, id);       // id : get(String id) 받은 id
        ResultSet rs = ps.executeQuery();       // ResultSet : 쿼리 실행 결과가 담겨 있습니다.

        rs.next();                              // rs.getString 을 통해 column 값을 꺼낼 수 잇음.

        User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("password"));
        rs.close();
        ps.close();
        conn.close();
        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
/*      값 추가
        userDao.add();
 */
        // 값 출력
        User user = userDao.get("0");
        System.out.println(user.getName());
    }

}
