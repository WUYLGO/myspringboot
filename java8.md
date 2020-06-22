1.lambda箭头左侧是方法参数,右侧是方法体,需要有对应的接口;

2.在对应的接口中:注意这种写法只适用接口只有一个方法的时候,注意这种写法相当于先定义了类,创建了对应的对象,在调用这个对象的方法;
(1)无参数,无返回值==>()->System.out.printLn();
(2)有一个参数,无返回值==>(x) -> System.out.println(x);
(3)有两个参数, 有多条语句,有返回值==> 
(x, y) -> {
     System.out.println("aaa");
     return x.compareTo(y); 
};

3.@FunctionalInterface,检查是否是函数式接口,只能有一个抽象方法;

4.java内置四大核心函数式接口:
(1)Consumer<T>:消费型接口;==>void accept(T yt)
(2)Supplier<T>:供给型接口;==>T get();
(3)Function<T,R>:函数型接口;==>R apply(T t);
(4)Predicate<T>:断言型接口;==>boolean test(T t)

5.方法引用的三种方式:
(1)对象名 : : 方法名;
(2)类名 : : 静态方法名;
(3)类名 : : 方法名;==>String : : equals==>只有第一个参数是第二个参数的方法参数时才能这样;
注意:需要保证对象调用方法的参数,返回值与接口中的参数和返回值一致,才能用方法引用;例如user.getName();无参,返回值为String,与Supplier<String> 中T get()的参数与返回值一致,因此可以直接引用user.getName()==>user : : getName;


6.构造器引用:
ClassName : : new
Supplier<Employee> sup=Employee : : new;
sup.get();
因为supplier的是T get()因此匹配的是无参构造函数;

7.数组引用:
Function<Integer,String[]> fun2=String[] : : new;
fun2.apply(10);

8.创建Stream的四种方式:
(1)Collection集合类提供的stream()或者parallelStream();
==>stream是串行流,parallelStream是并行流,能够开启多个线程去做中间操作和终止操作;
==>Stream<String> stream=new ArrayList<String>.stream();
(2)Arrays.stream();
==>Stream<Employee> stream=Arrays.stream(emps);
(3)Stream的静态方法of
==>Stream<String> stream=Stream.of("aa","bb","cc");
(4)创建无限流:迭代
==>Stream<Integer> stream= Stream.iterate(0,x->x+2);
生成:
==>Stream.generate(()->Math.ramdom).limit(5).forEach(System.out::println);


9.中间操作:
(1)filter
==>users.stream.filter(e->e.getAge>35).forEach(System.out::println);
==>只有中间操作,比如filter是不会执行的,只有执行终止操作的时候才会执行全部,比如forEach;即惰性求值;

(2)limit:返回满足条件的前几条数据,有截断提高效率的功能;
==>users.stream.filter(e->e.getSalary()>5000).limit(2).forEach(System.out::println);

(3)skip:返回一个扔掉前n个元素的流,若流中的元素不足n个,则返回空流,与limit互补;
==>users.stream.filter(e->e.getSalary()>5000).skip(2).forEach(System.out::println);

(4)distinct:去重;==>如果需要去重的是对象类型,则需要重写对象的hashCode和equals方法,因为hashCode比较的是地址值,要想让对象去重,则应该比较内容,所以必须重写;
==>users.stream.filter(e->e.getSalary()>5000).skip(2).distinct().forEach(System.out::println);

(5)map映射,用于提取某个字段,原理是把集合中的元素按照lambda函数转换映射到map中;
==>users.stream.map(User::getUserName).forEach(System.out::println);
==>map属于中间函数,返回的是流对象,因此得到的是Stream<Stream<String>>,遍历的时候需要两层forEach();
flatMap==>等同于addAll();

(6)排序:sorted:
==>list.stream().sorted((e1,e2)->{e1.getName.compareTo(e2.getName())});

10.终止操作:
(1)allMatch:检查是否匹配所有元素;
==>users.stream.allMatch((e)->e.getAge.equals(18));
(2)anyMatch:检查是否至少匹配一个元素;
(3)noneMatch:检查全部元素是不是都不能匹配;
(4)findFirst:返回第一个元素;
(5)findAny:返回当前流中的任意元素;
(6)count:返回流中元素的个数;
(7)max:返回流中最大值;
(8)min:返回流中最小值;

11.reduce:规约:
==>List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,8);
   Integer sum=list.stream().reduce(0,(x,y)->x+y);
得到是是list的元素和;
map-reduce:用来做数据统计,搜索
==>users.stream.map(User::getSalary).reduce(Double::sum);即可求出工资总和;https://www.cnblogs.com/sueyyyy/p/12125292.html 
非迭代求和,而是分段归并求和;


