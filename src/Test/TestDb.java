package Test;

import Bean.Accident;
import Util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhao on 2016/10/23.
 */
public class TestDb {
    public static void main(String[] args){
        /*Accident accident = new Accident("3101044201500060", 0, "中山南二路进东安路西约200米", "2015-11-28 16:53:00");
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConn();

        String sql = "insert into accident values (null, ?, ?, ?, ?)";
        PreparedStatement pstmt = dbUtil.prepare(conn, sql);
        try {
            pstmt.setString(1, accident.getAccidentNumber());
            pstmt.setInt(2, accident.getAccidentLevel());
            pstmt.setString(3, accident.getAccidentAddress());
            pstmt.setString(4, accident.getAccidentDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(pstmt);
            dbUtil.close(conn);
        }*/
    }

}
