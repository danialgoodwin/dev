# JavaFX Cheat Sheet #
(Very much a work-in-progress. Still experimenting in the projects.)


## Questions I've had to answer ##

### How to automatically resize pane to contain all content

    mStage.sizeToScene();



## Deploying ##

### Via command line
More info: [https://docs.oracle.com/javafx/2/deployment/packager.htm](https://docs.oracle.com/javafx/2/deployment/packager.htm)

    javafxpackager -makeall -appclass colorfulcircles.ColorfulCircles 
        -name "Colorful Circles" -width 800 -height 600

Note for using this method:
- Stage width and height must be specified for applications embedded in the browser.
- `-createjar` and `-deploy` commands have more options than `-makeall`.





## Snippets
- [Popup Menu](http://www.javacodegeeks.com/2012/02/popupmenu-in-javafx-2.html)
- [How to load image](http://www.javacodegeeks.com/2013/10/javafx-2-how-to-load-image.html)


## Further Resources ##
- Great: [http://www.slideshare.net/steveonjava/java-fx-20-a-developers-guide](http://www.slideshare.net/steveonjava/java-fx-20-a-developers-guide)
- Good for getting started on IntelliJ: [https://www.jetbrains.com/idea/help/developing-a-javafx-hello-world-application-coding-examples.html](https://www.jetbrains.com/idea/help/developing-a-javafx-hello-world-application-coding-examples.html)
