import Bean.Accident;
import Util.TimeUtil;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherTraffic {
//D:/Codes/java/WeatherTraffic//trafficaccident.xlsx
    public static void main(String[] args) {
        jxl.Workbook workbook = null;
        String accident_number = null;
        String accident_level = null;
        String accident_address = null;
        String accident_date = null;
        int[] dateDetail = null;
        try {
            File file = new File("D:/Codes/java/WeatherTraffic//trafficaccident.xls");
            InputStream inputStream = new FileInputStream(file);
            workbook = Workbook.getWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(0);
            int columns = sheet.getColumns();
            int rows = sheet.getRows();
            Accident accident = null;
            List<Accident> accidents = new ArrayList<Accident>();
            List<String> accidentContent = null;
            for(int i = 1; i < rows; i++){
                dateDetail = new int[4];
                accident = new Accident();
                accidentContent = new ArrayList<String>();
                for(int j = 0; j < columns; j++){
                    Cell cell = sheet.getCell(j, i);
                    accidentContent.add(j, cell.getContents());
                }
                accident_number = accidentContent.get(1);
                accident_level = accidentContent.get(2);
                accident_address = accidentContent.get(3);
                accident_date = accidentContent.get(4);
                //System.out.println(accident_number + " " + accident_address + " " + accident_date);
                dateDetail = TimeUtil.parseTime(accident_date);
                //System.out.println(dateDetail[0] + " " + dateDetail[1] + " " + dateDetail[2]);
                accident = new Accident(accident_number, accident_address, dateDetail[0],
                        dateDetail[1], dateDetail[2], dateDetail[3]);
                accidents.add(accident);
            }
            accident.addAccident(accidents);

            //System.out.println("Columns: " + columns + "Rows: " + rows);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
