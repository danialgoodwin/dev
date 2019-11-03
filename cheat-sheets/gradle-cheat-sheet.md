# Gradle Cheat Sheet


## Snippets

### How to add Gradle to a project

1. Create file: `touch build.gradle`
2. Add a task, for example:

        task zip(type: Zip) {
            from('source/') {
                include '**/'
            }
            archiveFileName 'my-source-files.zip'
            destinationDirectory(file('out/'))
        }

3. Run the task, for example: `gradle zip`
4. That's it :)

### How to add Gradlew to a project

1. Run: `gradle wrapper`
2. That's it :)


