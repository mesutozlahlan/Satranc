# Satranc
 Satranc Puan Hesaplama

Satranç Tahtası Projesi

Bu proje, bir satranç tahtasını temsil eden Java kodunu içerir. Proje, tahtadaki taşların yerlerini okur, tehdit edilen kareleri hesaplar ve her iki oyuncunun puanlarını hesaplar.

Nasıl Kullanılır

1. Proje dosyalarını bilgisayarınıza indirin veya bu depoyu klonlayın.

2. Java geliştirme ortamınızı açın ve projeyi içe aktarın.

3. board.txt adında bir satranç tahtası dosyası oluşturun ve istediğiniz taşları yerleştirin. Dosyanın nasıl biçimlendirileceği hakkında örnekler aşağıda verilmiştir:


ks as fs vs ss fs as ks

ps ps ps ps ps ps ps ps
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
pb pb pb pb pb pb pb pb

kb ab fb vb sb fb ab kb

'k' - Kale (rook)
'a' - At (knight)
'f' - Fil (bishop)
'v' - Vezir (queen)
's' - Şah (king)
'p' - Piyon (pawn)

's' - Siyah (black)
'b' - Beyaz (white)
'--' - Boş kare (null)

4.Projenizi derleyin ve çalıştırın.

5.Program, siyah ve beyaz oyuncuların puanlarını hesaplayacak ve ekrana yazdıracaktır.

NOT: Sadece vezir, at ve piyon için tehdit hesaplamaları yapmaktadır. 2 veya 3 taş tarafından tehdit edilen taşların puanı yanlış hesaplanmaktadır.
