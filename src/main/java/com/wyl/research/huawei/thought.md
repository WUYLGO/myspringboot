
==========================================================================================
打印任务排序
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i = 0; i < t; i++) {
			int n = input.nextInt();
			int pos = input.nextInt();

			Queue<Integer> q = new LinkedList<Integer>();
			Queue<Integer> qn = new LinkedList<Integer>();

			for(int j = 0; j < n; j++) {
				int temp = input.nextInt();
				q.add(temp);
				qn.add(j);
			}

			int time = 0;
			while(true) {
				int temp = q.poll();
				int num = qn.poll();
				if(goOnPrint(temp, q)) {
					time++;
					if(num == pos)
						break;
				}
				else {
					q.add(temp);
					qn.add(num);
				}
			}

			System.out.println(time);
		}
	}

	public static boolean goOnPrint(int t, Queue<Integer> q) {
		Iterator<Integer> iterator = q.iterator();
		while(iterator.hasNext()) {
			int v = iterator.next();
			if(v > t)
				return false;
		}

		return true;
	}
}
=============================================================================================
字符串数组压缩
public class Test201402 {

	private static String stringZip(String inputString){
		StringBuffer output = new StringBuffer();
		if (inputString.length()==0) {
			return "";
		}

		int n=1;

		for (int i = 1; i < inputString.length(); i++) {
			if (inputString.charAt(i)!= inputString.charAt(i-1)) {
				if (n>1){
					output.append(n);
					n=1;
				}
				output.append(inputString.charAt(i-1));
			}else {

				n++;
			}
			//处理最后一个字符
			if (i == inputString.length()-1) {
				if (n>1){
					output.append(n);
					n=1;
				}
				output.append(inputString.charAt(i));
			}
		}
		return output.toString();
	}


	public static void main(String args[]){

		String ss= "xxxyyyyyyz";
		System.out.println(stringZip(ss));
	}
}

=============================================================================================
分子弹
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] weightStr = bf.readLine().split(" ");

            int[] weight = new int[weightStr.length];
            for (int i = 0; i < weight.length; i++) {
                weight[i] = Integer.parseInt(weightStr[i]);
            }
            fenZiDan(weight);
        }
        bf.close();
    }


    public static void fenZiDan(int[] shibing) {
        int total = 0;//子弹总数
        int times = 0;//次数
        int[] temp = new int[shibing.length];//临时记录士兵第一次交出子弹后的数量
        for (int i = 0; i < shibing.length; i++) {
            total += shibing[i];
        }
        while (true) {//循环执行任务
            times++;
            for (int i = 0; i < shibing.length; i++) {
                if (shibing[i] % 2 != 0) {
                    total++;//向班长要一颗子弹
                    temp[i] = (shibing[i] + 1) / 2;
                } else {
                    temp[i] = shibing[i] / 2;
                }
            }
            for (int i = 0; i < shibing.length; i++) {
                if (i > 0) {
                    shibing[i] = temp[i - 1] + temp[i];
                } else {
                    shibing[i] = temp[i] + temp[temp.length - 1];
                }
                if (i != shibing.length - 1) {
                    System.out.print(shibing[i] + " ");
                } else {
                    System.out.println(shibing[i] + " ");
                }
            }

            if (total % shibing.length == 0) {//表示可以平均分,是子弹都相等的必要不充分条件,只有此时才会进行检查
                boolean isEnd = true;
                for (int i = 1; i < shibing.length; i++) {
                    if (shibing[0] != shibing[i]) {
                        isEnd = false;
                        break;
                    }
                }
                if (isEnd) {
                    break;
                }
            }
        }
        System.out.println("总共进行了" + times + "次");
    }
}
=============================================================================================
 JS如何判断一组数字是否连续
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] weightStr = bf.readLine().split(" ");

            int[] weight = new int[weightStr.length];
            for (int i = 0; i < weight.length; i++) {
                weight[i] = Integer.parseInt(weightStr[i]);
            }
            convert(weight);
        }
        bf.close();
    }


    public static boolean convert(int[] ints) {
        int index = 0;
        int end = index;
        if (ints.length == index) {//结束条件，遍历完数组
            return false;

        } else {
            for (int i = index; i < ints.length; i++) {
                if (i < ints.length - 1) {
                    if (ints[i] + 1 == ints[i + 1]) {
                        end = i;
                    } else {
                        if (i > index)
                            end = end + 1;
                        break;
                    }
                } else {
                    if (end == ints.length - 2) {
                        end = ints.length - 1;
                        break;
                    }
                }
            }
            if (index == end)//相等说明不连续
                return true;
            else//连续
                return false;

        }

    }
}
=============================================================================================
字符串分割
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.next();
            }

            System.out.println(convert(arr));
        }

        scanner.close();
    }

    private static String convert(String[] arr) {

        StringBuilder builder = new StringBuilder(128);
        for (String s : arr) {
            int pos = 8;

            while (pos <= s.length()) {
                builder.append(s.substring(pos - 8, pos)).append('\n');
                pos += 8;
            }


            if (pos > s.length()) {
                builder.append(s.substring(pos - 8, s.length()));
            }

            for (int i = s.length(); i < pos; i++) {
                builder.append('0');
            }

            builder.append('\n');
        }
        return builder.substring(0, builder.length() - 1);
    }
}

