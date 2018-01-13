
#ifndef CppLib_h
#define CppLib_h

#include <string>

class CppLib {
public:
    int CppAdd(int a, int b);
    char* CppString(const char* str);
    char* CppString2(std::string str);
private:
    std::string m_string;
};

#endif

