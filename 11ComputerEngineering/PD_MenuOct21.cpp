/*
Dhrumil Patel
TEJ3M
October 2019
First version of menu demo
Shows how to use a menu program
*/	

#include <iostream>
#include <conio.h>
#include <string>

using namespace std;

//***********************bytescalc*************************
void bytescalc()
{
	int size;
	cout << "How many kB is the file? ";
	cin >> size;
	if (size > 12)
    {
        cout << "Cannot process that large a number.";
    }
    else {
        cout << "The file can store " << size*1024 <<" characters";
    }
    
	cout << "This program has been terminated.";
	//cout << endl;
}

//***********************rect*************************
void rect()
{
	int length, width;
	cout << "Length: ";
	cin >> length;
	cout << "Width: ";
	cin >> width;
    if (length < 0 || width < 0)
    {
        cout << " Error";
        return;
    }
	cout << "Perimeter: " << 2 * (length + width);
	cout << "Area: " << length * width;
}

//***********************perc*************************
void perc()
{
	int mark, total;
	float percent;

    system("cls");
    cout << "What mark did you get?";
    cin >> mark;
    cout << "What was it out of";
    cin >> total;
    cin.ignore();
    percent = mark * 11.0 / total;
    if (percent >= 80)
    {
        cout << "A";
    }
    else if (percent >= 70)
    {
        cout << "B";
    }
    else if (percent >= 60)
    {
        cout << "C";
    }
    else if (percent >= 50)
    {
        cout << "D";
    }
    else if (percent <= 50)
    {
        cout << "F";
    }
}


//***********************Main Menu*************************
int main()
{ 
int choice;

    do
    {
		system ("cls");

		cout << "1.bytescalc " << "\n\n";

		cout << "2.rect " << "\n\n";

		cout << "3. perc " << "\n\n";
    
    	cout <<"0.Exit "<<"\n\n";
    	cin >>choice;
		if (choice == 1)
			bytescalc();
		else if (choice == 2)
			rect();

		else if (choice == 3)
			perc();
		
		system("cls");
		cout << endl << endl;
		getch();
		  
    }
    while (choice != 0 );
	cout << endl;
	cout <<"Goodbye!!!";
	getch();
	return (0);
}
