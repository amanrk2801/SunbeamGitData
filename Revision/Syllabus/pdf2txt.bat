@echo off
REM PDF to Text Converter Batch Script
REM Usage: pdf2txt.bat <pdf_file> [output_text_file]

echo PDF to Text Converter

REM Check if Python is installed
python --version > nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Python is not installed or not in the PATH. Please install Python.
    exit /b 1
)

REM Check if PyPDF2 is installed, if not install it
python -c "import PyPDF2" > nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Installing PyPDF2...
    pip install PyPDF2
    if %ERRORLEVEL% NEQ 0 (
        echo Failed to install PyPDF2. Please install it manually with "pip install PyPDF2"
        exit /b 1
    )
)

REM Check if a PDF file was provided
if "%~1"=="" (
    echo No PDF file specified.
    echo Usage: pdf2txt.bat ^<pdf_file^> [output_text_file]
    exit /b 1
)

REM Convert the PDF to text
python "%~dp0pdf_to_text.py" "%~1" "%~2"
