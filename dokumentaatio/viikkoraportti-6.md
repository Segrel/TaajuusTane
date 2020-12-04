# Viikkoraportti 6

[Tehtiin muutos](https://github.com/Segrel/TaajuusTane/commit/8f0b9241b282d31b2a6a70383f4eb131232fd7c2) Gradle-asetuksiin, jotta jar-tiedostossa olisi pääluokka määriteltynä. Tämä vaikutti olevan toisessa vertaisarvioissa ongelma, vaikka epäilenkin, ettei arvioija käyttänyt tarkalleen ohjeista löytynyttä komentoa ohjelman suoritukseen.

Testauksen osalta jäin miettimään toista hyväksyntätestiä viime viikon vertaisarvioijan manuaalisten testien inspiroimana. Hänen tekemänsä matalan amplitudin aallon sijasta voisi olla vielä mielenkiintoisempi tehdä äänitiedosto, jossa on useampi ääniaalto, sillä vasta tämä asettaa toteutuksen oikeaan testiin, olihan tavoitteena tunnistaa juuri perustaajuus, eli voimakkain taajuus. Ehkä toteutan tämän vielä ensi viikolla.

Tällä viikolla pohdin jonkin verran myös projektin kokonaisrakennetta, sillä se nousi molemmissa vertaisarvioinneissa esille. Tuntuu kuitenkin, että tällä laajuudella paloitellumpi rakenne on hieman väkinäistä ja muotoutuisi paremmin projektia laajentaessa. Katsotaan jos keksin jotain joka toisi lisää selkeyttä, mutta muutoin jätän nykyiselleen.

Periaatteessa AppTesti-luokan voisi poistaa, jolloin se ei vahingossakaan ainakaan vaikuta muun toteutuksen testikattavuusanalyysiin, nyt kun AppTesti ajaa oikean analyysin, vaikkakin vain hyvin pienelle syötteelle. Tämä kulkee hieman projektille asetettuja testaamisen periaatteita vastaan ja puhtaampi yksikkötestaus olisi mielestäni siistimpää. Jätetään kuitenkin vielä nämä testit projektiin ja poistetaan ne vasta kun lopullinen päätös rakenteen mahdollisista muutoksista on tehty.

Dokumentaatiota paranneltiin paikka paikoin ja se alkaa olla viimeistelyä vaille valmis.

Projekti ei käytä tässä vaiheessa ulkopuolisia riippuvuuksia algoritmiseen osuuteen, jos joitain Math-luokan tarjoamia matemaattisia perusoperaatioita ei lasketa.

### Tuntikirjanpito
- Dokumentaatio 3h
- Vertaisarviointi 3h
