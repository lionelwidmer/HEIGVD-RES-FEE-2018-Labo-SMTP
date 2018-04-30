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

A Mock SMTP server is a simulation of real SMTP server, that will not send any e-mail but show the results of what would have been sent and what would 
have been seen by the receiver in case the e-mails were sent to a real SMTP server.
Mock servers are useful when we are doing tests, to avoid sending hundreds of e-mails when developping.

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

Then, inside the repo you find a 'SMTPClient-build/config' directory, in which you can specify the groups of users and the list of available pranks.
This directory contains 3 files :
* groups.csv : A CSV file (semicolumn separated) containing the list of groups, with the e-mail addresses of each member of the group. Syntax : <GROUP_NAME>;<EMAIL_1>;<EMAIL_2>;<EMAIL_3>;<EMAIL_N>
* pranks.csv : A CSV file (semicolumn separated) containing the list of pranks. Syntax : <PRANK_TITLE>;<PRANK_TEXT>
* config.csv : A CSV file (semicolumn separated) containing the SMTP server hostnamd (or IP) and SMTP server port. Syntax : smtpHost;<SMTP_HOSTNAME>;<SMTP_PORT>

Finally, after editing the configuration files as desired, launch the prank generator to send the e-mails like this
```
$ cd <REPO_ROOT>/SMTPClient-build
$ java -jar out/artifacts/SMTPClient_build_jar/SMTPClient-build.jar <GROUP_ID> <PRANK_ID> <USER_ID>
```
Where :
* <GROUP_ID> is the Id of the group (1st group in groups.csv has Id 0, 2nd row has Id 1, ...)
* <PRANK_ID> is the Id of the prank (1st prank in pranks.csv has Id 0, 2nd row has Id 1, ...)
* <USER_ID> is the Id of the user (e-mail address) that will be used as 'mail from'. 1st e-mail address in groups.txt (on the required row according to <GROUP_ID> has Id 0, 
2nd e-mail address has Id 1, ...

Example
```
$ cd RES/Labos/HEIGVD-RES-FEE-2018-Labo-SMTP/SMTPClient-build
$ java -jar out/artifacts/SMTPClient_build_jar/SMTPClient-build.jar 1 1 0
```


