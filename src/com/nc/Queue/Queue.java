package com.nc.Queue;

public interface Queue
{      //队列的抽象接口的定义
    void enter(Object obj);       //元素进队，即向队列尾部添加一个新元素obj
    Object leave();               //元素离队，即从队列首部删除队首元素并返回
    Object peek();                //返回队首元素的值
    boolean isEmpty();            //判断队列是否为空
    void clear();                 //清除队列中的所有元素使之变为一个空队
}