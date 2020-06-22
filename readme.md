git config --global --unset http.proxy


mybatis json 互转
https://blog.csdn.net/u013246459/article/details/86082450

idea的配置:
1.快捷键换为eclipse;

2.颜色换位黑色;

3.字体调为consolas,大小为14;

4.修改快捷键搜素impletations==>为ctrl+左键;

5.修改gradle,maven配置;

6.修改git配置;


7.设置Edit==>General==>Code Completion除了Basic,Smart按键之外全勾;

8.设置File and Code Templates==>设置代码模板:注意打勾生效;
/**
 * @Description: TODO
 * @auther: wuyunlong
 * @date: ${DATE}
 */
public class ${NAME} {
}

9.设置Live Templates==>
**
* @Description: //TODO $end$
* @Date: $date$ $time$
* @Idea: 
*/
编辑变量:date(),time();
设置快捷键为w,之后按/w即可快速选择;

10.注意设置Plugins里面的Auto-detect proxy settings打勾;

11.安装lombok,注意配置项目anno打勾,注意项目引入lombok依赖:
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.16.10</version>
</dependency>

12.安装mybatisCoderHelper;

13.安装热部署插件:Jrbel;注意激活方式;
https://www.2loveyou.com/articles/2020/01/09/1578533228431.html
https://www.guidgen.com/
https://jrebel.qekang.com/738b776f-6cc9-4ac5-9574-960a057392db
File -> Settings -> JRebel -> [Work offline]按钮
