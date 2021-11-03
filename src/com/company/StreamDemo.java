package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

//        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        method6();
//        method7();
//        method8();
//        method9();
        method11();

    }

    private static void method11() {
        Integer once = 2;
        Integer couponPackageNum = 2;
        boolean flag = Objects.equals(once * couponPackageNum,8);
        if(!flag){
            System.out.println("======end========");
        }
    }

    private static void method10(String param) {
        if(param==null){
            return;
        }
         switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth"); break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null"); break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
        System.out.println("======end=======");
    }

    private static void method9() {
        /*String[] strs = new String[]{"aa","bb","cc"};
        List arr = Arrays.asList(strs);
        arr.add("dd");//java.lang.UnsupportedOperationException*/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println("===========end============="+list.size());

    }

    private static void method8() {
        System.out.println("========begin========");
        Person jack = new Person();
        jack.setName("jack");
        List<Integer> luckyNum = jack.getLuckyNum();
        //System.out.println("===== " + luckyNum.size());
        for (Integer integer : luckyNum) {
            System.out.println("=== " + integer);
        }

        System.out.println("========end========");
    }

    private static void method7() {
//        Person person = new Person();
//        person.setName("buck");
        My mine = new My();
        mine.setName("buck");
        mine.work(mine.getName());
    }

    private static void method6() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }

    private static void method5() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 8500, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8500, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max.get().getSalary());
        Map<Integer, Person> maps = personList.stream().collect(Collectors.toMap(Person::getSalary, a -> a, (v1, v2) -> v2));
        Map<Integer, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSalary));
        System.out.println("=========end==========");

    }

    private static void method4() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最小值：" + min.get());
        System.out.println("自定义排序的最大值：" + max.get());

    }

    private static void method3() {
        List<Person> personList = new ArrayList<Person>();
        /*personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen2222", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));*/

        List<String> list = personList.stream().filter(e -> e.getSalary() > 10000).map(Person::getName).collect(Collectors.toList());

//        Optional<Person> max = personList.stream().max(Comparator.comparing(e -> e.getName().length()));


        System.out.println("高于8500的员工姓名：" + list);
//        System.out.println("名字最长的员工姓名：" + max.get().getName());

    }

    private static void method2() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);

        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();

        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();

        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);

    }

    private static void method1() {
        IntStream.range(0, 2).forEach(e -> {
            System.out.println(e);
        });
    }


}
