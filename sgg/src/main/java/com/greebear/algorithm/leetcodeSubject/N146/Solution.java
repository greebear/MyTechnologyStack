package com.greebear.algorithm.leetcodeSubject.N146;

import java.util.HashMap;

class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
        DLinkedNode(){};
        DLinkedNode(int _key,int _value){
            this.key=_key;
            this.value=_value;}
    }
    private int capacity;
    private HashMap<Integer, DLinkedNode> map = new HashMap<>();
    private DLinkedNode head = new DLinkedNode();
    private DLinkedNode tail = new DLinkedNode();
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            // 移动到链头
            DLinkedNode node = map.get(key);
            moveToHead(node);
            // 返回
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 如果已存在
        if(map.containsKey(key)){
            // 移动到链头
            DLinkedNode node = map.get(key);
            // 修改值
            node.value = value;
            moveToHead(node);
            // 更新map
            map.put(key, node);
        }
        // 如果不存在
        else{
            // 添加到链头
            DLinkedNode node = new DLinkedNode(key,value);
            addToHead(node);
            map.put(key, node);
            // 判断size
            if(map.size()>this.capacity){
                // 大于size，删除尾节点
                int res = removeTail();
                // 删除map
                map.remove(res);
            }
        }
    }
    // 添加到链头
    private void addToHead(DLinkedNode node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
    // 删除节点
    private void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 移动到链头
    private void moveToHead(DLinkedNode node){
//        DLinkedNode p = head;
//        while (p.next.key!=node.value){
//            p = p.next;
//        }
        removeNode(node);
        addToHead(node);
    }

    // 删除尾节点
    private int removeTail(){
        DLinkedNode pre_tail = tail.pre;
        removeNode(pre_tail);
        return pre_tail.key;
    }

    public static void main(String[] args)
    {

    }
}
