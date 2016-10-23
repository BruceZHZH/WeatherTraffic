package Bean;

import Util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhao on 2016/10/23.
 */
public class Accident {
    int id;
    String accidentNumber;
    String accidentAddress;
    int accidentYear;
    int accidentMonth;
    int accidentDay;
    int accidentHour;



    public Accident(){}

    public Accident(String accidentNumber, String accidentAddress, int accidentYear,
                    int accidentMonth, int accidentDay, int accidentHour) {
        this.accidentNumber = accidentNumber;
        this.accidentAddress = accidentAddress;
        this.accidentYear = accidentYear;
        this.accidentMonth = accidentMonth;
        this.accidentDay = accidentDay;
        this.accidentHour = accidentHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccidentNumber() {
        return accidentNumber;
    }

    public void setAccidentNumber(String accidentNumber) {
        this.accidentNumber = accidentNumber;
    }


    public String getAccidentAddress() {
        return accidentAddress;
    }

    public void setAccidentAddress(String accidentAddress) {
        this.accidentAddress = accidentAddress;
    }


    public int getAccidentYear() {
        return accidentYear;
    }

    public void setAccidentYear(int accidentYear) {
        this.accidentYear = accidentYear;
    }

    public int getAccidentMonth() {
        return accidentMonth;
    }

    public void setAccidentMonth(int accidentMonth) {
        this.accidentMonth = accidentMonth;
    }

    public int getAccidentDay() {
        return accidentDay;
    }

    public void setAccidentDay(int accidentDay) {
        this.accidentDay = accidentDay;
    }

    public int getAccidentHour() {
        return accidentHour;
    }

    public void setAccidentHour(int accidentHour) {
        this.accidentHour = accidentHour;
    }

    public static void addAccident(List<Accident> accidents){
        DbUtil dbUtil = new DbUtil();
        Connection conn = dbUtil.getConn();
        //id    number     address   year    month   day    hour
        String sql = "insert into accident values (null, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = dbUtil.prepare(conn, sql);
        Accident accident = null;
        try {
            int len = accidents.size();
            for(int i = 0; i < len; i++ ) {
                accident = accidents.get(i);
                pstmt.setString(1, accident.getAccidentNumber());
                pstmt.setString(2, accident.getAccidentAddress());
                pstmt.setInt(3, accident.getAccidentYear());
                pstmt.setInt(4, accident.getAccidentMonth());
                pstmt.setInt(5, accident.getAccidentDay());
                pstmt.setInt(6, accident.getAccidentHour());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.close(pstmt);
            dbUtil.close(conn);
        }
    }
}
