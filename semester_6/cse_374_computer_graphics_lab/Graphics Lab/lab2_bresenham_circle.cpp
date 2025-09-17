#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>

using namespace std;

double p = 4, q = 6;

void show_points(int x, int y)
{
    glBegin(GL_POINTS);

    glVertex3f(x + p, y + q, 0.0);
    glVertex3f(x + p, -y + q, 0.0);
    glVertex3f(-x + p, -y + q, 0.0);
    glVertex3f(-x + p, y + q, 0.0);

    glVertex3f(y + p, x + q, 0.0);
    glVertex3f(y + p, -x + q, 0.0);
    glVertex3f(-y + p, -x + q, 0.0);
    glVertex3f(-y + p, x + q, 0.0);

    glEnd();
    glFlush();
}

void bresenham_circle(int r) {
    int D, x, y;
    D = 3 - 2 * r;

    x = 0;
    y = r;

    while (x <= y) {
        show_points(x, y);

        if (D <= 0) {
            D = D + 4 * x + 6;
        }
        else {
            D = D + 4 * (x - y) + 10;
            y -= 1;
        }
        x++;
    }
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);

    glBegin(GL_LINES);

    bresenham_circle(5);

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
    glutInitWindowSize(600,600);
    glutInitWindowPosition(10,10);
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);

    glutCreateWindow("Line Clipping");
    init();

    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}
