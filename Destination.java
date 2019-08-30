package com.testing.akka;

import com.testing.akka.bo.proxyFrameData;

import akka.actor.AbstractActor;
import akka.actor.Props;

public class Destination extends AbstractActor {
	
	
	public static Props props() {
		 return Props.create(Destination.class,Destination::new);
	}

	@Override
	  public void preStart() {
	    System.out.println("actor  started");
	  }

	  @Override
	  public void postStop() {
		  System.out.println("Actor stopped");
	  }
	  
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder().match(
	            String.class,
	            s -> {
	              System.out.println("Received String message: "+ s);
	            })
			.match(proxyFrameData.class, O->{
				System.out.println(new String(O.getHeader())+" : "+new String(O.getData()));
			})
	        .matchAny(o -> System.out.println("received unknown message")).build();
//		return null;
	}

}
