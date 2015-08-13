# Chrome Extensions Cheat Sheet #



## Quick walkthrough ##

### How to create a "Hello World" Chrome extension ###

1. Create a new folder called `my-chrome-project` (arbitrary name)
2. In that folder, create a file strictly called `manifest.json`. This is the minimum required file. Add the following code to the file:

        {
          "name": "Hello World",
          "version": "1.0",
          "description": "My first Chrome extension.",
          "manifest_version": 2,
          "browser_action": {
            "default_icon": "my-icon.png",
            "default_popup": "my-popup.html"
          }
        }

3. In the same folder, create and add a 48x48 PNG called `my-icon.png`.
4. In the same folder, create a file called `my-popup.html` and type "Hello World" in the file.
5. All the code is now done for the "hello world" project. Now, open Chrome and type `chrome://extensions` into the omnibar.
6. On the Extensions page that appears, enable "Developer mode".
7. Click "Load unpacked extension..." and navigate to the folder that was created on step one.

Congrats! You have created your first Chrome extension. The icon.png button should appear at the top-right, and when clicked will show the popup.html. Share this straightforward walkthrough if you found it useful. :)

(The code for this project can be found in "./practice-hello-world/")

### How to retrieve image based on current tab's URL ###
Check out the project at "./practice-image-search/".



## Further Resources ##
- [Official Chrome Extensions developer site](https://developer.chrome.com/extensions/)
- [Official Dev Guide](https://developer.chrome.com/extensions/devguide)
- [Samples](https://developer.chrome.com/extensions/samples)
  - [Commands extension: get notified of hotkeys](https://developer.chrome.com/extensions/examples/api/commands.zip)
  - [Broken links](https://developer.chrome.com/extensions/examples/api/devtools/audits/broken-links.zip)
  - [Download selected links](https://developer.chrome.com/extensions/examples/api/downloads/download_links.zip)
  - [Downloads overwrite existing files](https://developer.chrome.com/extensions/examples/api/downloads/downloads_overwrite.zip)
  - [Typed URL history](https://developer.chrome.com/extensions/examples/api/history/showHistory.zip)
  - [Test IME: convert all keystrokes to uppercase](https://developer.chrome.com/extensions/examples/api/input.ime/basic.zip)
  - [Omnibox example: special search terms](https://developer.chrome.com/extensions/examples/api/omnibox/simple-example.zip)
  - [Desktop notification demo](https://developer.chrome.com/extensions/examples/api/notifications.zip)
  - Override new tab page: [Blank](https://developer.chrome.com/extensions/examples/api/override/blank_ntp.zip), [iGoogle](https://developer.chrome.com/extensions/examples/api/override/override_igoogle.zip)
  - [Keyboard pin: hotkeys to toggle pinned state of current tab](https://developer.chrome.com/extensions/examples/api/tabs/pin.zip)
  - [Calculator](https://developer.chrome.com/extensions/examples/apps/calculator/app.zip)
  - [Chromium source code search](https://developer.chrome.com/extensions/examples/extensions/chrome_search.zip)
- Great, but old (deprecated): [How to build a chrome extension](http://lifehacker.com/5857721/how-to-build-a-chrome-extension)
- [Provide users options to customize the extension](https://developer.chrome.com/extensions/optionsV2)
- [Extensionizr: Chrome extension boilerplate generator](http://extensionizr.com)
- [Chrome Web Store](https://chrome.google.com/webstore/category/extensions)
- [Developer Dashboard](https://chrome.google.com/webstore/developer/dashboard)
- [Google Chrome Extensions: Technical videos playlist](https://www.youtube.com/view_play_list?p=CA101D6A85FE9D4B) (TODO: Watch all)

- [Inline installation](https://developer.chrome.com/webstore/inline_installation)
- [manifest.json](https://developer.chrome.com/extensions/manifest)
- [Add analytics](https://developer.chrome.com/apps/analytics)
