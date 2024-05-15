package view;

import controller.logincheck;

public class login {

    public void CLIENT1() {
        logincheck in = new logincheck();
        System.out.println("*--------Welcome to Core Online---------*");
        System.out.println();
        System.out.print("1.For CLIENT || 2.For FREELANCER: ");
        System.out.println();
        System.out.println("|------------------------------------------------------|");
        System.out.println("|1.If you Already Have an Account Press 1 And Login    |");
        System.out.println("|------------------------------------------------------|");
        System.out.println("|2.If you Not Have a Account press 2 and create Account|");
        System.out.println("|------------------------------------------------------|");
        System.out.println();

        System.out.println("Enter Your Role: ");
        in.CLIENT12();

    }
}
