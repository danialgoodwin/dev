# jQuery Cheat Sheet #

## Get started ##
1. See 'developers.google.com/speed/libraries' for script imports
2. Add the following code within the body tags. Future jQuery code will go on that blank line.

        <script type="text/javascript">
        $("document").ready(function()) {

        });
        </script>

3.


## Basics ##

Targeting id:

    $("#root").css("width", 500);
    $("#root").css("margin", "auto");

Targeting class:

    $(".classname").css({
      "background": "url('repeating.png') repeat-y"
    });

Targeting tag:

    $("a").css("color", "red");
    $("#tableData a").css("color", "green");
    $("em + a").css("color", "orange"); // + for after
    $("p > em").css("color", "gray"); // > for children
    $("ol li:nth-child(3)").css(...) // to target specific child
    $("ol li:even").css(...) // to target even children

    $("li[name]").html("Some HTML");
    $("input[type='text']#name").val("Some Name");

    $("img[alt^='thumb']").width(150).height(200); // ^ to find at beginning, * to find anywhere, $ to find at end

Handle click event:

    $("#id").click(function() {
      $(this).remove();
      $(this).toggleClass("highlight");
    });

More events to handle:

    $("#id").mouseover(function() {  });
    $("#id").mouseoout(function() {  });

    $("#id").hover(function() {
      // handle mouseover
    }, function() {
      // handle mouseout
    });

    $("#id").dblclick(function() {  }); // double-click

    $("document").click(function(e) {
      // Use `e.pageX` to get x position of click
      // Use `e.pageY` to get y
    });
    $("document").mousemove(function(e) {
      // Use `e.screenX` to get x position of move
      // Use `e.screenY` to get y
    });

    $("document").keypress(function(e) {
      var keyPressed = String.fromCharCode(e.which);
      $("#input").val(keyPressed);
    });

    $("#inputFormEvent").blur(function() {
      $("#formEvent").text("Left Input Element")
    });
    $("#inputFormEvent").change(function() {  });
    $("#inputFormEvent").focus(function() {  });
    $("#inputFormEvent").select(function() {  });

    function doSomething(e) {
      alert(e.data.message);
    }
    var message = { message: "My message" };
    var message2 = { message: "My message2" };
    $("#id").on("mouseover", message, doSomething);
    $("#id").on("click", message2, doSomething);

    resize // for browser
    scroll

## Example ##

### Simple Slideshow ###

    var images = ["1.jpg","2.jpg","3.jpg"];
    var focus = 1;
    $("#id").click(function() {
      var image = images[focus];
      focus++;
      if (focus > 3) { focus = 0; }
      $("img").attr("src", image);
    })

### Slideshow with Animation ###

    $("#id").click(function() {
      $(this).fadeOut(2000);
      $(this).fadeToggle(2000);
      $(this).fadeTo('slow', .50);
      $(this).slideUp(1000); // Also: slideDown

      // Custom animation
      $(this).css("position", "relative");
      $(this).animate({
        left: 300,
        opacity: .5,
        'font-size': "22px",
        width: 300,
      }, 2000, "easeInQuad", function() {alert("Done!");} );
    });



## jQuery UI ##
Simple styling using jQuery.

    $("#id").menu({
      position: {
        my: "center top",
        at: "center bottom"
      }
    });

    $("#id").accordion({
      animate: 1500,
      active: 1,
      collapsible: true,
      event: "click",
      heightStyle: "content"
    });

    $("#navbar").tabs({
      event: "click",
      show: "fadeIn", // fadeOut, slideUp..
      hide: "fadeOut",
      active: 3,
      collapsible: true,
      heightStyle: "auto" // Doesn't resize, like 'content'
    });

    $("#customDialog").dialog({
      draggable: true,
      resizeable: false,
      height: 300,
      width: 300,
      modal: true,
      position: {
        my: "center top",
        at: "center bottom",
        of: "#openDialog"
      },
      show: 1000, // delay
      hide: 1000, // delay
      autoOpen: false,
      buttons: {
        "OK": function() {
          // Do something
          $(this).dialog("close");
        },
        "Cancel": function() {
          // Do something
          $(this).dialog("close");
        }
      }
    });
    $("#customDialog").dialog("open");

    $(".title").tooltip();

    $("#present").selectmenu({
      width: 200
    });

    $("#present").datepicker({
      changeMonth: true,
      changeYear: true,
      dateFormat: "MM dd, yy",
      numberOfMonths: 1,
      maxDate: 365,
      minDate: -3650
    });

    $("#radioPresents").buttonset();
    $("#radioPresents").button();

    $("#sampleForm").draggable();
    $("#cart").droppable({
      activeClass: "highlight",
      hoverClass: "hoverDroppable",
      drop: function(event, ui) {
        ui.helper.hide("fade");
        var itemAlt = $(ui.draggable).attr("alt");
        alert("Item=" + itemAlt);
      },
      accept: ".toy",
      disabled: false,
      activate: function(event, ui) {
        $("cartMessage").remove();
        $(this).append("<span>" + ... + "</span>")
      },
      deactivate: function(event, ui) {
        $("cartMessage").remove();
        $(this).append("<span>" + ... + "</span>")
      },
      over: function(event, ui) {
        $("cartMessage").remove();
        $(this).append("<span>" + ... + "</span>")
      },
      out: function(event, ui) {
        $("cartMessage").remove();
        $(this).append("<span>" + ... + "</span>")
      },
    });


## AJAX with jQuery ##

    $("#button").on("click", getInfoFromServer);
    $("#button").on("click", getDoubleFromServer);
    $("#button").on("click", getXmlFromServer);

    function getInfoFromServer() {
      $.ajax({
        type: "GET",
        url: "textFromServer.txt",
        success: postToPage
      });
    }
    function postToPage(data, status) {
      $("#message").text(data);
    }

    function getDoubleFromServer() {
      $("").load("getDouble.php", $("#theForm").serializeArray());
    }

    function getXmlFromServer() {
      $.ajax({
        type: "GET",
        url: "customers.xml",
        datatype: "xml",
        succes: postToPageTwo
      });
    }
    function postToPageTwo(data) {
      $(data).find("customer").each(function() {
        var id = $(this).attr("id");
        var firstName = $(this).find("firstName").text();

        $("<div class='firstName'><div>").html(firstName).appendTo("#customer");
      });
    }


## Further Resources ##
- Good for beginner: [Derek Banas: jQuery Tutorial](https://www.youtube.com/watch?v=BWXggB-T1jQ)
