# SED Cheat Sheet

sed: stream editor

    # Simple replace (once on line)
    sed -e 's/old/new/' my-file.txt
    
    # Add 'g' for 'global', meaning replace for the entire line rather than just the first occurrence
    sed -e 's/old/new/g' my-file.txt
    
    # Add '-i' to edit in-place
    sed -i -e 's/old/new/' my-file.txt
    sed -ie 's/old/new/' my-file.txt
    






