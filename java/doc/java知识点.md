## 一、java



1、说一下ArrayList和LinkedList的区别？

```markdown
1.首先，他们的底层数据结构不同，ArrayList底层是基于数组实现的，LinkedList底层是基于链表实现的
2.由于底层数据结构不同，他们所适用的场景也不同，ArrayList更适合随机查找，LinkedList更适合删除和添加，查询、添加、删除的时间复杂度不同
3.另外ArrayList和LinkedList都实现了List接口，但是LinkedList还额外实现了Deque接口，所以LinkedList还可以当做双端队列来使用
```

2、ArrayList和LinkedList的插入和访问的时间复杂度？

```markdown
ArrayList 是线性表（数组）
get() 直接读取第几个下标，复杂度 O(1)
add(E) 添加元素，直接在后面添加，复杂度O（1）
add(index, E) 添加元素，在第几个元素后面插入，后面的元素需要向后移动，复杂度O（n）
remove（）删除元素，后面的元素需要逐个移动，复杂度O（n）

LinkedList 是链表的操作
get() 获取第几个元素，依次遍历，复杂度O(n)
add(E) 添加到末尾，复杂度O(1)
add(index, E) 添加第几个元素后，需要先查找到第几个元素，直接指针指向操作，复杂度O(n)
remove（）删除元素，直接指针指向操作，复杂度O(1)
```

