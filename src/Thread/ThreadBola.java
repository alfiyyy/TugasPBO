package Thread;

import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import bangunruang.Bola;
import connector.Connector;

public class ThreadBola extends Connector implements Runnable {

    private ArrayList<Bola> bolas;

    public ThreadBola(ArrayList<Bola> bolas) {
        this.bolas = bolas;
    }


    @Override
    public void run() {
        int jumlah=1;
        for (Bola bola : bolas) {
            String query = "INSERT INTO `bangun` (`nama_geometri`,`keliling`,`luas`,`luas_permukaan`,`volume`) VALUES (?,?,?,?,?)";
            try {
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, "Bola");
                pstmt.setDouble(2, bola.getCircumference());
                pstmt.setDouble(3, bola.getArea());
                pstmt.setDouble(4, bola.getSurfaceArea());
                pstmt.setDouble(5, bola.getVolume());
                pstmt.executeUpdate();

                String result = "\n----------\nBola " + jumlah++ + " \n"+
                                "Keliling: " + bola.getArea()+"\n" + 
                                "Luas\t: " + bola.getArea() + "\n" +
                                "Luas Permukaan\t: "+bola.getSurfaceArea()+"\n"+
                                "Volume\t: " + bola.getVolume()+"\n\n";

                writeTofile(result);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    private void writeTofile(String result){
        try (RandomAccessFile file = new RandomAccessFile("ResultBola.txt", "rw")) {
            file.seek(file.length());
            //file.setLength(0) untuk mereset file
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            file.write(dtf.format(now).getBytes());
            file.write(result.getBytes());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
}
