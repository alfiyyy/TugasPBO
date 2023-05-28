package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.Kerucut;
import connector.Connector;

public class ThreadKerucut extends Connector implements Runnable {

    private ArrayList<Kerucut> kerucuts;

    public ThreadKerucut(ArrayList<Kerucut> kerucuts) {
        this.kerucuts = kerucuts;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (Kerucut kerucut : kerucuts) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Kerucut");
                pstmt.setDouble(2, kerucut.getCircumference());
                pstmt.setDouble(3, kerucut.getArea());
                pstmt.setDouble(4, kerucut.getSurfaceArea());
                pstmt.setDouble(5, kerucut.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nKerucut " + jumlah++ + " \n" +
                        "Keliling: " + kerucut.getArea() + "\n" +
                        "Luas\t: " + kerucut.getArea() + "\n" +
                        "Luas Permukaan\t: " + kerucut.getSurfaceArea() + "\n" +
                        "Volume\t: " + kerucut.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultKerucut.txt", "rw")) {
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
