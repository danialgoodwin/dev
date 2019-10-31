# Roku TV Development Cheat Sheet


# Workflow

## Setup

## Development

### Quick Reference

Sizes:

    sd  Applications designed for standard definition 720x480
    hd  Applications designed for high definition 1280x720
    fhd Applications designed for full high definition 1920x1080

Storage: https://developer.roku.com/docs/developer-program/getting-started/architecture/file-system.md

    theme.OverhangSliceSD = "pkg:/images/Overhang_Slice_SD43.png"
    http.Http.GetToFile("tmp:/categorylist")
    DeleteFile("tmp:/categorylist")
    obj.SetCertificatesFile("common:/certs/ca-bundle.crt")

Official Samples:
- https://github.com/rokudev/samples


### How to create a channel app using Direct Publisher
This is the simplest way to get started, the only 'code' being a JSON file to specify the feed. Create a MVP that allows for minimal customization.
https://developer.roku.com/docs/direct-publisher/getting-started.md

### How to create a screensaver app using code

Here are the minimal files and code required for a stand-alone screensaver app.

    /
        manifest
        images/
            my-channel-poster-hd.png
            my-channel-poster-sd.png
            my-splash-screen-hd.jpg
            my-splash-screen-sd.jpg
        
        
manifest:
- Must end with a newline
- Empty lines are ignored
- Line comments start with `#`
- More info: https://developer.roku.com/docs/developer-program/getting-started/architecture/channel-manifest.md

    #title=My Title
    screensaver_title=My Screensaver
    major_version=1
    minor_version=1
    build_version=1
    
    #mm_icon_focus_hd=pkg:/images/my-channel-poster-hd.png
    #mm_icon_focus_sd=pkg:/images/my-channel-poster-sd.png
    #splash_screen_hd=pkg:/images/my-splash-screen-hd.jpg
    #splash_screen_sd=pkg:/images/my-splash-screen-sd.jpg

Brightscript file:

    RunScreenSaver()
        roScreen
        roImageCanvas

More info: https://developer.roku.com/docs/developer-program/media-playback/screensavers.md


## Testing


## Debugging




## More Resources

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




