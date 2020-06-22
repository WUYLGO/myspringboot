package com.wyl.research.java8;

import com.wyl.research.validUser.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/6/20
 */
public class LambdaTest {

    private List<User> users = Arrays.asList(new User("张三", 18, 9999),
            new User("李四", 20, 8888),
            new User("王五", 40, 7777),
            new User("赵六", 50, 6666));


    @Test
    public void testLambda() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }


    @Test
    public void testFilterByAge() {
        List<User> users = filterEmployee(this.users, new FilterEmployeeByAge());
        for (User user : users) {
            System.out.println(user);
        }
    }

    private List<User> filterEmployee(List<User> users, FilterRule<User> filterRule) {

        List<User> result = new ArrayList<>();
        for (User user : users) {
            if (filterRule.filter(user)) {
                result.add(user);
            }
        }
        return result;

    }


    @Test
    public void testFilterBySalary() {
        List<User> users = filterEmployee(this.users, new FilterEmployeeBySalary());
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFilterEmployeeByAnonymous() {
        List<User> users = filterEmployee(this.users, new FilterRule<User>() {
            @Override
            public boolean filter(User user) {
                return user.getAge() > 35;
            }
        });
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFilterUserByLambda() {
        List<User> users = filterEmployee(this.users, (user) -> user.getAge() > 35);
        users.forEach(t -> System.out.println(t));
        users.forEach(System.out::println);

    }

    @Test
    public void testFilterUserByNone() {
        users.stream()
                .filter(user -> user.getAge() > 35)
                .limit(10)
                .forEach(t -> System.out.println(t));

        users.stream()
                .map(User::getUserName)
                .forEach(userName -> System.out.println(userName));

    }

    @Test
    public void testNoArgumentsAndResults() {
        int num = 0;
        Runnable r1 = () -> System.out.println("hello world" + num);
        r1.run();
    }

    @Test
    public void testHasArgumentsAndNoResults() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("hello world");
    }


    @Test
    public void test2ArgumentsAndHasResults() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("aaa");
            return x.compareTo(y);
        };
    }


    @Test
    public void testLambdReference() {
        User user = new User("张三", 18, 1000);

        Supplier<String> supplier = () -> user.getUserName();
        String s = supplier.get();
        System.out.println(s);

        user.setAge(20);

        Supplier<Integer> supplier1 = user::getAge;
        Integer integer = supplier1.get();
        System.out.println(integer);

        Optional<Integer> reduce = users.stream().map(t -> 1).reduce((x, y) -> x + y);
        reduce.get();

        users.stream().collect(Collectors.groupingBy(x -> x.getUserName()));
        Map<String, List<User>> collect = users.stream().collect(Collectors.groupingBy(User::getUserName));

        Collectors.joining("", "", "");

        LongStream.rangeClosed(0, 100000).parallel().reduce((x, y) -> x + y);
        LongStream.rangeClosed(0, 100000).parallel().reduce(0, Long::sum);

    }


}
