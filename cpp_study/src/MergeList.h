/*
 * MergeList.h
 *
 *  Created on: 2013-3-22
 *      Author: Ewen
 */

#ifndef MERGELIST_H_
#define MERGELIST_H_

class Node {
public:
	   int data;
	   Node* next;
};

class MergeList {
public:
	Node* Merge (Node* head1, Node* head2);
};
#endif /* MERGELIST_H_ */
