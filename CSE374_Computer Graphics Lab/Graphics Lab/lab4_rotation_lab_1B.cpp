/*
 * GLUT Shapes Demo
 *
 * Written by Nigel Stewart November 2003
 *
 * This program is test harness for the sphere, cone
 * and torus shapes in GLUT.
 *
 * Spinning wireframe and smooth shaded shapes are
 * displayed until the ESC or q key is pressed.  The
 * number of geometry stacks and slices can be adjusted
 * using the + and - keys.
 */
#include<windows.h>
#include<bits/stdc++.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>
#define PI 3.14159
#define COS(x) cos(x*PI/180)
#define SIN(x) sin(x*PI/180)

using namespace std;

double arr[4][2] = {
    {7, 7},
    {4, 10},
    {1, 7},
    {4, 8.5}
};

int dx, dy, dz;
double x_piv = 4, y_piv = 17;

void display(void)
{
    glClear (GL_COLOR_BUFFER_BIT);

    glColor3f (1.0, 0.0, 1.0);

    glPointSize(2);

    glBegin(GL_POINTS);
    glVertex3f(4, 17, 0);
    glEnd();

    glBegin(GL_QUADS);

    glColor3f (1.0, 1.0, 1.0);

    // quadrilateral
    glVertex3f(arr[0][0], arr[0][1], 0);
    glVertex3f(arr[1][0], arr[1][1], 0);
    glVertex3f(arr[2][0], arr[2][1], 0);
    glVertex3f(arr[3][0], arr[3][1], 0);

    glEnd();

    glFlush ();
    glutPostRedisplay();
    glutSwapBuffers();
}

/* CCW rotation */
void CCW()
{
    double x_new, y_new;
    int i;
    for (i = 0; i < 4; i++) {
        x_new = arr[i][0] - x_piv;
        y_new = arr[i][1] - y_piv;

        arr[i][0] = x_piv + (x_new * COS(1) - y_new * SIN(1));
        arr[i][1] = y_piv + (x_new * SIN(1) + y_new * COS(1));
    }
}

void CW()
{
    int i;
    double x, y;
    for (i = 0; i < 4; i++) {
        x = arr[i][0] - x_piv;
        y = arr[i][1] - y_piv;

        arr[i][0] = x_piv + (x * COS(1) + y * SIN(1));
        arr[i][1] = y_piv + (-x * SIN(1) + y * COS(1));
    }
}


void key(int key,int x,int y)
{
    switch(key)
    {
        case GLUT_KEY_UP:
            CCW();
            glutPostRedisplay();
            break;
        case GLUT_KEY_DOWN:
            CW();
            glutPostRedisplay();
            break;
        case GLUT_KEY_RIGHT:
            dx++;
            glutPostRedisplay();
            break;
        case GLUT_KEY_LEFT:
            dx--;
            glutPostRedisplay();
            break;
    }
}

/* Program entry point */

void init (void)
{
    glClearColor (0.0, 0.0, 0.0, 0.0);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-40.0, 40, -40.0, 40, -10.0, 10.0);
}

int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode (GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize (600, 600);
    glutInitWindowPosition (100, 100);
    glutCreateWindow ("Demo");
    init ();
    glutDisplayFunc(display);
    glutSpecialFunc(key);
    glutMainLoop();
    return 0;
}
