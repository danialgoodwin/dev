# How to create a minimal Node server

0. Install Node.
1. Create file 'server.js':

    var http = require("http");

    http.createServer(function(request, response) {
      response.writeHead(200, {"Content-Type": "type/plain"});
      response.write("It's alive!");
      response.end();
    }).listen(3000);

2. Run `node server.js`
3. See it on [http://localhost:3000](http://localhost:3000)
