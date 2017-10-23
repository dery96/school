```Drawing line
* DDA algorithm (Digital Differential Analyzer)
```

def line(startPoint, endPoint, color, thickness):
    m = (endPoint[1] - startPoint[1]) / (startPoint[1] - startPoint[0])
    x, y = startPoint[0], startPoint[1]
    if m < 1:
        x += 1
        m = 
    elif m > 1:
        y += 1
    elif m == 1:
        x += 1
        y += 1
    pass
m =
