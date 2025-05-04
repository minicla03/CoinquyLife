# CoinquyLife

**CoinquyLife** è un'applicazione progettata per semplificare la gestione della vita in una casa condivisa. L'app offre funzionalità per organizzare turni, gestire spese, creare sondaggi e molto altro.

## Funzionalità principali

- **Gestione dei turni**: Assegna e visualizza i turni di pulizia o altre attività.
- **Gestione delle spese**: Tieni traccia delle spese condivise e calcola i bilanci.
- **Bacheca messaggi**: Pubblica note e messaggi per i coinquilini.
- **Sondaggi**: Crea e partecipa a sondaggi per decisioni condivise.
- **Classifica**: Guadagna punti e livelli per completare attività.
- **Selezione della casa**: Unisciti o crea una casa condivisa.

## Struttura del progetto

- **Linguaggi**: Java, Kotlin
- **Framework**: Android SDK
- **Database**: Room (persistenza locale)
- **Architettura**: MVVM (Model-View-ViewModel)

### Cartelle principali

- `app/src/main/java/minicla03/coinquylife/Auth`: Gestione dell'autenticazione e dello splash screen.
- `app/src/main/java/minicla03/coinquylife/Dashboard`: Dashboard principale dell'app.
- `app/src/main/java/minicla03/coinquylife/PERSISTANCE`: Gestione del database e delle entità.
- `app/src/main/java/minicla03/coinquylife/SelectionHouse`: Funzionalità per la selezione e creazione della casa.

## Requisiti

- **Android Studio**: Versione 2024.3.1 Patch 2 o superiore
- **Gradle**: Versione minima supportata dal progetto
- **SDK Android**: Min SDK 21, Target SDK 33

## Design & UX

- **Librerie UI**: Material Design 3, Jetpack Components
- **Temi**: Modalità chiara/scura
- **Accessibilità**: Testo scalabile, contrasto elevato

## Architettura tecnica

- **MVVM**: Separation of concerns tra logica, UI e dati.
- **Room**: Database SQLite con DAO e repository.
- **LiveData / StateFlow**: Osservazione dati in tempo reale.
- **ViewModel**: Gestione dello stato delle UI in modo lifecycle-aware.
- **Navigation Component**: Gestione sicura delle transizioni tra fragment.

## Installazione

1. Clona il repository:
   ```bash
   git clone https://github.com/minicla03/coinquylife.git
