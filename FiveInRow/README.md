# **This repo contains tests for API**
### API swagger : https://piskvorky.jobs.cz/api/doc
 

## **API test cases** :
 .
 
 
### **Test case 1** :POST create user /user endpoint.
 
**Priority** :  High
 
**description** : create user and get userToken to connect to a game.
 
### **Test case 2** : POST connect to game /connect endpoint.
 
**Priority** :  High
 
**description** : connect to create a game to play
 
 
### **Test case 3** : POST  play a game /play /login.
 
**Priority** :  medium
 
**description** : play a game the API will try for 2 Min 30 seconds times to get 201 respons for 410 or 406 that mean the game bot has a bug.
 
 
## **RUN and CI/CD** :
 
## **Locally :**
 
**prerequisite**
1. JAVA jdk 11 or above installed in the system
2. Maven 3.8.0 or above installed in the system (used maven 3.8.6)
3. optional intellij IDE
 
**Run from command line**
1. clone project to local environment : git clone https://github.com/AhmedAlaaPhil/FiveInRow.git
2. navigate to project directory
3. open cmd in the project directory
4. write **mvn test** and press enter
 
**Run from intellij IDE**
1. open project in intellij ID
2. run testng.xml file
 
 
## **CI/CD :**
 
I am using CircleCI for CI/CD

The Pipline has two stages:
1. Build 
2. Test 
[CircleCI Pipline](https://app.circleci.com/pipelines/github/AhmedAlaaPhil/FiveInRow)

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

