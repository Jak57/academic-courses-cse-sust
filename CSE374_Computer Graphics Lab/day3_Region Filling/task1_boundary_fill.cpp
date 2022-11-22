#include<bits/stdc++.h>
#include<windows.h>
#ifdef __APPLE__
#include <GLUT/glut.h>
#else
#include <GL/glut.h>
#endif

#include <stdlib.h>
using namespace std;

const int boundary_color = 1, new_color = 2;
int mat[10][20];

bool is_valid(int x, int y)
{
    int current_color = mat[x][y];
    if (x < 1 || x > 5 || y < 1 || y > 15 || current_color == boundary_color || current_color == new_color)
        return false;
    return true;
}

void boundary_fill_algorithm(int x, int y)
{
    queue<pair<int, int>> pq;
    pq.push(make_pair(x, y));

    while(!pq.empty())
    {
        x = pq.front().first;
        y = pq.front().second;
        pq.pop();

        mat[x][y] = new_color;

        if (is_valid(x-1, y))
            pq.push(make_pair(x-1, y));

        if (is_valid(x+1, y))
            pq.push(make_pair(x+1, y));

        if (is_valid(x, y-1))
            pq.push(make_pair(x, y-1));

        if (is_valid(x, y+1))
            pq.push(make_pair(x, y+1));
    }
}

static void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);
    glColor3f(1.0, 1.0, 1.0);
    glBegin(GL_POINTS);

    int i, j;
    for (i = 1; i <= 10; i++)
    {
        for (j = 1; j <= 20; j++) {

            if (mat[i][j] == new_color)
            glVertex3f(i, j, 0.0);
        }
    }

    glEnd();
    glFlush();
}

void init()
{
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(-20.0, 20.0, -20.0, 20.0, -10.0, 10.0);
}


/* Program entry point */

int main(int argc, char *argv[])
{
    int i, j, seed_x = 2, seed_y = 7, old_color;

    for (i = 1; i <= 5; i++) {
        for (j = 1; j <= 10; j++)
        {
            if (i == 1 || i == 5) {
                mat[i][j+i] = 1;
            }
            else {
                if (j == 1 || j == 10) {
                    mat[i][j+i] = 1;
                }
            }
        }
    }

    old_color = mat[seed_x][seed_y];
    for (i = 1; i <= 10; i++)
    {
        for (j = 1; j <= 20; j++) {
            cout<< mat[i][j] << " ";
        }
        cout<< "\n";
    }
    boundary_fill_algorithm(seed_x, seed_y);
    cout<< "\n\n";

    for (i = 1; i <= 10; i++)
    {
        for (j = 1; j <= 20; j++) {
            cout<< mat[i][j] << " ";
        }
        cout<< "\n";
    }

    glutInit(&argc, argv);
    glutInitWindowSize(640,480);
    glutInitWindowPosition(10,10);
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);

    glutCreateWindow("GLUT Shapes");

    init();
    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}
