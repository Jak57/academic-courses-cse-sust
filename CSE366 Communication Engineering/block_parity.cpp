/**
* Name: Jakir Hasan
* Registration no: 2018331057
*/

/**
* 4x8 block even parity error detection
*/

#include<bits/stdc++.h>
using namespace std;

void row_parity(int arr[][9])
{
    /**
    * Calculate row wise parity of each 8 bit data words
    */

    int i, j, cnt;
    for (i = 0; i < 4; i++)
    {
        cnt = 0;
        for (j = 0; j < 8; j++)
            cnt += arr[i][j];
        arr[i][j] = cnt%2;
    }
}

void column_parity(int arr[][9])
{
    /**
    * Calculate column wise parity of each 8 bit data words
    */
    int i, j, cnt;
    for (j = 0; j < 9; j++)
    {
        cnt = 0;
        for (i = 0; i < 4; i++)
            cnt += arr[i][j];
        arr[i][j] = cnt%2;
    }
}

int main()
{
    int sender_data[5][9], receiver_data[5][9];
    int i, j, pos_i, pos_j;
    bool error;

    // getting sender data
    for (i = 0; i < 4; i++)
        for (j = 0; j < 8; j++)
            cin>> sender_data[i][j];

    // calculating row and column wise parity
    // of sender data
    row_parity(sender_data);
    column_parity(sender_data);

    cout<< "\nSender data with even parity:" << "\n";
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 9; j++)
            cout<< sender_data[i][j] << " ";
        cout<< "\n";
    }

    // If sender data is received without error
    for (i = 0; i < 4; i++)
    {
        for (j = 0; j < 8; j++)
            receiver_data[i][j] = sender_data[i][j];
    }

    row_parity(receiver_data);
    column_parity(receiver_data);

    cout<< "\nIf sender data is received without error, received data will be:" << "\n";
    for (i = 0; i < 5; i++)
    {
        for (j = 0; j < 9; j++)
            cout<< receiver_data[i][j] << " ";
        cout<< "\n";
    }

    // checking parity of sender and received data
    error = false;
    pos_i = pos_j = -1;

    // checking row parity of sender and receiver data
    for (j = 0; j < 7; j++)
    {
        if (sender_data[4][j] != receiver_data[4][j])
        {
            error = true;
            pos_j = j;
        }
    }

    // checking column parity of sender and receiver
    for (i = 0; i < 4; i++)
    {
        if (sender_data[i][8] != receiver_data[i][8])
        {
            error = true;
            pos_i = i;
        }
    }

    if (!error)
        printf("Sender data received with no error\n");
    else
        printf("Bits at position (%d, %d) changed\n", pos_i, pos_j);

    return 0;
}

/*
Input data:

1 0 1 1 0 1 0 1
0 1 0 0 1 0 0 1
1 0 0 1 0 1 1 1
1 1 0 0 1 1 0 0

*/
