# In package.manifest? Maybe optionally
title: 'Calculator'
author: 'Danial Goodwin'
version: '0.2.1'
description: 'Simple calculator. Work-in-progress.'
home_page:
repo: 
license:
support: 
---

OPERATORS: '+', '-', '*', '/'

user_input_view: TextInputView
user_output_view: TextView
input_buttons: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '.', ..OPERATORS each as Button
delete_button: '<' as Button
operator_button: '=' as Button

input_buttons.each.on_click: user_input_view.text.add each.text
delete_button.on_click: user_input_view.text.remove_end 1
delete_button.on_long_click: user_input_view.text ''
operator_button.on_click: user_output_view.text solve_expression user_input_view

# TODO: Make this better, more robust
solve_expression(text):
    if OPERATORS.each not in text: return
    tokens: text.split OPERATORS
    a: tokens[0].trim
    b: tokens[1].trim
    operator: tokens.1
    user_ouptut_view.text when operator:
        '+': a + b
        '-': a - b
        '*': a * b
        '/': a / b

show
    user_output_view
    user_input_view, delete_button
    grid 4 input_buttons, operator_button
    

# The `:` basically means "define a new thing". The `:` is not used if the thing has already been created. This philosophy allows for extension functions/variables.


