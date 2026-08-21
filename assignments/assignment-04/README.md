# Assignment 04 - Hangman

Run these commands from this directory so the program can find `HangmanLexicon.txt`.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar" Hangman
```
