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

# More Info

