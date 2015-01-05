ELM327 Tester Application
==========================

This is a tester application in order to connect to OBD-II dongle via Bluetooth and get response.

Since STN1110 commands are compatible with ELM327, you are able to use this application to make sure STN1110 is working properly.
However, I have not tested this app against STN1110 yet.


Getting started
---------------

### How?

- Just clone this app and import it into your Android Studio. Then you can connect your mobile device to your laptop/PC and run the application. Once application installed you are ready to go.
- Go to your car :) put OBDII dongle in the port and start engine.
- It's good idea to pair the OBD-II with your device before launching the app. So, in your mobile phone go to settings screen the click on Bluetooth, Search for devices and chose OBDII once discovered. Password should be 1234 in case it asked.
- Launch the application, ELM327, then select OBDII device from paired devices list.

You should be connected to the dongle and ready to send your commands but application tries to send **AT Z**, **AT SP 0**, **0105**, **010C**, **010D** and **0131** commands in order once application launched.



Simulator Mode
------------------

If you want to modify this application based on your needs and don't want to sit inside your car, you are able to install this application on another device then by click on **Toggle Simulator/OBD mode** from menu, you are able to use it as OBD device. Then this device acs as OBD-II device and whatever you write will be received by your application.



Screenshots
--------------
![Enable simulator mode](http://i62.tinypic.com/2qt98cy.jpg)
![In normal usage](http://i61.tinypic.com/dfc8l0.jpg)
 

