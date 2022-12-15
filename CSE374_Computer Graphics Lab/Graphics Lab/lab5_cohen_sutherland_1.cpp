#include<bits/stdc++.h>
using namespace std;

// Window
const int x_min = 4;
const int y_min = 4;
const int x_max = 10;
const int y_max = 8;

const int INSIDE = 0;
const int LEFT = 1;
const int RIGHT = 2;
const int BOTTOM = 4;
const int TOP = 8;

int compute_code(double x, double y)
{
    int code = INSIDE;
    if (x < x_min)
        code |= LEFT;
    else if (x > x_max)
        code |= RIGHT;

    if (y < y_min)
        code |= BOTTOM;
    else if (y > y_max)
        code |= TOP;

    return code;
}


void cohen_sutherland_clip(double x1, double y1, double x2, double y2)
{
    int code1 = compute_code(x1, y1);
    int code2 = compute_code(x2, y2);

    //printf("%d %d\n", code1, code2);
    bool accept = false;
    while (true) {
        if (code1 == 0 && code2 == 0) {
            accept = true;
            break;
        }
        else if (code1 & code2 != 0)
            break;

        int code_cut;
        double x, y;

        if (code1 != 0)
            code_cut = code1;
        else
            code_cut = code2;

        double m = (y2 - y1) / (x2 - x1);
        if (code_cut & LEFT) {
            x = x_min;
            y = y1 + m * (x - x1);
        }
        else if (code_cut & RIGHT) {
            x = x_max;
            y = y1 + m * (x - x1);
        }
        else if (code_cut & BOTTOM) {
            y = y_min;
            x = x1 + (1 / m) * (y - y1);
        }
        else if (code_cut & TOP) {
            y = y_max;
            x = x1 + (1 / m) * (y - y1);
        }

        if (code1) {
            x1 = x;
            y1 = y;
            code1 = compute_code(x1, y1);
        }
        else {
            x2 = x;
            y2 = y;
            code2 = compute_code(x2, y2);
        }
    }

    if (accept) {
        printf("Line accepted from (%.2lf, %.2lf) to (%.2lf, %.2lf)\n", x1, y1, x2, y2);
    }
    else
        printf("Line is rejected\n");
}

int main()
{
    cohen_sutherland_clip(5, 5, 7, 7);
    cohen_sutherland_clip(7, 9, 11, 4);
    cohen_sutherland_clip(1, 5, 4, 1);

    return 0;
}
