# Assignment 07 - FacePamphlet

Run these commands from this directory so image paths resolve correctly.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar" FacePamphlet
```
