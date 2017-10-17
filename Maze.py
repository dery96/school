
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

    def visited(self, x, y):
        return True if self.mazeMap[x][y] == '.' else False

    def getBeginingPos(self):
        for i in range(len(self.mazeMap)):
            try:
                return i, self.mazeMap[i].index('@')
            except:
                pass

    def solveRecursive(self, x, y, mazeMap):
        checkIfEnd = True if mazeMap[x][y] == '$' else False
        print("(%d, %d)" % (x, y))
        if checkIfEnd:
            print("KONIEC")
            return self.end
        else:
            # firstly Will go every nearest possibility:
            # up -> right -> down -> left
            visited = True if mazeMap[x][y] == '.' else False
            mazeMap[x][y] = '.' if mazeMap[x][y] == ' ' else mazeMap[x][y]
            if not visited and mazeMap[x - 1][y] != '#':
                print("UP")
                # self.mazeMap[x + 1][y] = "."
                return self.solveRecursive(x - 1, y, mazeMap)
            elif not visited and mazeMap[x][y + 1] != '#':
                print("RIGHT")
                # self.mazeMap[x][y + 1] = '.'
                return self.solveRecursive(x, y + 1, mazeMap)
            elif not visited and mazeMap[x + 1][y] != '#':
                print("DOWN")
                # self.posX, self.posY = x - 1, y
                # self.mazeMap[x - 1][y] = '.'
                return self.solveRecursive(x + 1, y, mazeMap)
            elif not self.visited(x, y - 1) and mazeMap[x][y - 1] != '#':
                print("LEFT")
                # self.posX, self.posY = x, y - 1
                # self.mazeMap[x][y - 1] = '.'
                return self.solveRecursive(x, y - 1, mazeMap)

    def show(self):
        return [print(''.join(line)) for line in self.mazeMap]

with open('mazeExamples/labirynt0.txt', 'r') as f:
    mapFile = [list(line.strip()) for line in f]

mapFile[0] = "".join(mapFile[0])
mapProperties = [ int(x) for x in mapFile[0].split(' ') ]

mapWidth, mapHeight = mapProperties[1], mapProperties[0]
a = SolveMaze(mapWidth, mapHeight, mapFile[1:])

# a.solveRecursive(a.posX, a.posY)
# for i in range(200):
a.solveRecursive(a.posX, a.posY, mapFile[1:])

a.show()
print("Wysokosc: %d, Height: %d" %(mapHeight, mapWidth))
# print(a.mazeMap[7][13])
