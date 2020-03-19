# The official, organized create task

from graphics import *
import random

# Creates the graph window
win = GraphWin("Match", 500, 500)
win.setBackground("light green")

# Main Screen Function
def mainScreen():
    playButton = Rectangle(Point(200, 230), Point(300, 270))
    playButton.setFill("blue")
    playButton.draw(win)
    playText = Text(Point(250, 250), "Play")
    playText.setFill("black")
    playText.setStyle("bold")
    playText.setSize(15)
    playText.draw(win)
    
    instructions = Rectangle(Point(180, 300), Point(320, 340))
    instructions.setFill("blue")
    instructions.draw(win)
    intext = Text(Point(250, 320), "Instructions")
    intext.setFill("black")
    intext.setStyle("bold")
    intext.setSize(15)
    intext.draw(win)
    gameName = Text(Point(250, 150), "Memory Game")
    gameName.setFill("black")
    gameName.setStyle("bold")
    gameName.setSize(25)
    gameName.draw(win)
    click1 = win.getMouse()
    u = 0
    while u != 1:
        if (((click1.getX() > 200) & (click1.getX() < 300)) & ((click1.getY() > 230) & (click1.getY() < 270))) == True:
            u = 1
            playButton.undraw()
            playText.undraw()
            gameName.undraw()
            instructions.undraw()
            intext.undraw()
            gameScreen()
            n = 0
        elif (((click1.getX() > 180) & (click1.getX() < 320)) & ((click1.getY() > 300) & (click1.getY() < 340))) == True:
            u = 1
            playButton.undraw()
            playText.undraw()
            gameName.undraw()
            instructions.undraw()
            intext.undraw()
            instructionsPage()
        else:
            click1 = win.getMouse()

# Instruction Screen Function
def instructionsPage():
    header = Text(Point(250, 50), "Instructions")
    header.setFill("black")
    header.setStyle("bold")
    header.setSize(25)
    header.draw(win)
    int1 = Text(Point(250, 100), "1) The goal of the game is to match the boxes with the same")
    int1.setFill("black")
    int1.setStyle("bold")
    int1.setSize(12)
    int1.draw(win)
    int2 = Text(Point(110, 124), "numbers in them")
    int2.setStyle("bold")
    int2.setSize(12)
    int2.draw(win)
    int3 = Text(Point(230, 150), "2) Move around the boxes using the w, a, s, and d keys")
    int3.setStyle("bold")
    int3.setSize(12)
    int3.draw(win)
    int4 = Text(Point(266, 172), "w moves up, s moves down, a moves left, and d moves right")
    int4.setStyle("bold")
    int4.setSize(12)
    int4.draw(win)
    int5 = Text(Point(252, 198), "3) The game works in sets of two. The game compares every")
    int5.setStyle("bold")
    int5.setSize(12)
    int5.draw(win)
    int6 = Text(Point(130, 223), "two numbers selected. ")
    int6.setStyle("bold")
    int6.setSize(12)
    int6.draw(win)
    int7 = Text(Point(241, 247), "4) Press f to access the number inside a box. The last box")
    int7.setStyle("bold")
    int7.setSize(12)
    int7.draw(win)
    int8 = Text(Point(145, 270), "does not count in the game")
    int8.setStyle("bold")
    int8.setSize(12)
    int8.draw(win)
    mainPage = Rectangle(Point(180, 305), Point(320, 345))
    mainPage.setFill("blue")
    mainPage.draw(win)
    mainText = Text(Point(250, 325), "Home Page")
    mainText.setStyle("bold")
    mainText.setSize(15)
    mainText.setFill("black")
    mainText.draw(win)
    click = win.getMouse()
    while (((click.getX() > 180) & (click.getX() < 340)) & ((click.getY() > 295) & (click.getY() < 345))) != True:
        click = win.getMouse()
    int1.undraw()
    int2.undraw()
    int3.undraw()
    int4.undraw()
    int5.undraw()
    int6.undraw()
    int7.undraw()
    int8.undraw()
    header.undraw()
    mainPage.undraw()
    mainText.undraw()
    mainScreen()
    
    

# Game Screen Function
def gameScreen():
    c = 60
    d = 60
    for i in range(25):
        if c == 440:
            d = d + 76
            c = 60
        boxArray.append(drawBox(c, d))
        boxArray[i].draw(win)
        c = c + 76
    boxArray[0].setFill("yellow")
    numberArray1 = assignText()
    gameExecution(numberArray1, boxArray)


