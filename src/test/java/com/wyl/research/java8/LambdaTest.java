package com.wyl.research.java8;

import com.wyl.research.validUser.User;
import org.junit.Test;

import java.util.*;

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


}
