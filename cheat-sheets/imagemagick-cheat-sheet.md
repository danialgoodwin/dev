# ImageMagick Cheat Sheet

## Basics

    # Create image (`xc` same as `canvas`, size must go before canvas)
    magick convert -size 512x512 xc: image_512x512.png
    magick convert -size 512x512 canvas:black image-black_512x512.png
    magick convert -size 512x512 canvas:#7F00 image-red-tint_512x512.png
    magick convert canvas:lime[512x512!] lime.png
    
    # Create image with text (https://imagemagick.org/Usage/text/)
    magick convert -pointsize 72 -size 640x480 -background lightblue -fill blue -gravity south label:My-Image test-image.png
    # Automatically use best font size to fit canvas size
    magick convert -size 640x480 label:'My\nImage\n2' test-image-2.png
    
    # Resize an image (https://imagemagick.org/Usage/resize/)
    ## Resize images as they are read:
    magick convert '*.jpg[120x120]' thumbnail%03d.png
    ## Read all images, then resize:
    magick convert '*.jpg' -resize 120x120 thumbnail%03d.png
    
    
    # Get image details/meta-data
    magick identify my-image.png
    
    # Add a border
    magick convert -size 100x100 -border 10 -bordercolor "#0f0" xc:#000 sample.png

## Snippets

### Create a pattern

    magick -size 640x480 pattern:checkerboard checkerboard.png

More built-in patterns: https://imagemagick.org/script/formats.php#builtin-patterns

### Resize

    # Keep the same aspect ratio (at least one dimension will match below)
    magick '*.jpg' -resize 120x120 thumbnail%03d.png
    
    # Faster and less resource intensive to resize each image as it is read:
    magick '*.jpg[120x120]' thumbnail%03d.png
    
    # Use `!` to force dimensions
    magick '*.jpg[120x120!]' thumbnail%03d.png
    magick logo: -resize '100x200!' my-image_100x200.png
    
## Rename

    # Output: rose-70x46.png
    magick rose: -set filename:area '%wx%h' 'rose-%[filename:area].png'

## Use ImageMagick in bash script

Create an ico

    #!/bin/bash
    # Source: http://superuser.com/questions/40623/icons-command-line-generator

    # Just pass the original .png image as the only parameter to this script.
    SOURCE="$1"
    BASE=`basename "${SOURCE}" .png`

    magick convert "${SOURCE}" -thumbnail 16x16 "${BASE}_16.png"
    magick convert "${SOURCE}" -thumbnail 32x32 "${BASE}_32.png"
    magick convert "${SOURCE}" -thumbnail 48x48 "${BASE}_48.png"
    magick convert "${SOURCE}" -thumbnail 64x64 "${BASE}_64.png"

    icotool -c -o "${BASE}.ico" "${BASE}"_{16,32,48,64}.png

    rm -f  "${BASE}"_{16,32,48,64}.png

    # Convert all JPGs in current directory to PDFs
    # Source: http://unix.stackexchange.com/questions/29869/converting-multiple-image-files-from-jpeg-to-pdf-format
    for f in *.jpg; do
      convert ./"$f" ./"${f%.jpg}.pdf"
    done



# More Info

- ImageMagick docs: [Color](http://www.imagemagick.org/script/color.php)
- [Command line processing](http://www.imagemagick.org/script/command-line-processing.php)
- [ImageMagick Recipes](http://blog.megafaunasoft.com/2012/09/imagemagick-recipes.html)

About text in images:
- http://www.imagemagick.org/discourse-server/viewtopic.php?t=27366
- http://stackoverflow.com/questions/29523079/batch-create-images-from-text-file-with-irfanview