=============================================================================================
集五福
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0; i<10; i++){
                String input = scan.next();
                char[] chs = input.toCharArray();
                for(int j=0; j<chs.length; j++){
                    if(chs[j]=='1'){
                        if(map.get(j)!=null && map.get(j)>0){
                            map.put(j, map.get(j)+1);
                        }else{
                            map.put(j,1);
                        }
                    }
                }
            }
            //map中value值最小的就是最多能集齐的套数
            List list = new ArrayList(map.values());
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }
}
=============================================================================================
单词压缩编码

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] arr = new String[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.next();
            }

            System.out.println(minimumLengthEncoding(arr));
        }

        scanner.close();
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> good = new HashSet(Arrays.asList(words));
        for (String word : words) {
            for (int k = 1; k < word.length(); ++k)
                good.remove(word.substring(k));
        }

        int ans = 0;
        for (String word : good)
            ans += word.length() + 1;
        return ans;
    }

}
=============================================================================================
公司推举候选人
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String result = "";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(majorityElement(arr));
        }

    }


    public static int majorityElement(int[] nums) {
        int count = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    num = nums[i];
                    count++;
                }

            }
        }
        return num;
    }
}
=============================================================================================
九宫格按键输入
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int j=0;scanner.hasNext()&&j<500;j++)
		{
			String n =scanner.next();
			int length = n.length();
			char c = n.charAt(0);
			switch (c)
			{
			case '0':
				if(length%2==1) {System.out.print("0");}
				if(length%2==0) {System.out.print(" ");}
				break;
			case '1':
				if(length%5==1) {System.out.print("1");}
				if(length%5==2) {System.out.print(",");}
				if(length%5==3) {System.out.print(".");}
				if(length%5==4) {System.out.print("?");}
				if(length%5==0) {System.out.print("!");}
				break;
			case '2':
				if(length%4==1) {System.out.print("2");}
				if(length%4==2) {System.out.print("A");}
				if(length%4==3) {System.out.print("B");}
				if(length%4==0) {System.out.print("C");}
				break;
			case '3':
				if(length%4==1) {System.out.print("3");}
				if(length%4==2) {System.out.print("D");}
				if(length%4==3) {System.out.print("E");}
				if(length%4==0) {System.out.print("F");}
				break;
			case '4':
				if(length%4==1) {System.out.print("4");}
				if(length%4==2) {System.out.print("G");}
				if(length%4==3) {System.out.print("H");}
				if(length%4==0) {System.out.print("I");}
				break;
			case '5':
				if(length%4==1) {System.out.print("5");}
				if(length%4==2) {System.out.print("J");}
				if(length%4==3) {System.out.print("K");}
				if(length%4==0) {System.out.print("L");}
				break;
			case '6':
				if(length%4==1) {System.out.print("6");}
				if(length%4==2) {System.out.print("M");}
				if(length%4==3) {System.out.print("N");}
				if(length%4==0) {System.out.print("O");}
				break;
			case '7':
				if(length%5==1) {System.out.print("7");}
				if(length%5==2) {System.out.print("P");}
				if(length%5==3) {System.out.print("Q");}
				if(length%5==4) {System.out.print("R");}
				if(length%5==0) {System.out.print("S");}
				break;
			case '8':
				if(length%4==1) {System.out.print("8");}
				if(length%4==2) {System.out.print("T");}
				if(length%4==3) {System.out.print("U");}
				if(length%4==0) {System.out.print("V");}
				break;
			case '9':
				if(length%5==1) {System.out.print("9");}
				if(length%5==2) {System.out.print("W");}
				if(length%5==3) {System.out.print("X");}
				if(length%5==4) {System.out.print("Y");}
				if(length%5==0) {System.out.print("Z");}
				break;
			default:
				break;
			}
		}
	}
}

=============================================================================================
报数游戏
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static String result = "";

    public static void main(String[] args) throws IOException {
        .0Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        baoshu2(n, m);
    }


    public static int baoshu2(int n, Integer m) {
        if (n == 1 || m == 1) {
            return n;
        }
        // 构造一个数组存储所有n   1,2,3.. n
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        // 构造一个全局计数 从1 开始 一直数 知道 list的长度为1
        Integer count = 1;
        while (list.size() > 1) {
            int tmpSize;
            tmpSize = list.get(0);
            list.remove(0);
            if (count % m == 0 || count.toString().endsWith(m.toString())) { // 当前报的数 为 m的倍数 或者 以m结尾
            } else {
                list.add(tmpSize);
            }
            count++;
        }
        return list.get(0);
    }
}
=============================================================================================
找最长连续重复字母子串
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main{
    //保存最长公共子串
	static String result = "";
	public static void main(String [] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		//得到字符串的所有后缀
		for(int i = s.length()-1;i>=0;i--) {
			list.add(s.substring(i));
		}
		Collections.sort(list);
		int maxLen = 0;
		for(int i = 0;i<s.length()-1;i++) {
			int len = getComlen(list.get(i),list.get(i+1));
			maxLen = Math.max(maxLen, len);
		}
		System.out.println(result+":"+maxLen);
    }
    //得到两个字符串最长公共长度
	public static int getComlen(String str1,String str2) {
		int i;
		for(i =0;i<str1.length()&&i<str2.length();i++) {
			if(str1.charAt(i)!=str2.charAt(i)) {
				break;
			}
		}
		String temp = str1.substring(0,i);
		if(temp.length()>result.length()) result = temp;
		return i;
	}

}

=============================================================================================






