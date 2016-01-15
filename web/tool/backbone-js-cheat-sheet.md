# Backbone.js Cheat Sheet



## How to get started with Backbone.js

Backbone.js uses underscore.js and jquery.js.

In index.html: (Example without using Underscore.js template)

    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <title>Hello World in Backbone.js</title>
    </head>
    <body>

      <div id="container">Loading...</div>

      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>

      <script type="text/javascript">
        var AppView = Backbone.View.extend({
           // el - stands for element. Every view has a element associate in with HTML
           //      content will be rendered.
           el: '#container',
           // It's the first function called when this view it's instantiated.
           initialize: function(){
             this.render();
           },
           // $el - it's a cached jQuery object (el), in which you can use jQuery functions
           //       to push content. Like the Hello World in this case.
           render: function(){
             this.$el.html("Hello World");
           }
         });
         var appView = new AppView();
      </script>
    </body>
    </html>

In index.html: (Example without using Underscore.js template)

    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <title>Hello World in Backbone.js</title>
    </head>
    <body>

      <div id="container">Loading...</div>

      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone-localstorage.js/1.0/backbone.localStorage-min.js" type="text/javascript"></script>  

      <script type="text/javascript">
        var AppView = Backbone.View.extend({
          el: '#container',
          // template which has the placeholder 'who' to be substitute later
          template: _.template("<h1>Hello, <%= who %>!</h1>"), //_
          initialize: function(){
            this.render();
          },
          render: function(){
            this.$el.html(this.template({who: 'World'}));
          }
        });
        var appView = new AppView();
      </script>
    </body>
    </html>



## How to build a simple TODO app with Backbone.js

