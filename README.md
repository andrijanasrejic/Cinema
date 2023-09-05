# Cinema
**Aplikacija za vodjenje bioskopa.**

## Table of contents :book:
* [General info](#general-info-point_down)
* [Technologies](#technologies-wrench)
* [Setup](#setup-black_cat)

* ## General info :point_down:
**Aplikacija uz pomoc koje se može upravljati i mogu se koristiti usluge bioskopa.**

## Technologies :wrench:
- **Spring**
- **Vue.js**
- **MongoDB**

## Setup :black_cat:
Klonirati repozitorijum i pozicionirati se u njega:
```
git clone https://github.com/andrijanasrejic/Cinema.git
```

Za inicijalizovanje baze izvršiti:
```
mongoimport --host localhost --port 27017 --db demo --collection database_sequence --file database_sequence.json --jsonArray
```

Za pokretanje back end servera:
```
mvn org.springframework.boot:spring-boot-maven-plugin:run u root folderu
```

Za pokretanje front end aplikacije:
```
npm run dev u folderu src\cinema-front
```














