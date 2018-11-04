#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 29 15:27:47 2018

@author: oksanas
"""


from urllib.request import urlopen
#%%
def getMaxOrder(x1):
    order =0
    for x in x1:
        res=x.split("^")
        if len(res)>1:
            order= max(order,int(res[1]))
    return order

def getCoefficients(arr1, maxOrder):
    res = [0 for i in range(maxOrder+1)]
    for x in arr1:
        r1=x.split("^")
        if len(r1)>1:
            p1 = r1[1]
            p2 = r1[0].split("x")
            if len(p2[0].strip())==0:
                res[int(p1)]=1
            else:
                res[int(p1)] = int(p2[0])
        elif "x" in r1[0]:
            if len(r1[0].strip())>1:
                res[1] = int(r1[0].split("x")[0])
            else:
                res[1] = 1
        else:
            res[0]=int(r1[0])    
    return res      

def sumPolynom(arr1, arr2, maxOrder):
    arr3 = [0 for i in range(maxOrder+1)]
    i=0
    for x1,x2 in zip(arr1,arr2):
        arr3[i] = x1 + x2
        i=i+1
    print("arr3=",arr3)
    return arr3

def multiplyPolynom(arr1, arr2, maxOrder):
    print("multiply max order: ", maxOrder)
    arr3 = [0 for i in range(maxOrder+2)]
    for i in range(len(arr1)):
        for j in range(len(arr2)):
            arr3[i+j] += (arr1[i]*arr2[j]) 
    print("arr3=", arr3)
    return arr3

def printPolynom(arr):
    polynomStr=""
    for i in range(len(arr)):
        if(arr[i]!=0):
            if i==0:
                polynomStr = polynomStr + str(arr[0])
                polynomStr = polynomStr + "+"
            elif i==1:
                polynomStr = polynomStr +str(arr[1])
                polynomStr = polynomStr + "x+"
            else:
                polynomStr = polynomStr + str(arr[i])
                polynomStr = polynomStr + "x"
                polynomStr = polynomStr + "^"
                polynomStr = polynomStr + str(i)
                polynomStr = polynomStr + "+"
    return print(polynomStr[:len(polynomStr)-1])


#%%
p1="4x^5 + 3x^4 + x^2 + 5"
p2="5x^4 + 3x^3 + x + 1"

x1 = p1.split("+")
print("x1=",x1)
x2 = p2.split("+")
print("x2=",x2)
    
n = max(getMaxOrder(x2), getMaxOrder(x1))
print("Max order = ", n)
print(getCoefficients(x1, n))
print(getCoefficients(x2, n))
arr = sumPolynom(getCoefficients(x1, n), getCoefficients(x2, n), n)
print("sum polynom: ", arr)
printPolynom(arr)
arr2 = multiplyPolynom(getCoefficients(x1, n), getCoefficients(x2, n), getMaxOrder(x2)+getMaxOrder(x1))
print("multiply polynom:", arr2)
printPolynom(arr2)
#%%
    
    

#def fetch_words():
#    with urlopen('http://sixty-north.com/c/t.txt') as story:
#        story_worlds = []
#        for line in story:
#            line_words = line.split()
#            for word in line_words:
#                story_worlds.append(word)
#     
#    for word in story_worlds:
#        print(word)
            
print("=============\n")
