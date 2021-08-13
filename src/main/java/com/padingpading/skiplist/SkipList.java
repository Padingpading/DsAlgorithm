package com.padingpading.skiplist;

import java.util.Random;

/**
 * @author libin
 * @description 跳表
 * @date 2021-08-14
 */
public class SkipList {

    //最大索引层数
    private static int MAX_LEVEL = 16;

    //头节点
    private Node head;

    //索引的层级数,默认为1
    private int levelCount = 1;

    private Random random;

    class Node {
        //结点值
        private int value;
        //当前节点的所有后驱节点。1-maxlevel 层。
        private Node[] nodes = new Node[MAX_LEVEL];
        //当前节点的层数
        private int maxLevel;

        public Node(int value, int maxLevel) {
            this.value = value;
            this.maxLevel = maxLevel;
        }
        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder.append("{value:");
            builder.append(value);
            builder.append("; leves: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public Node get(int value) {
        //1、从最高层开始遍历
        Node cur = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            //找到比该值小的那个结点
            while (cur.nodes[i] != null && cur.nodes[i].value < value) {
                cur = cur.nodes[i];
            }
            //开始寻找下一层,直到找到最后一层
        }
        if (cur.nodes[0] != null && cur.nodes[0].value == value) {
            return cur.nodes[0];
        }
        return null;
    }

    public void insert(int number) {
        //1、获取要插入的索引层数量
        int level = randomLevel();
        //2、创建新节点
        Node newNode = new Node(number, level);
        //3、获取每一层的前驱结点
        Node update[] = new Node[level];
        //遍历索引层
        Node c = head;
        for (int i = level - 1; i >= 0; i--) {
            while (c.nodes[i] != null && c.nodes[i].value < number) {
                c = c.nodes[i];
            }
            update[i] = c;
        }
        //4、更新每一层的索引结构
        for (int i = 0; i < level; ++i) {
            //当前结点的后驱结点
            newNode.nodes[i] = update[i].nodes[i];
            //当前结点的前驱
            update[i].nodes[i] = newNode.nodes[i];
        }
        //5、更新索引层
        if (levelCount < level) {
            levelCount = level;
        }
    }


    public void delete(int value) {
        //1、获取每一层比当前值小的前一个结点
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.nodes[i] != null && p.nodes[i].value < value) {
                p = p.nodes[i];
            }
            update[i] = p;
        }
        //2、如果最后一层的结点的与当前值相同,进入变更指针操作。
        if (p.nodes[0] != null && p.nodes[0].value == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                //从最高层开始变更,如果值相等才进行变更
                if (update[i].nodes[i] != null && update[i].nodes[i].value == value) {
                    update[i].nodes[i] = update[i].nodes[i].nodes[i];
                }
            }
        }
    }

    // 显示跳表中的结点
    public void display(){
        Node p = head;
        while(p.nodes[0] != null){
            System.out.println(p.nodes[0] + " ");
            p = p.nodes[0];
        }
        System.out.println();
    }

    // 随机函数
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }
}