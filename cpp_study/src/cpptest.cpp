//============================================================================
// Name        : cpptest.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <memory>
#include <list>
#include <map>
#include <stdlib.h>
#include "templateclasse.h"
#include "threadpool.h"

using namespace std;

list<int> l; // 存放中间结果
void PrintSolution(); //打印结果

using namespace std;

int NKSolution(int n, int k)
{
    if (k > n) return 0;

    if (k == 1)
    {
        // found solution, print it
        l.push_back(n);
        PrintSolution();
        l.pop_back();
        return 1;
    }

    int count = 0;
    for(int i = 1; n-k*i >= 0; i++)
    {
        l.push_back(i);
        count += NKSolution(n-i-(k-1)*(i-1), k-1);
        l.pop_back();
    }

    return count;
}

int NKSolution2(int n, int k)
{
    if (k > n) return 0;

    if (k == 1)
    {
        // found solution, print it
        l.push_back(n);
        PrintSolution();
        l.pop_back();
        return 1;
    }

    int count = 0;
    for(int i = 1; n-k*i >= 0; i++)
    {
        l.push_back(i);
        count += NKSolution2(n-k*i, k-1);
        l.pop_back();
    }

    return count;
}

void PrintSolution2()
{
    std::list<int>::iterator it = l.begin();
    int previous = 0;
    while(it != l.end())
    {
        previous = *it + previous ;
        cout << previous << "  ";
        it++;
    }
    cout << endl;
    return;
}

void PrintSolution()
{
    std::list<int>::iterator it = l.begin();
    int previous = 1;
    while(it != l.end())
    {
        previous = *it + previous - 1;
        cout << previous << "  ";
        it++;
    }
    cout << endl;
    return;
}

struct treeNode {
    treeNode* left;
    treeNode* right;
};

void copystr(char* dst, const char* src, int len) {
    int *pdst = (int*)dst;
    int *psrc = (int*)src;
    int newLen = len>>2;
    for(int i=0; i<newLen; i++) {
        *pdst++ = *psrc++;
    }
    newLen = len - (newLen<<2);
    dst = (char*)pdst;
    src = (char*)psrc;
    for(int i=0; i<=newLen; i++) {
        *dst++ = *src++;
    }
}

void PrintLine1(int **m1, int startX, int startY, int m, int n) {
    for(int i=0; i<n; i++) {
        printf("%d,", *((int*)m1 + startX*m + startY+i));
    }
    printf("\n");
}

void PrintCol1(int **m1, int startX, int startY, int m, int n) {
    for(int i=1; i<m; i++) {
        printf("%d,", *((int*)m1+(startX+i)*m+startY+n-1));
    }
    printf("\n");
}

void PrintLine2(int **m1, int startX, int startY, int m, int n) {
    for(int i=n-2; i>=0; i--) {
        printf("%d,", *((int*)m1+(startX+m-1)*m+startY+i));
    }
    printf("\n");
}

void PrintCol2(int **m1, int startX, int startY, int m, int n) {
    for(int i=m-2; i>0; i--) {
        printf("%d,", *((int*)m1+(startX+i)*m+startY));
    }
    printf("\n");
}

void PrintMatrix(int **m1, int startX, int startY, int m, int n) {
    if (m<=0 || n<=0)
        return;
    PrintLine1(m1, startX, startY, m, n);
    PrintCol1(m1, startX, startY, m, n);
    PrintLine2(m1, startX, startY, m, n);
    PrintCol2(m1, startX, startY, m, n);
    PrintMatrix(m1, startX+1, startY+1, m-2, n-2);
}

int fib(int n) {
    if (n == 0) {
        return n;
    }
    int n2 = 0;
    int n1 = 0;
    int ret = 0;
    for (int i = 1; i <= n; i++) {
        if (i == 1) {
            n2 = 0;
            n1 = 1;
        }
        ret = n1 + n2;
        n2 = n1;
        n1 = ret;
    }
    return ret;
//    if (n == 1 || n == 0) {
//        return n;
//    }
//    return fib(n-1) + fib(n-2);
}

void swapstr(char *src, char *dst) {
    *src = *src ^ *dst;
    *dst = *src ^ *dst;
    *src = *src ^ *dst;
}

void reverse(char *str, int len) {
    if (len == 1 || len == 0) {
        return;
    }
    swapstr(str, str+len-1);
    reverse(str+1, len-2);
}

void MatrixRotate(int (*m)[5], int x, int y) {
    int n[5][5];
    for(int i=0; i<x; i++) {
        for(int j=0; j<y; j++) {
            n[y-1-j][i] = m[i][j];
        }
    }
    for(int i=0; i<x; i++) {
        for(int j=0; j<y; j++) {
            cout << n[i][j] << ' ';
        }
        cout << endl;
    }
}

void bubleSort(int *src, int len) {
    for(int i=0; i<len-1; i++) {
        for(int j=0; j<len-i-1; j++) {
            if(src[j] > src[j+1]) {
                std::swap(src[j], src[j+1]);
            }
        }
    }
}

class Common {
public:
     Common() {
        cout << "Common construct" << endl;
        vfunc();
    }
    virtual void vfunc() {
        cout << "Common vfunc call" << endl;
    }
};

class Base:public Common {
public:
    Base() {
        cout << "Base construct" << endl;
        vfunc();
    }
//    virtual void vfunc() {
//        cout << "Base vfunc call" << endl;
//    }
};

class Base2:public Common {
public:
    Base2() {
        cout << "Base2 construct" << endl;
        vfunc();
    }
//    virtual void vfunc() {
//        cout << "Base2 vfunc call" << endl;
//    }
};

class Derive : virtual public Base, Base2 {
public:
    Derive() {
        cout << "Derive construct" << endl;
        vfunc();
    }
    virtual void vfunc() {
        cout << "Derive vfunc call" << endl;
    }
};

void* OutPut(void *arg) {
    std::cout << (int*)arg << std::endl;
    return 0;
}

int main() {
    //NKSolution(11, 3);
//    char *src = "abcdefghi";
//    char dst[10];
//    copystr(dst, src, 9);
//    cout << dst;
//    int m[4][4] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//    PrintMatrix((int**)m, 0, 0, 4, 4);
//    for(int i=1; i<10; i++) {
//        cout << "i=" << i << endl;
//        cout << fib(i) << endl;
//    }
//    char str[100] = "abcdefghijklmn";
//    reverse(str, strlen(str));
//    cout << str << endl;
//    int m[5][5] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12,13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
//
//    MatrixRotate(m, 5, 5);
//    int data[10] = {23, 12, 34, 455,765, 566, 32, 1231,2131,321};
//    bubleSort(data, 10);
//    for(int i=0; i<10; i++) {
//        cout << data[i] << ' ';
//    }
//    Base objbase;
//    cout << sizeof(objbase) << endl;
//    Derive obj;
//    obj.vfunc();
//
//    cout << sizeof(obj);
//    map<string, string> namemap;
//    namemap["jason"] = "hello";
//    namemap["jack"] = "beis";
//    map<string, string>::iterator it = namemap.begin();
//    while(it != namemap.end()) {
//        cout << it->first << " " << it->second << endl;
//        it++;
//    }
//    test::templateclass<int> a;
//    a.test();
//    test::templateclass<int> b;
//    a = b;
    test::threadpool t;
    t.startpool();
    for(int i=0; i<100; i++) {
        t.add_worker(OutPut, (void*)i);
    }
    t.destroy();
    return 0;
}
