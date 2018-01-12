//
//  OCFile.m
//  cpptest
//
//  Created by Ewen on 18/1/12.
//  Copyright © 2018年 Ewen. All rights reserved.
//

#import "OCFile.h"
#import "CppLib.h"

@implementation OCFile

- (int)sumNum:(int)a withNum:(int)b
{
    CppLib lib;
    int ret = lib.CppAdd(a, b);
    return ret;
}

@end
