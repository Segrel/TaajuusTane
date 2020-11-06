# TaajuusTane
Yksinkertaista taajuusanalyysia, Tiralabra II/2020.

Projektin ytimessä on ymmärtää paremmin signaaliprosessointia Fourier-muunnosten avulla, toteuttaen samalla yleisesti käytetty [radix-2 DIT](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm#The_radix-2_DIT_case) versio Cooley-Tukey FFT-algoritmista. Se on käyttöömme riittävän nopea, yleisesti tunnettu ja sen [pseudokoodi](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm#Pseudocode) sekä optimointi-ideoita on helposti saatavilla.

## Dokumentaatio
- [Määrittelydokumentti](dokumentaatio/maarittelydokumentti.md)
- [Viikkoraportti 1](dokumentaatio/viikkoraportti-1.md)
- [Viikkoraportti 2](dokumentaatio/viikkoraportti-2.md)

## Artefaktit
Versionhallinnan `main`-haarasta tehdään [automaattisesti ajo](https://github.com/Segrel/TaajuusTane/actions), jossa:
- käännetään projekti ja tallennetaan JAR-paketti artefaktia `Package`,
- ajetaan checkstyle ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan testit ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan jacoco testikattavuustyökalu ja tallennetaan raportti osaksi `Reports` artefaktia,
- ajetaan Javadoc ja tallennetaan se `Javadoc` artefaktiksi.

Kaikki artefaktit (Artifacts) saa ladattua projektin Actions-välilehden alta, valitsemalla ensin jokin esitetyistä tuloksista (eli ajoista).

## Käyttö
Ohjelman JAR-tiedosto löytyy `gradle build` komennon suorittamisen jälkeen kansiosta `app/build/libs`, tai voit ladata sen Githubista kuten tämän dokumentin Artefaktit-osiossa kerrotaan.

Ohjelma lukee annetun Wav(RIFF)-muotoisen, yksikanavaisen signed 16bit PCM-muotoisen tallenteen. Komento voisi näyttää siis esimerkiksi seuraavalta:
```
java -cp app/build/libs/app.jar TaajuusTane.App tallenne.wav
```

## Linkkejä
- [YouTube: But what is the Fourier Transform? A visual introduction](https://www.youtube.com/watch?v=spUNpyF58BY), englanniksi, 3Blue1Brown 2018
- [Wikipedia: https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm), englanniksi
