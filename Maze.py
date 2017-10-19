import copy


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

  def visited(self, x, y, mape):
    return True if mape[x][y] == '.' else False

  def getBeginingPos(self):
    for i in range(len(self.mazeMap)):
      try:
        return i, self.mazeMap[i].index('@')
      except:
        pass

  def canMove(self, x, y, mape):
    if mape[x + 1][y] == ' ' or mape[x - 1][y] == ' ' or mape[x][y + 1] == ' ' or mape[x][y - 1] == ' ':
        return True
    return False
  def moveUp(self, x, y, mape):
    if not self.visited(x - 1, y, mape) and mape[x - 1][y] != '#':
        mapee = copy.deepcopy(mape)
        print("UP")
        mapee[x - 1][y] = "." if mapee[x - 1][y] == " " else mapee[x - 1][y]
        return self.solveRecursive(x - 1, y, mapee)

  def moveRight(self, x, y, mape):
    if not self.visited(x, y + 1, mape) and mape[x][y + 1] != '#':
        mapee = copy.deepcopy(mape)
        print("RIGHT")
        mapee[x][y + 1] = "." if mapee[x][y + 1] == " " else mapee[x][y + 1]
        return self.solveRecursive(x, y + 1, mapee)

  def moveDown(self, x, y, mape):
    if not self.visited(x + 1, y, mape) and mape[x + 1][y] != '#':
        mapee = copy.deepcopy(mape)
        print("DOWN")
        mapee[x + 1][y] = "." if mapee[x + 1][y] == " " else mapee[x + 1][y]
        return self.solveRecursive(x + 1, y, mapee)

  def moveLeft(self, x, y, mape):
    if not self.visited(x, y - 1, mape) and mape[x][y - 1] != '#':
      print("LEFT")
      mapee = copy.deepcopy(mape)
      mapee[x][y - 1] = "." if mapee[x][y - 1] == " " else mapee[x][y - 1]
      return self.solveRecursive(x, y - 1, mapee)

  def solveRecursive(self, x, y, mazeMap):
    mape = copy.deepcopy(mazeMap)
    # self.show(mape)
    # self.mazeMap = mape
    self.show(mape)
    checkIfEnd = True if mape[x][y] == '$' else False
    if checkIfEnd:
      print("KONIEC")
      self.mazeMap = mazeMap
      self.show(mape)
      return self.end
    else:
      # firstly Will go every nearest possibility:
      # up -> right -> down -> left
      visited = True if mape[x][y] == '.' else False
      # mape[x][y] = '.' if mape[x][y] == ' ' else mape[x][y]
      if self.canMove(x, y, mape) and mape[x][y] != '.':
        self.moveUp(x, y, mape)
        self.moveRight(x, y, mape)
        self.moveDown(x, y, mape)
        self.moveLeft(x, y, mape)

  def show(self, mape):
    return [print(''.join(line)) for line in mape]


with open('mazeExamples/labirynt0.txt', 'r') as f:
  mapFile = [list(line.strip()) for line in f]

mapFile[0] = "".join(mapFile[0])
mapProperties = [int(x) for x in mapFile[0].split(' ')]

mapWidth, mapHeight = mapProperties[1], mapProperties[0]
a = SolveMaze(mapWidth, mapHeight, mapFile[1:])

# a.solveRecursive(a.posX, a.posY)
# for i in range(200):
a.solveRecursive(a.posX, a.posY, mapFile[1:])
a.show(a.mazeMap)

print("Wysokosc: %d, Height: %d" % (mapHeight, mapWidth))
# print(a.mazeMap[7][13])
