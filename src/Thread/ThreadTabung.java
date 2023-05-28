package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.Tabung;
import connector.Connector;

public class ThreadTabung extends Connector implements Runnable {

    ArrayList<Tabung> tabungs;

    public ThreadTabung(ArrayList<Tabung> tabungs) {
        this.tabungs = tabungs;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (Tabung tabung : tabungs) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Tabung");
                pstmt.setDouble(2, tabung.getCircumference());
                pstmt.setDouble(3, tabung.getArea());
                pstmt.setDouble(4, tabung.getSurfaceArea());
                pstmt.setDouble(5, tabung.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nKeratan Bola " + jumlah++ + " \n" +
                        "Keliling: " + tabung.getArea() + "\n" +
                        "Luas\t: " + tabung.getArea() + "\n" +
                        "Luas Permukaan\t: " + tabung.getSurfaceArea() + "\n" +
                        "Volume\t: " + tabung.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultTabung.txt", "rw")) {
            file.seek(file.length());
            // file.setLength(0) untuk mereset file
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            file.write(dtf.format(now).getBytes());
            file.write(result.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
