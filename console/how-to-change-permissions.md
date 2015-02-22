# How to change permissions #

## List files and permissions, size, date created

    ls -la

## Change group-level permissions

    sudo chmod g+rwx TheGroupName // g = group // + = add // r = read permission // w = write permission // x = execute permission
    sudo chmod g+w .

## Change group-level access
Format: [sudo] chgrp GROUP_NAME LOCATION

    sudo chgrp webdev TheGroupName
    sudo chgrp webdev2 .

## Change owner-level access

    sudo chown webdev .

## How To Add / Change User Groups
More info: http://freshtutorial.com/add-users-groups-change-password-linux-terminal/

## How To Create A File To Test Access
vim test.txt
