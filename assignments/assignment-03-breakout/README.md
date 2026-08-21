# Assignment 03 - Breakout

Run these commands from this directory.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" Breakout.java
```

## Run

```powershell
java -cp "build;acm.jar" Breakout
```
