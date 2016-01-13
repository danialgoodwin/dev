# How to create a minimal Node server using Express

In app.js:

    var express = require('express');

    var app = express();

    app.get('/', function(req, res) {
        res.send('Hello World');
    });

    app.listen(3000);

In package.json:

    {
      "name": "minimal-node-express-server",
      "version": "0.0.0",
      "dependencies": {
        "express": "~4.13.1"
      }
    }

0. Install Node and npm.
1. Run `npm install`. This will install the Express package for the project directory.
2. Run `node app.js`. This will make the site available at localhost:3000.
