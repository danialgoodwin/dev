# Git Cheat Sheet - Intermediate



## Snippets

### How to create a GitHub-hosted website
Basically, create a branch with the exact name `gh-pages`, then push it to GitHub. Include an `index.html` and maybe some CSS and Javascript. But, server-side processing is not available, so no PHP, Ruby, Python, etc. It may take up to 10 minutes for the site to first be available.

Jekyll is a good simple static site generator, good for blogs too.

    git checkout -b gh-pages
    git push origin gh-pages

### How to create a new empty branch
So, this empty branch will have a clean commit history.

    git checkout --orphan gh-pages

### How to delete a remote branch

    git push origin :gh-pages

###  ###

###  ###

###  ###

###  ###
