import java.util.Scanner;

import bangundatar.*;
import bangunruang.*;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int loop;

        do {
            System.out.print("\033[H\033[2J");
            System.out.println("========================================");
            System.out.println("Pilih Bangun Ruang atau Bangun Datar");
            System.out.println("========================================");
            System.out.println("1. Lingkaran");
            System.out.println("2. Tabung");
            System.out.println("3. Kerucut");
            System.out.println("4. Kerucut Terpancung");
            System.out.println("5. Bola");
            System.out.println("6. Tembereng Bola");
            System.out.println("7. Juring Bola");
            System.out.println("8. Keratan Bola");
            System.out.println("0. Keluar");

            System.out.println("-------------------------------------");
            System.out.print("Pilihan\t: ");
            int pil = scanner.nextInt();

            switch (pil) {
                case 1:
                    menuLingkaran();
                    break;

                case 2:
                    menuTabung();

                    break;

                case 3:
                    menuKerucut();

                    break;

                case 4:
                    menuKerucutTerpancung();
                    break;

                case 5:
                    menuBola();
                    break;

                case 6:
                    menuTemberengBola();
                    break;

                case 7:
                    menuJuringBola();
                    break;
                
                case 8:
                    menuKeratanBola();
                    break;
                    
                case 0:
                    System.out.println("\nexited...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
            System.out.print("Ulangi? (1) ");
            loop = scanner.nextInt();
            Thread.sleep(700);

        } while (loop==1);
    

        System.out.println("\nexited...");

    }

    
    private static void menuLingkaran() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tLingkaran");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Lingkaran\t: ");
        int radius = scanner.nextInt();

        Lingkaran lingkaran = new Lingkaran(radius); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Lingkaran\t\t\t: %.2f\n", lingkaran.getArea());
        System.out.printf("Keliling Lingkaran\t\t: %.2f\n", lingkaran.getCircumference());
        
    }

    private static void menuTabung() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tTabung");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Tabung\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Tinggi Tabung\t: ");
        int height = scanner.nextInt();

        Tabung tabung = new Tabung(radius, height); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Tabung\t: %.2f\n", tabung.getSurfaceArea());
        System.out.printf("Volume Tabung\t\t: %.2f\n", tabung.getVolume());
        
    }

    private static void menuKerucut() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tKerucut");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Kerucut\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Tinggi Kerucut\t: ");
        int height = scanner.nextInt();

        Kerucut kerucut = new Kerucut(radius, height); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Kerucut\t: %.2f\n", kerucut.getSurfaceArea());
        System.out.printf("Volume Kerucut\t\t: %.2f\n", kerucut.getVolume());
        
    }

    private static void menuKerucutTerpancung() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tKerucut Terpancung");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Alas Atas Kerucut Terpancung\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Jari-jari Alas Bawah Kerucut Terpancung\t: ");
        int topRadius = scanner.nextInt();
        System.out.print("Masukan Tinggi Kerucut Terpancung\t: ");
        int height = scanner.nextInt();

        KerucutTerpancung kerucutTerpancung = new KerucutTerpancung(radius, height, topRadius); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Kerucut Terpancung\t: %.2f\n", kerucutTerpancung.getSurfaceArea());
        System.out.printf("Volume Kerucut Terpancung\t\t: %.2f\n", kerucutTerpancung.getVolume());
        
    }

    private static void menuBola() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tBola");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Bola\t: ");
        int radius = scanner.nextInt();

        Bola bola = new Bola(radius); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Bola\t: %.2f\n", bola.getSurfaceArea());
        System.out.printf("Volume Bola\t\t: %.2f\n", bola.getVolume());
        
    }

    private static void menuTemberengBola() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tTembereng Bola");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Bola\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Tinggi Tembereng: ");
        int height = scanner.nextInt();

        TemberengBola temberengBola = new TemberengBola(radius, height); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Tembereng Bola\t: %.2f\n", temberengBola.getSurfaceArea());
        System.out.printf("Volume Tembereng Bola\t\t: %.2f\n", temberengBola.getVolume());
        
    }

    private static void menuJuringBola() {
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tJuring Bola");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Bola\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Tinggi Juring\t: ");
        int height = scanner.nextInt();

        JuringBola juringBola = new JuringBola(radius, height); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Juring Bola\t: %.2f\n", juringBola.getSurfaceArea());
        System.out.printf("Volume Juring Bola\t\t: %.2f\n", juringBola.getVolume());
        
    }
    
    private static void menuKeratanBola(){
        System.out.println("\033[H\033[2J");
        System.out.println("===========================");
        System.out.println("\tKeratan Bola");
        System.out.println("===========================");
        System.out.print("Masukan Jari-jari Alas Bawah Bola\t: ");
        int radius = scanner.nextInt();
        System.out.print("Masukan Jari-jari Alas Atas Bola\t: ");
        int topRadius = scanner.nextInt();
        System.out.print("Masukan Tinggi Antara Kedua Alas\t: ");
        int height = scanner.nextInt();
    
        KeratanBola keratanBola = new KeratanBola(radius,topRadius, height); // base Cirlce
        System.out.println("----------------------------------------------");
        System.out.printf("Luas Permukaan Keratan Bola\t: %.2f\n", keratanBola.getSurfaceArea());
        System.out.printf("Volume Keratan Bola\t\t: %.2f\n", keratanBola.getVolume());
        System.out.printf("Jari-Jari Bola\t\t: %.2f\n", keratanBola.getSpehreRadius());
        
    }
}
