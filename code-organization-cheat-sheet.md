# General Code Organization Cheat Sheet



## Small Apps
- Maybe around 10 files (or 20 max) (note: these numbers are arbitrary)
- Doesn't really matter because the entire code base can easily be in working memory



## Non-Trivial Apps
- Place things that change for the same reason as close to each other as possible.
    - Example:
        - Codebases get harder to navigate if there are just three folders (ex: model/, view/, controller/) with tens (or hundreds) of files in each.
- Independent features should be grouped together
    - Example:
        - Have a folder (or module) like feature-1/ with the MVC at that level.



## Resources
