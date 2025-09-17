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
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>
#include <bits/stdc++.h>
using namespace std;

int dx, dy;
int dir = 0;
float s = 1.0, d, dd;
float x[] = {4, 1, 4, 7};
float y[] = {8.5, 7, 10, 7};
float cx = 1, cy=1, cz=1;

void setPoint(float x, float y) {
    //current center = (4+dx, 8.5+dy)
    x -= (4+dx); y -= (8.5+dy);
    float ang = dir*acos(0.0);//dir*90
    float xx = x*cos(ang) - y*sin(ang);
    float yy = x*sin(ang) + y*cos(ang);
    xx += (4+dx); yy += (8.5+dy);

    dd = sqrt((4+dx)*(4+dx) + (8.5+dy)*(8.5+dy));
    s = dd/d; //current scaling factor
    if(s > 1.0) {
        cx = 1.0;
        cy = 0.0;
        cz = 0.0;
    }
    else {
        cx = 1.0;
        cy = 1.0;
        cz = 1.0;
    }
    glVertex3f(s*xx, s*yy, 0.0f);
}

void display(void)
{
    glClear (GL_COLOR_BUFFER_BIT);

    //original d
    d = sqrt(4*4 + 8.5*8.5);

    //polygon
    glColor3f (cx, cy, cz);
    glBegin(GL_POLYGON);

    for(int i=0; i<4; i++) {
        setPoint(x[i]+dx, y[i]+dy);
    }




    glEnd(); //End quadrilateral coordinates

    glFlush ();
    glutPostRedisplay();
    glutSwapBuffers();
}

void key(int key,int x,int y)
{
    switch(key)
    {
        case GLUT_KEY_UP:
            if(dir == 0) {
                //already in up direction
                dy++;
            }
            else {
                //rotate 0*90
                dir = 0;
            }
            glutPostRedisplay();
            break;
        case GLUT_KEY_DOWN:
            if(dir == 2){
                //already in down
                dy--;
            }
            else{
                //rotate 2*90
                dir = 2;
            }
            glutPostRedisplay();
            break;
        case GLUT_KEY_RIGHT:
            if(dir == 3){
                //already in right
                dx++;
            }
            else{
                //rotate 3*90
                dir = 3;
            }
            glutPostRedisplay();
            break;
        case GLUT_KEY_LEFT:
            if(dir == 1){
                //already in left
                dx--;
            }
            else{
                //rotate 2*90
                dir = 1;
            }
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
    glOrtho(-50.0, 100, -50.0, 100, -10.0, 10.0);
}

int main(int argc, char *argv[])
{
    glutInit(&argc, argv);
    glutInitDisplayMode (GLUT_SINGLE | GLUT_RGB);
    glutInitWindowSize (1024, 1024);
    glutInitWindowPosition (100, 100);
    glutCreateWindow ("Demo");
    init ();
    glutDisplayFunc(display);
    glutSpecialFunc(key);
    glutMainLoop();
    return 0;
}

