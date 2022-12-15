#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>

using namespace std;

int mat[10][20];
int original_color = 1, fill_color = 2;

bool if_valid(int x, int y)
{
    int color = mat[x][y];
    if (x < 1 || x > 5 || y < 1 || y > 15 || color == fill_color || color != original_color)
        return false;
    return true;
}

void set_color(int x, int y)
{
    glBegin(GL_POINTS);
    glVertex3f(x, y, 0);
    glEnd();
}

void flood_fill(int x, int y)
{
    queue< pair<int, int> > q;
    q.push(make_pair(x, y));

    while (!q.empty()) {
        x = q.front().first;
        y = q.front().second;
        q.pop();

        mat[x][y] = fill_color;
        set_color(x, y);

        if (if_valid(x+1, y)) {
            q.push(make_pair(x+1, y));
        }

        if (if_valid(x+1, y-1)) {
            q.push(make_pair(x+1, y-1));
        }

        if (if_valid(x+1, y+1)) {
            q.push(make_pair(x+1, y+1));
        }

        if (if_valid(x, y-1)) {
            q.push(make_pair(x, y-1));
        }

        if (if_valid(x, y+1)) {
            q.push(make_pair(x, y+1));
        }

        if (if_valid(x-1, y)) {
            q.push(make_pair(x-1, y));
        }

        if (if_valid(x-1, y-1)) {
            q.push(make_pair(x-1, y-1));
        }

        if (if_valid(x-1, y+1)) {
            q.push(make_pair(x-1, y+1));
        }

    }
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);

    glBegin(GL_POINTS);

    flood_fill(2, 3);

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
    int i, j;
    for (i = 1; i <= 5; i++) {
        for (j = 1; j <= 10; j++)
        {
            mat[i][j+i] = 1;
        }
    }

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
