import java.util.ArrayList;
import java.util.Random;

import Thread.ThreadBola;
import Thread.ThreadJuringBola;
import Thread.ThreadKeratanBola;
import Thread.ThreadKerucut;
import Thread.ThreadKerucutTerpancung;
import Thread.ThreadLingkaran;
import Thread.ThreadTabung;
import Thread.ThreadTemberengBola;
import bangundatar.*;
import bangunruang.*;

public class App {

    public static void main(String[] args) throws Exception {

        ArrayList<Lingkaran> lingkarans = generateLingkarans(200);
        ArrayList<Tabung> tabungs = generateTabung(200);
        ArrayList<Bola> bolas = generateBola(200);
        ArrayList<Kerucut> kerucuts = generateKerucut(200);
        ArrayList<KerucutTerpancung> kerucutTerpancungs = generateKerucutTerpancung(200);
        ArrayList<JuringBola> juringBolas = generateJuringBola(200);
        ArrayList<KeratanBola> keratanBolas = generateKeratanBola(200);
        ArrayList<TemberengBola> temberengBolas = generateTemberengBola(200);

        Thread threadLingkaran = new Thread(new ThreadLingkaran(lingkarans));
        Thread threadTabung = new Thread(new ThreadTabung(tabungs));
        Thread threadBola = new Thread(new ThreadBola(bolas));
        Thread threadKerucut = new Thread(new ThreadKerucut(kerucuts));
        Thread threadKerucutTerpancung = new Thread(new ThreadKerucutTerpancung(kerucutTerpancungs));
        Thread threadJuringBola = new Thread(new ThreadJuringBola(juringBolas));
        Thread threadKeratanBola = new Thread(new ThreadKeratanBola(keratanBolas));
        Thread threadTemberengBola = new Thread(new ThreadTemberengBola(temberengBolas));

        threadLingkaran.start();
        threadTabung.start();
        threadBola.start();
        threadKerucut.start();
        threadKerucutTerpancung.start();
        threadJuringBola.start();
        threadKeratanBola.start();
        threadTemberengBola.start();


    }

    private static ArrayList<Lingkaran> generateLingkarans(int jumlah) {
        ArrayList<Lingkaran> lingkarans = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            Lingkaran lingkaran = new Lingkaran(random.nextInt(100));
            lingkarans.add(lingkaran);
        }
        return lingkarans;

    }

    private static ArrayList<Bola> generateBola(int jumlah) {
        ArrayList<Bola> bolas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            Bola bola = new Bola(random.nextInt(100));
            bolas.add(bola);
        }
        return bolas;

    }

    private static ArrayList<Tabung> generateTabung(int jumlah) {
        ArrayList<Tabung> tabungs = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            Tabung tabung = new Tabung(random.nextDouble(100), random.nextDouble(20));
            tabungs.add(tabung);
        }
        return tabungs;

    }

    private static ArrayList<Kerucut> generateKerucut(int jumlah) {
        ArrayList<Kerucut> kerucuts = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            Kerucut kerucut = new Kerucut(random.nextDouble(100), random.nextDouble(20));
            kerucuts.add(kerucut);
        }
        return kerucuts;
    }

    private static ArrayList<JuringBola> generateJuringBola(int jumlah) {
        ArrayList<JuringBola> juringBolas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            JuringBola juringBola = new JuringBola(random.nextDouble(100), random.nextDouble(20));
            juringBolas.add(juringBola);
        }
        return juringBolas;
    }

    private static ArrayList<KeratanBola> generateKeratanBola(int jumlah) {
        ArrayList<KeratanBola> keratanBolas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            KeratanBola keratanBola = new KeratanBola(random.nextDouble(50), random.nextDouble(50),
                    random.nextDouble(20));
            keratanBolas.add(keratanBola);
        }
        return keratanBolas;
    }

    private static ArrayList<TemberengBola> generateTemberengBola(int jumlah) {
        ArrayList<TemberengBola> temberengBolas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            TemberengBola temberengBola = new TemberengBola(random.nextDouble(100), random.nextDouble(20));
            temberengBolas.add(temberengBola);
        }
        return temberengBolas;
    }

    private static ArrayList<KerucutTerpancung> generateKerucutTerpancung(int jumlah) {
        ArrayList<KerucutTerpancung> kerucutTerpancungs = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < jumlah; i++) {
            KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(random.nextDouble(50), random.nextDouble(20), random.nextDouble(40));
            kerucutTerpancungs.add(kerucutTerpancung);
        }
        return kerucutTerpancungs;
    }

}
