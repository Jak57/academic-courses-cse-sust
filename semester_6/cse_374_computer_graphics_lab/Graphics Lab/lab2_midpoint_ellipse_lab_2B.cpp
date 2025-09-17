///2018331085

#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>
#include <bits/stdc++.h>
using namespace std;

float xc, yc;

void setPixel(float x, float y)
{
    double mul = 1.0/sqrt(2);
    float xx = x * mul - y * mul + xc;
    float yy = x * mul + y * mul + yc;

    glVertex3f(xx, yy, 0);
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);
    glBegin(GL_POINTS);

    glVertex3f(0, 0, 0);
    glVertex3f(-9, 9, 0);

    float a = 10, b = 5;
    xc = -9, yc = 9;

    float x = 0, y = b;
    float aa = a*a, bb = b*b, aa2 = aa*2, bb2 = bb*2;
    float fx = 0, fy = aa2 * b;
    float p = bb - aa * b + 0.25 * aa;

    while (fx < fy) {
        setPixel(x, y);
        setPixel(x, -y);
        setPixel(-x, y);
        setPixel(-x, -y);

        x++;

        fx = fx + bb2;

        if (p < 0)
            p = p + fx + bb;
        else {
            y--;
            fy = fy - aa2;
            p = p + fx + bb - fy;
        }
    }

    setPixel(x, y);
    setPixel(x, -y);
    setPixel(-x, y);
    setPixel(-x, -y);

    p = bb * (x + 0.5) * (x + 0.5) - aa * (y-1) * (y - 1) - aa * bb;

    while (y > 0) {
        y--;
        fy = fy - aa2;
        if (p >= 0)
            p = p - fy + aa;
        else {
            x++;
            fx = fx + bb2;
            p = p + fx - fy + aa;
        }
        setPixel(x, y);
        setPixel(x, -y);
        setPixel(-x, y);
        setPixel(-x, -y);
    }

    glEnd();
    glFlush();

}

void init()
{
    glClearColor(0, 0, 0, 0);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-20, 20, -20, 20, -10, 10);
}


int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitWindowSize(1024,1024);
    glutInitWindowPosition(10,10);
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);

    glutCreateWindow("Demo");
    init();
    glutDisplayFunc(display);
    glutMainLoop();

    return EXIT_SUCCESS;
}
