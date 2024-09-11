package com.eosdev.linguallexicon.ui.words.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eosdev.linguallexicon.R
import com.eosdev.linguallexicon.data.model.Word

class WordsViewModel : ViewModel() {

    private val _randomWords = MutableLiveData<List<Word>>()
    val randomWords: LiveData<List<Word>> = _randomWords

    private val allWords = listOf(
        Word(1, "Computer", R.drawable.desktop, "I use a computer every day.", "Her gün bilgisayar kullanırım.", "Bilgisayar"),
        Word(2, "Apple", R.drawable.apple, "Eating an apple is my favorite snack.", "Bir elma yemek en sevdiğim atıştırmalık.", "Elma"),
        Word(3, "Book", R.drawable.book, "Before bed, I read a book.", "Yatmadan önce bir kitap okurum.", "Kitap"),
        Word(4, "Phone", R.drawable.phone, "My phone is currently ringing.", "Telefonum şu anda çalıyor.", "Telefon"),
        Word(5, "Table", R.drawable.table, "This table is crafted from wood.", "Bu masa ahşaptan yapılmıştır.", "Masa"),
        Word(6, "Chair", R.drawable.dining, "This chair is very cozy.", "Bu sandalye oldukça rahat.", "Sandalye"),
        Word(7, "Lamp", R.drawable.lamp, "The lamp is situated on the desk.", "Lamba masanın üstünde yer alıyor.", "Lamba"),
        Word(8, "Clock", R.drawable.clock, "The clock reads 3 PM.", "Saat 3'ü gösteriyor.", "Saat"),
        Word(9, "Cup", R.drawable.cup, "I enjoy my coffee from this cup.", "Bu fincandan kahvemi içerim.", "Fincan"),
        Word(10, "Notebook", R.drawable.notebook, "I jot down notes in my notebook.", "Defterime notlar alırım.", "Defter"),
        Word(11, "Sofa", R.drawable.sofa, "I relax on the sofa while watching TV.", "Televizyon izlerken kanepeye otururum.", "Kanepe"),
        Word(12, "Window", R.drawable.window, "The window is currently open.", "Pencere şu anda açık.", "Pencere"),
        Word(13, "Pen", R.drawable.pencil, "I use a pen to sign documents.", "Belgeleri imzalamak için kalem kullanırım.", "Kalem"),
        Word(14, "Door", R.drawable.door, "Please ensure the door is closed.", "Lütfen kapıyı kapalı bırakın.", "Kapı"),
        Word(15, "Mirror", R.drawable.mirror, "The mirror hangs on the wall.", "Ayna duvarda asılı.", "Ayna"),
        Word(16, "Bed", R.drawable.bed, "I sleep soundly in this bed.", "Bu yatakta rahatça uyurum.", "Yatak"),
        Word(17, "Fridge", R.drawable.fridge, "The fridge is filled with groceries.", "Buzdolabı yiyeceklerle dolu.", "Buzdolabı"),
        Word(18, "Oven", R.drawable.oven, "I use the oven to bake delicious cakes.", "Fırında lezzetli kekler pişiririm.", "Fırın"),
        Word(19, "Washing Machine", R.drawable.washingmachine, "The washing machine cleans my clothes.", "Çamaşır makinesi kıyafetlerimi temizler.", "Çamaşır Makinesi"),
        Word(20, "Television", R.drawable.tv, "I watch my favorite shows on the television.", "Televizyonda sevdiğim programları izlerim.", "Televizyon"),
        Word(21, "Keyboard", R.drawable.keyboard, "I type on this keyboard daily.", "Bu klavye üzerinde her gün yazarım.", "Klavye"),
        Word(22, "Mouse", R.drawable.mouse, "This wireless mouse is very convenient.", "Bu kablosuz fare oldukça kullanışlı.", "Fare"),
        Word(23, "Printer", R.drawable.printer, "I use the printer to produce documents.", "Belgeleri yazdırmak için yazıcı kullanırım.", "Yazıcı"),
        Word(24, "Camera", R.drawable.camera, "I capture memories with my camera.", "Kameramla anılarımı yakalarım.", "Kamera"),
        Word(25, "Banana", R.drawable.banana, "Bananas are a great source of vitamins.", "Muzlar vitamin açısından zengindir.", "Muz"),
        Word(26, "Lemon", R.drawable.lemon, "Lemons are known for their tart flavor.", "Limonlar ekşi tatlarıyla bilinir.", "Limon"),
        Word(27, "Air Conditioner", R.drawable.airconditioner, "The air conditioner keeps the room cool in summer.", "Klima yazın odayı serin tutar.", "Klima"),
        Word(28, "Fan", R.drawable.fan, "The fan circulates air around the room.", "Vantilatör havayı odada dolaştırır.", "Vantilatör"),
        Word(29, "Water", R.drawable.water, "I stay hydrated by drinking water.", "Su içerek su ihtiyacımı karşılarım.", "Su"),
        Word(30, "Cupboard", R.drawable.cupboard, "The cupboard stores various kitchen items.", "Dolap mutfaktaki çeşitli eşyaları saklar.", "Dolap"),
        Word(31, "Drawer", R.drawable.drawer, "I keep my personal items in the drawer.", "Kişisel eşyalarımı çekmecede saklarım.", "Çekmece"),
        Word(32, "Shoe", R.drawable.shoes, "These new shoes are very comfortable.", "Bu yeni ayakkabılar oldukça rahat.", "Ayakkabı"),
        Word(33, "Hat", R.drawable.hat, "I wear a hat to shield from the sun's rays.", "Güneş ışınlarından korunmak için şapka takarım.", "Şapka"),
        Word(34, "Glasses", R.drawable.glasses, "Glasses help me see things clearly.", "Gözlükler net görmemi sağlar.", "Gözlük"),
        Word(35, "Watch", R.drawable.wristwatch, "My watch helps me keep track of time.", "Saatim zamanı takip etmemi sağlar.", "Saat"),
        Word(36, "Bag", R.drawable.bag, "I carry my essentials in this bag.", "Gerekli eşyalarımı bu çantada taşırım.", "Çanta"),
        Word(37, "Towel", R.drawable.towel, "I use a towel to dry off after a shower.", "Duş sonrası havluyla kurulanırım.", "Havlu"),
        Word(38, "Toothbrush", R.drawable.toothbrush, "I use a toothbrush to maintain dental hygiene.", "Diş sağlığımı korumak için diş fırçası kullanırım.", "Diş Fırçası"),
        Word(39, "Soap", R.drawable.soap, "I use soap to clean my hands.", "Ellerimi temizlemek için sabun kullanırım.", "Sabun"),
        Word(40, "Shampoo", R.drawable.shampoo, "Shampoo is used to wash my hair.", "Saçımı yıkamak için şampuan kullanırım.", "Şampuan"),
        Word(41, "Brush", R.drawable.brush, "I use a brush to style my hair daily.", "Saçımı her gün taramak için fırça kullanırım.", "Fırça"),
        Word(42, "Bicycle", R.drawable.bicycle, "I commute to work by bicycle.", "İşe bisikletle gidiyorum.", "Bisiklet"),
        Word(43, "Ladder", R.drawable.ladder, "I use a ladder to reach high places.", "Yüksek yerlere erişmek için merdiven kullanırım.", "Merdiven"),
        Word(44, "Pillow", R.drawable.pillow, "I sleep comfortably on a soft pillow.", "Yumuşak bir yastıkta rahatça uyurum.", "Yastık"),
        Word(45, "Blanket", R.drawable.blanket, "I use a blanket to keep warm at night.", "Gece sıcak kalmak için battaniye kullanırım.", "Battaniye"),
        Word(46, "Curtain", R.drawable.curtain, "Curtains block out unwanted light.", "Perdeler istenmeyen ışığı engeller.", "Perde"),
        Word(47, "Umbrella", R.drawable.umbrella, "An umbrella protects me from the rain.", "Şemsiye yağmurdan korur.", "Şemsiye"),
        Word(48, "Vase", R.drawable.vase, "The vase holds a bouquet of flowers.", "Vazo bir çiçek demetini tutar.", "Vazo"),
        Word(49, "Plant", R.drawable.plant, "I water the plant regularly to keep it healthy.", "Bitkilerin sağlıklı kalması için düzenli olarak sularım.", "Bitki"),
        Word(50, "Napkin", R.drawable.napkin, "I use a napkin to clean up spills.", "Sızıntıları temizlemek için peçete kullanırım.", "Peçete")

    )


    init {
        loadWords()
    }

    private fun loadWords() {
        _randomWords.value = allWords.shuffled()
    }

    fun refreshWords() {
        _randomWords.value = _randomWords.value?.shuffled()
    }
}



