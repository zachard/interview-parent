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

import java.util.Random;

import org.junit.Test;

/**
 * 对链表进行插入或删除操作类测试
 * <pre>
 * </pre>
 *
 * @author zachard
 * @version 1.0.0
 */
public class LinkedListAddRemoveTest {
    
    /**
     * 向链表中指定位置插入元素方法测试
     */
    @Test
    public void addNodeToIndexTest() {
        LinkedListAddRemove linkedList = new LinkedListAddRemove();
        
        for (int i = 1; i < 4; i++) {
            System.err.println("向链表中添加第" + i + "个元素, 结果为: " + linkedList.addNodeToIndex(i, i));
            System.err.println("链表此时的长度为: " + linkedList.length());
            System.err.println("链表的内容为: " + linkedList);
        }
        
        System.err.println();
        
        System.err.println("向链表为0的位置添加元素, 结果为: " + linkedList.addNodeToIndex(0, 0));
        System.err.println("链表中内容为: " + linkedList);
        System.err.println("链表此时的长度为: " + linkedList.length());
        
        System.err.println();
        
        System.err.println("向链表中最后位置添加元素, 结果为: " 
              + linkedList.addNodeToIndex(linkedList.length(), linkedList.length() + 1));
        System.err.println("链表中内容为: " + linkedList);
        System.err.println("链表此时的长度为: " + linkedList.length());
        
        System.err.println();
        
        System.err.println("向链表最后位置的后一位添加元素, 结果为: " 
              + linkedList.addNodeToIndex(linkedList.length() + 1, linkedList.length() + 2));
        System.err.println("链表中内容为: " + linkedList);
        System.err.println("链表此时的长度为: " + linkedList.length());
        
        System.err.println();
        
        System.err.println("向链表最后位置的后两位添加元素, 结果为: " 
                + linkedList.addNodeToIndex(linkedList.length() + 2, linkedList.length() + 3));
        System.err.println("链表中内容为: " + linkedList);
        System.err.println("链表此时的长度为: " + linkedList.length());
        
        System.err.println();
        
        System.err.println("向长度大于2的链表中第2个位置添加元素, 结果为: " 
                + linkedList.addNodeToIndex(2, 10));
        System.err.println("链表中的内容为: " + linkedList);
        System.err.println("链表此时的长度为: " + linkedList.length());
    }
    
    /**
     * 删除链表指定位置上的元素方法测试
     */
    @Test
    public void deleteIndexNodeTest() {
        LinkedListAddRemove linkedList = new LinkedListAddRemove();
        
        for (int i = 1; i < 9; i++) {
            System.err.println("向链表中添加第" + i + "个元素, 结果为: " + linkedList.addNodeToIndex(i, i));
            System.err.println("链表此时的长度为: " + linkedList.length());
            System.err.println("链表的内容为: " + linkedList);
        }
        
        System.err.println();
        
        System.err.println("将链表中位置为0的元素删除, 结果为: " + linkedList.deleteIndexNode(0));
        System.err.println("链表此时的长度为: " + linkedList.length());
        System.err.println("链表的内容为: " + linkedList);
        
        System.err.println("将链表中位置为长度+1处的元素删除, 结果为: " 
                    + linkedList.deleteIndexNode(linkedList.length() + 1));
        System.err.println("链表此时的长度为: " + linkedList.length());
        System.err.println("链表的内容为: " + linkedList);
        
        System.err.println();
        
        System.err.println("将链表中位置为1处的元素删除, 结果为: " + linkedList.deleteIndexNode(1));
        System.err.println("链表此时的长度为: " + linkedList.length());
        System.err.println("链表的内容为: " + linkedList);
        
        System.err.println();
        
        System.err.println("将链表中位置为4处的元素删除, 结果为: " + linkedList.deleteIndexNode(4));
        System.err.println("链表此时的长度为: " + linkedList.length());
        System.err.println("链表的内容为: " + linkedList);
        
        System.err.println();
        
        System.err.println("将链表中最末尾的元素删除, 结果为: "
                + linkedList.deleteIndexNode(linkedList.length()));
        System.err.println("链表此时的长度为: " + linkedList.length());
        System.err.println("链表的内容为: " + linkedList);
    }
    
    /**
     * 链表排序测试
     */
    @Test
    public void orderListTest() {
        LinkedListAddRemove linkedList = new LinkedListAddRemove();
        Random random = new Random();
        
        for (int i = 1; i < 6; i++) {
            System.err.println("向链表中添加第" + i + "个元素, 结果为: " + linkedList.addNodeToIndex(i, random.nextInt(20)));
            System.err.println("链表此时的长度为: " + linkedList.length());
            System.err.println("链表的内容为: " + linkedList);
        }
        
        linkedList.orderList();
        
        System.err.println("排序后链表的长度为: " + linkedList.length());
        System.err.println("排序后链表的内容为: " + linkedList);
    }

}
