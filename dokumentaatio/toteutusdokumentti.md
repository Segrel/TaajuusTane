# TaajuusTane toteutusdokumentti

## Konseptitaso

Intuitiivisella tasolla ohjelma lukee tallenteen ja suorittaa sille analyysin. Toteutuksessa on pääosassa Tallenne-luokka, joka suorittaa äänitiedoston lukemisen levyltä, sekä Analyysi-luokka, joka suorittaa luetulle signaalille analyysin.

Analyysin ymmärtämisen kannalta on Fourier-muunnoksesta hyvä tietää sen luonne eräänlaisena matemaattisena koneena. Tällaista korkean tason intuitiota voi muodostaa esimerkiksi [3Blue1Brown: But what is the Fourier Transform? A visual introduction](https://www.youtube.com/watch?v=spUNpyF58BY) -videon avulla.

## Luokat

### App
App-luokka vastaa sovelluksen komentorivirajapinnan toteutuksesta.

### Kompleksi
Toteutus käyttää globaalia Kompleksi-luokkaa ilmentämään kompleksilukuja ja suorittamaan näillä laskutoimituksia.

### Fourier
Fourier-luokka on eriytetty omakseen ja sisältää pelkästään Fourier-muunnoksessa tarvittavan logiikan. Fourier-muunnoksesta toteutuksesta tarkemmin osiossa Algoritmit.

### Tallenne
Tallenne tarjoaa staattisen metodin audiotiedoston lukemiseksi Kompleksi-taulukoksi. Luvun yhteydessä validoidaan tallenteen oikea muoto.

### Analyysi
Analyysi-luokalta voi pyytää perustaajuuden Kompleksi-muotoisella signaalisyötteellä. Koska Fourier-analyysimme suoriutuu vain syötteen pituuksista, jotka ovat kahden potensseja, voidaan analyysi-luokalta kysyä myös montako näytettä jätettiin analyysissa tämän takia käsittelemättä. Analyysi käyttää Fourier-luokkaa muuntaakseen signaalin taajuustasoon, minkä jälkeen se etsii magnitudiltaan suurimman alkion ja laskee tätä muunnos-siivua vastaavan taajuuden.

## Algoritmit

Algoritmien osalta kiinnostavaa on lähinnä Fourier-muunnos. Toteutus on nk. Cooley-Tukey radix-2 DIT FFT[1].

### Aika- ja tilavaativuudet

Olkoon `X` tehty muunnos ja `x` syötesignaali, molemmat kompleksilukutaulukoita. Nyt algoritmin pseudokoodi voidaan esittää esimerkiksi seuraavasti:
```
X = ditfft2(x):
  N = length(x)
  if N == 1:
    X = x
  else:
    X[1:N/2] = ditfft2(x[parilliset])
    X[N/2:N] = ditfft2(x[parittomat])
    for k = 1 to N/2:
      X[k] = X[k] + exp(-2*pi*k/N) * X[k+N/2]
      X[k+N/2] = X[k] - exp(-2*pi*k/N) * X[k+N/2]
```
Tästä nähdään asymptoottisen aikavaativuuden olevan O(N log N), sekä asymptoottisen tilavaativuuden O(N log N).

### Suorituskykytestien tulokset

Suorituskykytestauksen toteutus kuvataan tarkemmin [testausdokumentissa](testausdokumentti.md). Suorituskykytestit ajettiin tietokoneella, jossa 3.5GHz Quad-Core Intel Core i5 suoritin, missä 256KB L2-välimuistiä, sekä 6MB ytimien välillä jaettua L3-välimuistia.

![Suorituskykytestin visualisointi](perftest.png)

```
syötteen pituus: mediaanikesto (ms)
2^12: 2.785178
2^13: 10.80427
2^14: 17.704868
2^15: 20.702131
2^16: 29.999889
2^17: 76.239967
2^18: 141.203492
2^19: 341.202139
2^20: 669.518513
```

Tulokset noudattelevat O(N log N) aikavaativuutta. 2^20 ääninäytettä on noin 24 sekuntia kun näytteenottotaajuus on 44100 Hz.

## Puutteet

Suuressa osassa todellisista tallenteista ei ole juuri oikeaa määrää (kahden potenssi) sampleja, jolloin analyysi jättää osan tallenteesta käsittelemättä. Tämän osalta voitaisiin esimerkiksi pilkkoa tallenne lyhyempiin pätkiin, analysoida ne ja koostaa näistä pienemmistä analyyseista johtopäätös.

## Jatkokehittelyideoita

Mielenkiintoisia aihepiirejä olisivat:
- laajemmin erilaisten äänitallenteiden tukeminen
- taajuuden tunnistaminen reaaliaikaisesta äänilähteestä (mikrofoni)
- muiden signaalin ominaisuuksien tunnistaminen analyysissa

## Lähteet
- 1 [Wikipedia: Cooley–Tukey_FFT_algorithm](https://en.wikipedia.org/wiki/Cooley–Tukey_FFT_algorithm), englanniksi
- 2 [James W. Cooley ja John W. Tukey: An algorithm for the machine calculation of complex Fourier series](https://doi.org/10.2307%2F2003354), 1965, englanniksi
