Implementation of a classic concurency problem readers and writers in java.
Uruchomienie po wykonaniu komend mavenowych
    java -jar nazwa_paczki.jar
Wątki w programie porozumiewają się przez notify i notifyAll używając mechanizmu wait.
Gdy klient chce wejść do blblioteki uruchamie synchronizową metodę join która to na podstawie aktualnego
stanu rzeczy decyduje o jego dalszych losach. Następnie klient jeżeli klient może zostać wpuszczony to wchodzi
w przeciwnym razie trafia do pętli z wait() oczekując na wybudzenie przez wychodzące wątki