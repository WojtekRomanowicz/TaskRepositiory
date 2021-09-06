call runcrud.bat
if "%ERRORLEVEL%" == "0" goto open
echo.
echo runcrud has errors - breaking work
goto fail

:open
start chrome.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Problem with open chrome
goto fail


:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.