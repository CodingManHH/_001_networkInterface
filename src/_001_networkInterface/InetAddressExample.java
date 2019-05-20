package _001_networkInterface;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 
 * @author AAA
 * 1.出现的bug
 * 【bug1】
 *  cmd 控制台命令报错： 
 *  PS 
 *  C:\setup\_001_workspace\_001_networkInterface\src> java 
 *  .\_001_networkInterface\InetAddressExample
 *		错误: 找不到或无法加载主类 .\_001_networkInterface\InetAddressExample
 *		【正确的做法】
 *	在包下的类，在Java源文件的地方编译后，需要到最外层包的上一级目录下运行，而且类前面需要带包名，以 " . " 隔开
 * --------------
 * 【bug2】
 *  javac 编译出现乱码：  使用下面的指令： javac -encoding UTF-8 InetAddressExample.java
 *  增加参数：encoding 
 * -----------------
 * 2.【测试】
 * 	输入命令：跳到上层目录：
 * java _001_networkInterface.InetAddressExample mail.qq.com
 * 	打印信息如下：
 * 【2】Interface java.net.NetworkInterface$1checkedAddresses@7852e922
*  【4】    Address(v4)
*  【5】:127.0.0.1
*  【4】    Address(v6)
*  【5】:0:0:0:0:0:0:0:1
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@4e25154f
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@70dea4e
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@5c647e05
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@33909752
*  【4】    Address(v4)
*  【5】:192.168.0.7
*  
*  【4】    Address(v6)
*  【5】:fe80:0:0:0:acef:7786:3f70:7ad%eth1
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@55f96302
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@3d4eac69
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@42a57993
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@75b84c92
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@6bc7c054
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@232204a1
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@4aa298b7
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@7d4991ad
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@28d93b30
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@1b6d3586
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@4554617c
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@74a14482
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@1540e19d
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@677327b6
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@14ae5a5
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@7f31245a
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@6d6f6e28
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@135fbaa4
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@45ee12a7
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@330bedb4
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@2503dbd3
*  【3】   (No address for this interface)
*  
*  【2】Interface java.net.NetworkInterface$1checkedAddresses@4b67cf4d
*  【3】   (No address for this interface)
*  
*  
*  【7】   mail.qq.com/58.251.61.186
*  【7】   mail.qq.com/163.177.89.191
*  【7】   mail.qq.com/58.251.139.211
 * 
 * 
 * 
 * 
 * 
 * 
 */ 

public class InetAddressExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			/*使用静态方法getNetworkInterfaces() 返回一个列表，其中包含了该主机每一个接口所对应的NetworkInterface类实例 */
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			if (networkInterfaces == null) {
				System.out.println("【1】---No interfaces found--");
			}else {
				/* 打印并取出列表中每个接口的地址*/
				while (networkInterfaces.hasMoreElements()) {
					NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
					/*打印接口名*/
					System.out.println("【2】Interface "+ networkInterface.getInetAddresses());
					/* 获取与接口相关联的地址*/
					Enumeration<InetAddress> addlist = networkInterface.getInetAddresses();
					if (!addlist.hasMoreElements()) {
						System.out.println("【3】\t(No address for this interface)");
					}					
					/* 	列表的迭代，打印每个地址，对每个地址实例进行检测以判断其属于哪个IP地址子类*/
					while(addlist.hasMoreElements()) {
						InetAddress address = addlist.nextElement();
						System.out.println("【4】\t Address"
								+ (address instanceof Inet4Address ? "(v4)":
								  (address instanceof Inet6Address ? "(v6)":"(?)")));
						/* address.getHostAddress()方法返回一个字符串来代表主机的数字型地址*/
						System.out.println("【5】:" + address.getHostAddress());
					}
					
				}
			}
			
			
		} catch (SocketException e) {

			System.out.println("【6】Error getting interfaces:" + e.getMessage());
			e.printStackTrace();
		}

		for (String host: args) {
			try {
				/*获取给定主机名/地址 的相关地址列表*/
				InetAddress[] addressList = InetAddress.getAllByName(host);
				/**迭代列表中的每个主机：【address.getHostName()】获取主机名，【address.getHostAddress()】获取数字型地址
				    *  【7】   mail.qq.com/58.251.61.186
				 	*  【7】   mail.qq.com/163.177.89.191
				 	*  【7】   mail.qq.com/58.251.139.211 
				 */
				for (InetAddress address : addressList) {
					System.out.println("【7】\t" + address.getHostName() + "/" + address.getHostAddress());
					
				}
			} catch (UnknownHostException e) {
				System.out.println("【8】\t Unable to find address for " +host);
				e.printStackTrace();
			}
		}
		
	}

}
