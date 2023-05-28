package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.KerucutTerpancung;
import connector.Connector;

public class ThreadKerucutTerpancung extends Connector implements Runnable {

    private ArrayList<KerucutTerpancung> kerucutTerpancungs;

    public ThreadKerucutTerpancung(ArrayList<KerucutTerpancung> kerucutTerpancungs) {
        this.kerucutTerpancungs = kerucutTerpancungs;
    }

    @Override
    public void run() {
        int jumlah = 1;
        for (KerucutTerpancung kerucutTerpancung : kerucutTerpancungs) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Kerucut Terpancung");
                pstmt.setDouble(2, kerucutTerpancung.getCircumference());
                pstmt.setDouble(3, kerucutTerpancung.getArea());
                pstmt.setDouble(4, kerucutTerpancung.getSurfaceArea());
                pstmt.setDouble(5, kerucutTerpancung.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nKerucut Terpancung " + jumlah++ + " \n" +
                        "Keliling: " + kerucutTerpancung.getArea() + "\n" +
                        "Luas\t: " + kerucutTerpancung.getArea() + "\n" +
                        "Luas Permukaan\t: " + kerucutTerpancung.getSurfaceArea() + "\n" +
                        "Volume\t: " + kerucutTerpancung.getVolume() + "\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    private void writeTofile(String result) {
        try (RandomAccessFile file = new RandomAccessFile("ResultKerucutTerpancung.txt", "rw")) {
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
