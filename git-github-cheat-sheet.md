# Quickstart with Git and GitHub #

- Official Git Website: [http://git-scm.com/](http://git-scm.com/)
- Great resource: [http://net.tutsplus.com/tutorials/other/easy-version-control-with-git/](http://net.tutsplus.com/tutorials/other/easy-version-control-with-git/)

There are three main sections here. 1) First time use, 2) Second time use, 3) Cheat sheet.


## First time ##

### Quickstart Git ###

1. [Git Download](http://git-scm.com/ "Download Git").
2. Install Git, allow Git to have contextual options in File Explorer during the install process, aka defaults.
3. In File Explorer, navigate to the project that you want to use with Git.
4. Right-click, and select Git Bash.
5. Configure Git. Type in the following, replacing the information within the quotation marks:

        git config --global user.name "Your Name"
        git config --global user.email "your@email.com"

6. Initialize the project folder to be able to use Git:

        git init

7. Add all your files to be version controlled with Git (the period means all files in current directory will be staged to be saved):

        git add .

8. Save all those files to Git (you can put something meaningful in the quotation marks):

        git commit -m "Initial commit"

Done. Whenever you make more changes to be saved in version control, do `git add .` and `git commit -m "message"` again. Also, read the rest of this doc.


### Quickstart GitHub ###

1. Do all the steps in "Quickstart Git" first, then continue here where you left off, in the project folder.
2. Create a GitHub account and SSH public key.
3. Create a new "Repository" on GitHub, sometimes called a "Repo".
4. Set location of GitHub repo in Git (edit the last parameter as needed for your repo):

        git remote add origin git@github.com:danialgoodwin/MyFirstRepo.git

5. If you added a README file during the repo setup, then update your project with:

        git pull origin master

6. Save your project to GitHub:

        git push origin master

Done. Push and pull often, but don't break the GitHub project for others. And, read the rest of this doc and others online.


#### Basic Notes ####
- You don't need GitHub to use Git.
- There are automatic tools within Git that know what code is on every line, and what gets added and removed. If collaborators work in different files/methods/lines, then there will be no problems. If collaborators work on the same line, then Git/GitHub will present us the option to choose the preferred one.
- Different branches are typically created for new features to be added. If they work, then they are merged into the main/master branch. If they don't work well, then they are left off.


## Second time ##

### Quickstart Git ###
1. In your project directory:

        git init
        git add .
        git commit -m "message"


### Quickstart GitHub ###
1. After you do the above for git

        git remote add origin git@github.com:danialgoodwin/dev.git
        git pull origin master
        git push


#### Basic Notes ####
- There is still a lot more to learn to be productive and useful with Git+GitHub.

## Add Branching and Merging to Your Workflow ##
Why? Because it is a good practice. Branching allows you to work on multiple side-projects at once and not have them interfere with each other. If anything goes horribly wrong, then you don't have to figure out all the changes you've made because you can just delete or forget about the branch without messing up other features. Merging allows you to combine all the projects together without the hassle of doing it manually via copy+paste.

Here's how the flow generally goes:

    git checkout -b newBranch // Creates a new branch called "newBranch" and switches to it.
    // You edit things on the branch
    git commit -am "Comment here on changed things"
    git checkout master // Switches your working directory branch back to the master.
    git merge newBranch // Adds the changes from "newBranch" to "master"
    git branch -d newBranch // Call this to delete the branch if you don't need it anymore.

Sometimes when you merge, you will run into conflicts because same areas may have been edited on different branches. When this happens, open the file in question (with the merge conflict) and the code needed to be resolved will be marked, which looks something like:

    <<<<<<<< HEAD
        String example = "cheese";
    ========
        String cheese = "example";
    >>>>>>>> newBranch

To fix the conflict, remove all the `<<<<<<<<` and `========` and `>>>>>>>>` and replace with what you want the final committed version to be. Ex:

    String cheese = "jalapeno";

Then, do your regular `add` and `commit` to save the changes without the merge conflict.


## Git Cheat sheet ##

### Configuration ###
    git config --global user.name "Your Name"
    git config --global user.email "your@email.com"

    git config --global color.diff auto // Enable text coloring for easier reading
    git config --global color.status auto
    git config --global color.branch auto

### git init ###
In your directory/new repository, run the following:

    git init   // initializes current folder to be git ready
    git add .  // Adds everything in file to be ready to be committed // Used when you create a new file in the folder
               //Ex: git add *.js
               //Ex: get  add index.php

    git commit // Finishes adding files officially // And you can add your message afterwards // Doing this opens Vim, where you might have to press "i" to enter "inert" mode. Then esc, ":wq" to save and exit.
           // TIP: git commit -m "initial commit" // adds your message inline


### Status ###
Don't know what to do next? Don't remember what files you have changed? Just use `git status` at any time to see what files have been modified, added, deleted, staged, and the branch.

           
### Branching ###
    git branch  // lists your branches
    git branch newBranchName // creates a new branch with the name "newBranchName" only
    git checkout newBranchName // Used to switch branches
                           // TIP: git checkout -b branch newBranchName // Creates and switches to new branch


### Merging ###
[git checkout master]
    git merge newBranchName // Use on master branch to bring newBranchName's changes to master
    git branch -d newBranchName // deletes branch newBranchName // Must have merged this branch before deleting with this command
                            // TIP: git branch -D newBranchName // deletes any branch, even if not merged
                            // TIP: use -a to add all changes to all files to the staging area (http://git-scm.com/about/staging-area)


### Status ###
    git status // Allows you to see the current state of your code // helps decide what to do next with git
    git log    // shows history
    git log --graph // shows history with graph
    gitk --all      // shows gui log


### Remove ###
Make sure to `commit` after staging with `rm`.
Remove file and don't delete it.

    git rm --cached myFile.txt

Remove file/directory and don't delete it. // The `-r` parameter to apply removal recursively, for directories

    git rm -r --cached myFolder

Remove file/directory and delete it.

    git rm myFileOrFolder


### Ignore ###
Allows you to prevent files from being "saved" with Git. More info: [https://help.github.com/articles/ignoring-files](https://help.github.com/articles/ignoring-files)

1. Create a `.gitignore` file that will be committed into the repository. (Sidenote: In Windows, you can either use a texteditor to create/save the file or use the bash command `touch .gitignore`)
2. Add rules. You can find some suggestions at https://github.com/github/gitignore
Sample ".gitignore" file for Eclipse project: (The # signs are comments)

        *.pydevproject
        .metadata
        .gradle
        bin/
        tmp/
        *.tmp
        *.bak
        *.swp
        *~.nib
        local.properties
        .settings/
        .loadpath
        
        # External tool builders
        .externalToolBuilders/
        
        # Locally stored "Eclipse launch configurations"
        *.launch
        
        # CDT-specific
        .cproject
        
        # PDT-specific
        .buildpath


## GitHub Cheat sheet ##
(Most of the following can be substituted for other remote repositories also.)

You'll need a GitHub account and SSH public key (Note: This is a one-time process for GitHub setup.)

    ssh-keygen -t rsa -C "your@email.com" // creates the SSH public key // t = type, C = comment (usually email address)
                                      // You can add this key to your GitHub account page
                                      // test authentication with ssh git@github.com


### Git Clone ###

    git clone git://github.com/jquery/jquery.git // grabs the jquery GitHub project
                                             // TIP: checkout the complete history with gitk --all


### Git Push ###
First, create a new repository in GitHub // They will provide you an url for the repo

    git remote add origin git@github.com:danialgoodwin/MyFirstRepo.git // to tell git the remote location for the following:
    git push origin master // adds your master branch to the location you specified above


#### Notes ####
- Before you can `push` to GitHub, you must `pull` if there is any changes in there that was added before your files.
- Before you can `push` to GitHub, you must have done the regular git steps also, i.e. `git add .` and `git commit -m "messge"`. Meaning, there needs to be something new to push.
- After doing `git push origin master` or `git pull origin master` once, then after that you can just do `git push` or `git pull` to do the same thing.


### Git Pull ###
git remote add origin git@github.com:danialgoodwin/MyFirMyFirstRepostRepo.git // to tell git the remote location for the following:
git pull origin master // runs git fetch (gets the changes) and git merge (merges changes with your current copy


### Remote Branches ###

Get info:

    git remote show origin // Lists the remote branches

Checkout from remote:

    git checkout -b localBranchName origin/remoteBranchName

Retrieve all remote branches:

    git fetch --all // Gets all branches from all remotes
    git fetch origin // Gets all branches of the origin remote

Delete:

    git push origin :myBranchName // Deletes the remote branch, but still need to delete local branch also.
    git branch -d myBranchName // Something like this to delete local branch.


## Collaboration ##
- Make sure collaborators only push working code
- That way, you always pull before beginning work and don't have to fix other's code.
- Push whenever a feature is done/working.


## Intermediate Notes ##

### About git-add and staging ###
- [Official docs for git-add](http://git-scm.com/docs/git-add)

Basically, `add` means to stage files (to "index") so that they can be committed. There are three types of files that can be staged: modified files, new files, and removed files.

    git add --update // Stages modified files and removed files.
    git add // With no arguments, stages new and modified files.
    git add --all // Stages new, modified, and removed files.
    git rm // Stages removed files. (Sidenote: Some arguments of this can actually delete files)

#### How to undo an `add` before `commit` ####
    git reset <file> // Removes just the one file from staging area. // Short for `git reset HEAD <file>`.
    git reset // Removes all files from staging area. Meaning, unstages all files.


### Commit Messages Style ###
For small personal projects, you may be fine with one-liner messages using `git commit -m "my message"`, but as you start to get more serious about your work, you may want to adopt a well-practice style that will help you more in the long run.

Highlights:
- The first line contains the main summary for the commit and why the change took place. Ex: "Foo the bar to prevent memory leak". Imagine looking back in the future, you may want to easily glance through many commits to see the what and why things changed. You may be looking for the source of a bug. If you see a commit message and ask why it was done and why this implementation and why is it necessary and what effects does the patch have (benchmarks, side effects, etc), then the reasoning should be in the message itself.
- The most common styling of the message seems to be the "50-72 style", where there are about 50 characters on the first line for a quick description, followed by a blank newline, then a paragraph with details and limitations using 72 or less characters on each line. These specific numbers are used so that logs are easier to read in the future. [1][3][5]
  - About 50 because it is used in many different places with other info on the line and message may be cut off if longer.
  - 72 max because the typical terminal is 80 characters wide, and the commit message is indented four spaces on the left, and, to be symetrical, four spaces on the right.
- Using `get add -p` (or `-i`) may help you split larger changes to bite-sized commits.

Sources:
- [1] http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html (Most referenced, has example Git commit message using 50-72 style)
- [2] https://github.com/blog/926-shiny-new-commit-styles
- [3] http://www.slideshare.net/TarinGamberini/commit-messages-goodpractices
- [4] https://wiki.openstack.org/wiki/GitCommitMessages (Great, many examples)
- [5] http://ablogaboutcode.com/2011/03/23/proper-git-commit-messages-and-an-elegant-git-history/
- [6] http://who-t.blogspot.de/2009/12/on-commit-messages.html (Great)
- [7] http://stackoverflow.com/questions/15324900/standard-to-follow-when-writing-git-commit-messages/15325058#15325058


## Further Resources ##
- Great article on how Git stores you data: [Git for Computer Scientists](http://eagain.net/articles/git-for-computer-scientists/)
- The entire [Pro Git](http://git-scm.com/book/en) book.