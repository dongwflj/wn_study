/*
 * RevertStr.cpp
 *
 *  Created on: 2013-3-21
 *      Author: Ewen
 */

#include "RevertStr.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

RevertStr::RevertStr() {
	// TODO Auto-generated constructor stub

}

RevertStr::~RevertStr() {
	// TODO Auto-generated destructor stub
}

void RevertStr::Swap(char* a, char* b) {
	char tmp = *a;
	*a = *b;
	*b = tmp;
}

void RevertStr::RevertHelp(char* aStr, int len) {
	for (int i=0; i<len/2; i++) {
		Swap(aStr+i, aStr+len-i-1);
	}
}

void RevertStr::Revert(char* aStr, int len) {
	RevertHelp(aStr, len);
	printf("%s\n", aStr);
	int flag = 0;
	for (int j=0; j<=len; j++) {
		if ( j == len || *(aStr+j) == ' ') {
			RevertHelp(aStr+flag, j-flag);
			flag = j+1;
		}
	}
}

//void RevertStr::Insert2Head(char* aTail, char* aHead) {
//
//	for (char* i=aTail-1; i>aHead; i--) {
//
//	}
//}

void RevertStr::Revert2(char* aStr, int len) {
	char* head = aStr;
	char* tail = aStr + len;
	for (int i=len; i>0; i--) {
		if (*tail == ' ') {

		}
	}
}
