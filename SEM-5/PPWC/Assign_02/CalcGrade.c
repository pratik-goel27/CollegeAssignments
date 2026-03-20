#include <stdio.h>
int main()
{
    int marks;
    char grade;
    printf("Enter the marks obtained: ");
    printf("Enter the marks obtained: ");
    scanf("%d", &marks);
    switch(marks/10) {
        case 10:
        case 9:
            if(marks >= 95) {
                grade = 'O';
            }else {
                grade = 'A';
            }
            break;
        case 8: 
            if(marks >= 81) {
                grade = 'A';
            }else {
                grade = 'B';
            }
            break;
        case 7:
            if(marks >= 71) {
                grade = 'B';
            }else {
                grade = 'C';
            }
            break;
        case 6:
            if(marks >= 61) {
                grade = 'C';
            }else {
                grade = 'D';
            }
            break;
        case 5:
            if(marks >= 51) {
                grade = 'D';
            }else {
                grade = 'E';
            }
            break;
        case 4:
            if(marks >= 40) {
                grade = 'E';
            }else {
                grade = 'F';
            }
            break;
        default:
            grade = 'F';
            break;
    }

    printf("%c", grade);
}