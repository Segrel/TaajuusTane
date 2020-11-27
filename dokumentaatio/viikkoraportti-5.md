# Viikkoraportti 5

Tämän viikon osalta jatkettiin ensin [visualisoiden suorituskykytestauksen tuloksia](https://github.com/Segrel/TaajuusTane/commit/e66edba15358c2830679239eb87741bf9b64dc40). Tähän käytettiin taas pythonia ajan säästämiseksi. Esimerkkivisualisaatio laitettiin aluksi [testausdokumenttiin](testausdokumentti.md) ja siirrettiin myöhemmin [luotuun toteutusdokumenttiin](https://github.com/Segrel/TaajuusTane/commit/e8d9700d37c065e89b3c51418a70750ac424bc6a).

[Saatu vertaispalaute](https://github.com/Segrel/TaajuusTane/issues/1) oli selkeästi ajatuksella tehty, vaikkei annakaan aihetta suurempiin muutoksiin. [Vertaispalautteen antaminen](https://github.com/nnecklace/calc-malc/issues/1) taas oli virkistävää vaihtelua pelkästään oman koodin tuijottamiseen. Labtool sen sijaan ei nähtävästi halua toimia näin perjantai-iltapäivästä.

[Lisättiin hyväksyntätesti](https://github.com/Segrel/TaajuusTane/commit/3b4f48df97621e1b98a1196e4e607090cff91e85), jonka voi ajaa `./gradlew acctest` komennolla ja määritettiin se suoritettavaksi Github Actionien yhteydessä. Päivitettiin myös testidokumentaatio tämän myötä.

Tässä vaiheessa perustoteutus alkaa olla aika hyvin kasassa, joskin dokumentaatiota, testausta ja rakennetta voi vielä hioa. Tästä eteenpäin pyritään pitämään koko paketti dokumentaatioineen ajan tasalla jos muutoksia vielä tehdään.

#### Tuntikirjanpito
- Suorituskykytestien visualisointi ym. 1h
- Toteutusdokumentti 4h
- Vertaisarviointi 4h
- Hyväksyntätesti 1h
