package service;

import dao.Basedao;
import entity.LMONKEY_USER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LMONKEY_USERDao {
    public static int insert(LMONKEY_USER u) {
        String sql = "insert into lmonkey_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
                u.getUSER_ID(),
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS()

        };
        return Basedao.exectuIUD(sql, params);
    }

    public static ArrayList<LMONKEY_USER> selectAll(int page, int count, String keyword) {
        ArrayList<LMONKEY_USER> list = new ArrayList<>();
        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        try {
            if (keyword != null) {
                sql = "select * from lmonkey_user where USER_ID like ? order by USER_BIRTHDAY desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");
                ps.setInt(2, (page - 1) * count);
                ps.setInt(3, count);
            } else {
                sql = "select * from lmonkey_user order by USER_BIRTHDAY desc limit ?,?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (page - 1) * count);
                ps.setInt(2, count);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                LMONKEY_USER u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return list;
    }

    public static int[] totalPage(int count, String keyword) {
        int arr[] = {0, 1};//总数，总页数
        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        try {
            if (keyword != null) {
                sql = "select count(*) from lmonkey_user where USER_ID like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + keyword + "%");

            } else {
                sql = "select count(*) from lmonkey_user";
                ps = conn.prepareStatement(sql);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                arr[0] = rs.getInt(1);
                if (arr[0] % count == 0) {
                    arr[1] = arr[0] / count;
                } else {
                    arr[1] = arr[0] / count + 1;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return arr;
    }

    public static LMONKEY_USER selectById(String id) {
        LMONKEY_USER user = null;
        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        try {
            sql = "select m.*,DATE_FORMAT(m.user_birthday,'%y-%m-%d') birthday from lmonkey_user m where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                user = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("birthday"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return user;
    }

    public static int update(LMONKEY_USER u) {
        String sql = "update lmonkey_user set USER_NAME=?, USER_PASSWORD=?, USER_SEX=?, USER_BIRTHDAY=?, USER_IDENITY_CODE=?, USER_EMAIL=?, USER_MOBILE=?, USER_ADDRESS=?,USER_STATUS=? where USER_ID = ?";
        Object[] params = {
                u.getUSER_NAME(),
                u.getUSER_PASSWORD(),
                u.getUSER_SEX(),
                u.getUSER_BIRTHDAY(),
                u.getUSER_IDENITY_CODE(),
                u.getUSER_EMAIL(),
                u.getUSER_MOBILE(),
                u.getUSER_ADDRESS(),
                u.getUSER_STATUS(),
                u.getUSER_ID()

        };
        return Basedao.exectuIUD(sql, params);
    }

    public static int delete(String id) {
        String sql = "delete from lmonkey_user where USER_ID=? and USER_STATUS=1";
        Object[] params = {id};
        return Basedao.exectuIUD(sql, params);
    }

    public static int selectByName(String name) {
        int count = 0;

        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from lmonkey_user where USER_ID=? ";
            ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return count;
    }
    public static int selectByNM(String name, String pwd) {
        int count = 0;

        Connection conn = Basedao.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select count(*) from lmonkey_user where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, pwd);

            rs = ps.executeQuery();

            while(rs.next()) {
                count = rs.getInt(1);
            }



        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return count;
    }

    public static LMONKEY_USER selectAdmin(String name, String pwd) {

        LMONKEY_USER u = null;

        ResultSet rs = null;//声明结果集
        //获取连接对象
        Connection conn = Basedao.getConn();

        PreparedStatement ps = null;

        try {
            String sql = "select * from lmonkey_user where USER_ID=? and USER_PASSWORD=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, pwd);


            rs=ps.executeQuery();


            while(rs.next()) {
                u = new LMONKEY_USER(
                        rs.getString("USER_ID"),
                        rs.getString("USER_NAME"),
                        rs.getString("USER_PASSWORD"),
                        rs.getString("USER_SEX"),
                        rs.getString("USER_BIRTHDAY"),
                        rs.getString("USER_IDENITY_CODE"),
                        rs.getString("USER_EMAIL"),
                        rs.getString("USER_MOBILE"),
                        rs.getString("USER_ADDRESS"),
                        rs.getInt("USER_STATUS")
                );

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            Basedao.closeAll(rs, ps, conn);
        }
        return u;

    }

}
