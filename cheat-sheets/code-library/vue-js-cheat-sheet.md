# Vue.js Cheat Sheet


## Basic

Overall Vue file:

    <template>
      ...
    </template>
    
    <script>
      import ...
      
      export default {
        data() {
          return {
            foo: 'bar',
            // ...
          }
        },
        methods: {
          // ...
        },
        // ...
      }
    </script>
    
    <style scoped>
      ...
    </style>

Shorthand:
- v-bind: `:`
- v-on: `@`
- v-slot: `#`

    <!-- Use `template` rather than `div` so that there isn't an extra element in the DOM. -->
    <template v-if="true">
      <p>asdf</p>
      <p>asdf</p>
      <p>asdf</p>
    </template>
    <template v-else>
      <p>qwerty</p>
      <p>qwerty</p>
      <p>qwerty</p>
    </template>
    
    <div v-for="item in items" :key="item.id">
      {{ item.value }}
    </div>
    
Lazy-loading modules:

    export default new Router({
      routes: [
        {
          path: '/myfeature1',
          name: 'myfeature1',
          // Special comment syntax: https://router.vuejs.org/guide/advanced/lazy-loading.html#grouping-components-in-the-same-chunk
          component: () => import(/* webpackChunkName: "myfeature1" */ './modules/myfeature1/views/MyFeature1.vue')
        },
        // ...
      ]
    })

### How to change port

    npm run serve -- --port 4242


### More Resources:
- Great: https://vuejs.org/v2/style-guide/#Priority-A-Rules-Essential-Error-Prevention



## Code Organization

    <template src="./file.html"></template>
    <script src="./file.js"></script>

Idea for larger projects:
- Different modules (in the organization below) should NOT depend on any other modules. Shared components go in `core/`.
- Use `components/` for 'dumb' components, which only take props and emit events.
- Use `pages/` for 'smart' components, which can access the store, routers, window object, etc.

    /
      src/
        core/
          components/
          pages/
        modules/
          feature1/
            Feature1.vue
            components/
            pages/
            routes/
            services/
            store/
            tests/
          feature2/
            Feature2.vue
            components/
            ...

Code splitting patterns:
- Great: https://medium.com/js-dojo/3-code-splitting-patterns-for-vuejs-and-webpack-b8fff1ea0ba4



# Testing

Basic structure of a test file:

    import { mount } from "@vue/test-utils";
    import MyComponent from "@/components/MyComponent";
    
    describe("MyComponent", () => {
        test("my test description", () => {
            const wrapper = mount(MyComponent); // The name 'wrapper' is used by convention
            // console.log(wrapper.html()) // Use this to show the HTML
            expect(wrapper.find("mySignOutButton").isVisible()).toBe(false); // Using Jest
            wrapper.setData({ signedIn: true });
            expect(wrapper.find("mySignOutButton").isVisible()).toBe(true); // Using Jest
        });
    });


# Troubleshooting

## ReferenceError: requestAnimationFrame is not defined

> ReferenceError: requestAnimationFrame is not defined
>    at VueComponent.mounted
>    ...

Solution: 

# Resources
- Great: https://www.vuemastery.com/blog/Unit-Testing-in-Vue-Your-First-Test/
    - Cheat Sheet: https://www.vuemastery.com/pdf/Vue-Essentials-Cheat-Sheet.pdf
