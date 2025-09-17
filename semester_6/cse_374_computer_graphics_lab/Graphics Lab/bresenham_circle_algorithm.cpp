/**
@author: Jakir
Topic: Bresenham's Circle Algorithm
(02-11-22)
*/

#include<bits/stdc++.h>
using namespace std;

void plotCircle(int r)
{
    int x, y, d;
    x = 0;
    y = r;
    d = 3-2*r;

    while (x <= y)
    {
        printf("%d %d\n", x, y);
        if (d < 0) {
            d = d + 4*x + 6;
        }
        else {
            d = d + 4*(x-y) + 10;
            y--;
        }
        x++;
    }
}

int main()
{
    int r = 10;
    //cin>> r;
    plotCircle(r);

    return 0;
}
