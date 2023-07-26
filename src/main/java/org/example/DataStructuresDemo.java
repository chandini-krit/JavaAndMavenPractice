package org.example;

import java.util.*;

public class DataStructuresDemo {
    public static void main(String[] args) {
        //set is unordered and doesn't allow duplicates
        Set<String> set = new HashSet<String>();
        set.add("Jack");
        set.add("Tom");
        set.add("Mickey");
        set.add("Nick");
        System.out.println("set :"+set);

        Set<String> set1 = new HashSet<String>();
        set1.addAll(Arrays.asList(new String[]{"Jerry", "Bob","Tom"}));
        System.out.println("set1 :"+set1);

        Set<String> union = new HashSet<String>(set);
        union.addAll(set1);
        System.out.println("union of set and set1:"+union);

        Set<String> intersection = new HashSet<String>(set);
        intersection.retainAll(set1);
        System.out.println("intersection of set and set1:"+intersection);

        Set<String> difference = new HashSet<String>(set);
        difference.removeAll(set1);
        System.out.println("difference of set and set1 :");

        System.out.println(set.contains("Nick"));
        System.out.println("size of set :"+set.size());
        Iterator itr= set.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        set.clear();
        System.out.println(set.isEmpty());

        //Array allows elements of fixed size to get stored in contiguous memory location

        int[] array=new int[5];
        int a=1;
        for (int i=0;i<array.length;i++) {
            array[i]=a;
            a++;
        }

        String str="abcdefg";
        char[]  charArray=str.toCharArray();
        for (char c: charArray) {
            System.out.println(c);
        }

        // copy array
        char[] copyArray = new char[7];
//        System.arraycopy(charArray, 2, copyArray, 0, 6);
        System.out.println(copyArray.toString());
        //to copy whole array use array.clone()

        //multidimensional array
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        //jagged array
        int[][] jaggedArray=new int[3][];
        jaggedArray[0]= new int[]{1, 2};
        jaggedArray[1]=new int[]{3,4,5};
        jaggedArray[2]=new int[]{6,7,5,4};

        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j]+" ");
            }
            System.out.println();
        }

        //ArrayList
        ArrayList<Integer> arrList= new ArrayList<>(10);
        arrList.add(2);
        arrList.add(1000);
        arrList.add(4334);
        arrList.add(2);

        arrList.set(2,3);
        System.out.println(arrList.get(0));
        System.out.println(arrList.size());
        arrList.trimToSize();
        System.out.println(arrList.size());
        arrList.remove(1);
        Collections.sort(arrList);
        for (int i: arrList) {
            System.out.println(arrList);
        }
        arrList.clear();
        System.out.println(arrList.isEmpty());
        //arraylist to store objects
        ArrayList<Employee> listOfEmployees= new ArrayList<>();
        Employee emp1 =new Employee(1,"ram",25,"india");
        listOfEmployees.add(emp1);
        System.out.println(listOfEmployees.get(0).getName());

        //linkedList
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(12);
        ll.add(13);
        ll.add(15);
        ll.add(1,16);
        ll.add(11);
        ll.add(12);

        ll.removeFirstOccurrence(12);
        ll.removeFirst();
        ll.removeLast();

        ll.addFirst(4);
        ll.addLast(5);
        System.out.println(ll.indexOf(16));
        Iterator iterator = ll.descendingIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.err.println("errorrr..........");
    }
}
