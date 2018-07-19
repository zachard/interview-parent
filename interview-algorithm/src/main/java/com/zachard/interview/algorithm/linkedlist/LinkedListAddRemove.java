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
     * 将链表进行从小到大排序
     * 
     * @return   排序之后链表的head节点
     */
    public LinkedListNode orderList() {
        LinkedListNode nextNode = null;
        LinkedListNode curNode = head;
        // 用于交换的数据
        int tmp = 0;
        
        while (curNode.next != null) {
            nextNode = curNode.next;
            
            while (nextNode != null) {
                
                // 比较两个节点中的数据, 如果倒序则交换数据
                if (nextNode.data < curNode.data) {
                    tmp = nextNode.data;
                    nextNode.data = curNode.data;
                    curNode.data = tmp;
                }
                
                nextNode = nextNode.next;
            }
            
            curNode = curNode.next;
        }
        
        return head;
    }
    
    /**
     * 删除重复元素
     * 
     * @return   删除后的列表
     */
    public LinkedListAddRemove removeRepeat() {
        LinkedListNode tmp = head;
        
        while (tmp != null) {
            // 前驱节点
            LinkedListNode preNode = tmp;
            // 当前比较的节点
            LinkedListNode curNode = tmp.next;
            
            while (curNode != null) {
                // 获取需要比较数据的下一个节点
                LinkedListNode nextNode = curNode.next;
                
                if (curNode.data == tmp.data) {
                    // 如果数据相等, 元素重复, 将前一个节点的next指针指向当前节点的下一节点
                    preNode.next = nextNode;
                    curNode.next = null;
                } else {
                    // 如果数据不相等, 需要pre指针需要跟着往后移动
                    preNode = preNode.next;
                }
                
                // 不论当前数据是否相等, 都需要将当前指针往后移动
                curNode = nextNode;
            }
            
            // 将节点往后移, 并将其数据与之后的节点数据比较
            tmp = tmp.next;
        }
        
        return this;
    }
    
    /**
     * 删除链表中的重复元素, 这是一种更为简便的方法, 比{@link LinkedListAddRemove#removeRepeat()}
     * 创建更少的局部变量
     * 
     * @see  #removeRepeat()
     */
    public void removeRepeatConcise() {
        LinkedListNode tmp = head;
        
        while (tmp != null) {
            LinkedListNode pre = tmp;
            
            while (pre.next != null) {
                // 遍历链表查看是否存在重复元素
                
                if (tmp.data == pre.next.data) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
            
            tmp = tmp.next;
        }
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
