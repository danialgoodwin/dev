# Polymer Cheat Sheet - Getting Started Basics #
Most of this information is from the [official quickstart](https://www.polymer-project.org/docs/start/creatingelements.html). The difference is that this shorter guide has many deletions and just a few additions.



## Getting Started For The First Time ##
This is a quick walkthrough for how to get started with Polymer from scratch.

1. Install Polymer: You can do this a few different ways, but the easiest is with Bower, which is a package and dependency manager for many web libraries. So, [install Bower](http://bower.io/) if you don't already have it.
2. In the root of your project, run `bower init`. You can just press Enter if you don't know what to do yet. This initialization just produces a `bower.json` file, which has settings that can easily be changed later.
3. Install Polymer for the project by running `bower install --save Polymer/polymer`. This will create and fill a new directory `bower_components` with Polymer and its dependencies. Using `--save` will update the `bower.json` file by listing Polymer as a dependency. (Sidenote: To update the components in bower_components, just run `bower update`.)

Now, you can use Polymer in your project. See the section on [How To Create A Polyment Element] for a quick walkthrough on getting a simple app working.



## How To Create A Polymer Element ##
In this quick walkthrough, you'll create a simple polymer element called "my-element".

1. Create a new file called `my-element.html` and add the following code. Make sure the import is pointing to the valid location within the bower_components directory.

        <link rel="import" href="../bower_components/polymer/polymer.html">
        
        <polymer-element name="my-element" noscript>
          <template>
            <span>Hello from <b>my-element</b>. This is my Shadow DOM.</span>
          </template>
        </polymer-element>

2. Use your element in `index.html`. Here's a minimal example. Note: The above `my-elements.html` was put in an `elements` directory for some organization.

        <!DOCTYPE html>
        <html>
          <head>
            <!-- 1. Load platform support before any code that touches the DOM. -->
            <script src="bower_components/webcomponentsjs/webcomponents.min.js"></script>
            <!-- 2. Load the component using an HTML Import -->
            <link rel="import" href="elements/my-element.html">
          </head>
          <body>
            <!-- 3. Declare the element by its tag. -->
            <my-element></my-element>
          </body>
        </html>

3. Run the app from a web server so that the [HTML Imports](https://www.polymer-project.org/platform/html-imports.html) work correctly.

Notes about Polymer elements:

- The name of the element must have at least one dash `-` in it. (Reason: It's part of the web component spec as to not interfere with official HTML tags.)
- The `noscript` attribute used in the above sample code indicates that it's a simple element with no script, which allows it to be registered automatically.



## How To Reuse Other Elements ##

Find some elements with bower by running `bower search Polymer`.

1. Install the element for the project/app, for example:

        bower install Polymer/core-ajax

2. Use that element in your layout or custom element. An import statement must also be included, for example:

        <link rel="import" href="../bower_components/polymer/polymer.html">
        <link rel="import" href="../bower_components/core-ajax/core-ajax.html">
        
        <polymer-element name="my-element" noscript>
          <template>
            <span>I'm <b>my-element</b>. This is my Shadow DOM.</span>
            <core-ajax url="http://example.com/json" auto response="{{resp}}"></core-ajax>
            <textarea value="{{resp}}"></textarea>
          </template>
        </polymer-element>

3. Run the project and enjoy how easy it is to create modular web apps and site now. If you don't see anything on the page, then make sure that all your imports are pointing to the correct place.

The best way I've found to learn about using new elements is to see the demos and look at the source code for the ones that you like.



## Further Resources ##
- [Official getting started walkthrough](https://www.polymer-project.org/docs/start/tutorial/intro.html)
- [Official quickstart](https://www.polymer-project.org/docs/start/creatingelements.html)
