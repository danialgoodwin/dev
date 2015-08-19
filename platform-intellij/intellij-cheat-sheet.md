# IntelliJ Cheat Sheet #




## Plugin Development ##

### How to get started (Performing action at plugin load time) ###
1. In IntelliJ, create a new project
2. Choose "IntelliJ Platform Plugin" (installed by default), and set the project SDK to point to the *community* version of IntelliJ.
3. When created a `plugin.xml` file should appear in the workspace. Read through to know what's in there, then edit the id, name, version, and vendor to your liking.
4. Create a new Java file in the "src" directory, called something like 'SampleStartupActivity'. Add the following code:

        package com.example.mypluginname;
        import com.intellij.openapi.project.Project;
        import com.intellij.openapi.startup.StartupActivity;

        public class SampleStartupActivity implements StartupActivity {
            @Override
            public void runActivity(Project project) {
                System.out.println("Hello World! Loaded project: " + project.getName());
            }
        }

5. Back in 'plugin.xml', make the 'extensions' tag look something like the following:

        <extensions defaultExtensionNs="com.intellij">
            <postStartupActivity implementation="com.example.mypluginname.SampleStartupActivity"></postStartupActivity>
        </extensions>

6. Run the plugin (shift+F10), and a new instance of IntelliJ will startup. When your new plugin loads, the log will be displayed in the first IDE.


The [source has pictures and more words](https://www.cqse.eu/en/blog/intellij-plugin-tutorial/).


### How to add an Action to an IntelliJ Plugin ###
1. Right-click 'src' in the Project window, select New->Action.
2. Add some id, class name, name, and description. The group will define where the action will appear. For example, add the Action to the Group 'ToolsMenu (Tools)' and the action will appear in the menu bar 'Tools'. When you click 'OK', the plugin.xml should be updated and a new file with the specified class name will be created.

The source with more useful words, after skipping through the first half of unuseful words: [How to make an IntelliJ IDEA plugin in less than 30 minutes](http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes)



## Further Resources ##
- [live-plugin](https://github.com/dkandalov/live-plugin): Build IntelliJ plugins faster, without having to open a new IDE instance for each build. (Not personally tested yet.)
- [What is the IntelliJ platform](http://www.jetbrains.org/pages/viewpage.action?pageId=983889)
- [Plugin Development News](http://blog.jetbrains.com/idea/category/plugin-development/)


### TODO: Resources to go through ###
- https://www.jetbrains.com/idea/plugins/
- http://www.jetbrains.org/intellij/sdk/docs/index.html
  - http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started.html
  - http://www.jetbrains.org/intellij/sdk/docs/basics/architectural_overview.html
  - http://www.jetbrains.org/intellij/sdk/docs/faq.html
- https://www.jetbrains.com/idea/help/plugin-development-guidelines.html
- https://confluence.jetbrains.com/display/IDEADEV/Getting+Started+with+Plugin+Development
- Some good snippets maybe: http://tomaszdziurko.pl/2011/09/developing-plugin-intellij-idea-some-tips-and-links/
