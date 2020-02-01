# Roku TV Development Cheat Sheet

Quick links:
- [Roku OS release notes](https://developer.roku.com/en-gb/docs/developer-program/release-notes/roku-os-release-notes.md)
- [Channel certification criteria]
  - [Update for 2019-10](https://blog.roku.com/developer/channel-certification-criteria-updates-october-2019)
    - Now required to measure launch times, and to have a fully rendered home screen within 20 seconds
  - Update for 2020-04: For SVOD channels with over 10m hours of streamed video



# Workflow

## Setup

## Development

### Quick Reference

Sizes:

    sd  Applications designed for standard definition 720x480
    hd  Applications designed for high definition 1280x720
    fhd Applications designed for full high definition 1920x1080

Icon sizes:

    hd  png  336x210
    sd  png  248x140

Storage: https://developer.roku.com/docs/developer-program/getting-started/architecture/file-system.md

    theme.OverhangSliceSD = "pkg:/images/Overhang_Slice_SD43.png"
    http.Http.GetToFile("tmp:/categorylist")
    DeleteFile("tmp:/categorylist")
    obj.SetCertificatesFile("common:/certs/ca-bundle.crt")

Types:

    string 'literal
    roString 'object

Official Samples:
- https://github.com/rokudev/samples


### How to create a channel app using Direct Publisher
This is the simplest way to get started, the only 'code' being a JSON file to specify the feed. Create a MVP that allows for minimal customization.
https://developer.roku.com/docs/direct-publisher/getting-started.md

### How to create a screensaver app

Here are the minimal files and code required for a stand-alone screensaver app.

    pkg:/
        manifest
        components/
            MyScreenSaver.brs
            MyScreenSaver.xml
        images/
            my-channel-poster-hd.png
            my-channel-poster-sd.png
            my-splash-screen-hd.jpg
            my-splash-screen-sd.jpg
        source/
            main.brs
        
        
        
manifest:
- Must end with a newline
- Empty lines are ignored
- Line comments start with `#`
- More info: https://developer.roku.com/docs/developer-program/getting-started/architecture/channel-manifest.md

    #title=My Title
    screensaver_title=My Screen Saver
    major_version=1
    minor_version=1
    build_version=1
    
    #mm_icon_focus_hd=pkg:/images/my-channel-poster-hd.png
    #mm_icon_focus_sd=pkg:/images/my-channel-poster-sd.png
    #splash_screen_hd=pkg:/images/my-splash-screen-hd.jpg
    #splash_screen_sd=pkg:/images/my-splash-screen-sd.jpg

components/MyScreenSaver.brs:

    Function changeBackground() as Void
        m.count = (m.count + 1) % 4 'Number of images to cycle through
        m.MyBackground.uri = m.pictures[m.count]
    End Function
    
    Function init()
        m.count = 0
        
        m.pictures = []
        for i = 1 to 5
            m.pictures.push("pkg:/images/" + i.toStr() + ".jpg")
        end for
        
        m.MyBackground = m.top.findNode("MyBackground")
        m.MyBackground.uri = m.pictures[m.count]
        
        m.global.observeField("ChangeBackground", "changeBackground") 'Call changeBackground() each time ChangeBackground changes
    end Function

components/MyScreenSaver.xml:

    <?xml version="1.0" encoding="UTF-8" ?>
    <component name="MyScreenSaver" extends="Scene">
        <script type="text/brightscript" url="pkg:/components/MyScreenSaver.brs" />
        <children>
            <Poster id="MyBackground" width="1280" height="720" />
        </children>
    </component>

source/main.brs:

    sub RunScreenSaver()
        screen = CreateObject("roSGScreen")
        port = CreateObject("roMessagePort")
        screen.setMessagePort(port)
        
        m.global = screen.getGlobalNode()
        m.global.AddField("ChangeBackground", int, true)
        m.global.ChangeBackground = 0
        
        scene = screen.createScene("MyScreenSaver")
        screen.show()
        
        while (true)
            msg = wait(7000, port)
            if (msg <> invalid)
                msgType = type(msg)
                if msgType = "roSGScreenEvent"
                    if msg.isScreenClosed() then return
                end if
            else
                m.global.ChangeBackground += 1
            end if
        end while
    end sub

More info:
- Official documentation: https://developer.roku.com/docs/developer-program/media-playback/screensavers.md
- Old: https://blog.roku.com/developer/tutorial-screensavers
- Roku blog: https://blog.roku.com/developer/2016/07/06/tutorial-screensavers--

## Testing


## Debugging
See: https://developer.roku.com/docs/developer-program/debugging/debugging-channels.md

Create a remote debugger: https://developer.roku.com/en-gb/docs/developer-program/debugging/socket-based-debugger.md#sample-remote-debugger

## Deploying

Locally:
1. Open browser to URL of the Roku device, ex: 10.4.3.6
2. Upload ZIP of files

Publically:
1. Publishing guide: https://developer.roku.com/docs/developer-program/publishing/channel-publishing-guide.md
2. Upload channel package to https://developer.roku.com/developer-channels/channels

To see the public app sooner: Settings > System > System Updates > Check Now

More info:
- https://developer.roku.com/docs/developer-program/publishing/packaging-channels.md



# SceneGraph Reference

    <?xml version="1.0" encoding="UTF-8" ?>
    <component name="MyComponent" extends="Scene">
        <script type="text/brightscript" uri="pkg:/components/MyScene.brs" />
        
        <children>
            <Label />
            <Poster id="myPoster" width="1920" height="1080" />
            <Rectangle id="myRectangle" color="0xFF0000" width="500" height="200" translation="[600, 300]" />

            <Animation id="myAnimation" repeat="false" duration="4" easeFunction="linear|inQuad">
                <FloatFieldInterpolator id="myInterpolator" key="[0.0,0.25,0.75,1.0]" KeyValue="[0.0,0.25,0.75,1.0]" fieldToInterp="myRectangle.opacity" />
            </Animation>
        </children>
    </component>

Common components:
- Label (and SimpleLabel for one-line) (similar to TextView in Android): https://developer.roku.com/docs/references/scenegraph/renderable-nodes/label.md

        <Label
          id="myLabel"
          height="44"
          width="0"
          font="font:MediumBoldSystemFont"
          text = "My Label Text!"
          horizAlign = "left"
          vertAlign = "center"
          translation="[318,8]" />

    - Available system fonts: https://developer.roku.com/docs/references/scenegraph/typographic-nodes/overview.md
- Poster (similar to ImageView in Android): https://developer.roku.com/docs/references/scenegraph/renderable-nodes/poster.md

        <Poster
          id="myPoster"
          uri="pkg:/images/myPosterImage.png"
          width="0.0"
          height="0.0"
          translation="[160,8]"
          loadDisplayMode="scaleToZoom" />

- Rectangle (similar to using a background color): https://developer.roku.com/docs/references/scenegraph/renderable-nodes/rectangle.md

        <Rectangle
          id="myRectangle"
          color="0x880088FF"
          width="1280"
          height="60"
          translation="[0,0]" />

- Storage: https://developer.roku.com/docs/developer-program/getting-started/architecture/file-system.md

# BrightScript Reference

BrightScript is not case sensitive.


Variables: (https://developer.roku.com/docs/references/brightscript/language/expressions-variables-types.md)

    a = 42
    
    'Array/roArray
    Dim array[5]
    array = CreateObject("roArray", 6, true)
    a2 = []
    a2.push("MyValue")
    a3 = [x + 1, true, 1 <> 2, ["a", "b"]]
    
    'Map/Dict/'Associative Array'
    aa = { }
    aa = { key1: "value1", key2: 42, "key 3 with spaces": 1 + 2 }

Flow:

    For i = 10 To 1 Step -1
        print i
    End For
    
    For Each myElement in myArray
        print myElement
    End For
    
    While true
        print ""
    end While

Global utility functions, aka standard library:

    'More info: https://developer.roku.com/docs/references/brightscript/language/global-utility-functions.md#parsejsonjsonstring-as-string-as-object
    ParseJson(jsonString as String) as Object

    sleep(milliseconds as Integer)
    Wait(milliseconds as Integer, MessagePostInterface)
    
    'Files
    ListDir(path as String) 'Ex: `ListDir("pkg:/movies")`
    ReadAsciiFile(filepath as String) as String 'Ex: `ReadAsciiFile("tmp:/config.txt")`
    WriteAsciiFile(filepath as String, text as String) as Boolean
    CopyFile(source as String, destination as String) as Boolean
    MoveFile(source as String, destination as String) as Boolean
    DeleteFile(file as String) as Boolean
    DeleteDirectory(dir as String) as Boolean
    CreateDirectory(dir as String) as Boolean
    
    'More info: https://developer.roku.com/docs/references/brightscript/language/global-utility-functions.md#matchfilespath-as-string-pattern_in-as-string-as-object
    MatchFiles(path as String, pattern_in as String) as Object/List/`roList` 'Ex: `MatchFiles(".", "*.jpg")`

More:
- Reference Overview: https://developer.roku.com/docs/references/references-overview.md
- Variables may end with an optional type designator character ($ for string, % for integer, ! for float, # for double)
- `Function` vs `Sub`: `Sub`s are `Function`s that return Void
- String functions: https://developer.roku.com/docs/references/brightscript/language/global-string-functions.md
- Math functions: https://developer.roku.com/docs/references/brightscript/language/global-math-functions.md

# More Resources

Learn:
- https://github.com/learnroku/crash-course
- Monetezation: https://blog.roku.com/developer/direct-publisher-monetization

Open-source apps to maybe look into more:
- Play random Netflix episodes: https://github.com/justinkunz/RokuAndNetflix (24 stars on 2019-10-30)
- NPR's Tiny Desk Concerts: https://github.com/nprapps/roku-tinydesk (30 stars on 2019-10-30)

Open-source projects to maybe look into more:
- Control Roku via Python: https://github.com/jcarbaugh/python-roku (153 stars on 2019-10-30)
- Development helper (Ruby): https://github.com/ViacomInc/roku_builder (30 stars on 2019-10-30)
- Starter framework: https://github.com/mrkjffrsn/RokuFramework (22 stars on 2019-10-30)
- Build tool, supporting build flavors: https://github.com/willowtreeapps/ukor (36 stars on 2019-10-30)
- Roku Package Manager: https://github.com/code-vicar/rpm (7 stars on 2019-10-30)

- Unofficial Twitch app: https://github.com/FrozenIronSoftware/Twitched (17 stars on 2019-10-30, no longer maintained, last updated on 2019-07-10)
- Utilities: https://github.com/dphang/roku-lib (41 stars on 2019-10-30, last updated on 2016-04-04)
- Starter channel: https://github.com/jordanmueller/roku_channel (30 stars on 2019-10-30, last updated on 2015-11-17)
- Roku API wrapper (Node): https://github.com/TheThingSystem/node-roku (25 stars on 2019-10-30, last updated on 2013-11-15)
- Screensaver: https://github.com/BenjaminAdams/roku-screensaver (14 stars on 2019-10-30. last updated on 2013-07-16)
- Browser: https://github.com/aaron-santos/roku-oversight (5 stars on 2019-10-30, last updated on 2013-01-17)

Open-source games on Roku?:
- Prince of Persia: https://github.com/lvcabral/Prince-of-Persia-Roku (50 stars on 2019-10-30)
- Lode Runner: https://github.com/lvcabral/Lode-Runner-Roku
- Moon Patrol: https://github.com/lvcabral/Moon-Patrol-Roku
- Space shooter: https://github.com/lvcabral/retaliate-roku

Cast to Roku from Chrome:
- https://github.com/pranav-prakash/RokuCast/
- https://github.com/dgreuel/RokuKast




# Ideas

General:
- Use popular Amazon Echo/Show apps as inspiration for Roku apps

Screen saver:
- Time + background that matches the weather/sun in that device's location (or chanage in settings)

- https://random-ize.com/random-art-gallery/
- https://channelstore.roku.com/en-gb/details/554990/winter-screensaver
- https://channelstore.roku.com/en-gb/details/556106/word-of-the-hour
- 


# Dan-TODO
Go through and double-check these resources:
- https://github.com/sumitk/librokudev
- https://github.com/juliomalves/roku-libs
- https://github.com/learnroku/crash-course
- https://github.com/search?p=10&q=roku&type=Repositories (I've been through 10 pages, but can go through more)
- https://bitbucket.org/jesstech/roku-youtube/src/master/

- https://developer.roku.com/en-gb/docs/references/brightscript/language/program-statements.md#functionparameter--default-as-type--as-type--end-function
- https://community.roku.com/t5/Roku-Developer-Program/Dynamic-animation/td-p/421255
- https://blog.roku.com/developer/2012/08/09/getting-started-with-brightscript-screen-navigation
- https://developer.roku.com/en-gb/docs/developer-program/getting-started/architecture/dev-environment.md

- https://stackoverflow.com/questions/39123573/how-to-develop-a-custom-keyboard-in-brightscript
- https://stackoverflow.com/questions/45285806/programmatically-upload-roku-channel-without-eclipse-plugin
- https://stackoverflow.com/questions/22021954/how-do-i-open-another-channel-from-one-channel-in-roku
- https://stackoverflow.com/questions/44467750/creating-a-page-for-date-entry-for-roku
- https://stackoverflow.com/questions/32753953/find-date-difference-in-brightscript
- https://stackoverflow.com/questions/19113832/call-function-from-another-file-in-brightscript
- https://stackoverflow.com/questions/44289814/how-to-move-focus-between-a-keyboard-and-button-group-on-a-screen
- https://stackoverflow.com/questions/9431148/how-to-make-api-request-to-some-server-in-roku
- 

