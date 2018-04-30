# HEIGVD-RES-FEE-2018-Labo-SMTP

## Project description
This project implements the **SMTP** client protocol. In addition to simply send e-mails with hardcoded text to hardcoded receipents, it also contains a part that can read
configuration files containing group of people to which you want to send an e-mail. The a-mail subject and body are also contained in a predefined editable configuration file.

Project purposes
* Send e-mails (lightweight implenmentation of SMTP client protocol)
* Send e-mails to many users based on configuration files

This project contains as well a Mock SMTP server, in case you want to do some tests.
The Mock SMTP server (called MockMock) has been downloaded from the following GIT repository :
https://github.com/tweakers-dev/MockMock

## Instructions to use MockMock (Mock SMTP) server
MockMock will listen on 2 ports :
* SMTP port : The port on which it will listen for e-mails. Default : 25
* Web port : The port oif the Web interface, where you can see the e-mails received by the server. Default : 8282

1. Go to the root of the repository
2. Launch MockMock.jar : java -jar MockMock.jar
2.1 If you want to overrite the default ports (25 and 8282), launch MockMock.jar as following :
     java -jar MockMock.jar -p <SMTP_PORT> -h <WEB_PORT>
	    Where :
		  <SMTP_PORT> : the desired SMTP port
		  <WEB_PORT>  : the desired port for the Web interface
    Example :
      	java -jar MockMock.jar -p 2525 -h 8181
3. When you want to exit MockMock, interrupt MockMock by doing CTRL+C, or kill the associated Java (or javaw on Windows) process