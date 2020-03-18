# TheEndTimes
Programmering

Vi skal fortsette med å utvide oppgaven vi lagde i Oblig 4. Du kan fortsette på din egen implementasjon, eller du kan starte fra løsningsforslaget som finnes her:

Oblig4_ProposedSolution.zip

Video: Oblig 4 - Løsningsforslag

Vi skal ta for oss filskriving, og hente data herfra, samt kunne gjøre både Create, Update og Delete på dataene våre. Slik at vi har hele CRUD-løpet (Create, Read, Update og Delete).

Oppdaterte vue-filer

Oppgave 2.1 - Fillesing og nytt JSON repository

Vi skal nå kunne gjøre mer enn å bare lese data, vi ønsker derfor å lage og utvide repositoriet vårt.

a - Repository)

Lag et nytt repository kalt UniverseJSONRepository. I konstruktøren skal du kunne ta inn enten et filnavn, eller et File-objekt, og gjør noe lignende slik vi gjorde tidligere, med å lese disse dataene inn i en liste med PlanetSystems. Bruk Jackson eller et lignende bibliotek for å hjelpe til med lesingen av data.

Lag også en egen metode som kan lese inn alle dataene fra filen på nytt.

planets_100.json

planets_4000.json

b - Forberedelser)

Når JSON serialiserer og deserialiserer (gjør om fra Java-objekter til JSON og tilbake), så gjør den dette ved hjelp av noe som heter reflection (ser hvilke metoder som finnes, og benytter disse). I tilfellet hvor vi ønsker å lese en Planet, så inneholder denne en "CelestialBody". På grunn av arv, så kan denne for oss være en subklasse. Hvis dette er tilfelle må vi gi noe informasjon om at hvis dette er en stjerne, bruk Star-klassen.

Med Jackson, kan man legge til annotering i CelestialBody. Legg til:

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Star.class, name = "star")
})
public class CelestialBody implements Comparable<CelestialBody> 

I tillegg forutsetter også denne deserialiseringen at vi har tomme konstruktører i klassene vi skal benytte. Da denne benytter disse, for så å fylle opp objektet med data ved hjelp av set-metodene.

Lag tomme konstruktører i alle model-klassene, verifiser også at det finnes get- og set-metoder for alle variabler som skal kunne leses og skrives.

c - Implementasjon av interface)

Implementere IUniverseRepository, og lag en implementasjon av alle metodene derfra.

Benytt så dette repositoriet fremfor det gamle i Application.java. Hvorfor fungerer nå dette sammen med Controllerne våre, selv om vi har et helt nytt repository?

d - Skriving)

Vi ønsker at endringer vi gjør i dataene i senere oppgaver blir lagret, og er der når vi starter applikasjonen på nytt. Vi skal derfor gjøre klart skriving av disse endringene til fil.

Lag en metode som skriver all dataen til fil i JSON-format. Siden det er unødvendig komplisert og oppdatere enkelte områder i en fil med endringene som er gjort er det OK å skrive hele filen på nytt.

Oppgave 2.2 - Fillesing og nytt CSV repository

a - Repository)

Lag enda et nytt repository kalt UniverseCSVRepository. I konstruktøren skal du kunne ta inn enten et filnavn, eller et File-objekt. 

I dette tilfellet ønsker vi å benytte HashMap som den interne lagringsstrukturen fremfor en ArrayList. Hvilke fordeler gir dette oss når vi skal implementere metodene fra IUniverseRepository?

Å lese en .CSV fil krever litt mer kodelogikk. Sørg for at et PlanetSystem og Star bare opprettes én gang, selv om data for dette er duplisert per planet.

planets_100.csvForhåndsvis dokumentet

planets_4000.csvForhåndsvis dokumentet

b - Interface)

Implementere IUniverseRepository, og lag en implementasjon av alle metodene derfra.

Test så ut ved å bruke denne repositoriet i Application.java.

c - Skriving)

Lag en metode som skriver all dataen til fil i JSON-format. Siden det er unødvendig komplisert og oppdatere enkelte områder i en fil er det OK å skrive hele filen på nytt.

Oppgave 2.4 - Delete

a - Interface)

Du skal utvide interfacet vi laget med følgende metoder:

    Opprette en planet
    Oppdatere en planet
    Slette en planet

Tenk gjennom hvilke parametere du trenger som input for å kunne utføre de forskjellige handlingene. Du trenger ikke lage en implementasjon av disse metodene i repositoryene enda, men de må fortsatt overrides der slik at koden kompilerer (i.e. lage tomme metoder uten en ferdig implementasjon).

b - Delete-metoden)

Velg enten UniverseJSONRepository eller UniverseCSVRespository og implementer så denne metoden i dette repositoriet. Den skal slette en planet, og skrive data til fil.

c - Delete - API - Controller)

Oppdater controlleren til å ta imot en API-get request til:

    /api/planet-systems/:planet-system-id/planets/:planet-id/delete

Kall så den korrekte metoden i UniverseFileRepository.

Oppgave 2.2 - Create

a - Create-metoden)

Velg enten UniverseJSONRepository eller UniverseCSVRespository og implementer så denne metoden i dette repositoriet. Den skal opprette en planet, og skrive data til fil.

b - Koble opp views)

Kobl sammen planet-create vue med path'en:

    /planet-systems/:planet-system-id/createplanet

e - Create - API - Controller)

Oppdater controlleren til å ta imot en API-post request til:

    /api/planet-systems/:planet-system-id/createplanet

Hent ut data fra post-requesten, dette kan gjøres ved hjelp av formParam-metoden til Context. Pass på å konverter verdiene du får (alt er String-er) til korrekte typer i.e. double. Kall så den korrekte metoden i repositoriet.

Du skal til slutt redirectes tilbake til detaljvisningen for planetsystemet planeten er blitt lagt til i.

Oppgave 2.3 - Update

a - Update-metoden)

Implementer denne metoden i dette valgfritt repository. Den skal oppdatere en planet. Tenk gjennom hvordan du kan få oppdatert det faktiske planet-objektet som finnes i et PlanetSystem. Du står fritt til å utvide med metoder i modell-klassene hvis det skulle være behov for det.

Endringene skal til slutt skrives til fil. Siden det er unødig komplisert og oppdatere spesifikke områder i en fil, så går det fint at hele innholdet i filen overskrives.

b - Update - API - Controller)

Oppdater controlleren til å ta imot en API-post request til:

    /api/planet-systems/:planet-system-id/planets/:planet-id/update

Er det noe kode her som blir felles med create-metoden i controlleren? Kan noe av dette skilles ut i en egen metode begge benytter? Kall den korrekte metoden i det valgte repositoriet.

Du skal til slutt redirectes tilbake til detaljvisningen for planetsystemet planeten er blitt lagt til i.

Oppgave 2.5 - Tråder

Lag en egen tråd for skrivingen til fil i UniverseCSVRepository/UniverseJSONRepository.

 

Bonusoppgaver

Oppgave 3.1 - Database

Lag et nytt database-repository - UniverseDBRepository. Implementer alle metodene fra IUniverseRepository og benytt denne i Application.java.

....
