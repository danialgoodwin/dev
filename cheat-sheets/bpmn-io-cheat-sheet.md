# BPMN.IO Cheat Sheet
Web-based viewer and editor for BPMN, DMN, and CMMN.



## How to get started with BPMN.IO

1. In your project, run: `npm install bpmn-js`
2. Access the BPMN Modeler:

        import Modeler from 'bpmn-js/lib/Modeler'
        let modeler = new Modeler({ container: '#canvas' })
        modeler.importXML(bpmnXML, function(err) {
          // ...
        })

More info:
- https://bpmn.io/toolkit/bpmn-js/walkthrough/



## Development

### How to create a custom element in bpmn-js


More info:
- https://github.com/bpmn-io/bpmn-js-example-custom-elements
- https://github.com/bpmn-io/bpmn-js-examples/tree/master/custom-elements

### How to create a custom palette

### How to create a custom properties panel

More info:
- https://github.com/bpmn-io/bpmn-js-examples/tree/master/properties-panel

### How to create a custom renderer




## References
- [Official site](https://bpmn.io/)
    - [Examples](https://bpmn.io/toolkit/bpmn-js/examples/) (via [GitHub](https://github.com/bpmn-io/bpmn-js-examples))
    - [Forums](https://forum.bpmn.io/c/developers)
- GitHub - [vue-bpmn](https://github.com/bpmn-io/vue-bpmn): Show BPMN 2.0 diagram in Vue.js
- bpmn-io--bpmn-js
    - Colors: https://github.com/bpmn-io/bpmn-js-examples/tree/master/colors
         - Can be done via overlay, BPMN 2.0 extension, CSS, or custom rendere
    - Comments: https://github.com/bpmn-io/bpmn-js-examples/tree/master/commenting
    - Custom Shapes:
        - BPMN 2.0 compatible: https://github.com/bpmn-io/bpmn-js-examples/tree/master/custom-elements
        - Not BPMN 2.0 compatible: https://github.com/bpmn-io/bpmn-js-example-custom-shapes
    - Modeling Rules: https://github.com/bpmn-io/bpmn-js-examples/tree/master/custom-modeling-rules
    - Overlays: https://github.com/bpmn-io/bpmn-js-examples/tree/master/overlays
    - [Properties Panel Extension](https://github.com/bpmn-io/bpmn-js-examples/tree/master/properties-panel-extension)
    - Theming: https://github.com/bpmn-io/bpmn-js-examples/tree/master/theming
        - Includes custom renderer, font, colors, css
- GitHub - [awesome-bpmn-io](https://github.com/bpmn-io/awesome-bpmn-io)

- Custom examples:
    - https://gojs.net/latest/projects/bpmn/BPMN.html#
    - https://gojs.net/latest/samples/roundedGroups.html
- Fun:
    - GitHub - Custom Shape - Nyan cat: https://github.com/bpmn-io/bpmn-js-nyan
