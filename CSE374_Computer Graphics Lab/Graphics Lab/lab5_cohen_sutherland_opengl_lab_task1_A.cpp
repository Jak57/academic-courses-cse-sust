#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>

using namespace std;

// Rectangular window
const int x_min = 0;
const int y_min = 0;
const int x_max = 10;
const int y_max = 5;

// Region code
const int INSIDE = 0;
const int LEFT = 1;
const int RIGHT = 2;
const int BOTTOM = 4;
const int TOP = 8;

void show_line(double x1, double y1, double x2, double y2)
{
    glBegin(GL_LINES);

    glVertex3f(x1, y1, 0);
    glVertex3f(x2, y2, 0);

    glEnd();
    glFlush();
}

int region_code(double x, double y)
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
    int code1 = region_code(x1, y1);
    int code2 = region_code(x2, y2);

    bool accept = false;
    while (true) {
        if ((code1 == 0) && (code2 == 0)) {
            accept = true;
            break;
        }
        else if ((code1 & code2) != 0)
            break;

        int code_cut;
        double x, y, m;

        if (code1 == 0)
            code_cut = code2;
        else
            code_cut = code1;

        m = (y2 - y1) / (x2 - x1);
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

        if (code1 != 0) {
            x1 = x;
            y1 = y;
            code1 = region_code(x1, y1);
        }
        else {
            x2 = x;
            y2 = y;
            code2 = region_code(x2, y2);
        }
    }

    if (accept)
        show_line(x1, y1, x2, y2);
}


static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);

    glBegin(GL_LINES);

    // Rectangular window
    glVertex3f(0, 0, 0);
    glVertex3f(10, 0, 0);

    glVertex3f(10, 0, 0);
    glVertex3f(10, 5, 0);

    glVertex3f(10, 5, 0);
    glVertex3f(0, 5, 0);

    glVertex3f(0, 5, 0);
    glVertex3f(0, 0, 0);

    cohen_sutherland_clip(-3, 4, 1, 8);
    cohen_sutherland_clip(-1, 4, 4, 2);
    cohen_sutherland_clip(-1, -3, 5, 6);
    cohen_sutherland_clip(3, -2, 12, 7);
    cohen_sutherland_clip(6, 2, 6, 7);

    glEnd();
    glFlush();
}

void init(void)
{
    glClearColor(0.0, 0.0, 0.0, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-10.0, 20.0, -10.0, 20.0, -10.0, 10.0);
}

int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitWindowSize(640,480);
    glutInitWindowPosition(10,10);
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);

    glutCreateWindow("Line Clipping");
    init();

    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}

