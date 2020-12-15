# TaajuusTane testausdokumentti

## Strategia
Projektin testit on jaoteltu yksikkötesteihin, suorituskykytesteihin ja hyväksyntätesteihin. Yksikkötesteillä testataan luokkien, kuten `Analyysi`, `Fourier`, `Kompleksi` ja `Tallenne` julkista rajapintaa. Suorituskykytesteillä tarkkaillaan eniten aikaa vievien osien suorituskykyä ja hyväksyntätesteillä varmistetaan ohjelmakokonaisuuden toiminta. Kaikki testit ajetaan osana projektin Github Actions -ajoa, joka tapahtuu aina versionhallinnan `main`-haaran päivittyessä.

### Yksikkötestaus

Yksikkötesteillä testataan luokkien julkisten rajapintojen toiminnan oikeellisuutta. Yksikkötestien ajoon kuluva aika pyritään pitämään pienenä kehityksen sujuvuuden vuoksi. Testattavan luokan ulkopuoliset metodit ohitetaan ja palautetaan korvaavista mock-toteutuksista testidataa. Useassa tapauksessa oikeellisuus varmennetaan vertaamalla saatuja arvoja käsin laskettuihin, oikeaksi tiedettyihin arvoihin.

Yksikkötestit voi suorittaa seuraavalla komennolla:
```
./gradlew test
```
Komennon suoritus luo testiraportin polkuun `app/build/reports/tests/test/`, sekä testikattavuusraportin polkuun `app/build/reports/jacoco/test/html/`.

#### Tallenne

`Tallenne`-luokan testaus poikkeaa muista siten, että testeissä ei ohiteta luokan ulkopuolisia riippuvuuksia, vaan testi lukee tiedostoja oikeasta tiedostojärjestelmästä. Testaukseen käytetään `app/src/test/resources/` kansiosta löytyviä `kymmenykset` Wav-tiedostoja, jotka on generoitu `skriptit/genwav.py` python-skriptillä. Näissä tiedostoissa on kymmenen näytettä skaalan kymmenesosan välein, kaikki epänegatiivisia. Luettujen arvojen validointiin riittää hyvin epätarkempikin täsmäys, sillä arvojen väli on tuhansia yksiköitä etumerkillisellä 16-bittisellä skaalalla.

Big Endian -muotoisen Wav-tiedoston hylkäystä ei testattu tällaisen tiedoston luomisen työläyden vuoksi, [Javan dokumentaation](https://docs.oracle.com/javase/8/docs/api/javax/sound/sampled/AudioFormat.html#isBigEndian--) mukaisesti toteutuksen pitäisi suorittaa haluttu lopputulos.

Tiedoston luvun keskellä tapahtuvan virheen käsittelyä ei ole testattu.

### Suorituskykytestaus

Suorituskykytesteillä testataan `Fourier.muunnos` metodin nopeutta. Wav-tiedostot vievät paljon tilaa, joten testaamisessa käytetty signaali (440 Hz siniaalto) generoidaan testien suorituksen yhteydessä. Koska käyttämämme algoritmi suoriutuu vain kahden potensseista, tehdään testaus kahden potenssien pituisilla syötteillä. Käytetään pituuksia 2^12, ..., 2^20, sillä näilläkin yksittäinen muunnos vie (testatulla laitteistolla) joistain millisekuinneista aina useisiin satoihin millisekunteihin.

Suorituskykytestit voi suorittaa seuraavalla komennolla:
```
./gradlew perftest
```
Komennon suoritus luo testiraportin polkuun `app/build/reports/tests/perftest/`. Testien tulokset löytyvät HTML-raportista navigoimalla TaajuusTane > FourierSuorituskykyTesti näkymään ja klikkaamalla "Standard output". Myös CSV-muotoinen esitys tallentuu samaan polkuun. CSV-tiedoston pohjalta voi luoda visualisaation käyttämällä projektin sisältämää python-skriptiä sijainnissa `skriptit/perfplot.py`. Suorituskykytestien tuloksista on lisää [toteutusdokumentissa](toteutusdokumentti.md).

### Hyväksyntätestaus

Automaattinen hyväksyntätesti varmistaa, että sovellus palauttaa oikean taajuuden kun annetaan syötteeksi 440 Hz siniaallon sisältävä `app/src/test/resources/440hz.wav`, sekä kun annetaan monta siniaaltoa (200 Hz, 400 Hz ja 800 Hz) sisältävä tiedosto `app/src/test/resources/200hz-400hz-800hz.wav`, jonka perustaajuudeksi tiedetään 200 Hz. Tiedostot on generoitu `skriptit/genwav.py` python-skriptillä.

Hyväksyntätestin voi suorittaa seuraavalla komennolla:
```
./gradlew acctest
```
Tätä vastaa manuaalinen suoritus:
```
java -jar app/build/libs/app.jar app/src/test/resources/440hz.wav
```
