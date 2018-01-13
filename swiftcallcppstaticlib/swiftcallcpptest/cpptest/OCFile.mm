//
//  OCFile.m
//  cpptest
//
//  Created by Ewen on 18/1/12.
//  Copyright © 2018年 Ewen. All rights reserved.
//

#import "OCFile.h"
#import "CppLib.h"
#include <iostream>

@implementation OCFile

- (int)sumNum:(int)a withNum:(int)b
{
    CppLib lib;
    int ret = lib.CppAdd(a, b);
    return ret;
}

- (NSString*)cppString: (NSString*) str
{
    CppLib lib;
    const char *ret = lib.CppString([str UTF8String]);
//    std::string strRet = lib.CppString([str cStringUsingEncoding:NSUTF8StringEncoding]);
//    std::cout << "Object c cppString:" << strRet << std::endl;
//    NSString* ret = @"dfd";//[[NSString alloc] initWithUTF8String:strRet.c_str()];
//    NSLog(@"NString %@",ret);
    return [NSString stringWithUTF8String:ret];
}

- (NSString*)cppString2: (NSString*) str
{
    CppLib lib;
    const char* ret = lib.CppString2([str cStringUsingEncoding:NSUTF8StringEncoding]);
    return [NSString stringWithUTF8String:ret];
}
@end
