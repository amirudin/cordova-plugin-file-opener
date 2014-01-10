A File Opener Plugin for Cordova
==========================
This plugin will open a file on your device file system with its default application.

Requirements
-------------
Android
Cordova 3.0 or higher

Installation
-------------
    cordova plugin add [url-of-the-git-repo]

Usage
------
Open an APK install dialog:
    
    <script>
      cordova.plugins.fileOpener.open('/sdcard/Downloads/gmail.apk', 'application/vnd.android.package-archive');
    </script>
    
Open a PDF document with the default PDF reader:

    <script>
      cordova.plugins.fileOpener.open('/sdcard/Downloads/starwars.pdf', 'application/pdf');
    </script>
    