12.collect:收集:将流转换为其他形式,给Stream元素做汇总;
==>List<String>  list=users.stream().map(User::getUserName).collect(Collectors.toList);
==>collect(Collectors.toCollection(HashSet::new));
==>Collectors.counting();
==>Collectors.averagingDouble();
==>Collectors.summingDouble();
==>Collectors.maxBy();
==>Collectors.minBy();
分组:
==>Map<String, List<User>> collect =      users.stream().collect(Collectors.groupingBy(User::getUserName));
多级分组:
即groupingBy函数中也可以继续传Collectors.groupingBy();按照下一个字段分组,主要返回的是嵌套的map;

分区:
==>Map<Boolean,List<User>>Collectors.partitioningBy(user->user.getSalary>8000);
返回的分区是false区和true区;

==>汇总:
DoubleSummaryStatistics dss=
users.stream().collect(Collectors.summarizingDouble(User::getSalary)
dss.getSum();
dss.getAverage();
dss.getMax();

==>连接字符串:
users.stream().map(User::getUserName).collect(Collectors.joining(","));
通过,号连接姓名,会自动去掉最后一个逗号;
通过,号连接姓名,会自动去掉最后一个逗号;

13.累加计算:
 LongStream.rangeClosed(0, 100000).parallel().reduce(0, Long::sum);


14.Optional<T> op=Optional.ofNullabele(null)==>可以用来防止空指针,原理是在发生NPE的时候有一个默认值;
==>op.orElse(new User()).getGodness().orElse(new Godness("ABC")).getName();

15.java8中允许接口中有默认的方法,静态方法;

16.解决simpledateFormat的方法:
private static final ThreadLocal<DateFormat> df=new ThreadLocal<DateFormat>(){
	@Override
	protect DateFormat initialValue(){
	return new SimpleDateFormat("yyyMMdd");
}

public static DateFormat get(){
	return df.get();
}

16.新日期API:
LocalDate
LocalTime
LocalDateTime
now()==>静态方法，根据当前时间创建对象	LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();  LocalDateTime localDateTime = LocalDateTime.now();
of()==>静态方法，根据指定日期/时间创建对象	
		LocalDate localDate = LocalDate.of(2016, 10, 26);
		LocalTime localTime = LocalTime.of(02, 22, 56);  LocalDateTime localDateTime = LocalDateTime.of(2016, 10,  26, 12, 10,55);
plusDays, plusWeeks==>向当前 LocalDate 对象添加几天、	
plusMonths, plusYears==>几周、几个月、几年	
minusDays, minusWeeks==>从当前 LocalDate 对象减去几天、	
minusMonths, minusYears==>几周、几个月、几年	
plus, minus==>添加或减少一个Duration 或Period	
withDayOfMonth,withDayOfYear,withMonth,withYear==>将月份天数、年份天数、月份、年份修改为指定的值并返回新的LocalDate 对象	
getDayOfMonth==>获得月份天数(1-31)	
getDayOfYear==>获得年份天数(1-366)	
getDayOfWeek==>获得星期几(返回一个 DayOfWeek枚举值)	
getMonth==>获得月份, 返回一个Month枚举值	
getMonthValue==>获得月份(1-12)	
getYear==>获得年份	
until==>获得两个日期之间的 Period 对象,或者指定ChronoUnits 的数字	
isBefore, isAfter==>比较两个 LocalDate	
isLeapYear==>判断是否是闰年	


17.Instant 时间戳:
==>用于“时间戳”的运算。它是以Unix元年(传统 的设定为UTC时区1970年1月1日午夜时分)开始 所经历的描述进行运算
==>Duration:用于计算两个“时间”间隔
==>Period:用于计算两个“日期”间隔


18.TemporalAdjuster : 时间校正器。有时我们可能需要获
取例如：将日期调整到“下个周日”等操作。
TemporalAdjusters : 该类通过静态方法提供了大量的常 用 TemporalAdjuster 的实现。
例如获取下个周日：
==>LocalDate nextSunday=LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));


19.java.time.format.DateTimeFormatter 
==>DateTimeFormatter dtf= DateTimeFormatter.ISO_DATE_TIME;
==>dtf.format(LocalDateTime.now());
==>DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss" );
==>LocalDateTime.now().format(dtf);正反format都可以;

20.Java8 中加入了对时区的支持，带时区的时间为分别为：
ZonedDate、ZonedTime、ZonedDateTime
其中每个时区都对应着 ID，地区ID都为 “{区域}/{城市}”的格式
例如 ：Asia/Shanghai 等
ZoneId：该类中包含了所有的时区信息 getAvailableZoneIds() : 可以获取所有时区时区信息 
of(id) : 用指定的时区信息获取ZoneId 对象
==>LocalDateTime.now(ZoneId.of(Europe/Tallinn));这个时区的时间;
==>LocalDateTime.now().atZone(ZoneId.of(Asia/Shanghai));带时区显示时间;

