/*
 * threadpool.cpp
 *
 *  Created on: 2013-7-9
 *      Author: Ewen
 */

#include "threadpool.h"

namespace test {

void* threadpool::thread_routine(void *arg) {
    ((threadpool*)arg)->thread_func();
}
} /* namespace test */
