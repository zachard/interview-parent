/*
 *  Copyright 2015-2018 zachard, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.zachard.interview.algorithm.linkedlist;

/**
 * 对单链表进行插入及删除操作的示例链表
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class LinkedListAddRemove {
    
    /**
     * 链表头节点
     */
    LinkedListNode head = null;
    
    /**
     * 将元素添加到链表的结尾
     * 
     * @param data    需要添加的元素数据
     * @return   true-添加成功; false-添加失败
     */
    public boolean addNode(int data) {
        LinkedListNode node = new LinkedListNode(data);
        
        if (head == null) {
            // 如果链表为空, 则加到头节点即可
            head = node;
            return true;
        }
        
        LinkedListNode tmp = head;
        
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        
        tmp.next = node;
        
        return true;
    }

}
