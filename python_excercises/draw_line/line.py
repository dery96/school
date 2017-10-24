#!/usr/bin/env python
# -*- coding: utf-8 -*-

'''
** Drawing line
* DDA algorithm (Digital Differential Analyzer)

# rysowanie tablicy linia ktora ma sie rysowac za tablica, musi sie ucinać
'''
import numpy as np
import matplotlib.pyplot as plt

lineColor = [0, 0, 0]
background = [1, 1, 1]


def line(startPoint, endPoint, boxSize, thickness):
    data = np.zeros((boxSize[0], boxSize[1], 3))
    data.fill(1)
    if startPoint[1] - startPoint[0] == 0:
        m = 1
    else:
        m = (endPoint[1] - startPoint[1]) / (startPoint[1] - startPoint[0])
    direction = 1 if endPoint[0] > startPoint[0] else -1
    x, y = startPoint[0], startPoint[1]

    if m < 1:
        for i in range(startPoint[0], endPoint[0] + direction, direction):
            x += 1
            y += m
            data[x, y, 0] = lineColor[0]
            data[x, y, 1] = lineColor[1]
            data[x, y, 2] = lineColor[2]

    if m > 1:
        for i in range(startPoint[1], endPoint[1] + direction, direction):
            x += i*1 / m
            y += 1
            data[x, y, 0] = lineColor[0]
            data[x, y, 1] = lineColor[1]
            data[x, y, 2] = lineColor[2]
    if m == 1:
        for i in range(startPoint[1], endPoint[1] + direction, direction):
            x += 1
            y += 1
            data[x, y, 0] = lineColor[0]
            data[x, y, 1] = lineColor[1]
            data[x, y, 2] = lineColor[2]
    plt.imshow(data, interpolation='nearest')
    plt.show()


line([70, 50], [90, 50], [100, 100], 1)
