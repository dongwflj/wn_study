/*
 * templateclasse.h
 *
 *  Created on: 2013-7-9
 *      Author: Ewen
 */

#ifndef TEMPLATECLASSE_H_
#define TEMPLATECLASSE_H_
#include <iostream>
using namespace std;

namespace test {

template<class T>
class templateclass {
public:
    void test() {
        T tmp = 100;
        cout << "hello" << tmp << endl;
    }
    templateclass<T>& operator =(templateclass<T>& in) {
        cout << "operator called" << endl;
        return in;
    }
};

} /* namespace test */
#endif /* TEMPLATECLASSE_H_ */
