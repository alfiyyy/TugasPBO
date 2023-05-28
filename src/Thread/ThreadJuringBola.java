package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.JuringBola;
import connector.Connector;

public class ThreadJuringBola extends Connector implements Runnable {

    private ArrayList<JuringBola> juringBolas;

    public ThreadJuringBola(ArrayList<JuringBola> juringBolas) {
        this.juringBolas = juringBolas;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (JuringBola juringBola : juringBolas) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Juring Bola");
                pstmt.setDouble(2, juringBola.getCircumference());
                pstmt.setDouble(3, juringBola.getArea());
                pstmt.setDouble(4, juringBola.getSurfaceArea());
                pstmt.setDouble(5, juringBola.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nJuring Bola " + jumlah++ + " \n" +
                        "Keliling: " + juringBola.getArea() + "\n" +
                        "Luas\t: " + juringBola.getArea() + "\n" +
                        "Luas Permukaan\t: " + juringBola.getSurfaceArea() + "\n" +
                        "Volume\t: " + juringBola.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultJuringBola.txt", "rw")) {
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
