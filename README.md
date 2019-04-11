Desktop application that uses the java.io.File class to manage files.

Features implemented:
- createDirectory
- deleteDirectory
- deleteFile
- listDirectory
- copyFile

To run in the command line on Linux
$javac ca.diogo.fileapp.FileApp.java
$java ca.diogo.fileApp listDirectory /home/[DIRECTORY_NAME]
@$param args [listDirectory|createDirectory|deleteDirectory|deleteFile|copyFile][DIRECTORY_OR_FILE_FULL_PATH][NEW_FILE_FULL_PATH]