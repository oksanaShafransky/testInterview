#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov  4 12:03:39 2018

@author: oksanas
"""

#simple_calculator

def add(x,y):
    return x+y

def subtract(x,y):
    return x-y

def multiply(x,y):
    return x*y

def divide(x,y):
    if num2==0:
        raise ValueError("Cannot divide with 0")
    return (x / y)

import sys

while 1:
    print("Select operation \n1) add \n2) subtract \n3) multipfy \n4) divide \n5) exit")
    choice = int(input())
    if choice == 5:
        sys.exit("bye bye")
    elif choice >=1 and choice <=4:    
        try:
            num1 = int(input("Input first number: "))
            num2 = int(input("Input second number: "))
        except ValueError as e:
            print("Invalid input: {}".format(str(e)))
            continue

    if choice == 1:
        print(num1,"+",num2,"=",add(num1,num2))
    elif choice == 2:
        print(num1,"-",num2,"=",subtract(num1,num2))
    elif choice == 3:
        print(num1,"*",num2,"=",multiply(num1,num2))
    elif choice == 4:
        try:
            print(num1,"/",num2,"=",divide(num1,num2))
        except ValueError as e:
            print("Error: {}".format(str(e)))
    else:
        print("Invalid input")
    
