$files = Get-ChildItem -Path "src/main/java/brainmateapp" -Recurse -Filter "*.java"
foreach ($file in $files) {
    $content = Get-Content $file.FullName -Raw
    $content = $content -replace "package main\.java\.brainmateapp", "package brainmateapp"
    $content = $content -replace "import main\.java\.brainmateapp", "import brainmateapp"
    Set-Content -Path $file.FullName -Value $content
} 