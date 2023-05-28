package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.TemberengBola;
import connector.Connector;

public class ThreadTemberengBola extends Connector implements Runnable {

    private ArrayList<TemberengBola> temberengBolas;

    public ThreadTemberengBola(ArrayList<TemberengBola> temberengBolas) {
        this.temberengBolas = temberengBolas;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (TemberengBola temberengBola : temberengBolas) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Tembereng Bola");
                pstmt.setDouble(2, temberengBola.getCircumference());
                pstmt.setDouble(3, temberengBola.getArea());
                pstmt.setDouble(4, temberengBola.getSurfaceArea());
                pstmt.setDouble(5, temberengBola.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nKeratan Bola " + jumlah++ + " \n" +
                        "Keliling: " + temberengBola.getArea() + "\n" +
                        "Luas\t: " + temberengBola.getArea() + "\n" +
                        "Luas Permukaan\t: " + temberengBola.getSurfaceArea() + "\n" +
                        "Volume\t: " + temberengBola.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultTemberengBola.txt", "rw")) {
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
