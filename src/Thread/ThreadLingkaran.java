package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangundatar.Lingkaran;
import connector.Connector;

public class ThreadLingkaran extends Connector implements Runnable {

    ArrayList<Lingkaran> lingkarans;

    public ThreadLingkaran(ArrayList<Lingkaran> lingkarans) {
        this.lingkarans = lingkarans;
    }

    @Override
    public void run() {
        int jumlah = 1;

        for (Lingkaran lingkaran : lingkarans) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Lingkaran");
                pstmt.setDouble(2, lingkaran.getCircumference());
                pstmt.setDouble(3, lingkaran.getArea());
                pstmt.setDouble(4, 0);
                pstmt.setDouble(5, 0);
                pstmt.executeUpdate();

                String result = "\n----------\nKeratan Bola " + jumlah++ + " \n" +
                        "Keliling: " + lingkaran.getArea() + "\n" +
                        "Luas\t: " + lingkaran.getArea() + "\n" +
                        "Luas Permukaan\t: " + 0 + "\n" +
                        "Volume\t: " + 0 + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultLingkaran.txt", "rw")) {
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