def gameExecution(numberArray1, boxArray):
    a = 0
    e = 0
    index1 = 0
    index2 = 0
    finalArray1 = []
    finalArray2 = []
    b = 0
    score = Text(Point(0, 0), "s")
    flip = 0
    text1 = Text(Point(0, 0), "s")
    text2 = Text(Point(0, 0), "s")
    while a != 12:
        score.undraw()
        score = Text(Point(250, 30), a)
        score.setSize(20)
        score.setStyle("bold")
        score.draw(win)
        # This prompts the user to check one of the boxes
        while flip != "f":
            flip = win.getKey()
            e = findBox(e, flip)
        if b == 0:
            text1.undraw()
        # Prints out the value of the box
        rectPoint1 = boxArray[e].getP1()
        averageX1 = rectPoint1.getX()
        rectPoint2 = boxArray[e].getP2()
        averageX2 = rectPoint2.getX()
        averageX3 = (averageX1 + averageX2)/2
        averageY1 = rectPoint1.getY()
        averageY2 = rectPoint2.getY()
        averageY3 = (averageY1 + averageY2)/2
        text1 = Text(Point(averageX3, averageY3), numberArray1[e])
        text1.setSize(23)
        if b == 0:
            text2.undraw()
        text1.draw(win)
        # Saves the value of e into a variable
        index1 = e
        flip = 0
        # Repeats the process for the second input
        while flip != "f":
            flip = win.getKey()
            e = findBox(e, flip)
        rectPoint1 = boxArray[e].getP1()
        averageX1 = rectPoint1.getX()
        rectPoint2 = boxArray[e].getP2()
        averageX2 = rectPoint2.getX()
        averageX3 = (averageX1 + averageX2)/2
        averageY1 = rectPoint1.getY()
        averageY2 = rectPoint2.getY()
        averageY3 = (averageY1 + averageY2)/2
        text2 = Text(Point(averageX3, averageY3), numberArray1[e])
        text2.setSize(23)
        text2.draw(win)
        # Saves the value of e into a variable
        index2 = e
        text1Anchor = text1.getAnchor()
        text1X = text1Anchor.getX()
        text1Y = text1Anchor.getY()
        text2Anchor = text2.getAnchor()
        text2X = text2Anchor.getX()
        text2Y = text2Anchor.getY()
        if text1X == text2X:
            if text1Y == text2Y:
                b = 0
            elif numberArray1[index1] == numberArray1[index2]:
                finalArray1.append(text1)
                finalArray2.append(text2)
                text1.undraw()
                text2.undraw()
                finalArray1[a].setFill("red")
                finalArray2[a].setFill("red")
                finalArray1[a].draw(win)
                finalArray2[a].draw(win)
                a = a + 1
                b = 1
            else:
                b = 0
        elif numberArray1[index1] == numberArray1[index2]:
            finalArray1.append(text1)
            finalArray2.append(text2)
            text1.undraw()
            text2.undraw()
            finalArray1[a].setFill("red")
            finalArray2[a].setFill("red")
            finalArray1[a].draw(win)
            finalArray2[a].draw(win)
            a = a + 1
            b = 1
        else:
            b = 0
        flip = 0
    score.undraw()
    gameScreenDelete()
    for h in range(12):
        finalArray1[h].undraw()
        finalArray2[h].undraw()
    boxArray[e].setFill("white")
    mainScreen()

# Everything below serves a purpose in the functions above
   
# Draw Box Function
def drawBox(x, y):
    box = Rectangle(Point(x, y), Point(x + 76, y + 76))
    box.setFill("white")
    return box

# Assign Text Function
def assignText():
    numberTestArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    numberBoxArray = [12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23]
    numberArray = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
    lenNumberTestArray = len(numberTestArray) 
    for k in range(lenNumberTestArray):
        numberTestArrayPop = random.randint(1, len(numberTestArray)) - 1
        newNumberArray = numberTestArray[numberTestArrayPop]
        numberArray[k] = newNumberArray
        numberTestArray.pop(numberTestArrayPop)
        numberBoxArrayPop = random.randint(1, len(numberBoxArray)) - 1
        numberArray[numberBoxArray[numberBoxArrayPop]] = newNumberArray
        numberBoxArray.pop(numberBoxArrayPop)
    numberArray[24] = 0
    return numberArray

# Find Box Function
def findBox(f, key):
    boxArray[f].setFill("white")
    if f == 24:
        f = -1
    if key == "d":
        f = f + 1
        boxArray[f].setFill("yellow")
    elif key == "a":
        f = f - 1
        boxArray[f].setFill("yellow")
    elif key == "w":
        if f <= 4:
            f = f + 20
        else:
            f = f - 5
        boxArray[f].setFill("yellow")
    elif key == "s":
        if f >= 20:
            f = f - 20
        else:
            f = f + 5
        boxArray[f].setFill("yellow")
    else:
        boxArray[f].setFill("yellow")
    return f

# Game Screen Delete Function
def gameScreenDelete():
    for j in range(25):
        boxArray[j].undraw()

# Global Variable Declarations
boxArray = []
numberArray = []
# This is the single function call that starts the entire game
mainScreen()
