/**
@author: jakir
Topic: DDA Algorithm
(26-10-22)
*/

#include<bits/stdc++.h>
using namespace std;

void plotLine(double x0, double y0, double x1, double y1)
{
    double dx, dy, x, y, step;
    int i, j;
    dx = x1 - x0;
    dy = y1 - y0;

    if (abs(dx) >= abs(dy))
        step = abs(dx);
    else
        step = abs(dy);

    dx /= step;
    dy /= step;
    i = 0;
    x = x0;
    y = y0;

    while (i <= int(step)) {
        printf("--- %d %d\n", int(x), int(y));
        x += dx;
        y += dy;
        i++;
    }
}

int main()
{
    double x0, y0, x1, y1;
    cin>> x0 >> y0 >> x1 >> y1;

    plotLine(x0, y0, x1, y1);

    return 0;
}

/**
2 3 6 15
*/
