import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;


class SatrancTahtasi {
     private final Tas[][] tahta;

    public SatrancTahtasi() {
        tahta = new Tas[8][8];
    }
    //Dosyadan inputları alıyoruz ve tahtaya yerleştiriyoruz.
    public void tahtayiBaslat(String dosyaAdi) {
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
        String satir;
        int satirNo = 0;

        while ((satir = br.readLine()) != null && satirNo < 8) {
            for (int sutun = 0;  sutun < 8; sutun++) {
                String[] s = satir.split(" ");
                for (int i = 0; i < 8; i++) {
                    String renks = s[i];
                    var index = renks.toCharArray();
                    tahta[satirNo][i] =new Tas(index[0], index[1]); 
                }
              
            }
            satirNo++;
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    Set<Kare> tehditKareleri = new LinkedHashSet<>();
    public Set<Kare> tehditKontrol(int satir, int sutun, char renk, char tur) {
        
        char renkTersi = (renk == 'b') ? 's' : 'b'; // Karşılaştırma kontrolleri için karşıt rengi renkTersi değişkeniyle oluşturduk.
        char bosKare = '-'; // Vezir -- olan taşların yani boş karelerin üstünden atlayabilmesi için bosKare değişkenini oluşturduk.
        int ileriYon = (renk == 'b') ? -1 : 1; // Beyaz piyonlar ileriye, siyah piyonlar geriye doğru gider
        
        
        //Vezir Tehdit Kontrolleri
        if(tur == 'v'){
            // Yatay kontrol (sol ve sağ)
            for (int i = sutun - 1; i >= 0; i--) {
                Tas tas = tahta[satir][i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir, i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                    }else if(tas.getRenk() == bosKare){
                        continue;
                    }
                    else {
                        break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                    }
                } 

            for (int i = sutun + 1; i < 8; i++) {
                Tas tas = tahta[satir][i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir, i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                    }else if(tas.getRenk() == bosKare){
                        continue;
                    }
                    else {
                        break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                    }
                } 

            // Dikey kontrol (yukarı ve aşağı)
            for (int i = satir - 1; i >= 0; i--) {
                Tas tas = tahta[i][sutun];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(i, sutun);
                    tehditKareleri.add(tehditKaresi);
                    break;
                    }else if(tas.getRenk() == bosKare){
                        continue;
                    }
                    else {
                        break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                    }
                }

            for (int i = satir + 1; i < 8; i++) {
                Tas tas = tahta[i][sutun];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(i, sutun);
                    tehditKareleri.add(tehditKaresi);
                    break;
                    }else if(tas.getRenk() == bosKare){
                        continue;
                    }
                    else {
                        break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                    }
                }

            // Köşegen kontrol (sola yukarı)
            for (int i = 1; satir - i >= 0 && sutun - i >= 0; i++) {
                Tas tas = tahta[satir - i][sutun - i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir - i, sutun - i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                } else if(tas.getRenk() == bosKare){
                    continue;
                }
                else {
                    break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                }
            }

            // Köşegen kontrol (sola aşağı)
            for (int i = 1; satir + i < 8 && sutun - i >= 0; i++) {
                Tas tas = tahta[satir + i][sutun - i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir + i, sutun - i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                } else if(tas.getRenk() == bosKare){
                    continue;
                }
                else {
                    break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                }
            }

            // Köşegen kontrol (sağa yukarı)
            for (int i = 1; satir - i >= 0 && sutun + i < 8; i++) {
                Tas tas = tahta[satir - i][sutun + i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir - i, sutun+ i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                } else if (tas.getRenk() == bosKare) {
                    continue; 
                }
                else {
                    break; // Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                }
            }

            // Köşegen kontrol (sağa aşağı)
            for (int i = 1; satir + i < 8 && sutun + i < 8; i++) {
                Tas tas = tahta[satir + i][sutun + i];
                if (tas != null && tas.getRenk() == renkTersi) {
                    Kare tehditKaresi  = new Kare(satir + i, sutun + i);
                    tehditKareleri.add(tehditKaresi);
                    break;
                } else if (tas.getRenk() == bosKare) {
                    continue; 
                }
                else {
                    break;// Vezir taşın üstünden atlayamaz, bu nedenle durduruyoruz
                }
            }
        }
        //At Tehdit Kontrolleri
        else if(tur == 'a'){
            //Atın L hareketleri
            int[][] atHareketleri = {
                {-2, -1}, {-2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2},
                {2, -1}, {2, 1}
            };


            for (int[] hareket : atHareketleri) {
                int yeniSatir = satir + hareket[0];
                int yeniSutun = sutun + hareket[1];
                if (yeniSatir >= 0 && yeniSatir < 8 && yeniSutun >= 0 && yeniSutun < 8) {
                    Tas tas = tahta[yeniSatir][yeniSutun];
                    if (tas != null && tas.getRenk() == renkTersi) {
                        Kare tehditKaresi  = new Kare(yeniSatir, yeniSutun);
                        tehditKareleri.add(tehditKaresi);
                    }
                }
            }
        }
        //Piyon Tehdit Kontrolleri
        else {
            // Piyonun yeme hamlesi (sol ve sağ çapraz hareket)
            int[] yemekYonleri = {-1, 1}; // Piyonlar hem sol çapraz hem sağ çapraz gidebilir
            for (int yemekYonu : yemekYonleri) {
                int yeniSatir = satir + ileriYon;
                int yeniSutun = sutun + yemekYonu;
                if (yeniSatir >= 0 && yeniSatir < 8 && yeniSutun >= 0 && yeniSutun < 8) {
                    Tas tas = tahta[yeniSatir][yeniSutun];
                    if (tas != null && tas.getRenk() == renkTersi) {
                        Kare tehditKaresi  = new Kare(yeniSatir, yeniSutun);
                        tehditKareleri.add(tehditKaresi);
                    }
                }
            }
        }
        
        return tehditKareleri;
    }

    public Map<Character, Double> puanHesapla() {
        //Taşların Puanlarını puanlar tablosuna yerleştirelim
        Map<Character, Double> puanlar = new HashMap<>();
        puanlar.put('p', 1.0);
        puanlar.put('a', 3.0);
        puanlar.put('f', 3.0);
        puanlar.put('k', 5.0);
        puanlar.put('v', 9.0);
        puanlar.put('s', 100.0);

        double beyazPuan = 0.0;
        double siyahPuan = 0.0;
        
        //Taşların Değerlerini beyazPuan ve siyahPuan değişkenlerine atayalım
        for (int satir = 0; satir < 8; satir++) {
            for (int sutun = 0; sutun < 8; sutun++) {
                Tas tas = tahta[satir][sutun];
                if (tas != null && tas.getTur()!= '-') {
                    char tur = tas.getTur();
                    char renk = tas.getRenk();
                    Double puan = puanlar.get(tur);
                    if (puan != null ) {
                        if (renk == 'b') {
                            beyazPuan += puan;
                        }
                        else {
                            siyahPuan += puan;
                        }
                    }
                }
            }
        }
        //Tehdit altındaki taşların puanlarını yarıya düşürelim
        for (int satir = 0; satir < 8; satir++) {
            for (int sutun = 0; sutun < 8; sutun++) {
                Tas tas = tahta[satir][sutun];
                if (tas != null && tas.getTur()!= '-') {
                    char tur = tas.getTur();
                    char renk = tas.getRenk();
                    Double puan = puanlar.get(tur);
                    if (puan != null ) {
                        if (renk == 's' || renk == 'b') {

                            if (tur == 'v' || tur == 'a' || tur == 'p') {
                                tehditKareleri.clear();
                                tehditKareleri = tehditKontrol(satir, sutun, renk, tur);
                            
                                if (tehditKareleri != null) {
                                    for (Kare kare : tehditKareleri) {
                                        int tehditSatir = kare.getSatir();
                                        int tehditSutun = kare.getSutun();
                                        Tas tehditEdilenTas = tahta[tehditSatir][tehditSutun];
                                        if (tehditEdilenTas != null && tehditEdilenTas.getTur() != '-') {
                                            char tehditEdilenRenk = tehditEdilenTas.getRenk();
                                            char tehditEdilenTur = tehditEdilenTas.getTur();
                                            if (puanlar.containsKey(tehditEdilenTur)) {
                                                double tehditPuan = puanlar.get(tehditEdilenTur);
                                                if (tehditEdilenRenk == 'b') {
                                                    beyazPuan -= tehditPuan * 0.5;
                                                }
                                                if(tehditEdilenRenk == 's'){
                                                    siyahPuan -= tehditPuan * 0.5;
                                                }
                                            } else {
                                                System.out.println("Hata: Gecersiz anahtar -> " + tehditEdilenTur);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //Elde ettiğimiz sonuçları sonuc değişkenine atayalım.
        Map<Character, Double> sonuc = new HashMap<>();
        sonuc.put('s', siyahPuan);
        sonuc.put('b', beyazPuan);
        return sonuc;
    }

    // SatrancTahtasi sınıfına "tahtayiGoster" adında bir metod ekleyelim
    public void tahtayiGoster() {
    for (int satir = 0; satir <8; satir++) {
        for (int sutun = 0; sutun < 8; sutun++) {
            Tas tas = tahta[satir][sutun];
            if (tas != null) {
                System.out.print(tas.getTur()+ "" + tas.getRenk()+ " ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println(); // Her satırın sonunda bir satır sonu karakteri ekle
    }
  }
}

