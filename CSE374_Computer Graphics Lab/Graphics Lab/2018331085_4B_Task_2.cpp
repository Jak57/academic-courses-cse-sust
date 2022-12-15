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
float x[] = {4, 1, 4, 7};
float y[] = {8.5, 7, 10, 7};

void setPoint(float x, float y) {
    x -= (4+dx); y -= (8.5+dy);
    float ang = dir*90.0*acos(-1.0)/180;
    float xx = x*cos(ang) - y*sin(ang);
    float yy = x*sin(ang) + y*cos(ang);
    xx += (4+dx); yy += (8.5+dy);
    //cout<<fixed<<setprecision(2)<<xx<<","<<yy<<" "<<ang<<endl;
    glVertex3f(xx, yy, 0.0f);
}

void display(void)
{
    glClear (GL_COLOR_BUFFER_BIT);

    //polygon
    glColor3f (1.0, 1.0, 1.0);
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
    //cout <<"pre " << dir << endl;
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

    //cout <<"Now " << dir << endl;
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
    glutInitWindowSize (600, 600);
    glutInitWindowPosition (100, 100);
    glutCreateWindow ("Demo");
    init ();
    glutDisplayFunc(display);
    glutSpecialFunc(key);
    glutMainLoop();
    return 0;
}

