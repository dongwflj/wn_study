/*
 * MergeList.cpp
 *
 *  Created on: 2013-3-22
 *      Author: Ewen
 */

#include <unistd.h>
#include "MergeList.h"

//Node* MergeList::Merge (Node* head1, Node* head2) {
//    // Important, if found list data is equal cursor's data, need
//    // set cursor's next to NULL
//#define CHECKANDAPPEND(tail, list) \
//    if (tail->data == list->data) { \
//        Node* tmp = list; \
//        list = list->next; \
//        delete tmp; \
//        tail->next = NULL; \
//    } \
//    else { \
//        tail->next = list; \
//        tail = tail->next; \
//        list = list->next; \
//    }
//
//    Node *head, *tail; // head is result's head pointer, cursor is result's tail pointer
//    // Init head
//    if (head1 == NULL) {
//        // Special case, head point to the none empty list, and
//        // move its head to next
//        head = tail = head2;
//        if (head2 != NULL) {
//            head2 = head2->next;
//        }
//    }
//    else if (head2 == NULL){
//        head = tail = head1;
//        if (head1 != NULL) {
//            head1 = head1->next;
//        }
//    }
//    else {
//        // Normal case, both lists have data, head point to the smaller
//        if (head1->data <= head2->data) {
//            head = tail = head1;
//            head1 = head1->next;
//        }
//        else {
//            head = tail = head2;
//            head2 = tail->next;
//        }
//    }
//    while (head1 != NULL || head2 != NULL) {
//        // At least one list has data
//        if (head1 == NULL) {
//            CHECKANDAPPEND(tail, head2);
//        }
//        else if (head2 == NULL) {
//            CHECKANDAPPEND(tail, head1);
//        }
//        else {
//            // Both lists has data
//            if (head1->data <= head2->data) {
//                CHECKANDAPPEND(tail, head1);
//            }
//            else {
//                CHECKANDAPPEND(tail, head2);
//            }
//        }
//    }
//    return head;
//}

Node* MergeList::Merge (Node* head1, Node* head2) {
    // Important, if found list data is equal cursor's data, need
    // set cursor's next to NULL
#define CHECKANDAPPEND(tail, list) \
    if (tail->data == list->data) { \
        Node* tmp = list; \
        list = list->next; \
        delete tmp; \
        tail->next = NULL; \
    } \
    else { \
        tail->next = list; \
        tail = tail->next; \
        list = list->next; \
    }
    // Return the list if the other one list is empty
	if (head1 == NULL || head2 == NULL) {
		return head1 ? head1 : head2;
	}
	Node* head, *tail;
	// Make head pointer point to small value
	if (head1->data < head2->data) {
		head = tail = head1;
		head1 = head1->next;
	}
	else {
		head = tail = head2;
		head2 = head2->next;
	}
	while (head1 != NULL && head2 != NULL) {
		if (head1->data <= head2->data) {
		    CHECKANDAPPEND(tail, head1);
		}
		else {
		    CHECKANDAPPEND(tail, head2);
		}
	}
	if (head1 == NULL) {
		tail->next = head2;
	}
	else {
		tail->next = head1;
	}
	return head;
}
/*
Node* MergeList::Merge (Node* head1, Node* head2) {
	if (head1 == NULL || head2 == NULL) {
		return head1 ? head1 : head2;
	}
	Node* ret = head1;
	Node* prev = ret;
	while (head1 != NULL && head2 != NULL) {
		Node* tmp;
		if (head1->data < head2->data) {
			tmp = head2->next;
			head2->next = head1->next;
			head1->next = head2;
			head1 = head2;
			head2 = tmp;
		}
		else if (head1->data > head2->data && prev->data != head2->data) {
			tmp = head2->next;
			head2->next = head1;
			if (ret == prev) {
				prev = head2;
			}
			else {
				prev->next = head2;
				prev = head2;
			}
			head2 = tmp;
		}
		else {
			Node* removed = head2;
			head2 = head2->next;
			delete removed;
		}
	}
	if (head1 == NULL) {
		prev->next = head2;
	}
	return ret;
}
*/
