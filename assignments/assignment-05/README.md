# Assignment 05 - Yahtzee

Run these commands from this directory.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar;yahtzeelib.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar;yahtzeelib.jar" Yahtzee
```
