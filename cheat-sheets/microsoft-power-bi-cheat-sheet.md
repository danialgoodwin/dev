# Microsoft Power BI Cheat Sheet

Table of contents:
- [Development](#development)
    - [How to add conditional formatting](#how-to-add-conditional-formatting)
    - [How to create a multi-line chart in Power BI](#how-to-create-a-multi-line-chart-in-power-bi)
    - [How to show or hide a Power BI visual based on selection](#how-to-show-or-hide-a-power-bi-visual-based-on-selection)
    - [How to create Power BI custom visuals](#how-to-create-power-bi-custom-visuals)
        - [Power BI custom visuals using Google Charts JavaScript library](#power-bi-custom-visuals-using-google-charts-javascript-library)
- [Data Analysis Expressions (DAX)](#data-analysis-expressions--dax-)
    - [Get number of selected data points](#get-number-of-selected-data-points)
- [Version Control](#version-control)
- [How to have multiple developers working on Power BI at the same time](#how-to-have-multiple-developers-working-on-power-bi-at-the-same-time)
    - [Background](#background)
- [Resources](#resources)



## Development

### How to add conditional formatting
- Great: https://radacad.com/show-me-the-biggest-number-conditional-formatting-in-power-bi

### How to add conditional titles
- https://docs.microsoft.com/en-us/power-bi/desktop-conditional-format-visual-titles

### How to create a multi-line chart in Power BI
1. Start with a regular 'line chart'
2. In the panel for Visualizations > Fields, add a column to the 'Legend' section
3. See multiple lines when multiple fields in the column are selected

### How to show or hide a Power BI visual based on selection
- Great: https://exceleratorbi.com.au/show-or-hide-a-power-bi-visual-based-on-selection/
- Good: https://www.linkedin.com/pulse/show-different-visuals-based-condition-power-bi-alina-fisher

### How to create Power BI custom visuals
- Most helpful: https://docs.microsoft.com/en-us/power-bi/developer/visuals/custom-visual-develop-tutorial
- Main documentation: [Visuals in Power BI](https://docs.microsoft.com/en-us/power-bi/developer/power-bi-custom-visuals)
- Good documentation about `IVisual` (the interface that must be implemented): https://github.com/microsoft/PowerBI-visuals/blob/master/Visual/IVisualApi.md
- https://powerbi.microsoft.com/en-us/developers/custom-visualization/

- https://github.com/Microsoft/PowerBI-visuals
    - https://github.com/microsoft?utf8=%E2%9C%93&q=powerbi-visuals&type=&language=
- https://docs.microsoft.com/en-us/power-bi/developer/power-bi-custom-visuals-certified#certified-power-bi-visuals

#### Power BI custom visuals using Google Charts JavaScript library
- https://www.goodwin.dev/dev/2020/2/21/how-to-create-a-custom-visual-in-power-bi-using-google-charts/
- Receiving user events within Google Charts: https://developers.google.com/chart/interactive/docs/basic_interactivity



## Data Analysis Expressions (DAX)

[Operators](https://docs.microsoft.com/en-us/dax/dax-operator-reference)

    Math: +, -, *, /, ^
    Comparison: =, ==, >, <, >=, <=, <>
    Text concatenate: &
    Logical: &&, ||, IN (Ex: `[Color] IN {"Blue", "Green", "Brown"}`)

Conditionals ([IF](https://docs.microsoft.com/en-us/dax/if-function-dax))

    IF(<logical_test>, <value_if_true>[, <value_if_false>])
    =IF([MyMeasureCount] < 4, "low", IF ([MyMeasureCount] >= 7, "high", "medium"))
    =IF([MyLocation] = "Colorado" && ([MyHasDog] || [MyCity] = "Denver"), "great", "lacking")


More:
- [DAX Overview](https://docs.microsoft.com/en-us/dax/dax-overview)
- [DAX Fuctions](https://docs.microsoft.com/en-us/dax/dax-function-reference)

### Get number of selected data points

    =COUNTROWS(FILTERS([MyTableColumn]))
    =COUNTROWS(ALLSELECTED([MyTableColumn]))

And, may need to have a special case for 'no selection' when dealing with charts, otherwise the count will be all the rows:

    IF(ISFILTERED([MyTableColumn]), 
        COUNTROWS(ALLSELECTED([MyTableColumn])),
        0
    )



## Version Control
Currently, proper version control is not built in to Power BI. Here's' the feature request:
- https://ideas.powerbi.com/forums/265200-power-bi-ideas/suggestions/36978934-built-in-git-support-in-powerbi-desktop

So far, the best method workaround for having text-based (non-binary) Power BI version control is to use this open source script to 'unzip' the PBIX (or PBIT) file: https://github.com/awaregroup/powerbi-vcs

Usage to quickly test this workaround yourself:
1. Get the project local: `git clone https://github.com/awaregroup/powerbi-vcs.git`
2. Run the 'unzip' script on yout PBIX file: `python3 pbivcs.py my-eport.pbix my-output-dir`
3. Commit these changes so that we can easily see future changes: `git add .  && git commit -m 'Initial report'`
4. Modify the PBIX file, then run the 'unzip' command on the bew PBIX file: `python3 pbivcs.py myReport.pbix my-output-dir --over-write`
5. View the diff: `git diff`

Note: This isn't quite ready for production. It's best use case is ensuring that small changes are small (i.e., update text or style)

More resources:
- Good: [Administering and publishing Power BI resources via Azure DevOps](https://msftplayground.com/2018/12/administrating-and-publishing-power-bi-resources-via-azure-devops/) - Summary: Use 'Power BI Actions' from the Azure DevOps Marketplace. This is from the author of the 'task', which was updated on 2018-12-21
- Good: [CI/CD using Azure DevOps](https://community.powerbi.com/t5/Community-Blog/PowerBI-CICD-using-Azure-DevOps/ba-p/769244) - Summary: Use Power BI REST API in Azure DevOps, create service principal (or master account), use 'Power BI Actions' from Azure DevOps Marketplace. This also shows how to have multiple environments (dev+prod).
- Meh: [Versioning and CI/CD for Power BI with Azure DevOps](https://data-marc.com/2019/11/12/versioning-and-ci-cd-for-power-bi-with-azure-devops/) - Summary: Install 'Macaw Power BI Extensions' from the Azure DevOps Marketplace and use it in a pipeline.



## How to have multiple developers working on Power BI at the same time

Decouple data preparation to make Power BI load faster and to have at least different people working on the data and UI sides.
- https://radacad.com/power-bi-architecture-for-multi-developer-tenant-using-dataflows-and-shared-datasets

Also:
- 2016-05-25: "Can't combine multiple PBIX files into one PBIX" (Source: https://community.powerbi.com/t5/Desktop/How-can-multiple-developer-work-on-same-data-Model-in-a-PBIX/td-p/36852)


### Background
Unfortunately, there is no versional control built in to Power BI. But, there have been attempts to create one by third-party developers. These beta Power BI version control systems zip and unzip the PBIX files as needed, and the text version is checked into git.

In its default state, multiple developers can not work at the same time with a single PBIX file. That's because its contents are binary, and when it's checked into a VCS, the entire file is replaced rather than using a 'merge' strategy.



## Resources
- [Visual Vocabulary](https://github.com/ft-interactive/chart-doctor/tree/master/visual-vocabulary): Excellent overview of many different chart types and how to pick which chart type to use.

Lots of good notes, but unfortunately doesn't have a date: 
https://www.nigelfrank.com/blog/everything-you-ever-wanted-to-know-about-microsoft-power-bi/
