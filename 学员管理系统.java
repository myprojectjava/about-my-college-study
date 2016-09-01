package managesystem;

import java.util.Scanner;
public class Managerwork {

	Scanner input=new Scanner(System.in);
	int Maxlength=0;//已存学员的数量
	 Student[] students=new Student[100];
	 int number;//修改数组的下标

	
	/*界面1*/
   public void  interface1(int b){
	   if(b==1){
		System.out.println("1.添加学员\n2.显示所有学员\n3.查找学员\n4.修改学员\n5.删除学员\n0.退出\n请选择");
		System.out.print("请输入账号：");
		String account=input.next();
		System.out.print("请输入密码：");
		String code=input.next();
		enter(account,code);
	   }
	   else{
		   System.out.println("正在开发");
		   System.exit(0);
	   }
   }/*登录成功界面*/
    public void enter(String account,String code){
    	if(account.equals("111") && code.equals("aaa1")){
    	System.out.println("1.添加学员\n2.显示所有学员\n3.查找学员\n4.修改学员\n5.删除学员\n0.退出\n请选择");
    	int chose=input.nextInt();
    	chose(chose);
    	}
    	else{
    		System.out.println("输入信息有误\n请重新输入");
    		interface1(1);
    		
    		}
    }
    /*返回登录界面  */
    public void reenter(){
    	 System.out.println("是否返回登录界面y/n");
    	   char chose=input.next().charAt(0);
    	   if(chose=='y'){
    	   enter("111","aaa1");
    	   }
    	
    }
    
	/*功能选择*/
    public void chose(int i){
    	
    	switch(i){
    	case 1:
    	    add();
    	    reenter();
    		break;
    	case 2:
    		show();
    		reenter();
    		break;
    	case 3:
    		for(;;){
    		System.out.println("请选择查找的方式：");
    		System.out.println("1.编号  2.姓名  3.电话  4.年龄");
    		int a=input.nextInt();
    		search(a);
    	    System.out.println("是否继续查找y/n");
    		char chose=input.next().charAt(0);
    	    if(chose=='y')        
    		   { continue;}
    		   else{
    			   break;
    		   }
    		
    		}
    		reenter();
    		break;
    	case 4:
    		correct();
    		reenter();
    		break;
    	case 5:
    		delete();
    		reenter();
    		break;
    	case 0:
    		System.exit(0);
    	default:System.out.println("输入错误");
    	  enter("888","666");
    	
    	
    		
    	}
    	
    }
    /*1添加学员*/
   public void add(){
	   for(int i=Maxlength;i<students.length;i++){
			System.out.print("编号:");
    		int num=input.nextInt();
    		System.out.print("姓名:");
    		String name=input.next();
    		System.out.print("性别:");
    		char sex=input.next().charAt(0);
    		System.out.print("年龄:");
    		int age=input.nextInt();
    		System.out.print("电话:");
    		String phonenum=input.next();
		   Student s=new Student(num,name,sex,age,phonenum);
		   students[i]=s;
		   Maxlength++;
		   System.out.println("信息添加成功！！！");
		   System.out.println("是否继续添加y/n");
		   char chose=input.next().charAt(0);
		   if(chose=='y')        
		   { continue;}
		   else{
			   break;
		   }
		   
		  
	   }
	 
	   
   }
   /*2显示所有学员*/
   
   public void show(){
   System.out.println("编号\t姓名\t性别\t年龄\t电话");
   for(int i=0;i<Maxlength;i++){
	   students[i].print();
   }
   }   
   
