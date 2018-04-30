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

If you would like to launch MockMock and that MockMock *listen on the default ports* (25 and 8282)
```
$ cd <REPO_ROOT>
$ java -jar MockMock.jar
```

If you would like to launch MockMock and that MockMock *do not listens on the default ports* :
```
$ cd <REPO_ROOT>
$ java -jar MockMock.jar -p <SMTP_PORT> -h <WEB_PORT>
```
Where <SMTP_PORT> is the desired SMTP portand <WEB_PORT>is the desired port for the Web interface

When you want to exit MockMock, interrupt MockMock by doing CTRL+C, or kill the associated Java (or javaw on Windows) process

## Tool configuration and usage

First, you need to clone the repo
```
$ git clone https://github.com/lionelwidmer/HEIGVD-RES-FEE-2018-Labo-SMTP.git
```

Then, inside the repo you find a 'config' directory.
This directory contains 2 files :
* groups.csv : A CSV file (semicolumn separated) containing the list of groups, with all e-mail addresses of each group