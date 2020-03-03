# Microsoft Power BI Cheat Sheet



## Development

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



## Version Control
Currently, version control is not built in to Power BI. So, people have created workarounds so that we can see changes between versions:
- (Not tested yet) https://github.com/awaregroup/powerbi-vcs'



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
