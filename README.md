# Commodity Profit Analysis System

Bu proje, Gold, Oil, Silver, Wheat ve Copper olmak üzere beş farklı emtianın 12 aylık günlük kar verilerini analiz etmek amacıyla geliştirilmiş Java tabanlı bir veri işleme yazılımıdır.

Proje, büyük veri setlerini işleyerek finansal içgörüler sunmakta, kar marjı hesaplamaları, trend analizleri ve karşılaştırmalı raporlamalar yapmaktadır.

## Proje Hakkında

Bu yazılım, yapılandırılmamış metin dosyalarından (.txt) ham verileri okuyarak belleğe yükler ve kullanıcı sorgularına göre dinamik analizler gerçekleştirir. Geliştirme sürecinde Java programlama dilinin temel yapı taşları olan veri yapıları ve algoritma mantığı kullanılmıştır.

Projenin temel amacı, "ArrayList" veya "HashMap" gibi hazır kütüphaneler yerine, ilkel diziler (primitive arrays) ve çok boyutlu diziler kullanılarak karmaşık veri manipülasyonu yeteneklerinin sergilenmesidir.

## Teknik Özellikler ve Kısıtlamalar

Bu proje, SE 115 standartlarına uygun olarak aşağıdaki teknik prensiplerle geliştirilmiştir:

* **Veri Yapıları:** Sadece ilkel diziler ve çok boyutlu diziler kullanılmıştır. Java Collections Framework (ArrayList, Set, Map vb.) kullanılmamıştır.
* **Hata Yönetimi:** Sistem, geçersiz veri girişlerine (hatalı ay, gün veya emtia adı) karşı dayanıklı (robust) olacak şekilde tasarlanmıştır. Hata durumlarında program sonlanmaz (exception fırlatmaz), bunun yerine tanımlı hata kodları döndürür.
* **Veri Okuma:** Veriler `Data_Files` dizini içerisindeki aylık dosyalardan parse edilerek işlenir.

## Temel Fonksiyonlar

Yazılım, aşağıdaki analizleri gerçekleştirebilen 10 farklı sorgu algoritmasını barındırır:

1.  **Aylık Kar Analizi:** Belirli bir ayda en yüksek kar getiren emtianın tespiti.
2.  **Günlük Toplam Kar:** Tüm emtiaların belirli bir gündeki toplam karının hesaplanması.
3.  **Tarih Aralığı Sorgusu:** Belirli bir emtianın verilen gün aralığındaki toplam kar performansı.
4.  **En İyi Gün Tespiti:** Bir ay içerisindeki en yüksek karın elde edildiği günün bulunması.
5.  **Mevsimsel Performans:** Bir emtianın yıl genelinde en iyi performans gösterdiği ayın belirlenmesi.
6.  **Zarar Serisi Analizi:** Bir emtianın yıl boyunca aralıksız zarar ettiği en uzun gün serisinin tespiti.
7.  **Eşik Değer Analizi:** Belirlenen bir kar barajını aşan gün sayısının hesaplanması.
8.  **Volatilite Analizi:** Ardışık iki gün arasındaki en büyük kar değişiminin (dalgalanmanın) hesaplanması.
9.  **Karşılaştırmalı Analiz:** İki farklı emtianın performansının karşılaştırılması ve farkın raporlanması.
10. **Haftalık Analiz:** Ay içerisindeki en karlı haftanın (1-4. hafta) belirlenmesi.

## Kurulum ve Çalıştırma

Projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

1.  Repoyu klonlayın:
    ```bash
    git clone [https://github.com/hasanoozen/Commodity-Profit-Analysis.git](https://github.com/hasanoozen/Commodity-Profit-Analysis.git)
    ```

2.  Proje dizinine gidin ve `Main.java` dosyasını derleyin:
    ```bash
    javac Main.java
    ```

3.  Uygulamayı başlatın:
    ```bash
    java Main
    ```

Not: Programın doğru çalışabilmesi için `Data_Files` klasörünün proje ana dizininde bulunması gerekmektedir.
