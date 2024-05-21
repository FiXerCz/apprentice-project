# Hero Game

## Zapnuti

```shell script
./mvnw compile quarkus:dev
```

Po spuštění je aplikace dostupná v prohlížeči na adrese http://localhost:8080

Spuštění UNIT testů: kliknout pravým tlačítkem na název projektu a zvolit *Run all tests*.

Po doimplementování všech potřebných metod musí všchny testy projít.

## Den 1

Seznamte se se strukturou projektu. Vaším úkolem je doimplementovat datové služby a herní logiku.
Zbývající kód už v projektu je hotový, včetně HTML a CSS pro frontend.

### Implementace:

- services/HeroServiceImpl.java

Po implementaci musí projít testy pro *HeroServiceTest* a *ImportServiceTest*.



## Den 2

### Implementace

- pojo/Hero.java
- pojo/HeroRanking.java
- logic/Conflict.java

Po implementaci musí projít testy pro *HeroTest*, *HeroRankingTest* a *HealAbilityTest*.

## Den 3

Seznamte se s návrhovým vzorem Singleton. Ve velmi omezené míře jej naimplementujete v projektu:
[Singleton pattern](https://www.baeldung.com/java-singleton#singleton)

### Implementace

- logic/Tournament.java

Po implementaci musí alespoň částečně projít test pro *TournamentTest*.

## Den 4

### Implementace

- logic/Round.java

Po implementaci musí projít všechny test.

## Den 5

Buffer day pro dodělávky. Pokud bude vše hotové, tak se nabízí možnost implementovat dodatečné schopnosti hrdinů.




