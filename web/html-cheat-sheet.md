# HTML Cheat Sheet



## Caching

No cache: `<meta http-equiv="Cache-Control" content="no-cache">`



## Printing
Use a width of 800px to print on US sheet of paper. Note: Need a reference for this, so don't rely on this.



## Tag

### abbr
Annotate an acronym. Ex: `<abbr title="Domain Name Service">DNS</abbr>`

### form
Note: This example is old and can be improved.

    <form name="application" method="post" action="mailto:user@isp-abc.net?SUBJECT=formtest" enctype="text/plain">
        Please enter your full name: <input type="text" size="20" maxlength="30" name="Your_name"><br>
        Please enter your phone number: <input type="text" size="12" maxlength="12" name="Your_phone"><br>
        <input type="submit" name="submit" value=" Submit By E-Mail ">
        <input type="reset" name="reset" value=" Clear Form ">
    </form>



## HTML5 App

    <!DOCTYPE html>
    <html manifest="myapp.manifest">
      <head>
        <meta name="viewport" content="user-scalable=no, width=device-width" />
      </head>
      ...
    </html>



## More Info
- [Original HTML tags](http://www.w3.org/History/19921103-hypertext/hypertext/WWW/MarkUp/Tags.html): title, nextid (obsolete), a (w/attributes: href, name, type), isindex, plaintext, listing, p, h1, h2, h3, h4, h5, h6, address, hp1 (not used), hp2 (not used), dl, dt, dd, ul, li,
- The difference between `<em>` (emphasis) and `<i>` (italics):
    - In a visual medium, browsers show these tags the same, italicized
    - In an audio medium, `<em>` contains more semantic meaning
