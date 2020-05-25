package com.wyl.research.validUser;

/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: 2020/5/24
 */
public class UserServiceImpl {
    private static UserRepo userRepo = new UserRepo();


    /**
     * @Description: 使用建造者模式+Handler容器+Handler的结构解决if-else的问题;
     * @Date: 2020/5/25 9:42
     * @Idea: 建造者模式将不同的参数传入不同的实现类, 同时收集不同的实现类到容器中, 最后统一遍历容器里面的handler并调用其处理的方法;
     */
    public static User login(User user) {

        //校验参数
        ValidUtils validUtils = new ValidUtils()
                .build(new UserNameValid(user.getUserName()))
                .build(new PasswordValid(user.getPassword()))
                .build(new AgeValid(user.getAge()));
        validUtils.valid();

        //校验user是否存在
        User userEntity = userRepo.findUserByUserName(user.getUserName());
        userEntity = null;
        if (userEntity == null) {
            throw new BusinessException(ResponseEnum.USER_ISNULL);
        }
        return userEntity;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("张三aaaaaaa");
        user.setPassword("AAA1234656");
        user.setAge(8);
        login(user);
    }

}
