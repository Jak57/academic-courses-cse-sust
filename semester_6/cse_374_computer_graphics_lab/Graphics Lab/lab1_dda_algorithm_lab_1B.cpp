#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>

using namespace std;

void show_point(double x, double y)
{
    glBegin(GL_POINTS);

    glVertex3f(x, y, 0.0);

    glEnd();
    glFlush();
}

void dda_algorithm(double x1, double y1, double x2, double y2)
{
    double dx, dy, step, x, y;
    int n, i;
    if (abs(x2 - x1) > abs(y2 - y1))
        step = abs(x2 - x1);
    else
        step = abs(y2 - y1);

    dx = (x2 - x1) / step;
    dy = (y2 - y1) / step;

    i = 0;
    n = int(step);
    x = x1;
    y = y1;

    while (i <= n) {
        show_point(x, y);
        x += dx;
        y += dy;
        i++;
    }
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);

    dda_algorithm(-3, 5, -5, 15);
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
