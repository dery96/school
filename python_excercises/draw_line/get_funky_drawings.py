from draw_circle import circle
import matplotlib.pyplot as plt
from random import randint

# data = circle(200, 200, [100, 100], 60, 9)
data = []
size = 5
for i in range(0, 20):
    randColor = randint(10, 100)
    randColor = randColor / 100.
    radius = randint(5 * size, 30 * size)
    randx, randy = randint(
        50 * size, 180 * size), randint(50 * size, 180 * size)
    print randx, randy
    data = circle(200 * size, 200 * size,
                  [randx, randy], radius * size, 0, randColor, data)

plt.imshow(data, interpolation='nearest')
plt.show()
