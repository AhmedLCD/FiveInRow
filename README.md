# FiveInRow
API swagger : https://piskvorky.jobs.cz/api/doc
API test cases :
.

Test case 1 :POST create user /user endpoint.
Priority : High

description : create user and get userToken to connect to a game.

Test case 2 : POST connect to game /connect endpoint.
Priority : High

description : connect to create a game to play

Test case 3 : POST play a game /play /login.
Priority : medium

description : play a game the API will try for 2 Min 30 seconds times to get 201 respons for 410 or 406 that mean the game bot has a bug.

RUN and CI/CD :
Locally :
prerequisite

JAVA jdk 11 or above installed in the system
Maven 3.8.0 or above installed in the system (used maven 3.8.6)
optional intellij IDE
Run from command line

clone project to local environment : git clone https://github.com/AhmedAlaaPhil/FiveInRow.git
navigate to project directory
open cmd in the project directory
write mvn test and press enter
Run from intellij IDE

open project in intellij ID
run testng.xml file
CI/CD :
I am using CircleCI for CI/CD

The Pipline has two stages:

Build
Test CircleCI Pipline
