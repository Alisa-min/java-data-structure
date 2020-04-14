package MapTest;

import java.util.*;

/**
 * @Author: will
 * @Date: 2020/4/14
 * @description
 */
public class Maptest {
    public static void testTreeMap(){
        Map<String,String> m1=new TreeMap<>();
        System.out.println(m1.put("apple","苹果"));
        m1.put("orange","橘子");
        m1.put("peach","桃");
        System.out.println(m1.size());
        System.out.println(m1);
        //验证K是否可以重复
        //如果k不存在，将键值对直接插入
        //如果k存在，使用value替换原key对应的value
        //在插入key-value期间，Map会保证key是一个有序序列
        //返回值：如果key不存在，将键值对插入，然后返回null
        //                存在，


        System.out.println(m1.put("orange","橙子"));
        System.out.println(m1.size());
        System.out.println(m1);

        //key一定不能为空null，如果key为空无法进行比较从而抛出异常
        //m1.put(null,"无名");
        //value可以为空null
        m1.put("banana",null);
        System.out.println(m1.size());
        System.out.println(m1);

//get（key）
        //如果key存在，返回对应value
        //不存在，返回null
        //key为null，抛出异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //System.out.println(m1.get(null));


        System.out.println(m1.getOrDefault("apple","苹果手机"));
        System.out.println(m1.getOrDefault("watermelon","西瓜"));
        System.out.println(m1.size());

        //remove(key):将map中key对应的键值对删除
        System.out.println(m1);
        System.out.println(m1.remove("bananananana"));

        //时间复杂度O(logN)   根据底层结构特性（红黑树）
        if (m1.containsKey("banana")){
            System.out.println("banana is in!!!");
        }else {
            System.out.println("banana is not in!!!");
        }
        //时间复杂度O（1）
        if(m1.containsValue("西瓜")){
            System.out.println("有！");
        }else{
            System.out.println("没有！");
        }
        System.out.println(m1.remove("banana"));
        System.out.println(m1);


        //打印所有的key
        for (String s : m1.keySet() ){
            System.out.println(s+" ");
        }
        //打印所有value
        for (String s: m1.values()){
            System.out.println(s+" ");
        }

        //打印所有键值对
        for (Map.Entry<String,String> e:m1.entrySet()){
            System.out.println(e.getKey()+"---->"+e.getValue());
        }
    }

    public static void testHashMap(){
        Map<String,String> m1=new HashMap<>();
        System.out.println(m1.put("apple","苹果"));
        m1.put("orange","橘子");
        m1.put("peach","桃");
        System.out.println(m1.size());
        System.out.println(m1);
        //验证K是否可以重复
        //如果k不存在，将键值对直接插入
        //如果k存在，使用value替换原key对应的value
        //在插入key-value期间，Map会保证key是一个有序序列
        //返回值：如果key不存在，将键值对插入，然后返回null
        //                存在，


        System.out.println(m1.put("orange","橙子"));
        System.out.println(m1.size());
        System.out.println(m1);

        //key一定不能为空null，如果key为空无法进行比较从而抛出异常
        //m1.put(null,"无名");
        //value可以为空null
        m1.put("banana",null);
        System.out.println(m1.size());
        System.out.println(m1);

//get（key）
        //如果key存在，返回对应value
        //不存在，返回null
        //key为null，抛出异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //System.out.println(m1.get(null));


        System.out.println(m1.getOrDefault("apple","苹果手机"));
        System.out.println(m1.getOrDefault("watermelon","西瓜"));
        System.out.println(m1.size());

        //remove(key):将map中key对应的键值对删除
        System.out.println(m1);
        System.out.println(m1.remove("bananananana"));

        //时间复杂度O(logN)   根据底层结构特性（红黑树）
        if (m1.containsKey("banana")){
            System.out.println("banana is in!!!");
        }else {
            System.out.println("banana is not in!!!");
        }
        //时间复杂度O（1）
        if(m1.containsValue("西瓜")){
            System.out.println("有！");
        }else{
            System.out.println("没有！");
        }
        System.out.println(m1.remove("banana"));
        System.out.println(m1);


        //打印所有的key
        for (String s : m1.keySet() ){
            System.out.println(s+" ");
        }
        //打印所有value
        for (String s: m1.values()){
            System.out.println(s+" ");
        }

        //打印所有键值对
        for (Map.Entry<String,String> e:m1.entrySet()){
            System.out.println(e.getKey()+"---->"+e.getValue());
        }
    }



    public static void testTreeSet(){
        Set<String> s = new TreeSet<>();
        System.out.println( s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);


        System.out.println(s.add("apple"));
        System.out.println(s);

        if (s.contains("apple")){
            System.out.println("在");
        }else{
            System.out.println("不在");
        }



        //遍历
        Iterator<String> it=s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("peach"));

    }
    public static void main(String[] args) {
      // testTreeMap();
        //testHashMap();
        testTreeSet();

    }


}
