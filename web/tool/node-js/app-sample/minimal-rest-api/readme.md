# How to create a minimal simple REST API with Node and Express

In package.json:

    {
      "name": "minimal-rest-api",
      "version": "0.0.1",
      "dependencies": {
        "body-parser": "^1.14.2",
        "express": "^4.13.3"
      }
    }

In app.js:

    var express = require("express");
    var bodyParser = require("body-parser");
    var app = express();

    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: true }));

    var routes = require("./routes/routes.js")(app);

    var server = app.listen(3000, function () {
      console.log("Listening on port %s...", server.address().port);
    });

In routes/routes.js:

    var appRouter = function(app) {
      app.get("/", function(req, res) {
          res.send("Hello, World!");
      });
      app.get("/account", function(req, res) {
          var accountMock = {
              "username": "dan",
              "password": "1234",
              "twitter": "@dan"
          }
          if(!req.query.username) {
              return res.send({"status": "error", "message": "missing username"});
          } else if(req.query.username != accountMock.username) {
              return res.send({"status": "error", "message": "wrong username"});
          } else {
              return res.send(accountMock);
          }
      });
      app.post("/account", function(req, res) {
          if(!req.body.username || !req.body.password) {
              return res.send({"status": "error", "message": "missing a parameter"});
          } else {
              return res.send(req.body);
          }
      });
    }

    module.exports = appRouter;

0. Install Node and npm.
1. Run `npm install`. This will make the dependencies available to use.
2. Run `node app.js`. This will make the site available at localhost:3000 and localhost:3000/account.


[Source and more info](https://blog.nraboy.com/2015/10/create-a-simple-restful-api-with-node-js/)
