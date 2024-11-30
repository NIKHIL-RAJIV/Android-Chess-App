package com.example.chess17;

public class Bishop extends Pieces
{
    private char color;
    public  Bishop(char c, int num)
    {
        this.color = c;
        this.num = num;
        name = color + "B";
    }

    public void move(Pieces[][] gameBoard, int fromR, int fromC, int toR, int toC)
    {
        gameBoard[fromR][fromC] = null;
        gameBoard[toR][toC] = new Bishop(color,num);
    }


    public boolean isValid(Pieces[][] gameBoard, int fromR, int fromC, int toR, int toC)
    {
        if ((Math.abs(fromR - toR) == Math.abs(fromC - toC) ) && fromR != toR && fromC != toC)
        {
            if(gameBoard[toR][toC] != null && gameBoard[toR][toC].name.charAt(0) == color)
                return false;

            while(fromR != toR && fromC != toC)
            {
                if(fromR > toR && fromC < toC)
                {
                    fromR--;
                    fromC++;

                    if(fromR != toR && gameBoard[fromR][fromC] != null)
                        return false;

                }
                else if(fromR < toR && fromC > toC)
                {
                    fromR++;
                    fromC--;

                    if(fromR != toR && gameBoard[fromR][fromC] != null)
                        return false;
                }
                else if(fromR > toR && fromC > toC)
                {
                    fromR--;
                    fromC--;

                    if(fromR != toR && gameBoard[fromR][fromC] != null)
                        return false;
                }
                else
                {
                    fromR++;
                    fromC++;

                    if(fromR != toR && gameBoard[fromR][fromC] != null)
                        return false;
                }
            }

            return true;
        }

        return false;
    }
}