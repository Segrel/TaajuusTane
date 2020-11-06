# Viikkoraportti 2

[Cooley-Tukey FFT](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm#Pseudocode) tarvitsee kompleksilukujen yhteen- ja vähennyslaskun, kertolaskun ja eksponenttifunktion. Tarvitsemme lisäksi kompleksilukujen itseisarvoja Fourier-muunnoksen antamien kompleksilukujen muuntamiseksi reaaliarvoisiksi taajuuksiksi. Tarvittavat kaavat saadaan [Johdatus yliopistomatematiikkaan kurssimateriaalista](https://courses.helsinki.fi/sites/default/files/course-material/4505387/JYMmoniste.pdf). Tämä oli kohtalaisen suoraviivaista [toteuttaa](Segrel/TaajuusTane/commit/b465e4223d06cc2f19c90f6a0f5dabfe22d438b8).

[Audiotiedostosta lukeminen](Segrel/TaajuusTane/commit/51a6968942935a4766a7a2397acc4fdab1974814) ei ole tämän projektin ydintä, joten en vielä käyttänyt sen testaamiseen aikaa. Testasin käsin käyttämällä 440Hz Wav-tiedostoa, vertaamalla oletettuja sinikäyrän arvoja ja Java-koodilla lukemiani. En keksinyt mitään kovin puhtaasti eristettyä testitapaa, mutta ehkä voisi tehdä muutaman framen mittaisia Wav-muotoisia testitiedostoja, jotka lukee testeissä metodilla ja vertaa saatua tiedossa oleviin oikeisiin arvoihin.

Kirjoitin myös [raakileen main-metodista](Segrel/TaajuusTane/commit/85186ae6bd9005c6ddd898baa4e7a8fefe5fdc70) ja hahmottelin sen osalta myös vähän testausta, joskin tätä saisi hieman yksinkertaisemmaksi myös miettimällä Tallenne-luokan rakenteen eri tavalla. Ehkä palaan tähän vielä Tallenne-luokan testauksen yhteydessä. Tähän tulee vielä lisää koodia myös, joten tähän tulee palattua joka tapauksessa.

Työkalujen osalta jacoco, javadoc ja checkstyle ovat kaikki toiminnassa ja projekti [säädettiin ajamaan nämä, sekä testit Github Actioneissa](Segrel/TaajuusTane/commit/84f6a22f1487f9d987210b32b911232326d7c898) jokaisen main-haaran päivityksen yhteydessä. Kaikki projektin työkalujen muodostamat raportit löytyvät nyt myös Actions-ajojen artifakteista.

Seuraava ponnistus, eli viikon 3 agenda onkin siis kirjoittaa varsinainen FFT-toteutus, sekä sille hyväksyntä- ja suorituskykytestejä. Tässä vaiheessa olen myös kerennyt tutustua sen verran lisää algoritmiin, että uskoisin saavani sen toteutettua ilman suurempia ongelmia. Työkalut ovat myös sen verran hyvällä mallilla, että voin käyttää valtaosan ajastani oikeasti toteutukseen.


#### Tuntikirjanpito
- Kompleksilukuluokka 4h
- Audiotiedostosta lukeminen 3h
- Työkalut 2h
- Dokumentaatio 1h
