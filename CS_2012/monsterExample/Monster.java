package monsterExample;

import java.io.Serializable;

public class Monster implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String hometown;
	private String rampageBehavior;
		
	public Monster(String nameIn, String hometownIn, String rampageBehaviorIn){
		name = nameIn;
		hometown = hometownIn;
		rampageBehavior = rampageBehaviorIn;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getRampageBehavior() {
		return rampageBehavior;
	}
	public void setRampageBehavior(String rampageBehavior) {
		this.rampageBehavior = rampageBehavior;
	}
	
	public String toString (){
		return name + " from " + hometown + " likes to " + rampageBehavior;		
	}
	
	
}