   /*查找学员*/
   public void search(int i){
	   switch(i){
	   case 1:
		   System.out.println("请输入查找的编号");
		   int a=input.nextInt();
		   for(int j=0;j<Maxlength;j++){
			   if(a==students[j].num){
				   System.out.println("编号\t姓名\t性别\t年龄\t电话");
				   students[j].print();
				   number=j;
				   break;}
			   else{
				   if(j==Maxlength-1){
					   System.out.println("输入编号错误");
				   }
			   }
			   
		   }
		  
		   break;
	   case 2:
		   System.out.println("请输入查找的姓名");
		   String b=input.next();
		   for(int j=0;j<Maxlength;j++){
			   if(b.equals(students[j].name)){
				   System.out.println("编号\t姓名\t性别\t年龄\t电话");
				   students[j].print();
				   number=j;
				   break;
			   }else{
				   if(j==Maxlength-1){
					   System.out.println("输入姓名错误");
				   }
			   }
		   }
		  
		   
		   break;
	   case 3:
		   System.out.println("请输入查找的电话");
		   String c=input.next();
		   for(int j=0;j<Maxlength;j++){
			   if(c.equals(students[j].phonenum)){
				   System.out.println("编号\t姓名\t性别\t年龄\t电话");
				   students[j].print();
				   number=j;
				   break;
				   
			   }else{
				   if(j==Maxlength-1){
					   System.out.println("输入电话错误");
				   }
			   }
		   }
		  
		   
		   
	   break;
	   case 4:
		   System.out.println("请输入查找的年龄");
		   int d=input.nextInt();
		   for(int j=0;j<Maxlength;j++){
			   if(d==students[j].age){
				   System.out.println("编号\t姓名\t性别\t年龄\t电话");
				   students[j].print();
				   number=j;
				   break;
			   }else{
				   if(j==Maxlength-1){
					   System.out.println("输入年龄错误");
				   }
			   }
		   }
		  
		   
		   break;
		   default: System.out.println("输入错误");
			   
	   
	   }
	   
   }
   /*4修改学员*/
   public void correct(){
	   for(;;){
	   System.out.println("请选择查找的方式");
	   System.out.println("1请输入查找的编号");
	   System.out.println("2请输入查找的姓名");
	   System.out.println("3请输入查找的电话");
	   System.out.println("4请输入查找的年龄");
	   int a=input.nextInt();
	   search(a);
	   System.out.println("请选择修改的选项");
	   System.out.println("1编号\t2姓名\t3性别\t4年龄\t5电话");
	   int b=input.nextInt();
	   switch(b){
	   case 1:
		   System.out.println("请输入新的编号");
		   int n=input.nextInt();
		   students[number].num=n;
		   System.out.println("编号\t姓名\t性别\t年龄\t电话");
		   students[number].print();
		   break;
	   case 2:
		   System.out.println("请输入新的姓名");
		   String na=input.next();
		   students[number].name=na;
		   System.out.println("编号\t姓名\t性别\t年龄\t电话");
		   students[number].print();
		   break;
	   case 3:
		   System.out.println("请输入新的性别");
		   char s=input.next().charAt(0);
		   students[number].sex=s;
		   System.out.println("编号\t姓名\t性别\t年龄\t电话");
		   students[number].print();
		   break;
	   case 4:
		   System.out.println("请输入新的年龄");
		   int ag=input.nextInt();
		   students[number].age=ag;
		   System.out.println("编号\t姓名\t性别\t年龄\t电话");
		   students[number].print();
		   break;
	   case 5:
		   System.out.println("请输入新的电话");
		   String telephone=input.next();
		   students[number].phonenum=telephone;
		   System.out.println("编号\t姓名\t性别\t年龄\t电话");
		   students[number].print();
		   break;
		   default:System.out.println("输入错误");
	   }
	   System.out.println("是否继续修改y/n");
	   char chose=input.next().charAt(0);
	   if(chose=='y')        
	   { continue;}
	   else{
		   break;
	   }
		    }
	    }
  
    /*删除学员*/	
    	public void delete(){
    		for(;;){
    		   System.out.println("请选择查找的方式");
    		   System.out.println("1请输入查找的编号");
    		   System.out.println("2请输入查找的姓名");
    		   System.out.println("3请输入查找的电话");
    		   System.out.println("4请输入查找的年龄");
    		   int k=input.nextInt();
    		   search(k);
    		   int cha=Maxlength-number;
    		   for(int i=0;i<cha;i++){
    			   students[number+i]=students[number+i+1];
    			   }
    		   Maxlength--;
    		   System.out.println("是否继续删除y/n");
    		   char chose=input.next().charAt(0);
    		   if(chose=='y')        
    		   { continue;}
    		   else{
    			   break;
    		   }
    		}
    		   System.out.println("删除成功！！！");
    		   reenter();
    		   
    		
    		
    		
    		
    	}
    	
    	

    	 
     }
     
     
     
     
     
     package managesystem;

public class Student {
	int num;
	String name;
	char sex;
	int age;
	String phonenum;
	public Student(int a,String b,char c,int d,String e){
		num=a;
		name=b;
		sex=c;
		age=d;
		phonenum=e;
	}
	public void print(){
		System.out.println(num+"\t"+name+"\t"+sex+"\t"+age+"\t"+phonenum);
	}

}



package managesystem;

import java.util.Scanner;

public class test {

	public static void main(String[] args){
		System.out.println("欢迎使用学员通讯录管理系统");
		System.out.println("制作人：朱齐");
		System.out.println("1.登录\n2.注册\n3.找回密码\n0.注销");
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		Manager sc=new Manager();
		sc.interface1(a);
		input.close();
}
	}

