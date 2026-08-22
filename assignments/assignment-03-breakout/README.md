# Assignment 03 - Breakout

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" Breakout.java
```

## Run

```powershell
java -cp "build;acm.jar" Breakout
```
