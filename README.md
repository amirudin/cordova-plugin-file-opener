A File Opener Plugin for Cordova
==========================
This plugin will open a file on your device file system with its default application.

Requirements
-------------
- Android
- Cordova 3.0 or higher

Installation
-------------
    cordova plugin add [url-of-the-git-repo]

Usage
------
Open an APK install dialog:
    
    <script>
        cordova.plugins.fileOpener.open(
            '/sdcard/Download/gmail.apk', 
            'application/vnd.android.package-archive'
        );
    </script>
    
Open a PDF document with the default PDF reader and optional callback object:

    <script>
        cordova.plugins.fileOpener.open(
    	    '/sdcard/Download/starwars.pdf', 
    	    'application/pdf', 
    	    { 
    		    error : function(errorObj) { 
    			    alert('Error status: ' + errorObj.status + ' - Error message: ' + errorObj.message); 
    		    },
    		    success : function () {
    			    alert('file opened successfully'); 				
    		    }
    	    }
        );
    </script>
    
