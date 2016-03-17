# Nginx Cheat Sheet
(Pronounced "engine-x")



## Defaults

- Important server config files are located in `/etc/nginx/nginx.conf`, `/etc/nginx/sites-avialable/`, `/etc/nginx/sites-enabled/`
- By default, config points to public website files to be located at ` `, though many times moved to `/var/www/<site-domain>/html/`.



## Simple Snippets
- Restart server by running, `sudo service nginx restart` (may also be found at `/etc/init.d/nginx restart`)
- Or, run `nginx -s reload`


### How to SSH into server
This quick walkthough first explains how to add SSH public key to server so that you can log in without a password. After that is the simple `ssh` command.

For Linux/Mac:

    ssh-id-copy myusername@123.123.123.123

For Windows, using git-bash (or similar):

    // Not exactly this yet... Basically, paste contents of SSH pub to the other file on server from your home directory.
    scp C:\User\MyUserName\.ssh\.ssh_id.pub ~/MyUserName/.ssh/authorized_ids

Now, you can log in without a password

    ssh myusername@123.123.123.123



## Sample config file

    server {
        server_name blog.example.com;
        return 301 $scheme://example.com/blog$request_uri;
    }
    server {
        listen 80;
        listen [::]:80;
        listen 443 ssl;
        root /var/www/example.com/html;
        index index.php index.html;
        server_name example.com www.example.com;
        ssl_certificate /var/www/example.com/ssl/cert.pem;
        ssl_certificate_key /var/www/example.com/ssl/key.pem;
        location / {
            try_files $uri $uri/ =404;
        }
        location /custom {
            return 302 https://123.555.123.0:81;
        }
    }



## More Info
-
