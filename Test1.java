import java.util.List;

class ListNode{//结点类
    public int date;
    public ListNode next;
    public ListNode(int date)
    {
        this.date=date;
        this.next=null;
    }
}
class Mylist{
    public ListNode head;
    public Mylist(){
        this.head=null;
    }
    public void addFirst(int date){//头插法
        ListNode node=new ListNode(date);
        if(this.head==null)//判断是否第一次插入
        {
            this.head=node;
        }
        else
        {
            node.next=head;
            this.head=node;
        }
    }
    public void addLast(int date){//尾插法
        ListNode node=new ListNode(date);
        ListNode p=this.head;
        if(this.head==null)
        {
            this.head=node;
        }
        else {
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
    }
    public void display(){//输出
        ListNode p=this.head;
        for(p=this.head;p!=null;p=p.next){
            System.out.print(p.date+" ");
        }
        System.out.println(" ");
    }

    public boolean contains(int key){//查找链表中有无key结点
        ListNode p=this.head;
        while(p!=null)
        {
            if(p.date==key)
            {
                return true;
            }
            p=p.next;
        }
        return false;
    }
    public int getlength(){//求链表长度
        ListNode p=this.head;
        int count=0;
        while(p!=null)
        {
            count++;
            p=p.next;
        }
        return count;
    }

    public boolean addIndex(int index,int date)//插入结点
    {
        ListNode q=this.head;
        ListNode p=q;
        ListNode node=new ListNode(date);
        if(index<0||index>this.getlength())
        {
            System.out.println("index不合法！");
            return false;
        }
        if(index==0)
        {
            addFirst(date);
            return true;
        }
        int count=1;
        p=p.next;
        while(count!=index)
        {
            count++;
            q=q.next;
            p=p.next;
        }
        q.next=node;
        node.next=p;
        return true;
    }
    private ListNode searchPrev(int key){//找前驱结点
        ListNode p=this.head;
        ListNode q=this.head.next;
        while(q.date!=key)
        {
            p=p.next;
            q=q.next;
        }
        return p;
    }
    public void remove(int key)//删除结点
    {
        ListNode p=this.head;
        if(this.head==null)
        {
            System.out.println("单链表为空！");
            return;
        }
        if(this.head.date==key)
        {
            this.head=this.head.next;
        }
        ListNode prev=searchPrev(key);
        while(p.date!=key)
        {
            p=p.next;
        }
        prev.next=p.next;
    }
    //删除数据域为key的结点
    public void removeKey(int key) {
        ListNode prev =this.head;
        ListNode cur=this.head.next;
        while(cur!=null) {
            if(prev.next.date==key){
                prev.next=cur.next;
                cur=cur.next;
            }
            else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.date==key) {
            this.head=this.head.next;
        }
    }
    //反转链表
    public ListNode reverList(){
        if(this.head==null){
            return null;
        }
        ListNode cur=this.head;
        ListNode prev=null;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        this.head=prev;
        return this.head;
    }
//    {
//        ListNode prev=null;
//        ListNode cur=this.head;
//        while(cur!=null) {
//            ListNode curNext=cur.next;
//            cur.next=prev;
//            prev=cur;
//            cur=curNext;
//        }
//        this.head=prev;
//      return this.head;
//    }
    public void display2(ListNode newHead){
        ListNode p=newHead;
        for(p=newHead;p!=null;p=p.next){
            System.out.print(p.date+" ");
        }
        System.out.println(" ");
    }
    public ListNode middleNode(){//单链表中间结点
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null) {//偶数个结点时，返回中间第二个结点
            fast=fast.next.next;
            slow=slow.next;
        }
//        while(fast.next!=null&&fast.next.next!=null)//奇数个结点时，返回中间第一个结点
//        {
//            fast=fast.next.next;
//            slow=slow.next;
//        }
        return slow;
    }
    public ListNode FindKToTail(int k){//倒数第k个结点
        if(k<=0) {
            System.out.println("没有这个结点");
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0) {
            if(fast.next!=null) {
                fast = fast.next;
                k--;
            }
            else{
                System.out.println("没有这个结点");
                return null;
            }
        }
        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode partition(int x){//分割单链表
        ListNode cur=this.head;
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
        while(cur!=null) {
            ListNode curNext=cur.next;
            cur.next=null;
          if(cur.date<x){
              if(beforeStart==null){
                  beforeStart=cur;
                  beforeEnd=beforeStart;
              }
              else {
                  beforeEnd.next = cur;
                  beforeEnd=beforeEnd.next;
              }
          }
          else {
              if (afterStart == null) {
                  afterStart = cur;
                  afterEnd = afterStart;
              } else {
                  afterEnd.next = cur;
                  afterEnd=afterEnd.next;
              }
          }
          cur=curNext;
        }
        if (afterStart==null) {
            return beforeStart;
        }
        if(beforeEnd==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        return beforeStart;
    }
    public ListNode deleteDuplication() {//删除排序链表的重复结点
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while (cur != null) {
            if(cur.next != null && cur.date == cur.next.date) {
                while (cur.next != null && cur.date == cur.next.date) {
                    cur = cur.next;
                }
                cur = cur.next;
            }else {
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }
    public boolean chkPalindrome() {//回文链表
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode p=slow.next;
        while(p!=null){
            ListNode pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(head!=slow&&head.next!=slow){
            if(head.date!=slow.date){
                return false;
            }
            head=head.next;
            slow=slow.next;
        }
        if(head.date==slow.date){
            return true;
        }else
            return false;
    }
    public boolean hasCycle(){//环形链表
        if(this.head==null) {
            return false;
        }
        if(this.head.next==null) {
            return false;
        }
        ListNode fast=this.head;
        ListNode  slow=this.head;
        while(fast!=null&&fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            if(fast==slow) {
                return true;
            }
        }
        return false;
    }
    public void createLoop(){//创建环形链表
        ListNode cur=this.head;
        while(cur.next!=null) {
            cur=cur.next;
        }
        cur.next=head.next;
    }
    public ListNode detectCycle() {//环形链表2：找出环形链表的入口结点
        if(this.head==null||this.head.next==null) {
            return null;
        }
        ListNode fast=this.head;
        ListNode  slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                break;
            }
        }
        if(fast==null||fast.next==null)
        return null;
        slow=this.head;
        while(slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
public class Test1{
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){//两链表的相交结点
        if(headA==null||headB==null){
            return null;
        }
        ListNode pL=headA;
        ListNode pS=headB;
        int lenA=0;
        int lenB=0;
        while(pL.next!=null){
            lenA++;
            pL=pL.next;
        }
        while(pS.next!=null){
            lenB++;
            pS=pS.next;
        }
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        else{
            pS=headB;
            pL=headA;
        }
        while(len>0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS&&pL.next!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS)
            return pL;
        else
            return null;
    }
    public ListNode mergeTwoLists(ListNode headA, ListNode headB){//合并两个有序链表
        ListNode node= new ListNode(-1);
        ListNode tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.date<headB.date){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }
            else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        }
        if(headB!=null){
            tmp.next=headB;
        }
        return node.next;
    }
    public static void main(String[] args) {
        Mylist list1=new Mylist();
        list1.addLast(4);
        list1.addLast(5);
        list1.addLast(6);
        list1.addLast(0);
        list1.addLast(4);
        list1.addLast(2);
        ListNode p=list1.middleNode();
        System.out.println(p.date);
        list1.partition(5);
        list1.display();
//        Mylist list2=new Mylist();
//        list2.addFirst(5);
//        list2.addFirst(6);
//        list2.addFirst(7);
//        list1.reverList();
       // list1.display2();
 //       int count=list.getlength();
        // System.out.println("链表长度："+count);
//        list.addIndex(3,9);
//        list.display();
//        System.out.println(list.contains(999));
//        list.removeKey(2);
//        list.display();
//        System.out.println("***********************");
//        list.display2( list.reverList());
//        ListNode p=list.middleNode();
//        System.out.println(p.date);
   //     ListNode q=list.FindKToTail(0);
        //list.partieeption(4);
       // list.display();
        // list.display2();
//        boolean n=list.hasCycle();
//        System.out.println(n);
    }
}
