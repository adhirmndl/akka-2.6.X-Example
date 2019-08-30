package com.testing.akka;

import com.testing.akka.bo.proxyFrameData;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class MainClass {
	static ActorSystem system;

	public static void main(String[] args) {
		//system = ActorSystem.create();
		system = ActorSystem.create("testing-system");
//		final ActorRef child =  getContext().actorOf(Props.create(Child.class), "child");
		
		try {
			ActorRef dest = system.actorOf(Destination.props(),"test-destination");
			System.out.println("Press ENTER to exit the system");
			dest.tell("hello", dest.noSender());
			dest.tell(new proxyFrameData("header".getBytes(), "data".getBytes()),dest.noSender());
			System.in.read();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
		      system.terminate();
	    }
	}

}
