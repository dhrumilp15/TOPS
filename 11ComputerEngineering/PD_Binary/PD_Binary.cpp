/*
Dhrumil Patel
TEJ3M
October 2019
PD_MenuOct21
Menu Time!
*/

#include <iostream>
// #include <conio.h>
#include <string>

using namespace std;

int main()
{
	int Z, power = 128;
	do
	{
		cout << "Enter a number between 0-255: ";
		cin >> Z;
	} while (Z < 0 || Z > 255);
	
	while (power >= 1)
	{
		if (Z >= power)
		{
			cout << "1";
			Z -= power;
		}
		else
		{
			cout << "0";
			power /= 2;
		}
	}
	cout << "\n";
	return 0;
}