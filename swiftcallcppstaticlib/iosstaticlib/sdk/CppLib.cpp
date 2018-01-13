#include "CppLib.h"
#include <iostream>

int CppLib::CppAdd(int a, int b) {
    return a * b;
}

char* CppLib::CppString(const char* str) {
    std::cout << "CppLib::CppString entry:" << str << "\n";
    std::string str2(str);
    str2 += "tail";
    return (char*)str2.c_str();
}

char* CppLib::CppString2(std::string str) {
    std::cout << "CppLib::CppString2 entry:" << str << "\n";
    std::string str2(str);
    str2 += "tail";
//    return (char*)str2.c_str();
    return "fdsaf";
}
