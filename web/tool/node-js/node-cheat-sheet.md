# Node JS Cheat Sheet
Use Node to build scalable web apps, using JavaScript on the server-side.

- `npm` is the package manager for node.
  - By default, npm installs to the local directory `./node_modules/`. Use the `-g` command to install to the global directory `{prefix}/lib/node_modules/`. Ex: `npm install -g bower`.



## How to install Node and npm



## Simple Sample Projects
Each of these assume that Node and npm have already been installed.

### How to create a minimal Node server

1. Create a file 'server.js'.

    var http = require("http");

    http.createServer(function(request, response) {
      response.writeHead(200, {"Content-Type": "type/plain"});
      response.write("Hello, World!!");
      response.end();
    }).listen(3000);

2. Run `node server.js`
3. See it on [http://localhost:3000](http://localhost:3000)


### How to create a minimal Node blog

In package.json:

    {
      "name": "blog",
      "version": "0.0.1",
      "description": "My minimal blog",
      "dependencies": {
        "mime": "~1.2.7"
      }
    }

In server.js:

    var http = require("http");
    var fs = require("fs"); // File-system
    var path = require("path"); // File paths
    var mime = require("mime"); // MIME types

    function send404(response) {
      response.writeHead(404, {"Content-type": "text/plain"});
      response.write("Error 404: resource not found");
      response.end();
    }

    function sendPage(response, filePath, fileContents) {
      response.writeHead(200, {"Content-type": mime.lookup(path.basename(filePath))});
      response.end(fileContents);
    }

    function serverWorking(response, absPath) {
      fs.exists(absPath, function(exists) {
        if (exists) {
          fs.readFile(absPath, function(err, data) {
            if (err) {
              send404(response)
            } else {
              sendPage(response, absPath, data);
            }
          });
        } else {
          send404(response);
        }
      });
    }

    var server = http.createServer(function(request, response) {
      var filePath = false;

      if (request.url == '/') {
        filePath = "public/index.html";
      } else {
        filePath = "public" + request.url;
      }

      var absPath = "./" + filePath;
      serverWorking(response, absPath);
    }).listen(3000);

In public/index.html:

    <!DOCTYPE html>
    <html>
    <head>
        <title>Blog</title>
    </head>
    <body>
        <div id="header">
            <span>My Simple Blog</span>
            <ul id="menu">
                <li>ABOUT</li>
                <li>ARTICLES</li>
                <li>VIDEOS</li>
                <li>SUBSCRIBE</li>
            </ul>
        </div>
        <div id="content">
            <h2><a href="random-post.html">JavaScript UI libraries comparison</a></h2>
            <p>It seems to be pretty easy to create a good-looking web page. Even your neighbor has one or two of them. It's for sure! For approximately two decades of World Wide Web existence hordes of web developers are trying to improve the way of how you interact with the Global Network. And how it interacts with you through different technologies such as JavaScript, for example... <a class="article" href="ui_libraries_comparison.html">Read more</a></p>
            <h2><a href="">Node.js for beginners. Building your own web server</a></h2>
            <p>We will use Node.js for our project. Node.js is an open source, cross-platform runtime environment, which allows you to build server-side and networking applications. It's written in JavaScript and can be run within the Node.js runtime on any platform. First of all, of course, you need to install it... <a class="article" href="hode.html">Read more</a></p>
        </div>
    </body>
    </html>

1. Run `npm install`. This will make the mime dependency available.
2. Run `node server.js`. This will make the site available.

More info and how to deploy this to Heroku: [Node.js For Beginners. Deploy Your Blog to Heroku](http://howtonode.org/deploy-blog-to-heroku)


### [How to create a minimal simple Node server with Express](https://github.com/danialgoodwin/dev/tree/master/web/tool/node-js/app-sample/minimal-node-express-server)




## More Info


### TODO: Eventually Read
- http://howtonode.org/coding-challenges-with-streams
