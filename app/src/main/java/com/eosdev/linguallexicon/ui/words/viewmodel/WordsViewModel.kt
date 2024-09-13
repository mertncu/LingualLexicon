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
        Word(
            1,
            "Desktop Computer",
            R.drawable.computer,
            "I use a desktop computer for work and gaming.", // English sentence
            "Çalışmak ve oyun oynamak için masaüstü bilgisayar kullanırım.", // Turkish translation
            "Masaüstü Bilgisayar",
            "Electronics"
        ),

        Word(
            2,
            "Joystick",
            R.drawable.joystick,
            "I use a joystick to play video games.",
            "Video oyunları oynamak için joystick kullanırım.",
            "Joystick",
            "Electronics"
        ),

        Word(
            3,
            "Telephone",
            R.drawable.telephone,
            "I use a telephone to make calls.",
            "Aramalar yapmak için telefon kullanırım.",
            "Telefon",
            "Electronics"
        ),

        Word(
            4,
            "Airplane",
            R.drawable.airplane,
            "I travel by airplane when I go on vacation.",
            "Tatile gittiğimde uçakla seyahat ederim.",
            "Uçak",
            "Transportation"
        ),

        Word(
            5,
            "Apple",
            R.drawable.apple,
            "I eat an apple every day.",
            "Her gün bir elma yerim.",
            "Elma",
            "Food"
        ),

        //Avocado
        Word(
            6,
            "Avocado",
            R.drawable.avocado,
            "I eat avocado toast for breakfast.",
            "Kahvaltıda avokado tostu yerim.",
            "Avokado",
            "Food"
        ),

        //Christmas Balls
        Word(
            7,
            "Christmas Balls",
            R.drawable.balls,
            "I decorate the Christmas tree with Christmas balls.",
            "Noel ağacını noel topları ile süslerim.",
            "Noel Topları",
            "Decor"
        ),

        //Banana
        Word(
            8,
            "Banana",
            R.drawable.banana,
            "I eat a banana every day.",
            "Her gün bir muz yerim.",
            "Muz",
            "Food"
        ),

        //Blueberry
        Word(
            9,
            "Blueberry",
            R.drawable.berry,
            "I eat blueberries with my breakfast.",
            "Kahvaltıda yaban mersini yerim.",
            "Yaban Mersini",
            "Food"
        ),

        //blackberry
        Word(
            10,
            "Blackberry",
            R.drawable.blackberry,
            "I eat blackberries with my breakfast.",
            "Kahvaltıda böğürtlen yerim.",
            "Böğürtlen",
            "Food"
        ),

        //calculator
        Word(
            11,
            "Calculator",
            R.drawable.calculator,
            "I use a calculator to do math homework.",
            "Matematik ödevi yapmak için hesap makinesi kullanırım.",
            "Hesap Makinesi",
            "Stationery"
        ),

        //Phone
        Word(
            12,
            "Phone",
            R.drawable.telephone,
            "I use my phone to call my friends.",
            "Arkadaşlarımı aramak için telefonumu kullanırım.",
            "Telefon",
            "Electronics"
        ),

        //Car
        Word(
            13,
            "Car",
            R.drawable.car,
            "I drive a car to work every day.",
            "Her gün işe arabayla giderim.",
            "Araba",
            "Transportation"
        ),

        //Chair
        Word(
            14,
            "Chair",
            R.drawable.chair,
            "I sit on a chair when I eat dinner.",
            "Akşam yemeği yerken sandalyede otururum.",
            "Sandalye",
            "Furniture"
        ),

        //Chemistry
        Word(
            15,
            "Chemistry",
            R.drawable.chemistry,
            "I study chemistry in school.",
            "Okulda kimya çalışırım.",
            "Kimya",
            "Education"
        ),

        //Cherries
        Word(
            16,
            "Cherries",
            R.drawable.cherries,
            "I eat cherries in the summer.",
            "Yazın kiraz yerim.",
            "Kiraz",
            "Food"
        ),

        //Christmas bell
        Word(
            17,
            "Christmas Bell",
            R.drawable.christmas_bell,
            "I decorate the Christmas tree with Christmas bells.",
            "Noel ağacını noel çanları ile süslerim.",
            "Noel Çanları",
            "Decor"
        ),

        //Compass
        Word(
            18,
            "Compass",
            R.drawable.compass,
            "We use compass in our drawing classes.",
            "Resim derslerinde pergel kullanırız.",
            "Pergel",
            "Tools"
        ),

        //Tencere
        Word(
            19,
            "Pot",
            R.drawable.cooking,
            "I cook soup in a pot.",
            "Tencerede çorba pişiririm.",
            "Tencere",
            "Kitchen"
        ),

        //El kremi
        Word(
            20,
            "Hand Cream",
            R.drawable.cream,
            "I use hand cream to keep my hands soft.",
            "Ellerimi yumuşak tutmak için el kremi kullanırım.",
            "El Kremi",
            "Personal Care"
        ),

        //Door
        Word(
            21,
            "Door",
            R.drawable.door,
            "I close the door when I leave the house.",
            "Evi terk ederken kapıyı kapatırım.",
            "Kapı",
            "Home"
        ),

        //Drill
        Word(
            22,
            "Drill",
            R.drawable.drill,
            "I use a drill to hang pictures on the wall.",
            "Duvara resim asmak için matkap kullanırım.",
            "Matkap",
            "Tools"
        ),

        //earphone
        Word(
            23,
            "Earphone",
            R.drawable.earphone,
            "I use earphones to listen to music.",
            "Müzik dinlemek için kulaklık kullanırım.",
            "Kulaklık",
            "Electronics"
        ),

        //Teacher
        Word(
            24,
            "Teacher",
            R.drawable.female,
            "My teacher teaches me math.",
            "Öğretmenim bana matematik öğretir.",
            "Öğretmen",
            "Education"
        ),

        //Süs bayraklar
        Word(
            25,
            "Decorative Flags",
            R.drawable.garlands,
            "I decorate the garden with decorative flags.",
            "Bahçeyi süs bayrakları ile süslerim.",
            "Süs Bayrakları",
            "Decor"
        ),

        //Hammer
        Word(
            26,
            "Hammer",
            R.drawable.hammer,
            "I use a hammer to hang pictures on the wall.",
            "Duvara resim asmak için çekiç kullanırım.",
            "Çekiç",
            "Tools"
        ),

        //Kitchen Tools
        Word(
            27,
            "Kitchen Tools",
            R.drawable.kitchen_tool,
            "I use kitchen tools to cook.",
            "Yemek yapmak için mutfak aletleri kullanırım.",
            "Mutfak Aletleri",
            "Kitchen"
        ),

        //Knife
        Word(
            28,
            "Knife",
            R.drawable.knife,
            "I use a knife to cut vegetables.",
            "Sebzeleri kesmek için bıçak kullanırım.",
            "Bıçak",
            "Kitchen"
        ),

        //Pen
        Word(
            29,
            "Pen",
            R.drawable.pen,
            "I write with a pen.",
            "Kalemle yazarım.",
            "Kalem",
            "Stationery"
        ),

        //Perfume
        Word(
            30,
            "Perfume",
            R.drawable.perfume,
            "I use perfume to smell good.",
            "İyi kokmak için parfüm kullanırım.",
            "Parfüm",
            "Personal Care"
        ),

        //Phyisics
        Word(
            31,
            "Physics",
            R.drawable.relativity,
            "I study physics in school.",
            "Okulda fizik çalışırım.",
            "Fizik",
            "Education"
        ),

        //Shelf
        Word(
            32,
            "Shelf",
            R.drawable.shelf,
            "I put books on the shelf.",
            "Rafın üzerine kitap koyarım.",
            "Raf",
            "Furniture"
        ),

        //Truck
        Word(
            33,
            "Truck",
            R.drawable.shipment,
            "I drive a truck to transport goods.",
            "Mal taşımak için kamyon kullanırım.",
            "Kamyon",
            "Transportation"
        ),

        //Stapler
        Word(
            34,
            "Stapler",
            R.drawable.stapler,
            "I use a stapler to attach papers together.",
            "Kağıtları birbirine tutturmak için zımba kullanırım.",
            "Zımba",
            "Stationery"
        ),

        //Table
        Word(
            35,
            "Table",
            R.drawable.table,
            "I eat dinner at the table.",
            "Akşam yemeğini masada yerim.",
            "Masa",
            "Furniture"
        ),

        //Train
        Word(
            36,
            "Train",
            R.drawable.train,
            "I travel by train when I go to another city.",
            "Başka bir şehre gittiğimde trenle seyahat ederim.",
            "Tren",
            "Transportation"
        ),

        //Class
        Word(
            37,
            "Class",
            R.drawable.training,
            "I go to class every day.",
            "Her gün derse giderim.",
            "Ders",
            "Education"
        ),

        //Cetvel
        Word(
            38,
            "Ruler",
            R.drawable.triangle,
            "I use a ruler to draw straight lines.",
            "Düz çizgiler çizmek için cetvel kullanırım.",
            "Cetvel",
            "Stationery"
        ),

        //washing hands
        Word(
            39,
            "Washing Hands",
            R.drawable.washing_hands,
            "I wash my hands before eating.",
            "Yemek yemeden önce ellerimi yıkarım.",
            "Elleri Yıkama",
            "Personal Care"
        ),

        //Watermelon
        Word(
            40,
            "Watermelon",
            R.drawable.watermelon,
            "I eat watermelon in the summer.",
            "Yazın karpuz yerim.",
            "Karpuz",
            "Food"
        ),

        //Window
        Word(
            41,
            "Window",
            R.drawable.window,
            "I open the window when it's hot.",
            "Sıcak olduğunda pencereyi açarım.",
            "Pencere",
            "Home"
        ),

        //Wrench
        Word(
            42,
            "Wrench",
            R.drawable.wrench,
            "I use a wrench to fix things.",
            "Şeyleri tamir etmek için anahtar kullanırım.",
            "Anahtar",
            "Tools"
        ),

        //Bere
        Word(
            43,
            "Beanie",
            R.drawable.bere,
            "I wear a beanie in the winter.",
            "Kışın bere takarım.",
            "Bere",
            "Clothing"
        ),

        //gomlek
        Word(
            44,
            "Shirt",
            R.drawable.gomlek,
            "I wear a shirt to work.",
            "İşe gömlek giyerim.",
            "Gömlek",
            "Clothing"
        ),

        //Dress
        Word(
            45,
            "Dress",
            R.drawable.dress,
            "I wear a dress to parties.",
            "Partilere elbise giyerim.",
            "Elbise",
            "Clothing"
        ),

        //Tshirt
        Word(
            46,
            "T-shirt",
            R.drawable.shirt,
            "I wear a t-shirt in the summer.",
            "Yazın tişört giyerim.",
            "Tişört",
            "Clothing"
        ),

        //Scissors
        Word(
            47,
            "Scissors",
            R.drawable.scissors,
            "I use scissors to cut paper.",
            "Kağıdı kesmek için makas kullanırım.",
            "Makas",
            "Stationery"
        ),

        //push_pin
        Word(
            48,
            "Push Pin",
            R.drawable.push_pin,
            "I use push pins to hang pictures on the wall.",
            "Duvara resim asmak için raptiyeler kullanırım.",
            "Raptiye",
            "Stationery"
        ),

        //Pencil Sharpener
        Word(
            49,
            "Pencil Sharpener",
            R.drawable.pencil_sharpener,
            "I use a pencil sharpener to sharpen my pencils.",
            "Kalemlerimi kalemtıraş ile açarım.",
            "Kalemtıraş",
            "Stationery"
        ),

        //Sofa
        Word(
            50,
            "Sofa",
            R.drawable.sofa,
            "I sit on the sofa when I watch TV.",
            "Televizyon izlerken koltukta otururum.",
            "Kanepe",
            "Furniture"
        ),

        //Crip
        Word(
            51,
            "Crib",
            R.drawable.crib,
            "Babies sleep in a crib.",
            "Bebekler beşikte uyur.",
            "Beşik",
            "Furniture"
        ),

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



