# Lingual Lexicon

Lingual Lexicon, kullanıcılara çeşitli dillerdeki kelimeleri göstermek için geliştirilmiş bir mobil uygulamadır. Bu uygulama, en az 50 kelimenin farklı dillerdeki karşılıklarını kullanıcıya sunar ve kelimelerle etkileşimde bulunmalarını sağlar.

## Proje Amacı
Lingual Lexicon, dil öğrenme süreçlerine katkıda bulunmak için kelimeleri öğrenme ve yönetme işlevselliği sunar. Kullanıcılar kelimeleri öğrenebilir, öğrendiklerini takip edebilir ve kelimeleri yeniden öğrenmek üzere işaretleyebilir.

## Ana Gereksinimler

### Liste Yapısı
- **Kelimeler**, `RecyclerView` veya `ViewPager` kullanılarak gösterilecektir. Liste lineer veya yaratıcı formatlarda sunulabilir.

### DataBinding veya ViewBinding
- Projede **DataBinding** veya **ViewBinding** kullanımı zorunludur.

### BottomNavigationView
- **BottomNavigationView** kullanılarak iki sekme (tab) içerecektir:
    - **İlk Sekme:** Rastgele sıralanan 50 kelimeyi gösterecektir.
    - **İkinci Sekme:** "Learned" olarak işaretlenen kelimeleri listeleyecektir.

### Detay Sayfası ve Popup
- İlk sekmedeki liste elemanlarına tıklandığında:
    - Bir **popup** açılacak veya detay sayfasına yönlendirme yapılacaktır.
    - Detay ekranında **"Learned"** (Öğrenildi) butonu bulunacak ve bu butona tıklandığında ilgili kelime **SharedPreferences**'a kaydedilecektir.

### Öğrenilen Kelimeler Listesi
- İkinci sekme, **"Learned"** olarak işaretlenen kelimeleri listeleyecektir:
    - **"Learned"** olarak işaretlenen kelimeler ilk sekmedeki 50 kelime listesinden çıkarılacak ve tekrar gösterilmeyecektir.
    - İkinci sekmedeki listede bulunan bir kelimeye tıklandığında, bir popup veya detay sayfası açılacak ve **"UnLearned"** butonu bulunacaktır. Bu butona tıklanırsa ilgili kelime **SharedPreferences**'dan kaldırılacak ve ilk tab’daki listeye eklenecektir.

### Swipe to Refresh
- İlk sekmedeki liste üzerine **Swipe to Refresh** özelliği eklenmelidir:
    - Bu işlem sonucunda liste rastgele yeniden sıralanacak ve aynı sıralamada tekrar gelmeyecektir.

## Kurulum ve Kullanım

1. **Projenin Klonlanması:**
   git clone [GitHub Depo URL'si]
   Gerekli Bağımlılıkların Yüklenmesi:

- Android Studio'yu açın ve projeyi yükleyin.
- Proje bağımlılıklarını yüklemek için Gradle'ı senkronize edin.
- Uygulamanın Çalıştırılması:

- Cihazınızı veya emülatörü bağlayın.
- Uygulamayı çalıştırarak test edin.

## Teknolojiler

- **Kotlin**: Uygulamanın geliştirilmesinde kullanılan ana programlama dili.
- **Android Jetpack**: Modern Android uygulama geliştirme araçları ve kütüphaneleri.
    - **DataBinding**: XML ve kod arasındaki veri akışını yönetir.
    - **ViewBinding**: XML bileşenlerine güvenli ve performanslı erişim sağlar.
    - **Jetpack Navigation**: Uygulama içi navigasyonu yönetir.
- **RecyclerView**: Listeleri ve veri koleksiyonlarını görüntülemek için kullanılır.
- **ViewPager**: Sayfalar arasında geçiş yapmayı sağlayan bir bileşendir.
- **SharedPreferences**: Küçük veri parçalarını kalıcı olarak saklamak için kullanılır.