Chord-DHT
===================================

Pre-requisites
--------------

- Android Studio
- Android API 19
- Android Virtual Device
- Python



Getting Started
---------------

This project implemented a simple DHT based on Chord. Although it is based on the Chord protocol, it is a simplified version of Chord.To test the DHT, clone the whole project and open it in Android Studio.


Testing
-------

Firstly, Install Python and create Android Virtual Devices using the Python script create_avd.py, then run the Python script run_avd.py to boot up the virtual devices. finally, download the test case files from the test folder. 

After the download is completed, open an existing Android Studio project and choose the SimpleDht directory. Then, In the built-in terminal of Android Studio, navigate to the location of where you download your test case files.

Now, type the following command in your terminal (For example: if the system is macOS):
- python set_redir.py 10000
- ./simpledht-grading.osx 

After these commands are executed, the test case will run and verify the correctness of the DHT.




