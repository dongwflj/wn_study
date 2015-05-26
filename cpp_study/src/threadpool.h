/*
 * threadpool.h
 *
 *  Created on: 2013-7-9
 *      Author: Ewen
 */

#ifndef THREADPOOL_H_
#define THREADPOOL_H_


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <pthread.h>
#include <assert.h>
#include <iostream>

namespace test {

typedef void* (*Process) (void * arg);


typedef struct worker
{
     Process p;
     void *arg;/*回调函数的参数*/
     struct worker *next;
} CThread_worker;

class threadpool {
public:
    int add_worker(Process func, void *arg) {
        CThread_worker * worker = (CThread_worker*) malloc (sizeof(CThread_worker));
        worker->p = func;
        worker->arg = arg;
        worker->next = NULL;
        pthread_mutex_lock(&queue_lock);
        CThread_worker *member = queue_head;
        if(member != NULL) {
            while(member->next != NULL) {
                member = member->next;
            }
            member->next = worker;
        }
        else {
            queue_head = worker;
        }
        assert(queue_head != NULL);
        cur_queue_size++;
        pthread_mutex_unlock(&queue_lock);
        pthread_cond_signal(&queue_ready);
        return 0;
    }
    static void* thread_routine(void *arg);

    void startpool() {
        pthread_mutex_init(&queue_lock, NULL);
        pthread_cond_init(&queue_ready, NULL);
        queue_head = NULL;
        max_thread_num = 10;
        cur_queue_size = 0;
        shutdown = 0;

        threadid = (pthread_t *) malloc (max_thread_num * sizeof (pthread_t));
        for(int i=0; i< max_thread_num; i++) {
            pthread_create(&threadid[i], NULL, thread_routine, this);
        }
    }
    void thread_func() {
        while(1) {
            pthread_mutex_lock(&queue_lock);
            while(cur_queue_size == 0 && !shutdown) {
                pthread_cond_wait(&queue_ready, &queue_lock);
            }
            std::cout << "Get a job" << std::endl;
            if(shutdown) {
                pthread_mutex_unlock(&queue_lock);
                pthread_exit(NULL);
            }
            cur_queue_size--;
            CThread_worker *worker = queue_head;
            queue_head = queue_head->next;
            pthread_mutex_unlock(&queue_lock);
            (*(worker->p))(worker->arg);
            free(worker);
            worker=NULL;
        }
        pthread_exit(NULL);
    }
    void destroy() {
        if(shutdown == 1) {
            return;
        }
        shutdown = 1;
        pthread_cond_broadcast(&queue_ready);
        for(int i=0; i<max_thread_num; i++) {
            pthread_join(threadid[i], NULL);
        }
        free(threadid);

        // destroy task queue
        pthread_mutex_destroy(&queue_lock);
        pthread_cond_destroy(&queue_ready);

    }
private:
      pthread_mutex_t queue_lock;
      pthread_cond_t queue_ready;
      CThread_worker *queue_head;
      int shutdown;
      pthread_t *threadid;
      /*线程池中允许的活动线程数目*/
      int max_thread_num;
      /*当前等待队列的任务数目*/
      int cur_queue_size;
};

} /* namespace test */
#endif /* THREADPOOL_H_ */
