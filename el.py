    def getBeginingPos(self):
        for i in len(self.mazeMap):
            try:
                return self.mazeMap[i].index('@')
            
