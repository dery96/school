
class SolveMaze(object):
    """docstring for SolveMaze."""

    def __init__(self, width, height, mazeMap):
        super(SolveMaze, self).__init__()
        self.width = width
        self.height = height
        self.mazeMap = mazeMap
        self.posX, self.posY = self.getBeginingPos()[
                                                   0], self.getBeginingPos()[1]
        self.end = "It's end \n %s" % (self.mazeMap)

    def checkIfEnd(self, x, y):
        return True if self.mazeMap[x][y] == '$' else False

    def testPos(self, x, y):
        return True if y < self.width - 1 and x < self.height - 1 else False

    def getBeginingPos(self):
        for i in range(len(self.mazeMap)):
            try:
                return i, self.mazeMap[i].index('@')
            except:
                pass

    def solveRecursive(self, x, y):
        print("(%d, %d)" % (x, y))
        if self.checkIfEnd(x, y):
            return self.end
        else:
            if self.mazeMap[x][y] != '#':
                # firstly Will go every nearest possibility:
                # up -> right -> down -> left
                if self.testPos(x + 1, y) and self.mazeMap[x + 1][y] != '#':
                    print("UP")
                    self.posX, self.posY = x + 1, y
                    self.mazeMap[x + 1][y] = "."
                    # return self.solveRecursive(x + 1, y)
                elif self.testPos(x, y + 1) and self.mazeMap[x][y + 1] != '#':
                    print("RIGHT")
                    self.posX, self.posY = x, y + 1
                    self.mazeMap[x][y + 1] = '.'
                    # return self.solveRecursive(x, y + 1)
                elif self.testPos(x - 1, y) and self.mazeMap[x - 1][y] != '#':
                    print("DOWN")
                    self.posX, self.posY = x - 1, y
                    self.mazeMap[x - 1][y] = '.'
                    # return self.solveRecursive(x - 1, y)
                elif self.testPos(x, y - 1) and self.mazeMap[x][y - 1] != '#':
                    print("LEFT")
                    self.posX, self.posY = x, y - 1
                    self.mazeMap[x][y - 1] = '.'
                    # return self.solveRecursive(x, y - 1)
                else:
                    pass

    def show(self):
        return [print(''.join(line)) for line in self.mazeMap]

with open('mazeExamples/labirynt0.txt', 'r') as f:
    mapFile = [list(line.strip()) for line in f]

mapFile[0] = "".join(mapFile[0])
mapProperties = [ int(x) for x in mapFile[0].split(' ') ]

mapWidth, mapHeight = mapProperties[1], mapProperties[0]
a = SolveMaze(mapWidth, mapHeight, mapFile[1:])

for i in range(20):
    a.solveRecursive(a.posX, a.posY)

a.show()