In index.html:


    <!DOCTYPE html>
    <html>
    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      <title>Hello World in Backbone.js</title>

      <style type="text/css">
        <!-- Hide bullet points from todo list -->
        #todoapp ul {
          list-style-type: none;
        }
        #todo-list input.edit {
          display: none; /* Hides input box*/
        }
        #todo-list .editing label {
          display: none; /* Hides label text when .editing*/
        }
        #todo-list .editing input.edit {
          display: inline; /* Shows input text box when .editing*/
        }
      </style>
    </head>
    <body>

      <section id="todoapp">
        <header id="header">
          <h1>Todos</h1>
          <input id="new-todo" placeholder="What needs to be done?">
          <div>
            <a href="#/">show all</a> |
            <a href="#/pending">show pending</a> |
            <a href="#/completed">show completed</a>
          </div>
        </header>
        <section id="main">
          <ul id="todo-list"></ul>
        </section>
      </section>

      <script type="text/template" id="item-template">
        <div class="view">
          <input class="toggle" type="checkbox">
          <label><%- title %></label>
          <input class="edit" value="<%- title %>">
          <button class="destroy">remove</button>
        </div>
      </script>

      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>
      <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone-localstorage.js/1.0/backbone.localStorage-min.js" type="text/javascript"></script>

      <script type="text/javascript">
         var app = {}; // create namespace for our app

         app.Todo = Backbone.Model.extend({
           defaults: {
             title: '',
             completed: false
           }
         });

         app.TodoList = Backbone.Collection.extend({
           model: app.Todo,
           localStorage: new Store("backbone-todo"),
           completed: function() {
             return this.filter(function( todo ) {
               return todo.get('completed');
             });
           },
           remaining: function() {
             return this.without.apply( this, this.completed() );
           }
         });

         // renders individual todo items list (li)
        app.TodoView = Backbone.View.extend({
          tagName: 'li',
          template: _.template($('#item-template').html()), //_
          render: function(){
            this.$el.html(this.template(this.model.toJSON()));
            this.input = this.$('.edit');
            return this; // enable chained calls
          },
          initialize: function(){
            this.model.on('change', this.render, this);
            this.model.on('destroy', this.remove, this); // remove: Convenience Backbone'
          },
          events: {
            'dblclick label' : 'edit',
            'keypress .edit' : 'updateOnEnter',
            'blur .edit' : 'close',
            'click .toggle': 'toggleCompleted',
            'click .destroy': 'destroy'
          },
          edit: function(){
            this.$el.addClass('editing');
            this.input.focus();
          },
          close: function(){
            var value = this.input.val().trim();
            if(value) {
              this.model.save({title: value});
            }
            this.$el.removeClass('editing');
          },
          updateOnEnter: function(e){
            if(e.which == 13){
              this.close();
            }
          },
          toggleCompleted: function() {
            this.model.toggle();
          },
          destroy: function() {
            this.model.destroy();
          }
        });

        // renders the full list of todo items calling TodoView for each one.
        app.AppView = Backbone.View.extend({
          el: '#todoapp',
          initialize: function () {
            this.input = this.$('#new-todo');
            // when new elements are added to the collection render then with addOne
            app.todoList.on('add', this.addOne, this);
            app.todoList.on('reset', this.addAll, this);
            app.todoList.fetch(); // Loads list from local storage
          },
          events: {
            'keypress #new-todo': 'createTodoOnEnter'
          },
          createTodoOnEnter: function(e){
            if ( e.which !== 13 || !this.input.val().trim() ) { // ENTER_KEY = 13
              return;
            }
            app.todoList.create(this.newAttributes());
            this.input.val(''); // clean input box
          },
          addOne: function(todo){
            var view = new app.TodoView({model: todo});
            $('#todo-list').append(view.render().el);
          },
          addAll: function(){
            this.$('#todo-list').html(''); // clean the todo list
            //app.todoList.each(this.addOne, this);
            // filter todo item list
            switch(window.filter){
              case 'pending':
                _.each(app.todoList.remaining(), this.addOne); //_
                break;
              case 'completed':
                _.each(app.todoList.completed(), this.addOne); //_
                break;
              default:
                app.todoList.each(this.addOne, this);
                break;
            }
          },
          newAttributes: function(){
            return {
              title: this.input.val().trim(),
              completed: false
            }
          }
        });

        app.Router = Backbone.Router.extend({
          routes: {
            '*filter' : 'setFilter' //*
          },
          setFilter: function(params) {
            console.log('app.router.params = ' + params); // just for didactical purposes.
            window.filter = params.trim() || '';
            app.todoList.trigger('reset');
          }
        });

        app.todoList = new app.TodoList();
        var todo = new app.Todo({title: 'Learn Backbone.js', completed: false});
        var view = new app.TodoView({model: todo});
        app.appView = new app.AppView();
        app.router = new app.Router();
        Backbone.history.start();
      </script>
    </body>
    </html>

1. Open Chrome Developer Tools Console, and try out the Backbone Model, one line at a time:

        var todo = new app.Todo({title: 'Learn Backbone.js', completed: false}); // create object with the attributes specified.

        todo.get('title'); // "Learn Backbone.js"
        todo.get('completed'); // false
        todo.get('created_at'); // undefined
        todo.set('created_at', Date());
        todo.get('created_at'); // "Wed Sep 12 2012 12:51:17 GMT-0400 (EDT)"

2. Also in the Chrome console, try the Backbone Collection, one line at a time:

        var todoList = new app.TodoList()
        todoList.create({title: 'Learn Backbone\'s Collection'}); // notice: that `completed` will be set to false by default.
        var lmodel = new app.Todo({title: 'Learn Models', completed: true});
        todoList.add(lmodel);
        todoList.pluck('title');     // ["Learn Backbone's Collection", "Learn Models"]
        todoList.pluck('completed'); // [false, true]
        JSON.stringify(todoList);    // "[{"title":"Learn Backbone's Collection","completed":false,"id":"d9763e99-2267-75f5-62c3-9d7e40742aa6"},{"title":"Learn Models","completed":true}]"



## More Info
- Good: [Backbone.js for Absolute Beginners - Getting Started](http://adrianmejia.com/blog/2012/09/11/backbone-dot-js-for-absolute-beginners-getting-started/): The code there is similar to code here.
