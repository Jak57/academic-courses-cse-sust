/**
* Name: Jakir Hasan
* Registration no: 2018331057
*/

/**
* Find codeword of a dataword using CRC (Cyclic Redundancy Check) method
*/

#include<bits/stdc++.h>
using namespace std;

string CRC(string codeword, string divisor)
{
    /**
    * performs binary division using modulo 2 arithmetic
    * and returns remainder
    */

    int i, j, m, n;
    string remainder;
    m = codeword.size();
    n = divisor.size();

    for (i = 0; i <= m-n; )
    {
        for (j = 0; j < n; j++)
            codeword[i+j] = (codeword[i+j] == divisor[j] ? '0' : '1');

        while (i < m && codeword[i] != '1')
            i++;
    }

    remainder = codeword.substr(m-n+1, n-1);
    return remainder;
}

int main()
{
    string message, divisor, encoded = "", codeword, remainder, syndrome;
    int n, m, i, j, one;
    cout<< "Enter the message: ";
    cin>> message;

    cout<< "Enter the crc generator polynomial: ";
    cin>> divisor;
    m = message.size();
    n = divisor.size();
    encoded += message;

    // appending n-1 zeros with the given message;
    for (i = 1; i <= n-1; i++)
        encoded += '0';

    // finding remainder
    remainder = CRC(encoded, divisor);

    // appending remainder with message to generate codeword at
    // receiver side
    codeword = message + remainder;
    cout<< "Codeword is: " << codeword << "\n";

    // At receiver side, again perform binary division
    // to syndrome
    syndrome = CRC(codeword, divisor);
    cout<< "Syndrome is: " << syndrome << "\n";

    one = 0;
    // checking if there is 1 in syndrome
    for (i = 0; i < syndrome.size(); i++)
    {
        if (syndrome[i] == '1')
        {
            one++;
            break;
        }
    }

    // If we get syndrome zero, no error has occurred
    if (one == 0)
        cout<< "No error occurred during transmission." << "\n";
    else
        cout<< "Error occurred during transmission." << "\n";

    return 0;
}

/*
Example form book:

1001
1011
*/
