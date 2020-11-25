# TaajuusTane
Yksinkertaista taajuusanalyysia, Tiralabra II/2020.

Projektin ytimessä on ymmärtää paremmin signaaliprosessointia Fourier-muunnosten avulla, toteuttaen samalla yleisesti käytetty [radix-2 DIT](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm#The_radix-2_DIT_case) versio Cooley-Tukey FFT-algoritmista. Se on käyttöömme riittävän nopea, yleisesti tunnettu ja sen [pseudokoodi](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm#Pseudocode) sekä optimointi-ideoita on helposti saatavilla.

Sovellus analysoi lyhyitä äänitallenteita ja palauttaa signaalin perustaajuuden, eli dominantin aallonpituuden hertseinä. Tallenteen tulee olla 16bit mono WAV-tiedosto näytteenottotaajuudella 44100Hz.

## Käyttö
Ohjelman JAR-tiedosto löytyy `./gradlew build` komennon suorittamisen jälkeen polusta `app/build/libs`, tai voit ladata sen Githubista kuten tämän dokumentin "Artefaktit Githubissa" -osiossa neuvotaan.

Ohjelma lukee annetun Wav(RIFF)-muotoisen, yksikanavaisen signed 16bit PCM-muotoisen tallenteen. Toteutusta ei ole suunniteltu yli 5 sekunnin mittaisille tallenteille, eikä analyysi välttämättä ota huomioon koko tallennetta. Ohjelma ilmoittaa mahdollisesti sivuutettujen näytteiden määrän suorituksen yhteydessä.

Esimerkiksi seuraavan komennon pitäisi antaa perustaajuudeksi 440Hz:

```
java -cp app/build/libs/app.jar TaajuusTane.App app/src/test/resources/440hz.wav
```

Lisää äänitiedostoja voi generoida ottamalla mallia esimerkiksi [tästä python skriptistä](https://github.com/Segrel/TaajuusTane/blob/main/skriptit/genwav.py) tai käyttämällä saatavilla olevia äänen muokkamiseen soveltuvia ohjelmia.

## Dokumentaatio
- [Määrittelydokumentti](dokumentaatio/maarittelydokumentti.md)
- [Testausdokumentti](dokumentaatio/testausdokumentti.md)

## Edistyminen
- [Viikkoraportti 1](dokumentaatio/viikkoraportti-1.md)
- [Viikkoraportti 2](dokumentaatio/viikkoraportti-2.md)
- [Viikkoraportti 3](dokumentaatio/viikkoraportti-3.md)
- [Viikkoraportti 4](dokumentaatio/viikkoraportti-4.md)
- [Viikkoraportti 5](dokumentaatio/viikkoraportti-5.md)

## Artefaktit Githubissa
Versionhallinnan `main`-haarasta tehdään [automaattisesti ajo](https://github.com/Segrel/TaajuusTane/actions), jossa:
- käännetään projekti ja tallennetaan JAR-paketti artefaktia `Package`,
- ajetaan checkstyle ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan testit ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan jacoco testikattavuustyökalu ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan Javadoc ja tallennetaan se `Javadoc` artefaktiksi.

Kaikki artefaktit (Artifacts) saa ladattua projektin Actions-välilehden alta, valitsemalla ensin jokin esitetyistä tuloksista (eli ajoista).

## Linkkejä
- [3Blue1Brown: But what is the Fourier Transform? A visual introduction](https://www.youtube.com/watch?v=spUNpyF58BY), 2018, englanniksi
- [Wikipedia: Cooley–Tukey_FFT_algorithm](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm), englanniksi
- [James W. Cooley ja John W. Tukey: An algorithm for the machine calculation of complex Fourier series](https://doi.org/10.2307%2F2003354), 1965, englanniksi
- [Alijah Ahmed: FFT Calculator](https://scistatcalc.blogspot.com/2013/12/fft-calculator.html), 2013, englanniksi
