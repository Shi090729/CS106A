# Assignment 06 - NameSurfer

Run these commands from this directory so the program can find `names-data.txt`.

## Build

```powershell
New-Item -ItemType Directory -Force build | Out-Null
javac -d build -cp "acm.jar" *.java
```

## Run

```powershell
java -cp "build;acm.jar" NameSurfer
```
