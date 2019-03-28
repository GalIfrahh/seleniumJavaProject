# seleniumJavaProject
web automation using java & Junit + maven + slack integration for uploading screenshots during the Jenkins build to slack channel.


#the project based on pageObjects concept:

The pageObjects concept

PageObject is a design pattern used to:

Simplify the way we identify and maintain the UI of the application we are testing
Write readable code that will be easy to other developers to understand and use
You can see many approaches to using PageObject. this one is mine:

First of all we will create a class called a GenericPageObject. this class will contain an instance of the webDriver/RemoteWebDriver (Which I like to put in a wrapping class , usually called webDriverWrapper)

# i added salck integration for allerting the build status to slack channel & for sending screen shots during tests to slack as well. 
