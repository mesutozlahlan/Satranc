import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SatrancTahtasi tahta = new SatrancTahtasi();
        tahta.tahtayiBaslat("board.txt");
        
        //tahta.tahtayiGoster(); // Tahtayı ekrana yazdıran fonksiyonu çağırabiliriz.
        
        Map<Character, Double> puanlar = tahta.puanHesapla();

        System.out.println("Siyah Puan: " + puanlar.get('s'));
        System.out.println("Beyaz Puan: " + puanlar.get('b'));
        
        
    }
}    