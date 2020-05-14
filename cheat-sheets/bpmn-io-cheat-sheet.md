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

**Add custom elements to palette:**


**Remove built-in elements from palette:**

In your custom Palette or custom PaletteProvider, modify the return value of `getPaletteEntries(...)`:

    getPaletteEntries (element) {
      // ...
      // const myCustomEntries = ...
      const entriesToRemove = [  // This leaves the following tools: hand, lasso, spacer, connect
        'create.start-event',
        'create.data-object',
        'create.data-store',
        'create.end-event',
        'create.exclusive-gateway',
        'create.group',
        'create.intermediate-event',
        'create.participant-expanded',
        'create.subprocess-expanded',
        'create.task'
      ]

      const builtInEntries = super.getPaletteEntries(element)
      for (const entry of entriesToRemove) {
        delete builtInEntries[entry]
      }
      return Object.assign(builtInEntries, myCustomEntries)
      //return myCustomEntries  // Use this remove all built-in palette tools
    }

Note: After removing tools from the palette, you may also want to remove the tools from the 'context pad' and the 'change menu'.

More info:
- Good simple example: https://codesandbox.io/s/bpmn-js-custom-palette-lwwf2
- Testing: https://github.com/bpmn-io/diagram-js/blob/master/test/spec/features/palette/PaletteSpec.js
- https://github.com/camunda-consulting/code/tree/master/snippets/camunda-modeler-plugins/bpmn-js-plugin-reduced-palette

### How to create a custom properties panel

More info:
- https://github.com/bpmn-io/bpmn-js-examples/tree/master/properties-panel

### How to create a custom renderer


### How to avoid parallel flows

More info:
- https://forum.bpmn.io/t/avoid-parallel-flows/78



## References
- [Official site](https://bpmn.io/)
    - [Examples](https://bpmn.io/toolkit/bpmn-js/examples/) (via [GitHub](https://github.com/bpmn-io/bpmn-js-examples))
    - [Forums](https://forum.bpmn.io/c/developers)
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
- GitHub
    - [awesome-bpmn-io](https://github.com/bpmn-io/awesome-bpmn-io)
    - [BPMN 2.0 symbol font](https://github.com/bpmn-io/bpmn-font)
    - [vue-bpmn](https://github.com/bpmn-io/vue-bpmn): Show BPMN 2.0 diagram in Vue.js

- Custom examples:
    - https://gojs.net/latest/projects/bpmn/BPMN.html#
    - https://gojs.net/latest/samples/roundedGroups.html
- Fun:
    - GitHub - Custom Shape - Nyan cat: https://github.com/bpmn-io/bpmn-js-nyan
