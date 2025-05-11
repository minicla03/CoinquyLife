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

- **Linguaggi**: Java
- **Framework**: Android SDK
- **Database**: Room (persistenza locale)
- **Stile Architettura**: Clean Archietecture combinata con MVVM (Model-View-ViewModel)

![image](https://github.com/user-attachments/assets/cb57acec-829c-4451-9a74-a20344f902aa)

#### 📂 Livelli principali

- **Presentation Layer**  
  Contiene la UI e la logica di presentazione. Utilizza il pattern **MVVM** con `ViewModel`, `LiveData`.

- **Domain Layer**  
  Cuore dell'applicazione, indipendente da Android. Contiene:
  - **Use Case Interface**: Interfacce per DIP
  - **Use Case**: Logica di business dell'app
  - **Entity**: Modelli del dominio condivisi
  - **Repository Interface**: Interfacce per DIP

- **Data Layer**  
  Gestisce l’accesso ai dati. Comprende:
  - **Repository Implementation**: Implementazioni dei repository del dominio
  - **Room DAO**: Per la persistenza locale
  - **Convertes**: Per convertire i dati tra strati

 ### Architettura tecnica

- **MVVM**: Separation of concerns tra logica, UI e dati.
- **Room**: Database SQLite con DAO e repository.
- **LiveData**: Osservazione dati in tempo reale.
- **ViewModel**: Gestione dello stato delle UI in modo lifecycle-aware.
- **Navigation Component**: Gestione sicura delle transizioni tra fragment.

## Design & UX

- **Librerie UI**: Material Design 3, Jetpack Components
- **Temi**: Modalità chiara/scura
- **Accessibilità**: Testo scalabile, contrasto elevato

## Requisiti

- **Android Studio**: Versione 2024.3.1 Patch 2 o superiore
- **Gradle**: Versione minima supportata dal progetto
- **SDK Android**: Min SDK 21, Target SDK 33


