#!/usr/bin/env python
# -*- coding: utf-8 -*-

# anti-aliasing dla linii mozna zrobic na dodatkowe punkty
# x sin(x) * r ale jakosc okregu jest roznawa
# czas wykorzystania funkcji, nie bierzcie pod uwage matplotliba

import numpy as np
# import matplotlib.pyplot as plt


def xfitTest(x, r, data):
    return True if x > 0 and x < data.shape[0] else False


def yfitTest(y, r, data):
    return True if y > 0 and y < data.shape[1] else False


def getLineColor(color=[0.3, 0.3, 0.3]):
    return color


def circle(n, m, O, r, fill, color, data=[]):
    lineColor = getLineColor()
    if data == []:
        data = np.zeros((n, m, 3))
        data.fill(1)
    x0, y0 = O[0], O[1]
    for x in range(x0 - r, x0 + r):
        for y in range(y0 - r, y0 + r):
            if xfitTest(y, r, data) and yfitTest(x, r, data):
                m = ((x - x0) ** 2 + (y - y0) ** 2)
                if fill == 0:
                    if m > (r ** 2) - 2 * r and m <= (r ** 2) + r:
                        data[x, y, 0] = lineColor[0]
                        data[x, y, 1] = lineColor[1]
                        data[x, y, 2] = lineColor[2]
                else:
                    if m <= r ** 2:
                        data[x, y, 0] = lineColor[0]
                        data[x, y, 1] = lineColor[1]
                        data[x, y, 2] = lineColor[2]

    # plt.imshow(data, interpolation='nearest')
    # plt.show()
    return data


# circle(200, 200, [100, 100], 60, 9)
