#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>

using namespace std;

void show_point(int x, int y)
{
    glBegin(GL_POINTS);
    glVertex3f(x, y, 0.0);
    glEnd();
    glFlush();
}

void bresenham_line(int x1, int y1, int x2, int y2)
{
    int x, y, dx, dy, D;
    dx = x2 - x1;
    dy = y2 - y1;
    D = 2 * dy - dx;

    x = x1;
    y = y1;
    while (x <= x2) {
        show_point(-y, x);

        if (D <= 0) {
            D = D + 2 * dy;
        }
        else {
            D = D + 2 * (dy - dx);
            y += 1;
        }
        x += 1;
    }
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);

    int x1 = 8, y1 = 3, x2 = 15, y2 = 5;

    glBegin(GL_LINES);

    bresenham_line(x1, y1, x2, y2);

    glEnd();
    glFlush();
}

void init(void)
{
    glClearColor(0.0, 0.0, 0.0, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-20.0, 20.0, -20.0, 20.0, -10.0, 10.0);
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
