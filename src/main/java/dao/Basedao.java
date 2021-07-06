package dao;

import java.sql.*;

public class Basedao {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int exectuIUD(String sql, Object[] params) {
        int count = 0;
        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Basedao.closeAll(null, ps, conn);
        }
        return count;
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema?useSSL=false&serverTimezone=Asia/Shanghai", "root", "a22475957");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }

    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();

            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
