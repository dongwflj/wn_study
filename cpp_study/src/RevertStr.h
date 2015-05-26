/*
 * RevertStr.h
 *
 *  Created on: 2013-3-21
 *      Author: Ewen
 */

#ifndef REVERTSTR_H_
#define REVERTSTR_H_

class RevertStr {
public:
	RevertStr();
	virtual ~RevertStr();
	void Revert(char* aStr, int len);
	void Revert2(char* aStr, int len);
private:
	void Swap(char* a, char* b) ;
	void RevertHelp(char* aStr, int len);
};

#endif /* REVERTSTR_H_ */
