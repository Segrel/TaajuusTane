# TaajuusTane määrittelydokumentti
## Konteksti
Projekti toteutetaan osana Helsingin yliopiston Tietojenkäsittelytieteen kandidaatin tutkinnon kurssia. Toteutus tehdään Java-kielellä, ensisijaisesti suomea kirjoittaen. Projektin eri rajapinnat dokumentoidaan ja kehityksestä pidetään viikkokohtaista päiväkirjaa.

## Tavoite
TaajuusTane on lyhyitä, yksinkertaisia äänipätkiä analysoiva sovellus. Se tutkii algoritmisesti käyttäjän antaman WAV-muotoisen (pituus enintään 5s, näytteiden bittimäärä 16) äänitallenteen ja esittää käyttäjälle sen perustaajuuden, ts. magnitudiltaan voimakkaimman aallonpituuden. Tavoitteena on myös saada ohjelmallisesti poistettua muu kuin perustaajuus tallenteesta. Yksinkertaisuuden vuoksi rajoitutaan tarkastelemaan tallenteita, joissa on siniaalto(ja), kohinaa tai näiden jokin yhdistelmä.

## Toteutus
Käyttäjän määrittämä WAV-tiedosto voidaan lukea yksinkertaiseksi tavutaulukoksi, missä jokainen alkio on ääninäyte. Yksinkertaisimmillaan tämä voidaan tehdä siten, että suuremmalla indeksillä oleva ääninäyte on aina ajallisesti myöhemmin otettu. Näytteet ovat käytännössä 16-bittisiä lukuja.

Jotta voimme analysoida tallenteen taajuuksia, tarvitaan kuitenkin taajuustason esitys. Tähän ongelmaan soveltuu diskreetti Fourier-muunnos (Discrete Fourier Transform, DFT)[1]. Koska DFT:n aikavaativuus on O(N^2), kannattaa nojautua olemassa oleviin optimointeihin, kuten nopeisiin Fourier-muunnoksiin (Fast Fourier Transform, FFT), joilla voidaan saavuttaa O(N log N) aikavaativuus[2]. Näistä esimerkiksi Cooleyn-Tukeyn algoritmiin löytyy valmis pseudokoodi[3].

Saadusta muunnoksesta voidaan muodostaa taulukko eri taajuuksien magnitudeista ja etsiä taulukosta näin perusääni. Taajuustason esitystä voi myös muokata ja sen voi muuntaa käänteismuunnoksella takaisin aikatasoon, jolloin saadaan uusi toistokelpoinen tallenne. FFT-toteutuksen jälkeen tämä käänteinen muunnos pitäisi olla triviaali toteuttaa[2].

Fourier-muunnoksissa käytetään kompleksilukuja, joille voimme toteuttaa oman luokan. Tarvitsemme vain osan kompleksilukujen laskuoperaatioista.

## Testaus
Toteutuksessa syntyvien luokkien toiminnalle kirjoitetaan yksikkötestit. Yksikkötestikokonaisuus pyritään pitämään mahdollisimman nopeasti ajettavana ja luokkien riippuvuudet korvataan testeissä valetoteutuksilla. Testikattavuuden seuraamiseen käytetään ohjelmallisia ratkaisuja.

Vahvasti algoritmisille osille kirjoitetaan suorituskykytestit. Näin saadaan käsitys toteutuksen suorityskyvystä, sekä voidaan seurata mahdollisia muutoksia algoritmien tehokkuudessa tehtyjen muutosten myötä.

Pyritään tekemään myös pääasialliselle käyttötarkoitukselle yksinkertainen hyväksyntätesti, joka antaa käyttäjälle määritellyllä testitallenteella oikean perustaajuuden.

## Lähteet
- [1] [Fourier-muunnos - Wikipedia](https://fi.wikipedia.org/wiki/Fourier-muunnos)
- [2] [Fast Fourier transform - Wikipedia](https://en.wikipedia.org/wiki/Fast_-Fourier_transform)
- [3] [Cooley–Tukey FFT algorithm - Wikipedia](https://en.wikipedia.org/wiki/Cooley%E2%80%93Tukey_FFT_algorithm)