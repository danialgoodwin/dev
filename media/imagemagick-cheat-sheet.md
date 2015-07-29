# ImageMagick #
(in-progress)


## How to get started with ImageMagick on Windows ##
1. Download [ImageMagick](http://imagemagick.org/). Choose a suitable version for your version of Windows. I chose the portable version (`ImageMagick-6.9.1-10-portable-Q16-x64.zip`) so that nothing had to be installed. (Note: Windows OS and ImageMagick both have a command for "convert.exe".)
2. Run a test to confirm that it works. Inside the folder you downloaded, there is a "convert.exe" and that is the main executable that you will be referencing when using ImageMagick. Run `./convert.exe -size 100x100 xc:#990000 sample.png`

You should now have a red sample PNG image in the directory you ran the command.



## Simple commands for creating/generating a new image ##

### Create a colored canvas ###

    // Numbers after the number sign is in format of "rgb" or "rrggbb" or "argb" or "aarrggbb" or more.
    ./convert.exe -size 100x100 xc:#990000 sample.png

### Create a transparent image ###

    // Transparent square that is 100 pixels wide and tall.
    ./convert.exe -size 100x100 xc:#00000000 sample.png

### Add text ###
TODO: [Read this](http://www.imagemagick.org/discourse-server/viewtopic.php?t=27366)

    ./convert.exe -size 1000x250 xc:black -fill yellow -pointsize 36 -gravity center -draw "text 0,0 'my text'" myoutput.png

- [More info](http://stackoverflow.com/questions/29523079/batch-create-images-from-text-file-with-irfanview)
- [More info](http://www.imagemagick.org/Usage/text/#caption)

### Add a border ###

    // Green border line on a transparent square background.
    ./convert.exe -size 100x100 -border 10 -bordercolor "#0f0" xc:#00000000 sample.png


###


## Manipulate existing images ##

### Resize ###

    // Resize images as they are read.
    convert '*.jpg[120x120]' thumbnail%03d.png
    
    // Read all images, then resize.
    convert '*.jpg' -resize 120x120 thumbnail%03d.png


###


## Image conversions ##

### JPEG to PNG ###

    // A separate image will be created.
    convert image.jpg image.png

###

## Use ImageMagick in bash script ##

    #!/bin/bash

    # Just pass the original .png image as the only parameter to this script.
    SOURCE="$1"
    BASE=`basename "${SOURCE}" .png`

    convert "${SOURCE}" -thumbnail 16x16 "${BASE}_16.png"
    convert "${SOURCE}" -thumbnail 32x32 "${BASE}_32.png"
    convert "${SOURCE}" -thumbnail 48x48 "${BASE}_48.png"
    convert "${SOURCE}" -thumbnail 64x64 "${BASE}_64.png"

    icotool -c -o "${BASE}.ico" "${BASE}"_{16,32,48,64}.png

    rm -f  "${BASE}"_{16,32,48,64}.png

[More info](http://superuser.com/questions/40623/icons-command-line-generator)

    for f in *.jpg; do
      convert ./"$f" ./"${f%.jpg}.pdf"
    done

[More info](http://unix.stackexchange.com/questions/29869/converting-multiple-image-files-from-jpeg-to-pdf-format)


## Further Resources ##
- ImageMagick docs: [Color](http://www.imagemagick.org/script/color.php)
- [Command line processing](http://www.imagemagick.org/script/command-line-processing.php)

## Other options ##
- [AndroidResizer](https://github.com/BlitzKraig/AndroidResizer)
- [AndroidAssetStudio](https://github.com/romannurik/AndroidAssetStudio)
- [AndroidAssetStudio - Generic Icon Generator](http://romannurik.github.io/AndroidAssetStudio/icons-generic.html)