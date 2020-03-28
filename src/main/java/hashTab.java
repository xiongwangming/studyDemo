

import java.util.HashMap;

/**
 * @ClassName PACKAGE_NAME
 * @Author 24206
 * @Date 2020/3/24 9:31
 **/
public class hashTab {
    public static void main(String[] args) {
//        Emp emp = new Emp(1, "小伙子");
//        Emp emp1 = new Emp(2, "old man");
//        Emp emp2 = new Emp(3, "yang men");
//        Emp emp3 = new Emp(4, "man");
//        Emp emp4 = new Emp(5, "women");
//        HashTab hashTab = new HashTab(7);
//        hashTab.add(emp);
//        hashTab.add(emp1);
//        hashTab.add(emp2);
//        hashTab.add(emp3);
//        hashTab.add(emp4);
//        hashTab.list();
//        HashMap map = new HashMap();
//        map.put("so","斯奥掉");



    }




static class HashTab{
        MyLinkedList[] myLinkedLists;
        int size;

        HashTab(int size){
            this.size = size;
            myLinkedLists = new MyLinkedList[size];
            for (int i = 0; i < size; i++) {
                myLinkedLists[i] = new MyLinkedList();
            }
        }

        public void add(Emp emp){
            int hashFun = hashFun(emp.id);
            myLinkedLists[hashFun].add(emp);
        }

        public void list(){
            for (int i = 0; i < size; i++) {
                myLinkedLists[i].list();
            }
        }

        public int hashFun(int id){
            return id%size;
        }
}


   static class MyLinkedList{
        Emp hand ;

        public void add(Emp emp){
            if (hand == null){
                hand = emp;
                return;
            }
            Emp cur = hand;
            while (true){
                if (cur.next==null){
                    break;
                }
                cur = cur.next;
            }
            cur.next = emp;
        }

        public void list(){
            if (hand == null){
                System.out.println("链表为空");
                return;
            }
            Emp cur = hand;
            while (true){
                System.out.printf("%d %s",cur.id,cur.name);
                if (cur.next == null){
                    break;
                }
                cur = cur.next;
                System.out.println();
            }
        }
   }






   static class Emp{
        int id ;
        String name;
        Emp next;

        Emp(int id,String name){
            this.id = id;
            this.name = name;
        }
   }
}
