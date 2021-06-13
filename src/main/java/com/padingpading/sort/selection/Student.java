package com.padingpading.sort.selection;

import com.sun.corba.se.impl.oa.poa.AOMEntry;

/**
 * @author libin
 * @description
 * @date 2021/6/12
 */
public class Student implements Comparable<Student> {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Student other) {
//        if(this.score<other.score){
//            return -1;
//        } else if(this.score== other.score){
//            return 0;
//        } else  {
//            return 1;
//        }
        return this.score-other.score;
    }

    @Override
    public String toString() {
        return String.format("studen(name:%s,score:%s)",this.name,this.score);
    }
}