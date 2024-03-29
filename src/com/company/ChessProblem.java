package com.company;

public class ChessProblem {

    int size;//容量
    int[][] board;//棋盘
    int specialROW;//特殊点横坐标
    int specialCOL;//特殊点纵坐标
    int number = 0;//L形编号

    public ChessProblem(int specialRow, int specialCol, int size) {
        this.size = size;
        this.specialCOL = specialCOL;
        this.specialROW = specialROW;
        board = new int[size][size];
    }

    //specialROW   特殊点的行下标
    //specialCOL   特殊点的列下标
    //leftRow      矩阵的左边起点行下标
    //leftCol      矩阵左边起点的列下标
    //size         矩阵的宽或者高

    public void setBoard(int specialROW, int specialCOL, int leftROW, int leftCOL, int size) {
        if (1 == size) {
            return;
        }

        int subSize = size / 2;
        number++;
        int n = number;//注意这里一定要吧number存在当前的递归层次里，否则进入下一层递归全局变量会发生改变

        //假设特殊点在左上角区域
        if (specialROW < leftROW + subSize && specialCOL < leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW, leftCOL, subSize);
        } else {
            //不在左上角，设左上角矩阵的右下角就是特殊点（和别的一起放置L形）
            board[leftROW + subSize - 1][leftCOL + subSize - 1] = n;
            setBoard(leftROW + subSize - 1, leftCOL + subSize - 1, leftROW, leftCOL, subSize);
        }

        //假设特殊点在右上方
        if (specialROW < leftROW + subSize && specialCOL >= leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW, leftCOL + subSize, subSize);
        } else {
            //不在右上方，设右上方矩阵的左下角就是特殊点（和别的一起放置L形）
            board[leftROW + subSize - 1][leftCOL + subSize] = n;
            setBoard(leftROW + subSize - 1, leftCOL + subSize, leftROW, leftCOL + subSize, subSize);
        }

        //特殊点在左下方
        if (specialROW >= leftROW + subSize && specialCOL < leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW + subSize, leftCOL, subSize);
        } else {
            //不在左下方，设左下方矩阵的右上角就是特殊点（和别的一起放置L形）
            board[leftROW + subSize][leftCOL + subSize - 1] = n;
            setBoard(leftROW + subSize, leftCOL + subSize - 1, leftROW + subSize, leftCOL, subSize);
        }

        //特殊点在右下角
        if (specialROW >= leftROW + subSize && specialCOL >= leftCOL + subSize) {
            setBoard(specialROW, specialCOL, leftROW + subSize, leftCOL + subSize, subSize);
        } else {
            //不在右下角，设右下角矩阵的左上就是特殊点（和别的一起放置L形）
            board[leftROW + subSize][leftCOL + subSize] = n;
            setBoard(leftROW + subSize, leftCOL + subSize, leftROW + subSize, leftCOL + subSize, subSize);
        }
    }


    public void printBoard(int specialRow, int specialCol, int size) {
        setBoard(specialRow, specialCol, 0, 0, size);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int N = 4;
        int specialRow = 0;
        int specialCol = 1;
        ChessProblem chessProblem = new ChessProblem(specialRow, specialCol, N);
        chessProblem.printBoard(specialRow, specialCol, N);
    }
}
