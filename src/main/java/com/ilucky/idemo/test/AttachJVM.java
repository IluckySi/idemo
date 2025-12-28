//package com.ilucky.idemo.test;
////
//import com.sun.tools.attach.AgentInitializationException;
//import com.sun.tools.attach.AgentLoadException;
//import com.sun.tools.attach.VirtualMachine;
//import com.sun.tools.attach.VirtualMachineDescriptor;
//import java.io.IOException;
//import java.util.List;
//
//public class AttachJVM {
//
//    public static void main(String[] args) {
//        //获取当前系统中所有运行中的虚拟机
//        System.out.println("running JVM start ");
//        List<VirtualMachineDescriptor> list = VirtualMachine.list();
//        for (VirtualMachineDescriptor vmd : list) {
//
//            // 如果虚拟机为目标虚拟机, 获取该虚拟机的pid
//            System.out.println(vmd);
//            // if (vmd.displayName().contains("javaagent") && vmd.displayName().contains("agent.jar")) {
//            if (vmd.displayName().contains("IDemoApp")) {
//                System.out.println("--->"+vmd.id());
//
//                // 然后加载 agent.jar 发送给该虚拟机
//                try {
//                    VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
//                    virtualMachine.loadAgent("/Users/iluckysi/yzh/toushibao/code/javaagent/code-instrument-java/JavaAgent/lib/agent.jar");
//                    virtualMachine.detach();
//                    System.out.println("attach:"+vmd.id());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
