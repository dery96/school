from copy import deepcopy
class SolveMaze(object):
    """docstring for SolveMaze."""

    def __init__(self, width, height, mazeMap):
        super(SolveMaze, self).__init__()
        self.width = width
        self.height = height
        self.mazeMap = mazeMap
        self.solves = []
        self.posX, self.posY = self.getBeginingPos()[
                                                   0], self.getBeginingPos()[1]
        self.end = "It's end \n %s" % (self.mazeMap)

    def checkIfEnd(self, x, y):
        return True if self.mazeMap[x][y] == '$' else False

    def visited(self, x, y, mazeMap):
        return True if mazeMap[x][y] == '.' else False

    def getBeginingPos(self):
        for i in range(len(self.mazeMap)):
            try:
                return i, self.mazeMap[i].index('@')
            except:
                pass

    def solveRecursive(self, x, y, mazeMap):
        self._solveRecursive(x, y, mazeMap)
        dots_count_list = []
        for i in self.solves:
            solve_case = [j.count('.') for j in i]
            dots_count_list.append(sum(solve_case))

        get_min_case_of_dots = min(dots_count_list)
        get_index_of_min = dots_count_list.index(get_min_case_of_dots)
        print("From %d cases the best is: \n" % (len(self.solves)))
        self.show(self.solves[get_index_of_min])
    def _solveRecursive(self, x, y, mazeMap):
        # firstly Will go every nearest possibility:
        # up -> right -> down -> left
        checkIfEnd = True if mazeMap[x][y] == '$' else False
        # print("(%d, %d)" % (x, y))
        if checkIfEnd:
            mape = deepcopy(mazeMap)
            self.solves.append(mape)
        else:
            mazeMap[x][y] = '.' if mazeMap[x][y] == ' ' else mazeMap[x][y]
            visited = True if mazeMap[x][y] == '.' else False
            # mape = deepcopy(mazeMap)
            if not self.visited(x - 1, y, mazeMap) and mazeMap[x - 1][y] != '#':
                # moveUp
                # mape = deepcopy(mazeMap)
                # mazeMap[x-1][y] = '.' if mazeMap[x-1][y] == ' ' else mazeMap[x-1][y]
                self._solveRecursive(x - 1, y, mazeMap)

            if not self.visited(x, y + 1, mazeMap) and mazeMap[x][y + 1] != '#':
                # moveRight
                # mape = deepcopy(mazeMap)
                # mazeMap[x][y+1] = '.' if mazeMap[x][y+1] == ' ' else mazeMap[x][y+1]
                self._solveRecursive(x, y + 1, mazeMap)

            if not self.visited(x + 1, y, mazeMap) and mazeMap[x + 1][y] != '#':
                # moveDown
                # mape = deepcopy(mazeMap)
                # mazeMap[x+1][y] = '.' if mazeMap[x+1][y] == ' ' else mazeMap[x+1][y]
                self._solveRecursive(x + 1, y, mazeMap)

            if not self.visited(x, y - 1, mazeMap) and mazeMap[x][y - 1] != '#':
                # moveRight
                # mape = deepcopy(mazeMap)
                # mazeMap[x][y-1] = '.' if mazeMap[x][y-1] == ' ' else mazeMap[x][y-1]
                self._solveRecursive(x, y - 1, mazeMap)

    def show(self, array):
        return [print(''.join(line)) for line in array]

with open('mazeExamples/labirynt0.txt', 'r') as f:
    mapFile = [list(line.strip()) for line in f]

mapFile[0] = "".join(mapFile[0])
mapProperties = [ int(x) for x in mapFile[0].split(' ') ]

mapWidth, mapHeight = mapProperties[1], mapProperties[0]
a = SolveMaze(mapWidth, mapHeight, mapFile[1:])
a.solveRecursive(a.posX, a.posY, mapFile[1:])
