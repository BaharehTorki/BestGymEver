# BestGymEver

### Receptionisten önskemål:
>Skriv ett program där man skriver in en __kunds personnummer__ eller __namn__ när personen dyker upp
på gymet, sen söker programmet i filen och visar upp:</br>
__Kunden är en nuvarande medlem__ (dvs om årsavgiften betalades för mindre än ett år sedan).</br>
__En före detta kund__ (om årsavgiften betalades för mer än ett år sedan). </br>
__Obehörig__ (personen inte finns i filen och sålunda aldrig har varit medlem).

### Tränaren önskemål:
>Tränaren behöver veta __namn__, __personnummer__ och __datum__ när kunden var på gymmet (så detta ska alltså sparas
i hens fil).


## Betygskriterier:

För att bli Godkänd (G) krävs att du hjälper både __receptionisten__ och __den personlige tränaren__ och
uppfylla deras önskemål.</br>
#### _Din lösning ska kunna:_
>+ Läsa personposter från fil.
>+ Skriva till fil.
>+ Läsa in och parsa datum (_Tips_: __LocalDate__ är en bra klass för hantering av datum)
>+ Ha bra felhantering (relevanta felmeddelanden, exception hantering och try-with-resources)
>+ Koden ska vara enkelt läsbar och prydligt skriven.


För att bli __Väl Godkänd (VG)__ måste lösningen uppfylla följande:

 >- Alla krav för att få G vara uppfyllda.
 >- Jobba helt testdrivet när du löser uppgiften (Sigrun kommer såklart inte att kunna se om ni
gör det eller inte, detta är en hederssak)
 >- Det ska finnas enhetstester som minst täcker följande delar av koden:
 >  - Att inläsning av korrekt data görs, på korrekt sätt.
 >  - Att datat kontrolleras och behandlas på rätt sätt.
 >  - Att korrekta utskrifter skrivs till fil.
 >- Testerna ska uppfylla följande krav:
 >  - Dessa tester ska __alltid__ kunna köras med samma resultat. (De får alltså inte vara beroende av att man t.ex. kör koden ett visst datum för att de ska bli gröna)
 >  -  Testerna ska vara relevanta för programmets funktionalitet och inte vara extremt simplistiska. (Ni får alltså INTE VG om ni testar t.ex. 1==1 eller liknande, och inte heller om ni testar simpla getters och setters)
 >  -  De ska alltid gå att köra testerna automatiskt (det är alltså inte ok att testerna väntar på input från användaren)
 >  -  Alla testfallen ska gå gröna när de körs.

 ## Github Länk

>BestGymEver inlämning länk (https://github.com/BaharehTorki/BestGymEver.git)

