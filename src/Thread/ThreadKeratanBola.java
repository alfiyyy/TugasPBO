package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.KeratanBola;
import connector.Connector;

public class ThreadKeratanBola extends Connector implements Runnable {

    private ArrayList<KeratanBola> keratanBolas;

    public ThreadKeratanBola(ArrayList<KeratanBola> keratanBolas) {
        this.keratanBolas = keratanBolas;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (KeratanBola keratanBola : keratanBolas) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Keratan Bola");
                pstmt.setDouble(2, keratanBola.getCircumference());
                pstmt.setDouble(3, keratanBola.getArea());
                pstmt.setDouble(4, keratanBola.getSurfaceArea());
                pstmt.setDouble(5, keratanBola.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nKeratan Bola " + jumlah++ + " \n" +
                        "Keliling: " + keratanBola.getArea() + "\n" +
                        "Luas\t: " + keratanBola.getArea() + "\n" +
                        "Luas Permukaan\t: " + keratanBola.getSurfaceArea() + "\n" +
                        "Volume\t: " + keratanBola.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultKeratanBola.txt", "rw")) {
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
