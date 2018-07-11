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
    
    /**
     * 将元素加到链表指定位置
     * 
     * @param index   指定的链表位置
     * @param data    元素数据
     * @return        true-添加成功, false-添加失败
     */
    public boolean addNodeToIndex(int index, int data) {
        
        if (index < 1 || index > (length() + 1)) {
            // 链表下表有误, length() + 1 表示加在链表的尾端
            return false;
        }
        
        LinkedListNode node = new LinkedListNode(data);
        
        if (head == null) {
            // 当链表为空时的特殊处理, 直接将head指向需要添加的元素
            head = node;
            return true;
        }
        
        LinkedListNode preNode = head;
        
        for (int i = 1; i < index - 1; i++) {
            
            if (preNode.next == null) {
                // 将元素追加到链表末端的情况
                preNode.next = node;
                return true;
            }
            
            preNode = preNode.next;
        }
        
        // p.next = s; s.next = a
        LinkedListNode nextNode = preNode.next;
        preNode.next = node;
        node.next = nextNode;
        
        return true;
    }
    
    /**
     * 删除指定位置上的节点
     * 
     * @param index   需要被删除元素的位置
     * @return        true - 成功删除; false - 删除失败
     */
    public boolean deleteIndexNode(int index) {
        
        if (index < 1 || index > length()) {
            // 链表位置有误
            return false;
        }
        
        // 需要被删除的节点
        LinkedListNode delNode;
        
        if (index == 1) {
            // 删除第一个节点的情况
            delNode = head;
            head = head.next;
            delNode.next = null;
            return true;
        }
        
        // 其他情况
        // 被删除节点的前继节点
        LinkedListNode preNode = head;
        
        for (int i = 1; i < index - 1; i++) {
            // 找到需要被删除节点的前继节点
            preNode = preNode.next;
        }
        
        // 找到需要被删除的节点并执行删除操作
        delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;
        
        return true;
    }
    
    /**
     * 计算链表的长度
     * 
     * @return    链表的长度
     */
    public int length() {
        int length = 0;
        
        LinkedListNode tmp = head;
        
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        
        return length;
    }
    
    /**
     * 链表的字符串表示
     * 
     * @return  链表元素的字符串表示
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        
        LinkedListNode tmp = head;
        
        while (tmp != null) {
            sb.append(tmp.data).append("  ");
            tmp = tmp.next;
        }
        
        return sb.toString();
    }

}
