/**
Topic: Bresenham's Line Drawing Algorithm
Date: 26-10-22
*/


#include<bits/stdc++.h>
using namespace std;

void plotLine(int x0, int y0, int x1, int y1)
{
    int dx, dy, D, x, y;
    dx = x1 - x0;
    dy = y1 - y0;
    D = 2*dy - dx;

    x = x0;
    y = y0;

    while (x <= x1) {
        printf("--- %d %d\n", x, y);
        if (D <= 0)
        {
            D = D + 2*dy;
        }
        else
        {
            D = D + 2*(dy-dx);
            y += 1;
        }

        x++;
    }
}

int main()
{
    int x0, y0, x1, y1;
    cin>> x0 >> y0 >> x1 >> y1;
    plotLine(x0, y0, x1, y1);

    return 0;
}

/**
0 0 4 4

0 0 4 2
*/

