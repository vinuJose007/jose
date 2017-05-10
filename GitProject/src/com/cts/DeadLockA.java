package com.cts;

 class A {
	
	public synchronized void d1(B b){
		System.out.println("Thread1 Strrts execution of d1()");
	  try{
		Thread.sleep(100);
	}
	catch(InterruptedException e){}
	System.out.println("Thread1 trying to call B's Last method");
    b.last();
	}
	public synchronized void last(){
		System.out.println("Inside A This Is Last method");
		System.out.println("Inside A This Is Last method");
	}
}
 class B {
		
		public synchronized void d2(A a){
			System.out.println("Thread2 Strrts execution of d2()");
		  try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){}
		System.out.println("Thread1 trying to call A's Last method");
	    a.last();
		}
		public synchronized void last(){
			System.out.println("Inside  B This Is Last method");
		}
 }
 
 class DeadLockA extends Thread{
	 A a=new A();
	 B b=new B();
	 public void m1(){
		 this.start();
		 a.d1(b);
	 }
	 public void run(){
		 b.d2(a);
	 }
	 public static void main(String[] args) {
		DeadLockA d=new DeadLockA();
		d.m1();
	}
 }
 