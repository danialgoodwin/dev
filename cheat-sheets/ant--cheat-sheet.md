# Ant Cheat Sheet



## Overview
```ant
<project name="MyProject" default="build">
    <property environment="env" />
    <import file="${env.COMMON_REPO}/common.xml" />

    <path id="class.path">
        <pathelement location="${build.output.dir}" />
        <path refid="common.path" />
        <pathelement path="${java.class.path}" />
        <fileset file="${junit.jar}" />
    </path>
    
    <target name="doSomething">
        <copy todir="${build.output.dir}">
            <fileset dir="test" includes="**/*.txt" />
        </copy>
        <ant antfile="../common-java/build.xml" target="compile-test" useNativeBasedir="true" />
    </target>
</project>
```



## How To


## Troubleshooting


## Resources

